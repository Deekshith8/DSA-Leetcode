package jpProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumEven {
    public static void main(String[] args) {

//        int arr[][]=new int[3][2];
//        int n=0;
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[i].length;j++){
//                arr[i][j]=n;
//                n++;
//            }
//
//        }
//
//        for(int i=0;i<arr.length;i++){
//            for(int j=0;j<arr[i].length;j++){
//                System.out.print( arr[i][j]);
//
//            }
//            System.out.println();
//
//        }


        System.out.println(result(4,9,3));


    }


    public static List<String> result(int n1, int n2, int k) {

        List<String>list=new ArrayList<>();
        int length= (int) Math.pow((n2-n1+1),k);

        int[][]newarr=new  int[length][k];

        System.out.println(k+" "+Math.pow((n2-n1+1),k));




               for(int i=0;i<k;i++){


                   for(int x=n1;x<=n2;x++){
                       for(int j=0;j<length;j++){


                           newarr[j][i]=x;

                       }
                   }
               }
        System.out.println(newarr[1][0]);


        //chedhling the sum

        for(int i=0;i<length;i++) {
            int []temp=new int[k];
            for (int j = 0; j < k; j++) {

                temp[j]=newarr[i][j];

            }
             int count=0;
            for(int x=0;x<k;x++){
                count=temp[x];

            }

            if(count%2==0){
                list.add(Arrays.toString(temp));
            }

        }



        return list;
    }


}
