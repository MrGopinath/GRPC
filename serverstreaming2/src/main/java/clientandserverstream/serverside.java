package clientandserverstream;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.*;
import com.Serverstream.areq;
import com.Serverstream.ares;
import com.serverstreamingGrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class serverside {
	static Logger logger=Logger.getLogger(serverside.class.getName());
	 Server server;
	 static HashMap<String,ares> authorfind=new HashMap<String,ares>();
	 static {
		 authorfind.put("ponniyan selvan",ares.newBuilder().setName("ponniyan selvan").setAuthor("mani").setPrice(100).build());
		authorfind.put("tenali raman",ares.newBuilder().setName("tenali raman").setAuthor("jayaprada").setPrice(50).build());
		authorfind.put("ok kanmani",ares.newBuilder().setName("ok kanmani").setAuthor("mani").setPrice(35).build());
		authorfind.put("vikram vedha",ares.newBuilder().setName("vikram vedha").setAuthor("somadeva").setPrice(70).build());
		authorfind.put("tom and jerry",ares.newBuilder().setName("tom and jerry").setAuthor("william hanna").setPrice(90).build());
		 
	 }
	void start() throws Exception
	{
		int port=1111;
		server=ServerBuilder.forPort(port).addService(new ssstream()).build().start();
		logger.info("Server Started At "+server.getPort());
	}
	static class ssstream extends serverstreamingGrpc.serverstreamingImplBase{

		@Override
		public void authorsearch(areq request, StreamObserver<ares> responseObserver) {
			try {
			logger.info("Searching for the books with the name author: "+request.getAuthor());
			for(java.util.Map.Entry<String, ares> bookfind:authorfind.entrySet())
			{
				Thread.sleep(2000);
				logger.info("Going through more books");
					if(bookfind.getValue().getAuthor().startsWith(request.getAuthor()));
					{
						if(bookfind.getValue().getAuthor().equals(request.getAuthor()))
						{
						responseObserver.onNext(bookfind.getValue());
					}
								}


	
			}
			responseObserver.onCompleted();

		}
		
		catch(Exception e) {
		}
		
		}
	}
	
	public static void main(String args[])throws Exception
	{
		serverside sobj=new serverside();
		sobj.start();
		sobj.server.awaitTermination();
	}

}
