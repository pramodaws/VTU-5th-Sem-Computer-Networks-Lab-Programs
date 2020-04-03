import java.util.Scanner;

   public class pro1
    {
      int w;
      char[] p;
      String checksum,message;

      pro1()
       {
	w=16;
        p="10001000000100001".toCharArray();
       }

    void crc()
     {
      String crc="0000000000000000";
      char[] msg=(message+crc).toCharArray();
      char[] rem=(crc+'0').toCharArray();
      int n=0;

       while(n<msg.length)
        {
          rem[w]=msg[n++];
          boolean xorcopy=rem[0]=='1';

          for(int i=1;i<=w;i++)
           {
            rem[i-1]=xorcopy?(rem[i]==p[i]?'0':'1'):rem[i];
           }
         }

       checksum=String.valueOf(rem).substring(0,w);
      }

  void input()
   {
    Scanner input=new Scanner(System.in);
    System.out.println("MESSAGE");
    message=input.next();
    input.close();
   }

  void output()
   {
    System.out.println("checksum:"+checksum);
   }

   public static void main(String args[])
    {
     pro1 crc=new pro1();
     crc.input();
     crc.crc();
     crc.output();
    }
  }

