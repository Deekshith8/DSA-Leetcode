package Leetcode;

import java.util.PriorityQueue;

public class JumpGameII {

    public static void main(String[] args) {
        JumpGameII JGII = new JumpGameII();
        int[]nums = new int[]{2,0,2,0,1};
        int min = JGII.jump3(nums);

        System.out.println(min);
    }
    public int jump(int[] nums) {
        int[]ans = new int[]{Integer.MAX_VALUE};

        helpingMethod(nums , 0 ,ans, new boolean[nums.length] , 0);

       return ans[0];
    }

    public  void helpingMethod(int[]nums , int index, int[] ans , boolean[]isPossible , int minjumps){
        if(index >= nums.length-1){
            if(minjumps  < ans[0]){
                ans[0] = minjumps;

            }
            return;
        }

      if(minjumps <= ans[0]) {
          for (int i = nums[index]; i >= 1; i--) {
              helpingMethod(nums, index + i,ans, isPossible, minjumps + 1);
          }
      }

    }



    //approach2 using priority Queue
    public int jump2(int[]nums){
        PriorityQueue<pair> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new pair(0,0));
        while(!priorityQueue.isEmpty()){
            pair temp = priorityQueue.poll();
            if(temp.index >= nums.length-1){
                return temp.jumps;
            }
            int num = nums[temp.index];
            while(num > 0 ){
                priorityQueue.add(new pair(temp.jumps+1 , temp.index+num));
                num--;
            }

        }

        return Integer.MAX_VALUE;
    }


    // approach 3
    public int jump3(int[]nums){
        int jumps = 0;

        int left = 0; int right = 0;


        while(right < nums.length-1){
            jumps++;
            int tempright = 0;

            for(int i = left ; i<= right ;i++){
                tempright = Math.max(tempright , i+nums[i]);
            }
            left = right+1;
            right = tempright;
        }

        return jumps;
    }


}
class pair implements Comparable<pair> {

    public int jumps ;

    public int index;

    public pair(int jumps , int index){
        this.index = index;
        this.jumps = jumps;
    }


    @Override
    public int compareTo(pair o) {
        return this.jumps - o.jumps ;
    }
}