package Leetcode;

public class firstOccurenceIndex {
    public static void main(String[] args) {

        firstOccurenceIndex fOI = new firstOccurenceIndex();
        String hayStack ="mississippi" ;
        String needle = "issip";

        System.out.println(fOI.strStr(hayStack,needle));

    }

    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()){
            return -1;
        }

        int left = 0;
        int right = 0;
        int firstIndex = -1;
        int i = 0;
        int count = 0;

        while(right < haystack.length()){

            if(haystack.charAt(right) == needle.charAt(i)){
                i++;
                right++;
                count++;
            }
            else{
                left++;
                right = left;
                i = 0 ;
                count = 0;
            }
            if(count == needle.length()){
                return  left;
            }

        }
      return  -1;
    }
}
