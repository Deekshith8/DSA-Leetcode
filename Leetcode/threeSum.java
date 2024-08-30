package Leetcode;

import java.util.*;

public class threeSum {

    public static void main(String[] args) {

        threeSum ts = new threeSum();
        int[] nums = {-1,0,1,2,-1,-4};
       // int[] nums ={1,2,-2,-1};


        System.out.println(ts.threeSum(nums));

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer> > result = new ArrayList<>();

        Set<List<Integer>>set = new HashSet<>();


       Arrays.sort(nums);

        for(int i = 0; i< nums.length ;i++){

            int target = 0 - nums[i];


           int j = i+1;
           int k = nums.length-1;

           while(j < k){
               if(nums[j]+ nums[k] == target){
                   set.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                   j++;
                   k--;
               } else if (nums[j]+ nums[k] > target) {
                   k--;
               } else {
                   j++;
               }
           }


        }

        result.addAll(set);



        return  result;
    }
}
