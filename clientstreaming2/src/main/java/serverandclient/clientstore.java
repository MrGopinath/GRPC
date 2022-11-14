package serverandclient;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.Store;
import com.Store.purchase;
import com.Store.total;
import com.storeGrpc;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
public class clientstore {
	static Logger logger=Logger.getLogger(clientstore.class.getName());
	storeGrpc.storeStub stub;
	boolean servercompleted=false;
	StreamObserver<purchase> streamsender;
	StreamObserver<total> serverresponse()
	{
		StreamObserver<total> observer=new StreamObserver<Store.total>() {
			
			@Override
			public void onNext(total value) {
				// TODO Auto-generated method stub
				logger.info("***THE RESULT***: "+value.getNos());
				
			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				logger.info("ERROR IN CLIENT");
				
			}
			
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
//				servercompleted=true;
				logger.info("FINISHED CLIENT STREAMING");
				
			}
		};
		return observer;
	}
	
	 clientstore(Channel channel)
	{
		stub=storeGrpc.newStub(channel);
	}
	public void addtocart(String name)
	{
		logger.info("---FINDING VEGETABLES WITH STARTING LETTER---"+name);
		purchase send=purchase.newBuilder().setName(name).build();
		streamsender=stub.deptstore(serverresponse());
		streamsender.onNext(send);
	}
	public void completedfun()
	{
		streamsender.onCompleted();
	}
	public static void main(String args[])throws Exception
	{
		String serveraddress="localhost:3333";
		ManagedChannel channel=ManagedChannelBuilder.forTarget(serveraddress).usePlaintext().build();
		Scanner in=new Scanner(System.in);
		try {
		clientstore cs=new clientstore(channel);
		while(true)
		{
		logger.info("...TYPE YOUR REQUIRED VEGETABLE NAME...");
		String name=in.nextLine();
		if(name.equals("exit"))
		{
			cs.completedfun();
			break;
		}
		cs.addtocart(name);
		if(cs.servercompleted==false)
		{
			logger.info("IIIIIIIIII");
		Thread.sleep(3000);	
		}
//		cs.completedfun();
		}
		while(cs.servercompleted==false)
		{
			logger.info("WWWWWWWWWW");
		Thread.sleep(3000);	
		}

		}
		
		finally {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		}
		

}
}