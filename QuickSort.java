package Algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        QuickSort qs = new QuickSort();

        int []arr = new int[]{3,2,1,4,5,7,0,6};

        qs.quickSort(arr, 0 , arr.length-1);

        System.out.println(Arrays.toString(arr));
    }


    public void quickSort(int[]arr , int start, int end){
        if(start >= end){
            return ;
        }
        int low = start;
        int high = end;
        int mid = low + (high - low)/2;
        int pivot = arr[mid];

        while(low <= high){
            while(arr[low] < pivot){
                low++;
            }
            while(arr[high]>pivot){
                high--;
            }
            if(low <= high){
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            low++;
            high--;
            }
        }
        quickSort(arr , start , high);
        quickSort(arr , low , end );


    }
}
