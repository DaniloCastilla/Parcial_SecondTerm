package Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Army_Parade {
    public static int numberOfWays = 0;
    
    public static void changeRows(int[][] matrix, int row, int row2){
        int bubble[];
        bubble = matrix[row].clone();
        matrix[row] = matrix[row2];
        matrix[row2] = bubble;
    }
    
    public static void calculateNumberOfWays(int matrix[][],int finalRow,int finalCol, int initialRow){
        for (int i = initialRow; i < finalRow; i++) {
            for (int j = 0; j < finalCol; j++) {
                if(matrix[i][j] == 1){
                    numberOfWays++;
                }
            }
        }
    }
    
    public static void initializeMatrix(int matrix[][], int value){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        /*n number of columns, m number of row, k number of troopers, r for row and c for column*/
        int n, m, k, r, c, troop[][], copyTroop[][];
        /*index*/
        int i, j, initialRow = 0, rowToChange1 = 1, rowToChange2 = 2;
        int finalRow = 2, finalCol = 2;
        String input;
        
        input = br.readLine();
        
        n = Integer.parseInt(input.split(" ")[0]);
        m = Integer.parseInt(input.split(" ")[1]);
        k = Integer.parseInt(input.split(" ")[2]);
        
        troop = new int[n][m];
        initializeMatrix(troop, 1);//1 for the officers
        
        for (i = 0; i < k; i++) {
            input = br.readLine();
            r = Integer.parseInt(input.split(" ")[0]);
            c = Integer.parseInt(input.split(" ")[1]);
            troop[r-1][c-1] = 0;//0 for the troopers
        }
        
        copyTroop = troop.clone();
        while(finalRow < n || finalCol < m){
            while (rowToChange1 < n) {
                for (i = 0; i < n - rowToChange1; i++) {
                    calculateNumberOfWays(troop, finalRow, finalCol, initialRow);
                    changeRows(troop, rowToChange1, rowToChange2);
                }
                initialRow++;
                rowToChange1++;
                finalRow++;
            }
            if(finalRow + 1 <= n && finalCol == m ){
                finalRow++;
            }
            if(finalCol + 1 <= m && finalRow == n){
                finalCol++;
            }
            if(finalRow + 1 <= n && finalCol + 1 <= m){
                finalRow++;
                finalCol++;
            }
            initialRow = 0;
            rowToChange1 = finalRow;
            troop = copyTroop.clone();
        }
        
        calculateNumberOfWays(troop, n, m, 0);
        
        bw.write(numberOfWays + "\n");
        bw.flush();
    }
}