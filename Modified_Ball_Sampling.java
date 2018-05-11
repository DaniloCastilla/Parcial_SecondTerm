package Exercises;

import java.util.Scanner;

public class Modified_Ball_Sampling {

private static int PRIME = 998244353;
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int P = in.nextInt();
        int K = in.nextInt();
        
        int[] freq = new int[P];
        for(int i = 0 ;i < N;i++){
            int vi = in.nextInt();
            freq[vi]++;
        }
        
        updateFreq(freq, K);
        System.out.println(computeXByYModPrime(freq));
        
        in.close();
    }
    
    private static int computeXByYModPrime(int[] freq){
        long numerator = 0;
        long denominator = 0;
        for(int i = 0;i < freq.length;i++){
            numerator = (numerator + productModP(i, freq[i], PRIME)) % PRIME;
            denominator += freq[i];
        }
        
        return productModP(numerator, multInverse((int)denominator, PRIME), PRIME);
    }
    
    private static int multInverse(int value, int prime){
        int r0 = prime, s0 = 1, t0 = 0;
        int r1 = value, s1 = 0, t1 = 1;
        while(r1 != 0){
            int quot = r0/r1;
            int r2 = r0 - r1*quot;
            int s2 = s0 - s1*quot;
            int t2 = t0 - t1*quot;
            
            r0 = r1;r1 = r2;
            s0 = s1;s1 = s2;
            t0 = t1;t1 = t2;
        }
        return t0 < 0 ? (t0 + prime) : t0;
    }
    
    private static void updateFreq(int[] freq, int K){
        int[] tempFreq = new int[freq.length];
        for(int i = 2;i <= K;i++){
            for(int j = 0;j < freq.length;j++){
                if(freq[j] == 0) continue;
                
                for(int k = 0;k < freq.length;k++){
                    if(freq[k] == 0) continue;
                    
                    tempFreq[productModP(j, k, freq.length)] = freq[j] + freq[k];
                }
            }
        }
    }
    
    private static int productModP(long x, long y, int p){
        return (int) ((x*y) % p);
    }
	
}
