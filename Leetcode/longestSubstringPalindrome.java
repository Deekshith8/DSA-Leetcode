package Leetcode;

public class longestSubstringPalindrome {
    public static void main(String[] args) {

        longestSubstringPalindrome lsp = new longestSubstringPalindrome();
        System.out.println(lsp.longestPalindrome("babbaabc"));


    }
    public String longestPalindrome(String s) {
     String result = "";
     if(s.length() == 0 ){
         return  "";
     }
     if(s.length() == 1){
         return s;
     }



     for(int i = 0 ;i+1 < s.length() ;i++){

         String pal1 = searchPalindrome(s,i,i);
         String pal2 = searchPalindrome(s, i , i+1);

         if(pal1.length() > pal2.length()){
             if(result.length() < pal1.length()){
                 result = pal1;
             }
         }else {
             if(result.length() < pal2.length()){
                     result = pal2;
                 }

         }

     }


     return  result;
    }


    public String searchPalindrome(String s, int i , int j){
        String temp = "";

        while(i>=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            temp = s.substring(i,j+1);
            i--;
            j++;

        }

        return temp;
    }

}
