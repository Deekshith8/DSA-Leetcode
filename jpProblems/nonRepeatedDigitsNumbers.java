package jpProblems;

import java.util.HashSet;
import java.util.Set;

public class nonRepeatedDigitsNumbers {

    public static void main(String[] args) {
        System.out.println(method(101,200));
    }

    public static  int  method(int n1,int n2){
        int count=0;
        for (int i=n1;i<=n2;i++){
            if(isNoRepeatedDigits(i)){
               count++;
            }

        }
        return count;
    }

    private static boolean isNoRepeatedDigits(int n) {
        Set<Integer>mySet=new HashSet<>();

        while(n>0){
            if(mySet.add(n%10)){

            }
            else{
                return  false;
            }
            n=n/10;
        }

        return  true;
    }


}
