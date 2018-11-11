/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.OutputStreamWriter;

/**
 *
 * @author GGTTF
 */
public class Server {  
    
    public void setUpServer1() throws IOException{
        //为了简单起见，所有的异常信息都往外抛  
      int port = 8899;  
      //定义一个ServerSocket监听在端口8899上  
      ServerSocket server = new ServerSocket(port);  
      //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的  
      Socket socket = server.accept();  
      //跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了。  
      Reader reader = new InputStreamReader(socket.getInputStream());  
      char chars[] = new char[64];  
      int len;  
      StringBuilder sb = new StringBuilder();  
      String temp;  
      int index;  
      while ((len=reader.read(chars)) != -1) {  
         temp = new String(chars, 0, len);  
         if ((index = temp.indexOf("eof")) != -1) {//遇到eof时就结束接收  
            sb.append(temp.substring(0, index));  
            break;  
         }  
         sb.append(temp);  
      }  
      System.out.println("from client: " + sb);  
      //读完后写一句  
      Writer writer = new OutputStreamWriter(socket.getOutputStream());  
      writer.write("Hello Client.");  
      writer.flush();  
      writer.close();  
      reader.close();  
      socket.close();  
      server.close(); 
    }
    
    public void setUpServer() throws IOException{
        ServerSocket server = new ServerSocket(10111);
        int count=0;
        System.out.println("Server is started");
        while(true){
                Socket clientSocket = server.accept();
                System.out.println("The number of connected client:  "+ (++count));
        }
    }

   public static void main(String args[]) throws IOException {  
       new Server().setUpServer();
   }  

}  
