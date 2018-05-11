package Exercises;

import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
import java.io.IOException;
 
class maxpr {
    public static void main(String args[] ) throws Exception {
        
        Scan s = new Scan();
        int t = s.nextInt();
        int mod=1000000007;
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            long r[]=new long[n];
            int max[]=new int[n];
            int in[]=new int[n];
            int m=0;
            for (int i = 0; i < n; i++) {
            a[i]=s.nextInt();
            if(a[i]>m){
                m=a[i];
            }
            max[i]=m;
        }
        Stack<Integer> s1 = new Stack<Integer> ();
        s1.push(0);
        in[0]=0;
        for (int i=1; i<n; i++)
    {
       
        int top=s1.peek();
 
        if (a[i]<a[top])
        {
            in[i]=top;
            s1.push(i);
        
        }else{
            while (a[i] >a[s1.peek()])
            {
               s1.pop();
               if(s1.isEmpty()){
                   in[i]=i;
                   s1.push(i);
                   break;
               }
            }
            in[i]=s1.peek();
            s1.push(i);
        }
    }
    
        
            for (int i = 0; i < n; i++) {
            if(a[i]==max[i]&& i!=0 && max[i-1]!=max[i]){
               r[i]=1;
            }else if(i!=0 && a[i-1] >=a[i]){
                r[i]=(2*r[i-1]) % mod;
                
            }else if(i!=0){
                int j=in[i];

                int x=i-j-1;

                r[i]=((r[j]*((x+2)%mod))) % mod;
            }else{
                r[i]=1;
            }
           
        } 
        

            System.out.println(""+r[n-1]);
        }
        
        
 
       
    }
  static class Scan
{
    private byte[] buf=new byte[1024];   
    private int index;
    private InputStream in;
    private int total;
    public Scan()
    {
        in=System.in;
    }
    public int scan()throws IOException   
    {
        if(total<0)
        throw new InputMismatchException();
        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            if(total<=0)
            return -1;
        }
        return buf[index++];
    }
    public int nextInt()throws IOException
    {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n))    
        n=scan();
        int neg=1;
        if(n=='-')                
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n))
        {
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
        return true;
        return false;
    }
}
}