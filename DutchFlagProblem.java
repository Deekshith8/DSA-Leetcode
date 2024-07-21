package DSA;

import java.util.Arrays;

public class DutchFlagProblem {

    public static void main(String[] args) {

        DutchFlagProblem dfp = new DutchFlagProblem();

        int[] arr = {2,0,2,1,1,0,1,0,2,2,1,0};

        dfp.convertToFlagArray(arr);

        System.out.println(Arrays.toString(arr));
    }

    public void convertToFlagArray(int[] arr) {

        int n = arr.length;

        int start = 0;
        int mid = 0;
        int end = n-1;

        while(mid <= end){
            if(arr[start] == 0){
                start++;
            }
            if(arr[end] == 2){
                end--;
            }
            if(arr[mid] == 0 && mid != start){
                int temp = arr[mid];
                arr[mid] = arr[start];
                arr[start] = temp;
                start++;
            }
            if(arr[mid] == 2 && mid != end){
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;
                end--;
            }
            mid++;

        }

    }

}
