package Leetcode;

public class StringToInteger {
     static  public  void main(String[] args) {




        StringToInteger STI = new StringToInteger();
        System.out.println(STI.myAtoi(" 9223372036854775808"));

    }
    public int myAtoi(String s) {

        double ans = 0L;
        if(s.length() == 0){
            return 0;
        }

        boolean isSigned = false;
        boolean isNegative = false;

      //  boolean isNumStarted = false;
      //  boolean isSpaceEnded = false;

        for(int i = 0 ;i < s.length() ; i++){
            char temp = s.charAt(i);
            if(temp == ' ' && !isSigned){
                continue;
            }
            if( temp == '-'&& !isSigned){
                isSigned = true;
                isNegative = true;
                continue;
            }
            if( temp == '+'&& !isSigned){
               isSigned = true;
                continue;
            }
            int isNumber = helpingMethod(temp);
            if(isNumber < 0 ){
                break;
            }else{
                isSigned = true;
                ans = (ans*10) + isNumber;
            }


        }

        if(isNegative){
            ans = (-1)* ans;
        }
        if(ans < Integer.MIN_VALUE ){
            return  -2147483648;
        }
        if(ans > Integer.MAX_VALUE ){
            return  2147483647;
        }

        return Math.toIntExact((long) ans);

    }


    public int helpingMethod(char s){
        char[]arr = new char[]{'0','1','2','3','4','5','6','7','8','9'};

        for(int i = 0; i < arr.length ; i++){
            if(arr[i] == s){
                return i;
            }
        }
        return -1;
    }

}
