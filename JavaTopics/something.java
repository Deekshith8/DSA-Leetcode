package JavaTopics;

import java.util.Arrays;
import java.util.List;

public class something {
    public static void main(String[] args) {
        int[]arr = {0,1};
        int[]arr2 = {0,1};

        System.out.println(arr.equals(arr2));

        List<Integer> list1 = Arrays.asList(0,1);

        List<Integer> list2 = Arrays.asList(0,1);

        System.out.println(list1.equals(list2));

    }
}
