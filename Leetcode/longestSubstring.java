package Leetcode;

import  java.util.Map;
import  java.util.HashMap;

public class longestSubstring {
    public static void main(String[] args) {

        longestSubstring ls = new longestSubstring();
        System.out.println(ls.lengthOfLongestSubstring(" "));

    }
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int maxSub = 0;

        int temp = 0;

        int prev = -1;
        Map<Character , Integer> map = new HashMap<>();

        for(int i = 0; i< s.length() ; i++){

            char c = s.charAt(i);
            if(map.containsKey(c)  && map.get(c) >= prev){
                temp = i- map.get(c);
                if(temp > maxSub){
                    maxSub = temp;
                }
                prev = map.get(c);
                map.put(c,i);

            }
            else{
                map.put(c,i);
                temp++;
                if(temp>maxSub){
                    maxSub = temp;
                }
            }
        }

        return  maxSub;
    }
}
