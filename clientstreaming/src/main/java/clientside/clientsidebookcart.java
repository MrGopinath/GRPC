package clientside;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.io.Console;
import com.Clientstreaming.bookcartrequest;
import com.Clientstreaming.bookcartresponse;
import com.clientstreamGrpc;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class clientsidebookcart {
	static Logger logger = Logger.getLogger(clientsidebookcart.class.getName());
	clientstreamGrpc.clientstreamStub stub;
	boolean serverresponsecompleted = false;

	public clientsidebookcart(Channel channel) {
		stub = clientstreamGrpc.newStub(channel);

	}

	StreamObserver<bookcartrequest> streamclientsender;

	public StreamObserver<bookcartresponse> getserverresponseobserver() {
		StreamObserver<bookcartresponse> observer = new StreamObserver<bookcartresponse>() {

			@Override
			public void onNext(bookcartresponse value) {

				// TODO Auto-generated method stub
				logger.info("order summary :\n Total no of books : " + value.getCart() + " \nTotal order values : "
						+ value.getPrice());

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
//				logger.info("hhhhhhhEncounted Error");
				t.printStackTrace();

			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
//				serverresponsecompleted = true;
				logger.info("FINISHED CLINET STREAMING");
//				serverresponsecompleted=true;

			}

		};

		return observer;

	}

	public void completeorder() {
		logger.info("Done waiting for order for Summary");
//		if(streamclientsender!=null)
		streamclientsender.onCompleted();

	}

	public void addtocart(String name) {
		logger.info("Adding book with the title " + name);
		bookcartrequest request = bookcartrequest.newBuilder().setName(name).build();
//		if (streamclientsender == null) {

			streamclientsender = stub.bookcart(getserverresponseobserver());
//		}

		streamclientsender.onNext(request);

	}

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		String serveraddress = "localhost:2222";
		ManagedChannel channel = ManagedChannelBuilder.forTarget(serveraddress).usePlaintext().build();
		try {
			clientsidebookcart clientcart = new clientsidebookcart(channel);
			String name;

			while (true) {
				System.out.println("type the book name to be added");

				name = in.nextLine();
				if (name.equals("exit")) {
					clientcart.completeorder();
					break;

				}
				clientcart.addtocart(name);
				if (clientcart.serverresponsecompleted == false) {
					Thread.sleep(2000);
				}
			}
//			clientcart.completeorder();

			while (clientcart.serverresponsecompleted == false) {
				Thread.sleep(2000);
			}

		} 
//		catch(Exception e)
//		{
//			System.out.print(e);
//		}
		finally {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);

		}
	}

}
