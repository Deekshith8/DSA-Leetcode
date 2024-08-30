package jpProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class nBinaryNumber {


    public static void main(String[] args) {


        int n = 7;
        System.out.println(Arrays.toString(generateBinaryNumber( n) ) );

    }

    public  static  String[] generateBinaryNumber(int n){

        Queue<String >queue = new ArrayDeque<>();

        String[]strings = new String[n];
        queue.add("1");
        int i = 0 ;
        while(i < n){

            String s = queue.remove();
            strings[i] = s;
            String s1 = s +"0";
            queue.add(s1);

            String s2 = s+"1";
            queue.add(s2);
            i++;
        }



        return  strings;
    }

}
