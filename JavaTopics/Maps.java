package JavaTopics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

public class Maps {
    public static void main(String[] args) {
        TreeMap<Integer , String> map = new TreeMap<>();

        map.put(11, "Deekshith");
        map.put(10,"Divya");
        map.put(2,"Harsha");
        map.put(0,"Indhu");
        map.put(5,"Sandhya");
        map.put(6,null);
        map.put(7,null);
         //map.put(null,"Deekshith"); // this will gi

        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(map.get(entry.getKey()));
        }


        Map<Integer , String>map1  = new HashMap<>();
        map1.put(null,"Deekshith");
        map1.put(null,"Divya");
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(map.get(entry.getKey()));
        }



    }
}
