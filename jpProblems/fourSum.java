package jpProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static void main(String[] args) {
        fourSum fs = new fourSum();
        int[]nums = {1,0,-1,0,-2,2};
       // int[]nums = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fs.fourSum(nums , 0));

    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i+3 < nums.length ;i++){
            List<Integer>templist = new ArrayList<>();
            for(int j = i+1 ; j+2< nums.length ;j++){


                long temptarget =(long) target - (long)(nums[i]+nums[j]);
                int p = j+1;
                int q = nums.length-1;

                while(p < q){
                    if(nums[p]+nums[q] == temptarget){
                        templist.add(nums[i]);
                        templist.add(nums[j]);
                        templist.add(nums[p]);
                        templist.add(nums[q]);
                        if(!result.contains(templist)){
                           result.add(templist);
                        }
                        p++;
                        q--;
                       templist = new ArrayList<>();
                    }

                    else if(nums[p]+nums[q] < temptarget){
                        p++;
                    }
                    else{
                        q--;
                    }
                }

            }
        }


        return result;
    }
}
