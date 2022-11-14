package serverandclient;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.Store;
import com.Store.cart;
import com.Store.searchmob;
import com.mobilestoreGrpc;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class clientbi {
	static Logger logger=Logger.getLogger(clientbi.class.getName());
	mobilestoreGrpc.mobilestoreStub stub;
	StreamObserver<searchmob> clientrequest;
	clientbi(Channel channel)
	{
		stub=mobilestoreGrpc.newStub(channel);
	}
	StreamObserver<cart> serverresponse(){
		StreamObserver<cart> observer=new StreamObserver<Store.cart>() {
			
			@Override
			public void onNext(cart value) {
				// TODO Auto-generated method stub
				logger.info("BRAND- "+value.getName()+"\n"+"MODEL- "+value.getModel()+"\nCOUNT IN CART- "+value.getNos()+"\nTOTAL COST- "+value.getPrice());
				
				
			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				logger.info("---FINISHED----");
				
			}
		};
		return observer;
		
	}
	void addtocart(String name)
	{
		logger.info("....SEARCHING FOR YOUR BRAND....");
		searchmob send=searchmob.newBuilder().setName(name).build();
		clientrequest=stub.mobile(serverresponse());
		clientrequest.onNext(send);

	}
	void complete()
	{
		clientrequest.onCompleted();
	}
	

	public static void main(String args[])throws Exception{
		Scanner in=new Scanner(System.in);
		String serveraddress="localhost:8888";
		ManagedChannel channel=ManagedChannelBuilder.forTarget(serveraddress).usePlaintext().build();
		String name;
		try {
			clientbi cb=new clientbi(channel);
			while(true) {
			logger.info("ENTER YOUR REQUIRED MOBILE BRAND");
			name=in.next();
			if(name.equals("exit"))
			{
				cb.complete();
				break;
			}
			cb.addtocart(name);
			Thread.sleep(3000);
			}
			while(true)
			{
				Thread.sleep(3000);

			}
			
		}
		finally {
channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
}
		
	}

}
