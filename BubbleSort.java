package Algorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();

        int[] arr = new int[]{3,2,1,4,5,7,0,6};
        bs.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));


    }
    public void bubbleSort(int []arr){

        for(int i = 0;i<arr.length ;i++){
            for(int j = i+1;j<arr.length ;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}
