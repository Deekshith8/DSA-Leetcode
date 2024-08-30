package jpProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IbmTimeStamp {
    public static void main(String[] args) {
        List<String>logs=new ArrayList<>();
        logs.add("0:start:0");
        logs.add("2:start:4");
        logs.add("2:end:6");
        logs.add("1:start:7");
        logs.add("1:start:10");
        logs.add("0:end:11");

        String temp[]=new String[3];
        totaltimeexecution(3,logs);

        System.out.println(totaltimeexecution(3,logs));



    }


    public static List<Integer> totaltimeexecution(int n,List<String>list) {
        List<Integer>ans=new ArrayList<>(3);



        int i=0;
        while(i<list.size()){
            String[]temp=list.get(i).split(":");

            ans.add(Integer.valueOf(temp[0]));



            i++;
        }

        return ans;
    }


}
