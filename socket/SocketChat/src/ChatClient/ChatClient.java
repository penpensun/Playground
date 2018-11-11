/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatClient;
import ChatServer.ChatServer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.*;
import java.io.*;

/**
 *
 * @author GGTTF
 */
public class ChatClient extends javax.swing.JFrame {
    private Socket client;
    private int port;
    private String host;
    private BufferedReader clientReader = null;
    private BufferedWriter clientWriter = null;
    private MsgReceiver receiver = null;
    
    /**
     * Creates new form ChatClient
     */
    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
        initComponents();
        conn();
        receiver = new MsgReceiver(this);
        new Thread(receiver).start();
        inputArea.addKeyListener(new MsgInputListener(this));
    }
    
    public void conn(){
        try{
            client = new Socket(host, port);
            
            clientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            clientWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /**
     * return the BufferedReader
     * @return 
     */
    public final BufferedReader getClientReader(){
        return clientReader;
    }
    
    /**
     * return BufferedWriter
     * @return 
     */
    public final BufferedWriter getClientWriter(){
        return clientWriter;
    }

    /**
     * return client socket.
     * @return 
     */
    public final Socket getClientSocket(){
        return client;
    }
    
    public void closeConn(){
        try{
            clientReader.close();
            clientWriter.close();
            client.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public void appendText(String line){
        chatArea.append(line+"\n");
    }
    
    public String getInput(){
        return inputArea.getText();
    }
    
    public void clearInputArea(){
        inputArea.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Client");

        inputArea.setColumns(20);
        inputArea.setRows(5);
        jScrollPane2.setViewportView(inputArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClient("localhost", 10011).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}


class MsgReceiver implements Runnable{
    ChatClient client = null;
    
    public MsgReceiver(ChatClient client){
        this.client = client;
    }
    
    public void run(){
        BufferedReader reader = client.getClientReader();
        try{
        while(true){
            if(client.getClientSocket().isClosed()){
                client.closeConn();
                break;
            }
            String line = reader.readLine();
            client.appendText(line);
        }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


class MsgInputListener implements KeyListener{
    
    private ChatClient client;
    private BufferedWriter writer;
    
    public MsgInputListener(ChatClient client){
        this.client = client;
        writer = client.getClientWriter();
    }
    
    @Override
    public void keyPressed(KeyEvent e){
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        int keyTyped = e.getKeyCode();
        if(keyTyped == KeyEvent.VK_ENTER){
            System.out.println("return is pressed.");
            //Send the message
            String line= client.getInput();
            client.clearInputArea();
            try{
                writer.write(line+"\n");
                writer.flush();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}

