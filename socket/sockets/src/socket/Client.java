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
public class Client {
    public void setUpClient1() throws IOException{
         //为了简单起见，所有的异常都直接往外抛  
     String host = "127.0.0.1";  //要连接的服务端IP地址  
     int port = 8899;   //要连接的服务端对应的监听端口  
     //与服务端建立连接  
     Socket client = new Socket(host, port);  
      //建立连接后就可以往服务端写数据了  
     Writer writer = new OutputStreamWriter(client.getOutputStream());  
      writer.write("Hello Server.");  
      writer.write("eof");  
      writer.flush();  
      //写完以后进行读操作  
     Reader reader = new InputStreamReader(client.getInputStream());  
      char chars[] = new char[64];  
      int len;  
      StringBuffer sb = new StringBuffer();  
      String temp;  
      int index;  
      while ((len=reader.read(chars)) != -1) {  
         temp = new String(chars, 0, len);  
         if ((index = temp.indexOf("eof")) != -1) {  
            sb.append(temp.substring(0, index));  
            break;  
         }  
         sb.append(new String(chars, 0, len));  
      }  
      System.out.println("from server: " + sb);  
      writer.close();  
      reader.close();  
      client.close();  
    }
    
    public void setUpClient2() throws IOException{
        Socket client;
        int length = 1000;
        for(int i=0;i<length;i++){
                client = new Socket("127.0.0.1", 10111);
                client.close();
        }
    }
    public static void main(String args[]) throws Exception {  
        new Client().setUpClient2();
   }  
}
