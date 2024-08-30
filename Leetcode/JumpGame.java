package Leetcode;

public class JumpGame {
    public static void main(String[] args) {

        JumpGame jP = new JumpGame();
        System.out.println(jP.canJump(new int[]{2,1,1,0,4}));
    }

    public boolean canJump(int[] nums) {

        boolean[]isPossible = new boolean[nums.length];
       return helpingMethod(nums, 0 , isPossible);
    }

    public  boolean helpingMethod(int[]nums , int index , boolean[]isPossible){
        if(index + nums[index] >= nums.length-1){
            return true;
        }
     if(isPossible[index] == false) {
         for (int i = nums[index]; i >= 1; i--) {
             if (helpingMethod(nums, index + i, isPossible)) {
                 return true;
             }
         }
     }

        isPossible[index] = true;
        return false;
    }
}
