package Algorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort ss = new InsertionSort();

        int []arr = new int[]{3,2,1,4,5,7,0,6};

        ss.insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private  void insertionSort(int[]arr){

        for(int i = 1 ;i<arr.length ; i++){
            for(int j= 0 ;j<i ;j++){
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }


    }
}
