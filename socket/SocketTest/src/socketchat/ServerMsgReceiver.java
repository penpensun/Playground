package socketchat;
import java.net.*;
import java.io.*;


public class ServerMsgReceiver implements Runnable{
	private Server server;
	public ServerMsgReceiver(Server server){
		this.server = server;
	}
	
	//Start the message receiving thread
	public void run(){
		try{
			// Get client socket.
			Socket client = server.getClientSocket();
			// Get the inputstream from the socket
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String line;
			while(true){
				if(client.isClosed()){
					System.out.println("The client is offline. Chat finished.");
					break;
				}
				else{
					line= reader.readLine();
					if(line.equals("bye")){
						System.out.println(line);
						System.out.println("Chat finished.");
						client.close();
						break;
					}
					else{
						System.out.println("Client: ");
						System.out.println(line);
					}
				
				}
				
			}
			
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
