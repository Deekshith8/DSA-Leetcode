package Algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        MergeSort ss = new MergeSort();

        int []arr = new int[]{3,2,1,4,5,7,0,6};
        int left = 0;
        int right = arr.length-1;

        int[]result = ss.mergeSort(arr , left , right);

        System.out.println(Arrays.toString(result));

    }

    public int[] mergeSort(int[]arr, int left ,int right){

        if(arr.length == 1){
            return  arr;
        }

        int mid = (arr.length)/2;

        int[] leftArray = mergeSort(Arrays.copyOfRange(arr , left , mid),0 , mid-1);
        int[] rightArray = mergeSort(Arrays.copyOfRange(arr , mid, right+1),0 , right-mid);

       return merge(leftArray , rightArray);


    }

    private int [] merge(int[]arr1 , int []arr2){

        int i = 0;
        int j = 0;

        int x =0;

        int[]resultArray = new int [arr1.length + arr2.length];

        while(i<arr1.length && j<arr2.length){

            if(arr1[i] < arr2 [j]){
                resultArray[x] = arr1[i];
                i++;
            }
            else{
                resultArray[x] = arr2[j];
                j++;
            }
            x++;

        }


        while(i<arr1.length){
            resultArray[x] = arr1[i];
            i++;
            x++;
        }
        while(j<arr2.length){
            resultArray[x] = arr2[j];
            j++;
            x++;
        }


        return  resultArray;
    }


}
