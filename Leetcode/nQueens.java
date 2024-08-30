package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class nQueens {

    public static void main(String[] args) {

        nQueens nq = new nQueens();
        List<List<String>> allBoards = nq.solveNQueens(4);//[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]

        System.out.println(allBoards);

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        boolean[][]matrix = new boolean[n][n];

        helper(matrix , 0 , allBoards);



        return allBoards;
    }

    public void helper(boolean[][]matrix , int col , List<List<String>> allBoards){

        if(col == matrix.length){
            saveBoard(matrix , allBoards);
            return;
        }



        for( int i = 0 ;i< matrix.length ; i++){
            if(isSafe(matrix , i , col)){
                matrix[i][col] = true;
                helper(matrix , col+1 , allBoards);
                matrix[i][col] = false;
            }
        }

    }

    public  void saveBoard(boolean[][] matrix, List<List<String>> allBoards) {
        List<String>newboard = new ArrayList<>();
        for(int i = 0 ;i<matrix.length;i++){
            String temp = "";
            for(int j = 0;j<matrix[i].length;j++){

                if(matrix[i][j]){
                    temp +="Q";
                }
                else{
                    temp+=".";
                }

            }
            newboard.add(temp);
        }
        allBoards.add(newboard);
    }


    public boolean isSafe(boolean[][]matrix , int row , int col){
        //check for row;
       for(int i= 0  ; i < matrix.length ;i++){
         if(matrix[row][i]){
             return false;
         }
       }
       //check for col
        for(int i= 0  ; i < matrix.length ;i++){
            if(matrix[i][col]){
                return false;
            }
        }
        //check for upper left
        int r = row;
        int c = col;

        while(r >= 0 && c >= 0){
            if(matrix[r][c]){
                return false;
            }
            r-- ;
            c--;
        }

        // check for upper right
         r = row;
         c = col;

        while(r >= 0  && c <  matrix.length){
            if(matrix[r][c]){
                return false;
            }
            r--;
            c++;
        }

        //check for downleft
        r = row;
        c = col;

        while(r < matrix.length  && c >= 0){
            if(matrix[r][c]){
                return false;
            }
            r++;
            c--;
        }

        //check for down right
        r = row;
        c = col;

        while(r < matrix.length  && c < matrix.length){
            if(matrix[r][c]){
                return false;
            }
            r++;
            c++;
        }


        return true;
    }
}
