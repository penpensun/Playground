package sockettest;
import java.net.*;
import java.io.*;

public class Server {
	private ServerSocket server;
	public void setUpServer() throws IOException{
		server = new ServerSocket(10111);
		int count=0;
		System.out.println("Server is started");
		while(true){
			Socket clientSocket = server.accept();

		}
	}
	
	public static void main(String args[]) throws IOException{
		new Server().setUpServer();
	}
}
