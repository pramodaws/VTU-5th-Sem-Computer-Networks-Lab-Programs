import java.net.*;
import java.util.Scanner;

   class udpserver
    {
     public void server() throws Exception
     {
      DatagramSocket socket =new DatagramSocket(3333);
      DatagramPacket packet;
      System.out.println("udp server listening in "+3333);
      byte[] msgBuffer=new byte[1024];
      packet=new DatagramPacket(msgBuffer,msgBuffer.length);
      socket.receive(packet);
      String message=new String(msgBuffer,0,packet.getLength());
      System.out.println("client:message received="+message);
      InetAddress address=packet.getAddress();
      int port=packet.getPort();
      Scanner scanner=new Scanner(System.in);
      System.out.println("server type lines of text;type 'stop' to terminate");

   do
   {
    message=scanner.nextLine();
    packet=new DatagramPacket(message.getBytes(),message.length(),address,port);
    socket.send(packet);
   }

  while(message.compareTo("stop")!=0);
  scanner.close();
  socket.close();
 }

 public static void main(String[] args)throws Exception
  { 
   udpserver us=new udpserver();
   us.server();
  } 
 }
