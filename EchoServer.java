import java.net.*;
import java.io.*;


public class EchoServer{

//initialising socket and input stream

private Socket socket = null; //initiating socket for receiving client
private ServerSocket server = null; //initiating socket for server
private DataInputStream in = null; // initiating socket for data input
	private DataOutputStream out	 = null;

//constructor with port

public EchoServer(int port){

try
{
server = new ServerSocket(port); //initiating the server socket with the given port number

String line = "";
System.out.println("Server started"); 

while(!line.equals("OverAll")){

line = "";

System.out.println("Waiting for a client...");
socket = server.accept(); //accepting the client to this socket


in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));
			out = new DataOutputStream(socket.getOutputStream());


//reads message from client until "Over" is sent

while(!line.equals("Over")){

try{
line = in.readUTF(); //reading the input from the client 
System.out.println(line);
				out.writeUTF(line);
}

catch(IOException i){

System.out.println(i);

}
}
System.out.println("Closing the Connection");

//CLose the connection
socket.close();
System.out.println("\n New Client: ");
}
in.close();
			out.close();
}

catch(IOException i){
System.out.println(i);
}
}
public static void main(String args[]){
EchoServer server = new EchoServer(5000);
}
}
