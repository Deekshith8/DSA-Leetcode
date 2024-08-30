package jpProblems;

import java.sql.SQLOutput;
import java.util.*;

public class HashsetProblem {
    public static void main(String[] args) {
        String Teams="deek adi divya harsha#indhu divya gopi deek#ravi manju divya deek#divya pawan manju deek";
        System.out.println( ansMethod(4,Teams,2,4));


    }
    public static String ansMethod(int matches, String squads, int squad1,int squad2){



//        String []temp=Teams.split("#");
//        //teams of one string is made into array of String
//
//        for(int i=0;i< temp.length;i++){
//            set.add(temp[i]);
//
//        }
//        System.out.println(set);
//
//        for(int i=0;i< temp.length;i++){
//            String []temp2=temp[i].split(" ");
//            //System.out.println(Arrays.toString(temp2));
//
//            for(int j=0;j< temp2.length;j++){
//                int count=0;
//                for(String item:set){
//                    System.out.println(item);
//                    System.out.println(temp2[j].trim());
//                    if(item.contains(temp2[j].trim())){
//
//                        count++;
//                        System.out.println(count);
//                    }
//                }
//                if(count==4){
//                    if(!playedtotalmathces.contains(temp2[j].trim())) {
//                        playedtotalmathces +=  temp2[j].trim()+" ";
//                        // System.out.println(playedtotalmathces);
//                    }
//                }
//
//            }
//         // System.out.println(Arrays.toString(temp2));
//
//        }
//
//        for(String item:set){
//
//
//
//        }
//
//
//        System.out.println(playedtotalmathces);

//        String  playedtotalmathces="";
//        String playedinAnyOne="";
//
//        HashSet<String>set=new HashSet<String>();
//        String[]temp=Teams.split("[ #]");
//        System.out.println(Arrays.toString(temp));
//
//
//        String[]temp2=Teams.split("#");
//        System.out.println(Arrays.toString(temp2));
//
//       for(int i=0;i<temp2.length;i++){
//
//           set.add(temp2[i]);
//       }
//
//
//        for(int j=0;j< temp.length;j++){
//          int count=0;
//           for(String item:set){
//               if(item.contains(temp[j].trim())){
//                   count++;
//               }
//           }
//           if(count==4){
//               if(!playedtotalmathces.contains(temp[j].trim())) {
//                   playedtotalmathces += temp[j].trim() + " ";
//               }
//           }
//       }
//        int count=0;
//        for(int j=0;j< temp.length;j++){
//
//
//            for(String item:set){
//
//
//            }
//        }
//
//
//        System.out.println(playedtotalmathces);
//
//        return  null;




        String  playedtotalmathces="";
        String playedinAnyOne="";
        List<String> list=new ArrayList<>();

        HashSet<String>allplayers=new HashSet<>();

        String[]temp=squads.split("#");


        for(int i=0;i< temp.length;i++){
            String[]newteamp=temp[i].split(" ");
            for(int j=0;j< newteamp.length;j++){
                allplayers.add(newteamp[j].trim());
                list.add(newteamp[j].trim());
            }



        }
        System.out.println(list);
        System.out.println(allplayers);

        //checkling all squads
        Iterator it=allplayers.iterator();

        if(it.hasNext()){
            int count=0;
            String s=""+it.next();
         //   System.out.println(s.trim());
            for(int i=0;i< list.size();i++){
               // System.out.println(list.get(i));
              if(list.get(i).trim().equalsIgnoreCase(s.trim())){
                  System.out.println("hii");


                    count++;
                  System.out.println(count);
                }
            }
            if(count==matches){
                System.out.println(count);
                playedtotalmathces+=it+" ";
            }
        }

        //checking in squad 2 and not in squad 1
        Iterator it1=allplayers.iterator();
        while(it1.hasNext()){
           String s=""+it1.next();
            System.out.println(s);

//            if(list.get(squad2).contains(s)&&!list.get(squad1).contains(s)){
//
//
//                playedinAnyOne+=it1+" ";
//            }
        }

        String ans=playedtotalmathces+","+ playedinAnyOne;
        return ans;

    }
}
