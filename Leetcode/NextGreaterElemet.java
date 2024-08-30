package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElemet {
    public static void main(String[] args) {
        NextGreaterElemet nGE = new NextGreaterElemet();

        int [] ans = nGE.nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});

        System.out.println(Arrays.toString(ans));

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int []result = new int[nums1.length];

        Map<Integer , Integer> mapIndeces = new HashMap<>();
        Map<Integer , Integer> mapValues = new HashMap<>();

        for(int i = 0;i<nums2.length ; i++){
            mapIndeces.put(i,nums2[i]);
            mapValues.put(nums2[i],i);
        }

        int x = 0;

        for(int i = 0; i< nums1.length ; i++){


            int val = nums1[i];
            int index = mapValues.get(val) ;

            while(index < nums2.length){
                if(mapIndeces.get(index) > val){
                    result[x] = mapIndeces.get(index);
                    x++;
                    break;
                }
                if(index == nums2.length-1){
                    result[x] = -1;
                    x++;
                }
                index ++;

            }


        }

      return  result;
    }
}
