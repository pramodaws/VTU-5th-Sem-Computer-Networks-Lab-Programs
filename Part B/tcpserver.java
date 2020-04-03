import java.io.*;
import java.nio.file.*;
import java.net.*;
import java.nio.charset.*;
import java.util.*;

  public class tcpserver
   {
    void server() throws Exception
   {
    ServerSocket ss=new ServerSocket(3333);
    System.out.println("server is waiting for connection from client");
    Socket cs=ss.accept();
    DataInputStream din=new DataInputStream(cs.getInputStream());
    DataOutputStream dout=new DataOutputStream(cs.getOutputStream());
    String filename=din.readUTF();
    List<String> lines=Files.readAllLines(Paths.get(filename),Charset.defaultCharset());
    for(int i=0;i<lines.size();i++)
     {
      System.out.println("server:"+lines.get(i));
      dout.writeUTF(lines.get(i));
     }

   din.close();
   cs.close();
   ss.close();
  }

   public static void main(String args[]) throws Exception
   {
    tcpserver ts=new tcpserver();
    ts.server();
   }
 }

