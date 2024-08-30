package jpProblems;

import java.util.ArrayList;

public class sampleThings {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(54);
        list.add(53);
        list.add(52);
        list.add(51);
        list.add(12);


        for(int i=0;i<list.size();i++){
            if(i==2){
                list.remove(2);
                System.out.println(list.size());
                System.out.println(list.get(2));
            }
        }

    }
}
