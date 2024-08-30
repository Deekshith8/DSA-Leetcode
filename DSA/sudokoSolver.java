package DSA;

import java.util.Arrays;

public class sudokoSolver{
    public static void main(String[] args) {

        char[][]board =  {
                {'.', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '.'}
        };


        sudokoSolver ss = new sudokoSolver();
        ss.solveSudoku(board);

        for(int i = 0 ; i<board.length ; i++){
            System.out.println(Arrays.toString(board[i]));
        }



    }
    public void solveSudoku(char[][] board) {

        helper(board , 0 ,0 );


    }


    public boolean helper(char[][]board , int row , int col){

        if(row == board.length){

            return true;
        }

        int nrow = 0;
        int ncol = 0;


        if(col != board.length-1){
           nrow = row ;
           ncol = col+1;
        }else{
           nrow = row+1;
           ncol = 0;
        }

        if (board[row][col] != '.') {
            if(helper(board,nrow,ncol)){
                return true;
            }
        }
        else{
            for(int i = 1;i<= 9 ;i++) {
                if (isValid(board, row, col, (char) (i+'0') )) {
                     board[row][col] = (char) (i+'0');
                     if(helper(board , nrow , ncol)){
                         return true;
                     }else {
                         board[row][col] = '.';
                     }

                }
            }

        }




        return false;
    }

    public boolean isValid(char[][]board , int row , int col , char i){

        //for in col and row
        for(int j = 0;j< board.length ;j++){

            if(board[row][j]==i){
                return false;
            }
            if(board[j][col] == i){
                return false;
            }
        }

        //for 3*3 box;

        int strow = row%3;
        int strcol = col%3;

        for(int j = (row-strow) ; j< (row-strow) + 3 ; j++) {
            for (int k = (col - strcol) ; k < (col - strcol)+ 3 ;k++){
                if(board[j][k] == i){
                    return  false;
                }
            }
        }



        return true;
    }


}
