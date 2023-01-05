// A Java program for a Client
import java.net.*;
import java.io.*;

public class EchoClient
{
	// initialize socket and input output streams
	private Socket socket		 = null;
	private DataInputStream input = null;
private DataInputStream in = null; // initiating socket for data input
	private DataOutputStream out	 = null;

	// constructor to put ip address and port
	public EchoClient(String address, int port)
	{
		// establish a connection
		try
		{
			socket = new Socket(address, port);

			System.out.println("Connected");

			// takes input from terminal
			input = new DataInputStream(System.in);
in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}

		// string to read message from input
		String line = "";
String line2 = "";

		// keep reading until "Over" is input
		while (!line.equals("Over"))
		{
			try
			{
				line = input.readLine();

				out.writeUTF(line);
                line2 = in.readUTF(); //reading the input from the client 
System.out.println(line2);
			}
			catch(IOException i)
			{
				System.out.println(i);
			}
		}

		// close the connection
		try
		{
			input.close();
in.close();
			out.close();
			socket.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		EchoClient client = new EchoClient("127.0.0.1", 5000);
	}
}
