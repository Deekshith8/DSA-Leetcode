package jpProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Passenger {
    private int id;
    private float fare;


    public Passenger(int id, float fare) {
        this.id = id;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public float getFare() {
        return fare;
    }


    public void setFare(float fare) {
        this.fare = fare;
    }
}


public class ArrayListProblem2 {
    public static void main(String[] args) {
        List<String>list1=new ArrayList<>();
        list1.add("+2501 +2502 +2503 +2504");
        list1.add("-2501 -2504 +2505 +2506 +2507 +2509");
        list1.add("+2501 +2511 -2502 -2505");
        list1.add("+2513 -2507 -2503 -2511 -2509");
      //  list1.add("+101 -112 -113");
        //list1.add("+115 +116 -101 +112");

        System.out.println(BusStop(10,4,list1,"2"));

    }



    public static String BusStop(int capacity, int stops, List<String> listOfInputStrings, String query){
        String output="";

      String querytemp[]=query.split(",");

      switch ( Integer.parseInt(querytemp[0].trim())){
            case 1:
                ArrayList<Passenger>passengersGoton=new ArrayList<Passenger>();
                ArrayList<Passenger>passengersGotoff=new ArrayList<Passenger>();
                for(int i=0;i<stops;i++){
                    String[]temp=listOfInputStrings.get(i).split(" ");
                    for(String s:temp){
                        if(s.trim().startsWith("+")){
                            passengersGoton.add(new Passenger(Integer.parseInt(s.trim().substring(1)), 0));

                        }
                        else{
                            passengersGotoff.add(new Passenger(Integer.parseInt(s.trim().substring(1)), 0));
                        }
                    }

                }

                output+=passengersGoton.size()+"got on the bus and "+passengersGotoff.size()+" got off the bus";
                break;

          case 2:
              int fair=0;
              int fair13=0;
              int fair16=0;

              ArrayList<Passenger>passengersFare=new ArrayList<Passenger>();

              for(int i=0;i<stops;i++){


                  String[]temp=listOfInputStrings.get(i).split(" ");

                  for(String s:temp){


                      if(s.trim().startsWith("+")){

                          passengersFare.add(new Passenger(Integer.parseInt(s.trim().substring(1)), 0));
                         // System.out.println(passengersFare.get(passengersFare.size()-1).getId());

                      }
                      else{
                          for(int j=0;j<passengersFare.size();j++){
                             // System.out.println(Integer.parseInt(s.trim().substring(1)));
                              if(passengersFare.get(j).getId()==Integer.parseInt(s.trim().substring(1))){
                                 // System.out.println(s.trim().substring(1));
                                 // System.out.println(passengersFare.size());
                                 // System.out.println(passengersFare.get(j).getId());
                                  passengersFare.remove(j);
                                  break;
                              }

                          }

                      }



                  }

                  if(passengersFare.size()>(capacity/2)){
                      for(int j=0;j<passengersFare.size();j++){

                          passengersFare.get(j).setFare(capacity);
                         // System.out.println(passengersFare.size());
                          fair+=passengersFare.size();


                      }

                  }
                  else if(passengersFare.size()>(capacity/4)){
                      for(int j=0;j<passengersFare.size();j++){

                          passengersFare.get(j).setFare((float) (capacity+capacity*0.3));
                          fair13+=passengersFare.size();


                      }

                  }
                  else{
                      for(int j=0;j<passengersFare.size();j++){

                          passengersFare.get(j).setFare((float) (capacity+capacity*0.6)+passengersFare.get(j).getFare());
                          fair16+=passengersFare.size();


                      }

                  }


              }
             output+=fair+" travellefd with "+capacity+ " fare and "+fair13+" travelled with " + (capacity+capacity*0.3)+" fare and "+fair16+" travelled with "+(capacity+capacity*0.6);



        }








        return output;
    }

}
