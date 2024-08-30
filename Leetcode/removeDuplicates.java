package Leetcode;

import java.util.Arrays;

public class removeDuplicates {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates rd = new removeDuplicates();

        System.out.println(rd.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {

        int num  = nums[0];
        int count = 0;

        int[] ans = new int[nums.length];

        ans[0] = nums[0];
        int x = 1;
        for( int i = 1 ; i< nums.length ; i++){

            if(nums[i] == num){
                count++;
            }else{
                ans[x] = nums[i];
                x++;
                num = nums[i];
            }

        }

        for(int i =0 ;i<nums.length - count ;i++){
            nums [i] = ans[i];
        }
        return nums.length- count;
    }
}
