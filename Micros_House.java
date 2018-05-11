package Exercises;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
 
public class Micros_House {
	
	 private static int[]FindMax(int []Array) {
			int []result = new int[3];
			
			Node raiz = new Node();
			
			insert(raiz, 0, -1);
			
			int preXor = 0;
			
			result[0] = Integer.MIN_VALUE;
			
			int start =0;
			
			int end =-1;
			
			for(int i=0;i<Array.length;i++) {
				
				preXor ^= Array[i];
				
				int[]TestRes = Test(raiz, preXor);

				int res = Math.max(result[0], TestRes[0]);
				
				if(res > result[0]) {
					result[0] = res;
					end = i;
					start = TestRes[1];
					result[1] = start;
					result[2] = end;
				}
				insert(raiz, preXor, i);
			}
			return result;
		}
		
	
	 static class Node {
				
		 int value;
		 int index;
		 Node []son = new Node[2];
	}
	 
	 private static void insert(Node root, int num, int arrayIndex) {
		 
		 for(int i=31; i>=0; i--) {
			 int bit = num &(1<<i);
			 int index = 0;
			 if(bit >0)
				 index = 1;
				 
			 else 
				 index =0;
					
			 if(root.son[index] == null) 
				 root.son[index] = new Node();
			 
				root = root.son[index];
			}
			
			root.value = num;
			root.index = arrayIndex;
		}
		
	// 			
	 private static int[] Test(Node root, int pre_xor) {
		 int []Res = new int[2];
		 for(int i=31; i>=0; i--) {
			 int bit = pre_xor &(1<<i);
			 int index = 0;
			 if(bit >0) 
				 index = 1;
					
			  else 
					
				  index =0;
				
				
					
			 if(root.son[1-index] != null) 
				 root = root.son[1-index];
			 else 
				 if(root.son[index] != null) 
					root = root.son[index];
				
			}
			
			
		 Res[0] = pre_xor^(root.value);
		 Res[1] = root.index;
		 return Res;	
	 }
	
	
	
	
    public static void main(String args[] ) throws Exception {
    	
    	Scanner sc = new Scanner(System.in);
    	BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
    	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    	
   
    	String enter = sc.nextLine();
		int N = Integer.parseInt(enter.split(" ")[0]);
		int M = Integer.parseInt(enter.split(" ")[1]);
		int [][]Input = new int[N][M];
		
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<M;j++) 
				Input[i][j] = sc.nextInt();
		
		}
	
		int []result;
		int rows = Input.length;
		int cols = Input[0].length;
		int Xor = Integer.MIN_VALUE;
	
		try{	
			  	
		
		for(int leftCol =0; leftCol<cols; leftCol++) {
			int temp[] = new int[rows];
			for(int rightCol = leftCol; rightCol<cols; rightCol++) {
			
				for(int i=0;i<rows;i++){
					temp[i] ^= Input[i][rightCol];
				}
				
				result = FindMax(temp);
				
				if(result[0] > Xor && (result[2] - result[1] >= (rightCol - leftCol))) {
					Xor = result[0];
					int left = leftCol;
					int top = result[1];
					int right = rightCol;
					int bottom = result[2];
				}
			}	
		}
		
		System.out.println(Xor);
   
    }catch(Exception ex){}
   	
    }
}