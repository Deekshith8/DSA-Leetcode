package jpProblems;

import java.util.*;

//working but need to improve regarding time complexity


public class seqDigits {
    public static void main(String[] args) {

        System.out.println(result(100,1000));
    }

    public static List<Integer> result(int n1,int n2){

        ArrayList<Integer>ansList=new ArrayList<>();

        for(int i=n1;i<n2;i++){

           ArrayList<Integer>a=new ArrayList<>();
           //storing digits in array
           int z=i;
           while(z>0){
               int temp=z%10;
               z=z/10;
               a.add(temp);
           }
           int j=a.size()-1;
           int count=0;

          //chehcking if i is a sequencial digit or not
          while((j-1)>=0){


               if(a.get(j)+1==a.get(j-1)){
                    j--;
               }
               else{
                   //if its not a sequrntila digit then we have to jump to netx possible sequntila dgits


                   count++;
                   break;
               }

           }

          //if its sequentila digit then chnaging to int and storing into our list

          if(count==0){
              int ans=0;
              for(int  x=a.size()-1;x>=0;x--){
                  ans=(ans*10)+a.get(x);
              }
              ansList.add(ans);

          }



        }


        return ansList;
    }

}
