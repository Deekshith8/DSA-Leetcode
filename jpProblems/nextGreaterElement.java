package jpProblems;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {4, 7, 3, 4, 8, 1};

        int[]ans = new int[arr.length];
        int x = 0;
        for( int i= 0; i<arr.length;i++){

            int j = i;

            while(j<arr.length){
                if(arr[j]>arr[i]){
                    ans[x] = arr[j];
                    break;
                }
                else{
                    ans[x] = -1;
                }
                j++;
            }
           x++;
        }
        System.out.println(Arrays.toString(ans));

        System.out.println(Arrays.toString(usingstack(arr)));

    }


    public static int[] usingstack(int[] arr){

        int[]result = new int[arr.length];
        Stack<Integer> helpingStack = new Stack<>();

        for(int i= arr.length-1 ; i>= 0 ;i--){
            if(!helpingStack.isEmpty() && helpingStack.peek()<= arr[i]){
                helpingStack.pop();
            }
            if(helpingStack.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = helpingStack.peek();
            }
            helpingStack.push(arr[i]);
        }





        return result;
    }
}
