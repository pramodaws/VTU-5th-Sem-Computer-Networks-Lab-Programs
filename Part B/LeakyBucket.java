import java.util.*;

    public class LeakyBucket
     {
      int n;
      int burst;
      int outgoingRate;
      int bucketsize;
      int incoming;
      int outgoing;
      int pending;
      int overflow;
      int duration;
      int interval;

   LeakyBucket()
    {
     pending=0;
     incoming=0;
     overflow=0;
     outgoing=0;
    }

   void leakyBucket()
   {
    System.out.println("time incoming pending overflow outgoing");
    Random rand=new Random();
    int time=0;
    while(time<duration)
     {
      incoming=rand.nextInt(burst);

      if((pending+incoming)>bucketsize)
      {
       overflow=(pending+incoming)-bucketsize;
       pending+=bucketsize;
      }

    else pending+=incoming;
    interval=1;

   for(int clk=0;clk<interval;++clk)
   {
    output(time,incoming,pending,overflow,outgoing);
    outgoing=Math.min(outgoingRate,pending);
    pending-=outgoing;
    incoming=0;
    ++time;
   }
  }
 }
   
    void input()
    {
     Scanner scanner=new Scanner(System.in);
     System.out.println("enter burstsize");
     burst=scanner.nextInt();
     System.out.println("enter bucketsize");
     bucketsize=scanner.nextInt();
     System.out.println("enter outgoingRate");
     outgoingRate=scanner.nextInt();
     System.out.println("enter duration");
     duration=scanner.nextInt();
     scanner.close();
    }

    void output(int time,int incoming,int pending,int overflow,int outgoing)
     {
      System.out.printf("%d\t%d\t%d\t%d\t%d\n",time,incoming,pending,overflow,outgoing);
     }

    public static void main(String args[])
    {
     LeakyBucket lb=new LeakyBucket();
     lb.input();
     lb.leakyBucket();
    }
  }
