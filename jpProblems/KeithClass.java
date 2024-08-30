package jpProblems;

import java.util.*;

public class KeithClass {
    public static void main(String[] args) {
        System.out.println(iskeith(14));




    }


    public static boolean iskeith(int num){
        //divide the num into digits
        //and add those digits in list
        int num1=num;
        ArrayList<Integer> list=new ArrayList<>();

        while(num>0){

            int temp=num%10;
            list.add(temp);
            num=num/10;


        }
       System.out.println(list);

        while(list.get(0)<num1){

            int sum=0;
            for(int i=0;i< list.size();i++){
                sum+=list.get(i);

            }

            //now remove the last element
            list.remove(list.size()-1);
            list.add(0,sum);
            System.out.println(list);



            if(sum==num1){
                return true;
            }
        }


        return false;

    }

}
