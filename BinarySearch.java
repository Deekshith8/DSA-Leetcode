package Algorithms;

import DSA.BinaryTree;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bt = new BinarySearch();
        int []arr = new int[]{10,20,30,40,50,60,70};//sorted search for 60 or 70

       // int key = 30;
        int key = 80;


        System.out.println(bt.binarySearch(arr , key));
    }

    public int binarySearch(int[]arr ,int key){

        int left = 0;
        int right = arr.length-1;



        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] < key){
                left = mid+1;
            }
            else if (arr[mid] > key){
                right = mid -1;
            }
            else{
                return mid;
            }
        }

        return  -1;

    }




}
