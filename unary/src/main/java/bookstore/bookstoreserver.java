package bookstore;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.Unary.breq;
import com.Unary.bres;
import com.unaryGrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class bookstoreserver {
	static Logger logger=Logger.getLogger(bookstoreserver.class.getName());
	Server server;
	static HashMap<String,bres> bookmap=new HashMap<String,bres>();
	static {
		bookmap.put("ponniyan selvan",bres.newBuilder().setName("ponniyan selvan").setAuthor("mani").setPrice(100).build());
		bookmap.put("tenali raman",bres.newBuilder().setName("tenali raman").setAuthor("jayaprada").setPrice(50).build());
		bookmap.put("vikram vedha",bres.newBuilder().setName("vikram vedha").setAuthor("somadeva").setPrice(70).build());
		bookmap.put("tom and jerry",bres.newBuilder().setName("tom and jerry").setAuthor("william hanna").setPrice(90).build());		
	}
	void start() throws Exception
	{
		int port=2417;
		server=ServerBuilder.forPort(port).addService(new unarybook()).build().start();
		logger.info("Server is running in the port : "+server.getPort());
		
	}
	static class unarybook extends unaryGrpc.unaryImplBase{

		@Override
		public void bookstore(breq request, StreamObserver<bres> responseObserver) {
		logger.info("Serching for books by title "+request.getName());
		List<String> listcollected=bookmap.keySet().stream().filter(title->title.startsWith(request.getName())).collect(Collectors.toList());
		if(listcollected.size()>0)
		{
			bres b=null;

			b=bookmap.get(listcollected.get(0));
			responseObserver.onNext(b);
		}
		else
		{
			
		bres b=bres.newBuilder().setName("Your search "+request.getName()+" not found").build();
		responseObserver.onNext(b);

		}
		responseObserver.onCompleted();
		}
	
		
		
	}
	public static void main(String args[]) throws Exception
	{
		bookstoreserver bs=new bookstoreserver();
		bs.start();
		bs.server.awaitTermination();
	}

}
