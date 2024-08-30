package Leetcode;

public class firstMissingPositiveNumber {
    public static void main(String[] args) {

        firstMissingPositiveNumber fMP = new firstMissingPositiveNumber();
        System.out.println(fMP.firstMissingPositive(new int[]{3,4,2,1}));
    }
    public int firstMissingPositive(int[] nums){


        for(int i = 0;i<nums.length;i++){
                if(nums[i] <= 0){
                    nums[i] = nums.length  + 1;
                }
       }

        for(int j = 0 ; j< nums.length ; j++ ){
          int temp = Math.abs(nums[j])-1;
          if(temp < nums.length && nums[temp] > 0){
              nums[temp] = -nums[temp];
          }
        }

        for(int j = 0 ; j< nums.length ; j++ ){
          if(nums[j] >= 0 ){
              return j+1 ;
          }
        }

       return nums.length+1;
    }
}
