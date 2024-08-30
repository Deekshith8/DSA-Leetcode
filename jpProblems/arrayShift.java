package jpProblems;

import java.util.Arrays;

public class arrayShift {
    public static void main(String[] args) {
        int[] arr= {0,1,2,3,4,5,7};
        System.out.println(Arrays.toString(result(7,arr,3)) );
    }

    public static int[] result( int n,int []arr,int k){
        if(k>n){
            k=k%n;
        }

        for(int i=0;i<k;i++){
            int temp=arr[n-k+i];
            for(int j=n-k+i-1;j>=i;j--){
                arr[j+1]=arr[j];
            }
            arr[i]=temp;
        }


        return arr;
    }

}
