package DSA;

import java.util.Arrays;

public class squaresOfSortedArray {
    public static void main(String[] args) {

        int[]arr = new int[]{-8,-6,-2,0,1,3,5};

        squaresOfSortedArray squares = new squaresOfSortedArray();

        System.out.println(Arrays.toString(squares.squaresOfsortedarray(arr)));


    }

    //we can do it easily with o(n) space complexity , but want to do with o(1) space complexity
    //I think we cant do it
    //
    public int[] squaresOfsortedarray(int arr[]){

        int start = 0;
        int end = arr.length-1;

        int[] result = new int[arr.length];


        for(int i = arr.length-1 ;i>=0 ; i--){
            int a = Math.abs(arr[start]);
            int b = Math.abs(arr[end]);


            if(Math.pow(a,2) > Math.pow(b,2)){
                result[i] = arr[start] * arr[start];
                start++;
            }
            else{
                result[i] = arr[end] * arr[end];
                end--;
            }
        }


      return  result;
    }

}
