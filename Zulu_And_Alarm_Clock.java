package Exercises;

import java.util.*;

public class Zulu_And_Alarm_Clock {
    public static void main(String args[] ) throws Exception {
    	
  	Scanner s = new Scanner(System.in);
		int Cases = s.nextInt();
		int[] out = new int[Cases];
		for (int t_i = 0; t_i < Cases; t_i++) {
			int N = s.nextInt();
			int K = s.nextInt();
			String[] clock = new String[N];
			int[] output = new int[N];
			for (int i = 0; i < N; i++) {
				output[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < N; i++) {
				String time = s.next();
				clock[i] = time;
			}
			for (int i = 0; i < K; i++) {
				String Atime = s.next();
				for (int s_i=0; s_i<N; s_i++) {
					String Ctime = clock[s_i];
					String str1="",str2="";
					if(Atime.compareTo(Ctime) >= 0){
						str1 = Atime;
						str2 = Ctime;
					}else{
						str1 = Ctime;
						str2 = Atime;
					}
					int h1 = 0, m1 = 0, s1 = 0, h2 = 0, m2 = 0, s2 = 0,tt=0;
 
					String[] t1 = str1.split(":");
					String[] t2 = str2.split(":");
					h1 = Integer.parseInt(t1[0]);
					m1 = Integer.parseInt(t1[1]);
					s1 = Integer.parseInt(t1[2]);
					h2 = Integer.parseInt(t2[0]);
					m2 = Integer.parseInt(t2[1]);
					s2 = Integer.parseInt(t2[2]);
					
					if(s1>s2){
						if((s1-s2) >= 30){
							tt += 60-(s1-s2);
							if(s1>s2)
								m1++;
							else
								m1--;
						}
						else
							tt += s1-s2;
					}else{
						if(s2-s1 >= 30){
							tt += 60-(s2-s1);
							if(s2>s1)
								m2++;
							else
								m2--;
						}
						else
							tt += s2-s1;
					}
					if(m1>m2){
						if((m1-m2) >= 30){
							tt += 60-(m1-m2);
							if(m1>m2)
								h1++;
							else
								h1--;
						}
						else
							tt += m1-m2;
					}else{
						if(m2-m1 >= 30){
							tt += 60-(m2-m1);
							if(m2>m1)
								h2++;
							else
								h2--;
						}
						else
							tt += m2-m1;
					}
					if(h1>h2){
						if((h1-h2) >= 12){
							tt += 24-(h1-h2);							
						}
						else
							tt += h1-h2;
					}else{
						if(h2-h1 >= 12){
							tt += 24-(h2-h1);
						}
						else
							tt += h2-h1;
					}
					if (output[s_i] > tt)
						output[s_i] = tt;
				}
			}
			
			Arrays.sort(output);
			int ou=0;
			for(int k_i=0; k_i<K;k_i++){
				 ou += output[k_i];
			}
			out[t_i] = ou;
		}
		for (int i = 0; i < Cases; i++) {
			System.out.println(out[i]);
		}
		s.close();
	}
}