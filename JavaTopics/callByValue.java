package JavaTopics;

import java.util.Arrays;

public class callByValue {

    public static void main(String[] args) {

        callByValue ca = new callByValue();

        int a =10;
        ca. method(a);

        Integer a2 = 11;

        ca.method(a2);
        System.out.println(a2);
        System.out.println(a);


        int []arr = new int[]{1,2,3,4};
        ca.method2(arr);
        System.out.println(Arrays.toString(arr));

//        System.out.println(a--);
//        System.out.println(a--);//just a tricky ans for tricky q where 10-2= 9 hahahhaha...
    }

    public void method(int a){
        a++;
    }

    public void method2(int []arr){
        arr[0]= 10;
    }
}
