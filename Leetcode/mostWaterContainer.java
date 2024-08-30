package Leetcode;

public class mostWaterContainer {

    public static void main(String[] args) {
        mostWaterContainer mwc = new mostWaterContainer();
      // int max =  mwc.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int max =  mwc.maxArea(new int[]{6,4,10,2});
       // int max =  mwc.maxArea(new int[]{});

        System.out.println(max);

    }

    public int maxArea(int[] height) {

        // first brute force apply time complexioty O(n^2)

//        for(int i = 0;i < height.length ; i++){
//            int j = height.length-1;
//            while(j > i){
//                int tempArea = Math.min(height[i] , height[j])*(j-i);
//
//                if(tempArea > maxArea){
//                    maxArea = tempArea;
//                }
//                j--;
//            }
//        }


        // optimized --- time complexity O(n)
        int maxArea = 0;

        int left = 0;
        int right = height.length-1;

        while(left < right){

            int temp =  Math.min(height[left] , height[right])*(right - left);

            if(temp> maxArea){
                maxArea = temp;
            }


                if(height[left] <= height[right]){
                    left++;
                }
               else {
                    right--;
                }
        }

        return maxArea;
    }
}
