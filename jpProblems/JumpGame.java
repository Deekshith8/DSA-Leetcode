package jpProblems;

public class JumpGame {
    public static void main(String[] args) {
        int[]arr={2,3,1,1,4};
        jumps(arr,0,0);
        //int count=0;



    }
    public static void jumps(int[]arr,int n,int count){
        if(n>= arr.length-1){
            System.out.println(count);
        }
        else{
            int x=check(arr, n);
            n=n+x;
            count++;
            jumps(arr,n,count);


        }


    }

    public static int check(int[]arr,int n){
        int x=0;
        int max=0;
        for(int i=0;i<=arr[n];i++){
            if(arr[n+i]+i>max){
                max=arr[n+i]+i;

                x=i;
            }
        }


//     if(x==0){
//         return n+1;
//     }

       // System.out.println(x);
        return x;
    }


}
