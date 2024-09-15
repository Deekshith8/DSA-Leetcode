package Leetcode;

import java.util.Stack;

public class LargestRectangle_84 {
    public static void main(String[] args) {

        LargestRectangle_84 obj = new LargestRectangle_84();

        System.out.println(obj.largestRectangleArea(new int[]{5,6,1,9}));

    }

    public int largestRectangleArea(int[] heights) {

        int largestRectangle = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack();


        for(int i = 0;i< heights.length ; i++){

            if(stack.isEmpty()){
                stack.push(heights[i]);
                continue;
            }

            if(stack.peek() > heights[i]){
                int count = 0;
                int tempArea = 0;
                Stack<Integer> tempStack = new Stack<>();
                do{
                    int temp = stack.pop();

                    count++;
                    tempArea = temp * count;

                    if(tempArea > largestRectangle){
                        largestRectangle = tempArea;
                    }

                }while (!stack.isEmpty() && stack.peek() > heights[i]);

                for(int j = 0;j<=count ;j++){
                stack.push(heights[i]);
                }

            }else{
                stack.push(heights[i]);
            }


        }


        int min = Integer.MAX_VALUE;
        int count = 0;
        int tempArea = 0;

        do{
            int temp = stack.pop();

            count++;
            tempArea = temp * count;

            if(tempArea > largestRectangle){
                largestRectangle = tempArea;
            }

        }while (!stack.isEmpty());

       return  largestRectangle;

    }
}
