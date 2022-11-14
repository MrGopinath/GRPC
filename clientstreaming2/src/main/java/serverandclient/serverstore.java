package serverandclient;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import com.Store;
import com.Store.purchase;
import com.Store.total;
import com.storeGrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class serverstore {
	static Logger logger=Logger.getLogger(serverstore.class.getName());
	Server server;
	 void start() throws Exception{
		int port=3333;
		server=ServerBuilder.forPort(port).addService(new storebase()).build().start();
		logger.info("Server is Started At Port : "+server.getPort());
	}
	static HashMap<String,purchase>addlist=new HashMap<String,purchase>();
	static{
addlist.put("tomato", purchase.newBuilder().setName("tomato").setPrice(35).build());
addlist.put("carrot", purchase.newBuilder().setName("carrot").setPrice(25).build());
addlist.put("onion", purchase.newBuilder().setName("onion").setPrice(15).build());
addlist.put("potato", purchase.newBuilder().setName("potato").setPrice(15).build());

	}
	static class storebase extends storeGrpc.storeImplBase{

		@Override
		public StreamObserver<purchase> deptstore(StreamObserver<total> responseObserver) {
			return new StreamObserver<Store.purchase>() {
				ArrayList<purchase> storelist=new ArrayList<purchase>();

				@Override
				public void onNext(purchase value) {
					// TODO Auto-generated method stub
					for(java.util.Map.Entry<String, purchase> entrylist:addlist.entrySet())
					{
						if(entrylist.getValue().getName().startsWith(value.getName()))
						{
							logger.info("...SEARCH WAS FOUND...");
							storelist.add(entrylist.getValue());
							
						}
					}
					
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					t.printStackTrace();
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					responseObserver.onNext(total.newBuilder().setNos(storelist.size()).build());
					responseObserver.onCompleted();
					
				}
				
			};


		}
		
		
		
		
		
	}
	public static void main(String args[]) throws Exception
	{
		serverstore s=new serverstore();
		s.start();
		s.server.awaitTermination();
	}

}
