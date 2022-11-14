package serverandclient;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.Store;
import com.Store.cart;
import com.Store.searchmob;
import com.mobilestoreGrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class serverbi {
	static Logger logger=Logger.getLogger(serverbi.class.getName());
	Server server;
	static HashMap<String,searchmob> mobmap=new HashMap<String,searchmob>();
	static {
		mobmap.put("samsung", searchmob.newBuilder().setName("samsung").setModel("m51").setPrice(25000).build());
		mobmap.put("apple", searchmob.newBuilder().setName("apple").setModel("14pro").setPrice(85000).build());
		mobmap.put("pixel", searchmob.newBuilder().setName("pixel").setModel("7pro").setPrice(60000).build());		
		
	}
	static ArrayList<searchmob> moblist=new ArrayList<searchmob>();
	static 	int cartvalue=0;


	
	void start() throws Exception
	{
		int port=8888;
		server=ServerBuilder.forPort(port).addService(new addmob()).build().start();
		logger.info("Server Started At Port- "+server.getPort());
	}
	static class addmob extends mobilestoreGrpc.mobilestoreImplBase{

		@Override
		public StreamObserver<searchmob> mobile(StreamObserver<cart> responseObserver) {
			// TODO Auto-generated method stub
			return new StreamObserver<Store.searchmob>() {

				@Override
				public void onNext(searchmob value) {
					// TODO Auto-generated method stub
					for(java.util.Map.Entry<String, searchmob> mobentry:mobmap.entrySet())
					{
						if(mobentry.getValue().getName().startsWith(value.getName()))
						{
							logger.info("MOBILE FOUND");
							moblist.add(mobentry.getValue());
							cartvalue+=mobentry.getValue().getPrice();
						}
						
					}
					logger.info("updating cart value");
					for(searchmob mob:moblist)
					{
						responseObserver.onNext(cart.newBuilder().setName(mob.getName()).setModel(mob.getModel()).setNos(moblist.size()).setPrice(cartvalue).build());

					}
	

				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					logger.info("ORDER COMPLETED");
					responseObserver.onCompleted();
					
				}
				
			};
		}
		
	}
	public static void main(String args[])throws Exception
	{	

		serverbi sb=new serverbi();
		sb.start();
		sb.server.awaitTermination();
		
	}

}
