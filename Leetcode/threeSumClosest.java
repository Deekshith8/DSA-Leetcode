package Leetcode;

import java.util.Arrays;

public class threeSumClosest {
    public static void main(String[] args) {

        threeSumClosest tsc = new threeSumClosest();
        System.out.println(tsc.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));

    }
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;

        Arrays.sort(nums);


        for(int i = 0 ; i< nums.length ; i++){
            int left = i+1;
            int right = nums.length-1;

           int temptarget = target - (nums[i]);

            while(left<right){
                int temp = nums[i]+nums[left]+nums[right];
                if(Math.abs(target-closest) > Math.abs(target - temp)){
                    closest = temp;
                }

                if((nums[left] + nums[right]) < temptarget){
                    left++;
                }
                else{
                    right--;
                }


            }
        }

     return  closest;
    }


}
