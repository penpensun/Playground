package socketchat;
import java.io.*;
import java.net.*;

public class ServerMsgSender implements Runnable{
	private Server server;
	public ServerMsgSender(Server server){
		this.server = server;
	}
	
	// Start the message sending thread
	public void run(){
		
		try{
			//Get client socket.
			Socket client = server.getClientSocket();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			String line = null;
			while(true){
				line = reader.readLine();
				if(client.isClosed()){
					System.out.println("The client is offline. Chat finished.");
					break;
				}
				else{
					System.out.println("Server:  ");
					System.out.println(line);
					//Write the line to client
					writer.write(line);
					writer.newLine();
					writer.flush();
				}
			}
			
			//close the streams
			reader.close();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
