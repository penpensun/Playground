package socketchat;
import java.net.*;
import java.io.*;

public class ClientMsgSender implements Runnable{
	private Client client;
	public ClientMsgSender(Client client){
		this.client = client;
	}
	
	public void run(){
		try{
			Socket clientSocket = client.getClient();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line;
			while(true){
				if(clientSocket.isClosed()){
					System.out.println("Chat finished.");
					break;
				}
				else{
					line = reader.readLine();
					System.out.println("Client: ");
					System.out.println(line);
					writer.write(line);
					writer.newLine();
					writer.flush();
					if(line.equals("bye"))
						break;
				}
			}
			writer.close();
			reader.close();
			
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
