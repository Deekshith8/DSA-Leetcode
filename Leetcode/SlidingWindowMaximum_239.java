package Leetcode;

import java.util.*;

public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        SlidingWindowMaximum_239 obj = new SlidingWindowMaximum_239();

        int []result = obj.maxSlidingWindow(new int[]{10,3,5,4,-3,6,7,8,9},4);

        System.out.println(Arrays.toString(result));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length-k+1];

        Deque<Integer> queue = new ArrayDeque<>();
        int x = 0;

        for(int i = 0 ; i< nums.length ; i++){

            while(!queue.isEmpty() ){
                if(queue.getLast() < nums[i]){
                     queue.removeLast();
                }else{
                    queue.addLast(nums[i]);
                    break;
                }

            }
            if(queue.isEmpty()){
                queue.addLast(nums[i]);
            }

            if(i >= k-1){
                 result[x] = queue.getFirst();

                 if(nums[x] == queue.getFirst()){
                     queue.removeFirst();
                 }
                x++;
            }

        }



        return result;
    }
}
