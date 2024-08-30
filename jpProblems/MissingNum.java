package jpProblems;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MissingNum {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//
//       int[]arr=new int[n];
//       for(int i=0;i<n;i++){
//            arr[i]=sc.nextInt();
//       }

        int[]arr={-1,0,-2,1,3,4};
       Check(arr);

    }

    public static void Check(int[]arr){
       for(int j=1;j<Integer.MAX_VALUE;j++){
           int count=0;
           for(int i=0;i< arr.length;i++){
               if(arr[i]==j){
                   count++;
                   break;
               }


           }
           if(count==0){
               System.out.println(j);
               break;
           }
       }


    }
}