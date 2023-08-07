package pckg;

import java.io.IOException;
import java.net.Socket;

public class Client extends Main
{
	private Socket client = null;
	public Client(String address, int port) 
	{
		
		try 
		{
		client = new Socket(address,port);
		}
		
		catch(IOException e) 
		{
			
		}
		
		
	}
	
	
	public static void main(String[] args) 
	{
		
		
	}

}
