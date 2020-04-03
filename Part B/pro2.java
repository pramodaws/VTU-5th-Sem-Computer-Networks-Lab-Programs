import java.util.Scanner;

   public class pro2
     {
	int n;
	int [][]a;
        int[] d;
        int [] p;
        int s;
        public static final int infty=999;

    pro2(int n)
     {
      this.n=n;
      a=new int[n][n];
      d=new int[n];
      p=new int[n];
     }
 
   void bellman()
    {
     for(int i=0;i<n;i++)
      {
       d[i]=a[s][i];
       p[i]=a[s][i]==infty?-1:s;
      }
      p[s]=-1;

       for(int i=0;i<n-1;i++)
        {
         for(int u=0;u<n;u++)
          {
           for(int v=0;v<n;v++)
            {
             if(d[v]>d[u]+a[u][v])
              {
               d[v]=d[u]+a[u][v];
               p[v]=u;
              }
             }
           }
          }
         }

       void input(Scanner scanner)
        {
         System.out.println("enter g:");
         for(int i=0;i<n;i++)
          {
           for(int j=0;j<n;j++)
             {
              a[i][j]=scanner.nextInt();
              if(i!=j && a[i][j]==0)
              a[i][j]=infty;
             }
           }
       System.out.println("Enter the source vertex");
       s=scanner.nextInt();
       scanner.close();
      }

   void path(int v)
    {
     if(v==-1)
     return;
     path(p[v]);
     System.out.println("."+v);
    }

    void output()
     {
      int i;
      for(i=0;i<n;i++)
       {
        System.out.println("d("+s+","+i+")="+d[i]+"p");
        path(i);
        System.out.println();
       }
      }

    public static void main(String args[])
     {
      int n;
      Scanner scanner=new Scanner(System.in);
      System.out.println("enter n:");
      n=scanner.nextInt();
      pro2 b=new pro2(n);
      b.input(scanner);
      b.bellman(); 
      b.output();
     }
   }

