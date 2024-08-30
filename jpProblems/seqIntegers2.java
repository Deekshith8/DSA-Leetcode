package jpProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class seqIntegers2 {

    public static void main(String[] args) {

    }

    public static List<Integer>result(int n1,int n2){
        ArrayList<Integer>ansList=new ArrayList<>();


        for(int i=n2;i>=n1;i--){

            ArrayList<Integer> a=new ArrayList<>();
            //storing digits in array

            int z=i;
            while(z>0){
                int temp=z%10;
                z=z/10;
                a.add(temp);
            }
                int count=0;
                Collections.reverse(a);


                    for (int j = 0; j + 1 < a.size(); j++) {
                        int temp = a.get(j);
                        if (a.get(j) + 1 != a.get(j + 1)) {


                        } else {
                            count++;
                        }
                    }
                    if (count != 0) {
                        int ans = 0;
                        for (int x = 0; x < a.size(); x++) {
                            ans = (ans * 10) + a.get(x);
                        }
                        ansList.add(ans);
                    }




        }


        return ansList;
    }

}
