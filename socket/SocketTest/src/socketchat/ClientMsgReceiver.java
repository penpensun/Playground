package socketchat;
import java.io.*;
import java.net.*;

public class ClientMsgReceiver implements Runnable{
	private Client client;
	public ClientMsgReceiver(Client client){
		this.client = client;
	}
	
	public void run(){
		try{
			Socket clientSocket = client.getClient();
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String line = null;
			while(true){
				if(clientSocket.isClosed()){
					System.out.println("Chat finished.");
					break;
				}
				else{
					line = reader.readLine();
					System.out.println("Server: ");
					System.out.println(line);
				}
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
