package Algorithms;

import java.util.Arrays;

public class SelectionSort {

    //we select one itm (min or max and put that into right place

    public static void main(String[] args) {

        SelectionSort ss = new SelectionSort();

        int []arr = new int[]{3,2,1,4,5,7,0,6};

        ss.selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private void selectionSort(int[] arr) {

        for(int i = 0;i<arr.length ; i++){

            int min = i;

            for(int j = i+1 ;j< arr.length ;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }



    }

}
