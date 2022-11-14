package clientandserverstream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import com.Serverstream.areq;
import com.Serverstream.ares;
import com.serverstreamingGrpc;
import java.util.Iterator;
import java.util.Scanner;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class clientside {
	static Logger logger=Logger.getLogger(clientside.class.getName());
	serverstreamingGrpc.serverstreamingBlockingStub asyncstub;
	public  clientside(Channel channel)
	{
		asyncstub=serverstreamingGrpc.newBlockingStub(channel);
		
	}
	public void makesearch(String author) throws Exception
	{
		logger.info("Search book by Author name : "+author);
		areq clientrequest=areq.newBuilder().setAuthor(author).build();
		Iterator<ares> serverresponse;
		serverresponse=asyncstub.authorsearch(clientrequest);

		while(serverresponse.hasNext())
			{

				Thread.sleep(5000);
				logger.info("HENCE FOUND BOOK "+serverresponse.next());
			}
	
		logger.info("---COMPLETED---");
		
	}
	public static void main(String args[]) throws Exception
	{
		Scanner in=new Scanner(System.in);
		String author;
	logger.info("search by author name------");
		author=in.next();
		String serviceaddress="localhost:1111";
		ManagedChannel channel=ManagedChannelBuilder.forTarget(serviceaddress).usePlaintext().build();
		try {
			clientside cs=new clientside(channel);
			cs.makesearch(author);


		}
		finally {
			channel.shutdownNow().awaitTermination(5,TimeUnit.SECONDS);
			
		}
	}

}
