package socketchat;
import java.net.*;
import java.io.*;

public class Server {
	private ServerSocket server;
	private Socket client;
	private int port;
	private ServerMsgReceiver smr;
	private ServerMsgSender sms;
	//Start the server.
	public Server(int port){
		try{
			server = new ServerSocket(port);
			client  = server.accept();
			System.out.println("Client is online, ip address is: "+client.getInetAddress().toString());
			
			
			smr = new ServerMsgReceiver(this);
			new Thread(smr).start();
			sms = new ServerMsgSender(this);
			new Thread(sms).start();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Socket getClientSocket() throws IOException{
		return client;
	}
	public static void main(String args[]){
		System.out.println("Starting server...");
		Server s = new Server(20010);
		
	}
	
	
}
