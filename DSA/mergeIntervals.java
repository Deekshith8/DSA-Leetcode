package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {
    public static void main(String[] args) {

        int[][]arr = {{1,3},{2,6},{8,10},{15,18}};

        mergeIntervals  mi = new mergeIntervals();
        ArrayList<int[]> results = (ArrayList<int[]>) mi.method(arr);


        int[][] ans = new int[results.size()][2];
        for(int i = 0 ;i< results.size();i++){
            ans[i][0] =  results.get(i)[0];
            ans[i][1] = results.get(i)[1];
        }

        Arrays.stream(ans).forEach((int[] nums)-> System.out.println(Arrays.toString(nums)));



    }
    public List<int[]> method(int[][]arr){
        List<int[]>results = new ArrayList<>();
        int min = arr[0][0];
        int max = arr[0][1];

        for(int i = 0 ;i< arr.length ;i++){
            if(min <= arr[i][0] && arr[i][0] <= max){
                if(arr[i][1] >= max){
                    max = arr[i][1];
                }
            }
            else {
                results.add(new int[]{min , max});
                min = arr[i][0];
                max = arr[i][1];

            }
        }
        results.add(new int[]{min , max});


        return results;
    }
}
