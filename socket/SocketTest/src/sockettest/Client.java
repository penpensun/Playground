package sockettest;
import java.net.*;
import java.io.*;

public class Client {
	private Socket client;
	public void connToServer() throws IOException{
		int length = 1000;
		for(int i=0;i<length;i++){
			client = new Socket("127.0.0.1", 10123);
			client.close();
		}
	}
	
	public static void main(String args[]) throws IOException{
		new Client().connToServer();
	}
}
