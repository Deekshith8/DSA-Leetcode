package Leetcode;

public class ReverseInteger {
    public static void main(String[] args) {

        ReverseInteger reverseInteger = new ReverseInteger();

        System.out.println(reverseInteger.reverse(1534236469));

    }

    public int reverse(int x) {




        int temp = Math.abs(x);
        long result = 0;

        while(temp > 0){
            int num = temp%10;
            result = result*10 + num;
            temp = temp/10;
        }


        if(result > 2147483647 || result < -2147483648){
            return 0;
        }
        return (int) (x < 0 ? result = (-1)*result : result);
    }
}
