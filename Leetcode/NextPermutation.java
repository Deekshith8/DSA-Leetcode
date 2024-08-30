package Leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation Np = new NextPermutation();
        int nums[] = new int[]{1,3,2,5};

        Np.nextPermutation(nums);

        System.out.println(Arrays.toString(nums));

    }

    public void nextPermutation(int[] nums) {


        int left = nums.length-2;

        int max = nums[nums.length-1];
        boolean isFound = false;


        while(left >= 0 && !isFound){

            if(nums[left] >= max){
                max = nums[left];
                left--;
            }
            else {
                int temp = Integer.MAX_VALUE;
                int i = nums.length-1;
                int index = -1;
                while(i > left){
                    if(nums[i] > nums[left] && nums[i] <= temp){

                        temp = nums[i];
                        index = i;

                    }  i--;

                }

                //swap index and ledft and sort from left
                isFound = true;
                int swapTemp = nums[left];
                nums[left] = nums[index];
                nums[index] = swapTemp;


                for(int j = left+1 ; j<nums.length ;j++){
                    for(int k = j+1 ; k<nums.length ;k++){
                       if(nums[j] > nums[k]) {
                           int t = nums[j];
                           nums[j] = nums[k];
                           nums[k] = t;
                       }
                    }
                }




            }


        }



       if(!isFound){
           //sort
           for(int i = 0 ; i< nums.length ; i++){

               for(int j= i+1 ; j< nums.length ; j++){
                   int t = nums[i];
                   nums[i] = nums[j];
                   nums[j] = t;
               }
           }
       }
    }
}
