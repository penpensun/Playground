package socketchat;
import java.net.*;
import java.io.*;

public class Client {
	private Socket client;
	private int port;
	private String host;
	private ClientMsgReceiver cmr;
	private ClientMsgSender cms;
	
	public Client(int port, String host) throws IOException{
		System.out.println("Try to connect to the server.");
		client = new Socket(host, port);
		System.out.println("Connected to the server. Chatting has started.");
		cmr = new ClientMsgReceiver(this);
		cms = new ClientMsgSender(this);
		
		new Thread(cmr).start();
		new Thread(cms).start();
	}
	public Socket getClient(){
		return client;
	}
	
	public static void main(String args[]){
		int port = 20010;
		String host = "localhost";
		try{
			Client c = new Client(port, host);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	

}
