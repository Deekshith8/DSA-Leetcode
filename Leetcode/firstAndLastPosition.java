package Leetcode;

import java.util.Arrays;

public class firstAndLastPosition {
    public static void main(String[] args) {
        firstAndLastPosition fLP = new firstAndLastPosition();

        System.out.println(Arrays.toString( fLP.searchRange(new int[]{5,7,7,8,8,10}, 6)) );


    }
    public int[] searchRange(int[] nums, int target) {
        int[] results = new int[]{-1,-1};
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target && i < first ){
                first = i;
                results[0] = first;
            } else if (nums[i] == target && i>last) {
                last = i;
                results[1] = last;
            }
        }
        return results;
    }
}
