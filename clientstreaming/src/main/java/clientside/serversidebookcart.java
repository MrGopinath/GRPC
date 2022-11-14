package clientside;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.Clientstreaming.bookcartrequest;
import com.Clientstreaming.bookcartresponse;
import com.clientstreamGrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class serversidebookcart {
	static Logger logger=Logger.getLogger(serversidebookcart.class.getName());
	Server server;
	static HashMap<String,bookcartrequest> addcart=new HashMap<String,bookcartrequest>();
	 static {
		 addcart.put("ponniyan selvan",bookcartrequest.newBuilder().setName("ponniyan selvan").setAuthor("mani").setPrice(100).build());
		addcart.put("tenali raman",bookcartrequest.newBuilder().setName("tenali raman").setAuthor("jayaprada").setPrice(50).build());
		addcart.put("ok kanmani",bookcartrequest.newBuilder().setName("ok kanmani").setAuthor("mani").setPrice(35).build());
		addcart.put("vikram vedha",bookcartrequest.newBuilder().setName("vikram vedha").setAuthor("somadeva").setPrice(70).build());
		addcart.put("tom and jerry",bookcartrequest.newBuilder().setName("tom and jerry").setAuthor("william hanna").setPrice(90).build());
		 
	 }
	
	void start() throws Exception
	{
		int port=2222;
		server=ServerBuilder.forPort(port).addService(new cart()).build().start();
		logger.info("Server Started At Port "+server.getPort());
	}
	static class cart extends clientstreamGrpc.clientstreamImplBase{
		ArrayList<bookcartrequest>booksearch=new ArrayList<bookcartrequest>();

		@Override
		public StreamObserver<bookcartrequest> bookcart(StreamObserver<bookcartresponse> responseObserver) {
			return new StreamObserver<bookcartrequest>() {
				@Override
				public void onNext(bookcartrequest value) {
		            logger.info("Searching for book with title starting with: " + value.getName());

						for(java.util.Map.Entry<String, bookcartrequest> findbook:addcart.entrySet())
						{
							if(findbook.getValue().getName().startsWith(value.getName()))
									{
								logger.info("Found book adding to the cart");
								booksearch.add(findbook.getValue());
								
									}
						}

				}
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
//					logger.info("ggggEncount");
					
				}
				@Override
				public void onCompleted() {
					int cartvalue=0;
					for(bookcartrequest book:booksearch)
					{
						cartvalue=cartvalue+book.getPrice();
					}
					responseObserver.onNext(bookcartresponse.newBuilder().setCart(booksearch.size()).setPrice(cartvalue).build());
					responseObserver.onCompleted();	
				}								
			};
		}	
	
		
	}
	public static void main(String args[])throws Exception
	{
		serversidebookcart sbc=new serversidebookcart();
		sbc.start();
		sbc.server.awaitTermination();
	}

}
