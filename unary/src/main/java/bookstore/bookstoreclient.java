package bookstore;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.Unary.breq;
import com.Unary.bres;
import com.unaryGrpc;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class bookstoreclient {
	static Logger logger=Logger.getLogger(bookstoreclient.class.getName());
	unaryGrpc.unaryBlockingStub blockingstub;
	public bookstoreclient(Channel channel)
	{
		blockingstub=unaryGrpc.newBlockingStub(channel);
		
	}
	public void searchbook(String bookname)
	{
		logger.info("SEARCHING THE BOOK BY ITS NAME ---"+bookname);
		breq bookreq=breq.newBuilder().setName(bookname).build();
		bres bookres;
		bookres=blockingstub.bookstore(bookreq);
		logger.info("Got the following from server \n\nTITLE:"+bookres.getName()+"\nAUTHOR:"+bookres.getAuthor()+"\nPRICE:"+bookres.getPrice());
		
	}
	
	
	public static void main(String args[]) throws Exception
	{
		String name;
		System.out.println("SEARCH--");
		Scanner in=new Scanner(System.in);
		name=in.next();
		
		String serveraddress="localhost:2417";
		ManagedChannel channel=ManagedChannelBuilder.forTarget(serveraddress).usePlaintext().build();
		try {
			bookstoreclient bc=new bookstoreclient(channel);
			bc.searchbook(name);
			
			
		}
		finally {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		}
	}

}
