package jpProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class PackageProbKeith {
    public static void main(String[] args) {
        String conversation="Hello: A i am 3. A: Hi deekshith I am 14. B: Hi three i am seven. C: Hi 65 i am six 27.D: HIi harsha  ia ma nine and eight 2208";
        int totalsumNum=0;
        String ans="";



        String[]words=conversation.split("[,.:? ]");


        for(String word:words){
            word.trim();


            if(ExtractString.extractNumberdigits(word)!=0){
                int num=ExtractString.extractNumberdigits(word);

                if(NumberFinder.iskeith(num)){

                    ans=ans+""+num;
                }
            }//

           else {
                if (ExtractString.extractNumWord(word) != 0) {
                    int num = ExtractString.extractNumWord(word);
                    totalsumNum += num;
                }
            }

        }
        System.out.println(ans+""+totalsumNum);



    }
}



//class 2 starts<<<<----------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
class NumberFinder{

    public static boolean iskeith(int num){

        if(NumberFinder.iscomposite(num)){

            int num1=num;
            ArrayList<Integer> list=new ArrayList<>();

            while(num>0){

                int temp=num%10;
                list.add(temp);
                num=num/10;


            }
//        System.out.println(list);

            while(list.get(0)<num1){

                int sum=0;
                for(int i=0;i< list.size();i++){
                    sum+=list.get(i);

                }

                //now remove the last element
                list.remove(list.size()-1);
                list.add(0,sum);




                if(sum==num1){
                    return true;
                }
            }


            return false;
        }

        return false;
    }//method 1

    public static  boolean iscomposite(int num){
        int count=0;

        for(int i=1;i<=num;i++){
            if(num%i==0){
                count++;
            }
        }
        if(count>2){
            return  true;
        }
        return  false;
    }//method 2


}

//class 3 starts<<<<----------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
class ExtractString{


    //method 1 to get  numeric digits
    public static Integer extractNumberdigits(String word){

       try{

           int num=Integer.parseInt(word);

           return num;

       }
       catch (Exception e){
           return  0;
       }
    }


    //method 2
    public static Integer extractNumWord(String word){

      if(word.equalsIgnoreCase("one")){
          return 1;
      }
        if(word.equalsIgnoreCase("two")){
            return 2;
        }
        if(word.equalsIgnoreCase("three")){
            return 3;
        }
        if(word.equalsIgnoreCase("four")){
            return 4;
        }
        if(word.equalsIgnoreCase("five")){
            return 5;
        }
        if(word.equalsIgnoreCase("six")){
            return 6;
        }
        if(word.equalsIgnoreCase("seven")){
            return 7;
        }
        if(word.equalsIgnoreCase("eight")){
            return 8;
        }
        if(word.equalsIgnoreCase("nine")){
            return 9;
        }
        return 0;
    }


}