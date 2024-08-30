package Leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {

        RemoveElement rE = new RemoveElement();
        //0,1,2,2,3,0,4,2
        int[]nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 1;
        System.out.println(rE.removeElement(nums,2));

        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val){

        int left = 0;
        int right = nums.length-1 ;

        while(left <= right ){

           if(nums[right] == val){
               right--;
           } else if (nums[left] != val) {
               left++ ;
           } else if (nums[left] == val) {
               int temp = nums[left];
               nums[left] = nums[right];
               nums[right] = temp;

           }

        }

      return left;
    }
}
