package Leetcode;

import java.util.HashMap;

public class subArraySumK {

    public static void main(String[] args) {
//
//        int[] arr = {10, 2, -2, -20, 10};// ans 3
//        int k = -10;

        int[]arr = {1,2,3};
        int k = 3;
        subArraySumK sak = new subArraySumK();
        System.out.println(sak.countofSubArraySumofK(arr, k));

    }


    public int countofSubArraySumofK(int[]arr, int k ){
        HashMap<Integer , Integer>map = new HashMap<>();

        int count = 0;

        int sum = 0;
        map.put(sum , 1);
        for(int i = 0 ;i<arr.length ;i++ ){

            sum += arr[i];
            if(map.containsKey(sum )){
                map.put(sum , map.get(sum)+1);
            }
            else{
                map.put(sum , 1);
            }
            if(map.containsKey(sum - k)){
               count += map.get(sum-k);
            }


        }

        return count;
    }

}
