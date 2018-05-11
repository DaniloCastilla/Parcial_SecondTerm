package Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Dual_Issues {
	
	public boolean isPrime(int x) {
		
		int C = 0;
		
		for (int i = 1; i <= x; i++) {
			if(x%i == 0 ) {
				C += 1;	
			}
		}
		
		if(C == 2) 
			return true;
		else 
			return false;
		}
	
	public void bubbleSort(int[] array) {
		
		int aux;
		boolean cambio = false;
		
		while(true) {
			
			cambio = false;
			for (int i = 1; i < array.length; i++) {
				
				if(array[i]<array[i-1]) {
					
					aux=array[i];
					array[i] = array[i-1];
					array[i-1] = aux;
					cambio = true;
					
				}
				
			}
			
			if(cambio == false)
				break;
			
		}
		
	}
	
	public int numMayorPrime(int array[]) {
		
		int N = 0;
		int C = 0;
		int Mayor = 0;
		int Ultimo;
		int Penultimo;
		
		for (int k = 0; k < array.length; k++) {
			
			if(isPrime(array[k])) {
				C++;
			}
		}
		
		int[] primeArray = new int[C];
		
		for (int i = 0; i < array.length; i++) {
			
			if(isPrime(array[i])) {
				
				primeArray[N] = array[i];
				N++;
			}
		}		
		
		if(C<1) {
			
			Mayor = -1;
			
		}else if(C==1) {
			
			Mayor = primeArray[0] * primeArray[0];
			
		}else {
			
			bubbleSort(primeArray);
			
			Ultimo = primeArray[primeArray.length-1];
			Penultimo = primeArray[primeArray.length-2];
			
			Mayor = Ultimo*Penultimo;
		}
		
		return Mayor;	
	}

	public static void main(String[] args) throws IOException {
		
		Dual_Issues DI = new Dual_Issues();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Cases = Integer.parseInt(br.readLine());
		int Total[] = new int[Cases];
		
		for (int i = 0; i < Cases; i++){
			
			int Num = Integer.parseInt(br.readLine());
			
			String cadena = br.readLine();
			String[] cadena_2 = cadena.split(" ");
			
			int array[] = new int[Num];
			
			for (int j = 0; j < Num; j++) {
				
				array[j] = Integer.parseInt(cadena_2[j]);
				
			}
			
			DI.bubbleSort(array);
			
			Total[i] = DI.numMayorPrime(array);
			
		}
		
		for (int i = 0; i < Total.length; i++) {
			System.out.println(Total[i]);
		}
		
	}
	
}
