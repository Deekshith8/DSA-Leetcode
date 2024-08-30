package Leetcode;

public class BuyAndSell1 {
    public static void main(String[] args) {

        BuyAndSell1 BAS = new BuyAndSell1();
        System.out.println(BAS.maxProfit(new int[]{7,1,5,0,6,7}));

    }

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int left = 0 ;
        int right = 1 ;

        while(right < prices.length ){
            if(prices[left] < prices[right]){
                if(maxProfit < (prices[right] - prices[left])) {
                    maxProfit = prices[right] - prices[left];
                }
                right++;
            }
            else{
                left = right ;
                right++;
            }
        }
     return  maxProfit ;
    }
}
