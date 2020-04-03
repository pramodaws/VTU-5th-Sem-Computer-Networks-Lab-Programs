import java.io.*;
import java.net.*;
import java.util.*;

  public class tcpclient
   {
    void client() throws Exception
    {
     Socket s=new Socket("192.168.30.24", 3333);
     DataInputStream din=new DataInputStream(s.getInputStream());
     DataOutputStream dout=new DataOutputStream(s.getOutputStream());
     Scanner sc=new Scanner(System.in);
     System.out.println("enter filename");
     String filename=sc.next();
     dout.writeUTF(filename);
     String message;

  do
  {
   message=din.readUTF();
   System.out.println("client:"+message);
  }

   while(!message.equals("stop"));
    sc.close();
    dout.close();
    s.close();
  }

  public static void main(String args[]) throws Exception
  {
   tcpclient ob=new tcpclient();
   ob.client();
  }
}
