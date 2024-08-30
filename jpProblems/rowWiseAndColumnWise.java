package jpProblems;

import java.util.Arrays;

public class rowWiseAndColumnWise {

    public static void main(String[] args) {


        int[][]matrix = {{10,20,30,40},
                         {15,25,35,45},
                          {27,29,37,48},
                           {32,33,39,50}};
        System.out.println(matrix[matrix.length-1][0]);
        System.out.println(Arrays.toString(search(matrix , 50)));

    }

    public static int[] search(int[][] matrix, int key){
        int i = matrix.length-1;

        int j =0;

        while(i >= 0 && j < matrix.length){

            if(matrix[i][j] == key){
                return  new int[]{i , j};
            }
            if(matrix [i][j] < key){
                j++;
            }
            else{
                i--;
            }

        }

        return null;
    }

}
