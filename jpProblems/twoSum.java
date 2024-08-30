package jpProblems;

import java.util.ArrayList;
import java.util.List;

public class twoSum {
    public static void main(String[] args) {
        int []nums={1,2,33,4};
        int target=4;

     int []ans=   TwoSum( nums,  target);

    }

    public static int[] TwoSum(int[] nums, int target) {
        int[]ans=new int[2];

        for(int i=0;i< nums.length;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]+nums[j]==target){
                    nums[0]=i;
                    nums[1]=j;


                }
            }
        }





      return ans;

    }
}
