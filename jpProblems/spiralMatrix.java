package jpProblems;

public class spiralMatrix {

    public static void main(String[] args) {


        int[][]matrix = {{10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}};
        printmyMatrixInSpiral(matrix);
    }

    public static  void printmyMatrixInSpiral(int[][]matrix){

        int left = 0;
        int top = 0;
        int down = matrix.length-1;
        int right = matrix[0].length-1;

        int direction = 0;

        while(top <= down && left<= right){

            if(direction == 0){
                for(int i = left; i<= right ; i++){

                    System.out.println(matrix[top][i]);

                }
                top++;
                direction ++;
            } else if (direction == 1){
                for(int i = top; i<= down ; i++){

                    System.out.println(matrix[i][right]);

                }
                right--;
                direction ++;

            }else if (direction == 2){
                for(int i = right; i>= left ; i--){

                    System.out.println(matrix[down][i]);

                }
                down--;
                direction++;
            }
            else if(direction == 3){
                for(int i = down; i>= top ; i--){

                    System.out.println(matrix[i][left]);

                }
                left++;
                direction = 0;

            }


        }


    }


}
