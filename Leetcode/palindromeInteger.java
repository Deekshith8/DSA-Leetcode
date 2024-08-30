package Leetcode;

public class palindromeInteger {

    public static void main(String[] args) {

        palindromeInteger pI = new palindromeInteger();
        System.out.println(pI.isPalindrome(1212));

    }

    public boolean isPalindrome(int x) {

        int num = x;
        if(x < 0){
            return  false;
        }
        int reverse = 0;

        while (num != 0){
            int temp = num % 10 ;
            reverse = reverse * 10 + temp;

            num = num / 10 ;

        }

        if(reverse == x ){
            return  true;
        }

        return  false;
    }

}
