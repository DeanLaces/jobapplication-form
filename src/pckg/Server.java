package pckg;



import java.net.*;
import java.util.ArrayList;
import java.io.*;
 
public class Server extends Main
{
    //initialize socket and input stream
    private Socket client= null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    private boolean isRunning = false;
 
    // constructor with port
    public Server(int port)
    {
    	Socket tempSocket;
    	this.isRunning = true;
    	
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            client = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(client.getInputStream()));
 
            String line = "";
 
            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
 
                }
                catch(IOException i)
                {
                }
            }
            System.out.println("Closing connection");
 
            // close connection
            client.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        
    }
}