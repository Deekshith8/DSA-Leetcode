package Leetcode;

public class CountAndSay_Leetcode38 {
    public static void main(String[] args) {

        CountAndSay_Leetcode38 CAS = new CountAndSay_Leetcode38();

        System.out.println(CAS.countAndSay(6));


    }
    public String countAndSay(int n) {


         if(n==1){
             return "1";
         }
        StringBuilder  ans = new StringBuilder("1");

        while(n>1){
            ans = helpingMethod2(ans,1, ans.charAt(0),new StringBuilder() , 1);
            n--;
        }

        return ans.toString() ;


    }


//    public String helpingMethod(String s , int n){
//
//        String  ans = "";
//
//
//        while(n>0){
//            ans = helpingMethod2(s,1, s.charAt(0),new StringBuilder());
//        }
//
//        return ans ;
//    }

    public StringBuilder helpingMethod2(StringBuilder s , int count , char value , StringBuilder ans , int index){
        if(index == s.length()){
            ans.append(count);
            ans.append(value);
            return ans;
        }

        if(s.charAt(index) == value){
            count++;
            return helpingMethod2(s,count, value , ans ,  index+1);
        }
        else{
            ans.append( count);
            ans.append(value);
            value = s.charAt(index);
            return  helpingMethod2(s,1,value,ans , index+1);
        }

    }




}
