package Leetcode;

import java.util.*;

public class longestSubstringwithoutRepeatingChar {
    public static void main(String[] args) {

        longestSubstringwithoutRepeatingChar ls = new longestSubstringwithoutRepeatingChar();
        System.out.println(ls.lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        List<String> substrings = new LinkedList<>();

        int maxSub = 0;
        for (int i = 0; i <= s.length(); i++) {
            substrings.add(s.substring(i, s.length()));
        }

        for (String subs : substrings) {
            Set<Character> set = new HashSet<>();
            int isrepeat = 0;
            for (int i = 0; i < subs.length(); i++) {

                if (set.contains(subs.charAt(i))) {

                    isrepeat++;
                    break;
                } else {
                    if (i + 1 > maxSub) {
                        maxSub = i + 1;
                    }
                    set.add(subs.charAt(i));
                }

            }
            set.removeAll(set);

        }


        return maxSub;

    }

}
