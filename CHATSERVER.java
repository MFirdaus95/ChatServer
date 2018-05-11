import java.io.*;
import java.net.*;

public class ChatServer
{
    public static void main(String[] args) throws Exception
    {
      ServerSocket sersock = new ServerSocket(4583);
      System.out.println("CHAT IS READY");
      Socket sock = sersock.accept();
      String IPadd = sock.getInetAddress().getHostAddress();
      String clientPort = ""+sock.getLocalPort();
      String hostname = sock.getInetAddress().getCanonicalHostName();
      System.out.println("Connected" + hostname +" " + IPadd);
      BufferedReader keyRead = new BufferedReader(new 
InputStreamReader(System.in));
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true);
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new 
InputStreamReader(istream));
      String receiveMessage, sendMessage;               
      System.out.println("If you want to exit, press C");
      while(true)
      {
        sendMessage = keyRead.readLine();
        
        //start chatting to client
        if(sendMessage.equalsIgnoreCase("IPadd"))
        {
          System.out.println(IPadd);
          pwrite.println("NOTHING TO SHOW");
          pwrite.flush();
        }
        else if(sendMessage.equalsIgnoreCase("hostname"))
        {
          System.out.println(hostname);
          pwrite.println("NOTHING TO SHOW");
          pwrite.flush();
        }
        else if(sendMessage.equalsIgnoreCase("port"))
        {
          System.out.println(clientPort);
          pwrite.println("NOTHING TO SHOW");
          pwrite.flush();
        }
        else
        {
          pwrite.println(sendMessage);
          pwrite.flush();
        }
        if((receiveMessage = receiveRead.readLine()) != null)
        {
           System.out.println(receiveMessage);
        }
      }
    }
}
