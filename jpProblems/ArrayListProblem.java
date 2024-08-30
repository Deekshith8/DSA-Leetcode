package jpProblems;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListProblem {
    public static void main(String[] args) {
        List<String>list1=new ArrayList<>();
        list1.add("+2501 +2502 +2503 +2504");
        list1.add("-2501 -2504 +2505 +2506 +2507 +2509");
        list1.add("+2501 +2511 -2502 -2505");
        list1.add("+2513 -2507 -2503 -2511 -2509");
//        list1.add("+101 -112 -113");
//        list1.add("+115 +116 -101 +112");

        String output= result(10,4,list1,"2");
        System.out.println(output);

    }


    public static String result(int capacity,int stops, List<String>listOfInputStrings,String query){
        String outstring="";
        //Write your code here



        ArrayList<Passenger>listofpassengers=new ArrayList<Passenger>();
        for(int i=0;i<stops;i++){
            String[]temp=listOfInputStrings.get(i).split(" ");
            for(String s:temp){
                if(s.trim().startsWith("+")){
                    listofpassengers.add(new Passenger(Integer.parseInt(s.trim().substring(1)), 0));

                }
            }

        }

       for(int i=0;i<listofpassengers.size();i++){
           System.out.println(listofpassengers.get(i).getId()+" "+listofpassengers.get(i).getFare());
       }





        String[]querytemp=query.split(",");
        if(Integer.parseInt(querytemp[0].trim())==1){
            int[] InOut=calpassengersInOut(listOfInputStrings);
            outstring=""+InOut[0]+" passengers got on the bus and "+InOut[1]+" passengers got out of the bus";

        }
        if(Integer.parseInt(querytemp[0].trim())==2){
            int[]fairs=calPassengersFair(capacity, listOfInputStrings);
            outstring=""+fairs[0]+" passengers traveled with a fare of "+(capacity+capacity*0.6)+
                    ", "+fairs[1]+ " passengers traveled with a fare of "+(capacity+capacity*0.3)+
                    ", "+fairs[2]+ " passengers traveled with a fare of "+(double)(capacity);
        }
        if(Integer.parseInt(querytemp[0].trim())==3){
            double totalFare=passengerFair( capacity,listOfInputStrings,querytemp);
            outstring="Passenger "+querytemp[1].trim()+" spent a total fare of "+totalFare;
        }
        if(Integer.parseInt(querytemp[0].trim())==4){
            int in=passengerInandOut( capacity,listOfInputStrings,querytemp);
            outstring="Passenger "+querytemp[1].trim()+" has got on the bus for "+in+" times";
        }
        if(Integer.parseInt(querytemp[0].trim())==5){
            if(passengerIsInOrOut(capacity,listOfInputStrings,querytemp)){
                outstring="Passenger "+querytemp[1].trim()+" was inside the bus at the end of the trip";
            }
            else{
                outstring="Passenger "+querytemp[1].trim()+" was not inside the bus at the end of the trip";
            }
        }


        return outstring;
    }

    //QUERY1
    private static int[] calpassengersInOut(List<String>passengers){

        ArrayList<Passenger>listofpassengers=new ArrayList<Passenger>();

        int in=0;
        int out=0;
        int[]InOut=new int[2];
        for(String s:passengers){
            String []temp=s.split(" ");
            for(int i=0;i<temp.length;i++){
                if(temp[i].trim().startsWith("+")){
                    in++;



                }
                else{
                    out++;
                }
            }
        }
        InOut[0]=in;
        InOut[1]=out;
        System.out.println(passengers);
        return InOut;

    }

    //QUERY2
    private static int[] calPassengersFair(int capacity,List<String>passengers){
        int[]fairs=new int[3];
        int fair16=0;
        int fair13=0;
        int fair=0;
        int remain=0;
        int  cap1=capacity/2;
        int cap2=capacity/4;
        if(capacity%2!=0){
            cap1=(capacity/2+1);
        }
        if(capacity%4!=0){
            cap2=(capacity/4+1);
        }

        for(String s:passengers){


            String temp[]=s.split(" ");
            int in=0;
            int out=0;

            for(int i=0;i< temp.length;i++){
                if(temp[i].trim().startsWith("+")){
                    in++;
                }
                else{
                    out++;
                }
            }

             remain+=in-out;

            if(remain>cap1){
                fair+=in;



            }
            else if(remain>cap2){
                fair13+=in;

            }
            else{
                fair16+=in;

            }


        }


        fairs[0]=fair16;
        fairs[1]=fair13;
        fairs[2]=fair;
        return fairs;

    }

    //QUERY3
    private static double  passengerFair(int capacity,List<String>passengers,String[]query){
        int in=0;
        int out=0;
        boolean count=false;

        double totalFare=0;
        int cap1=capacity/2;
        int cap2=capacity/4;

         if(capacity%2!=0){
             cap1=(capacity/2+1);
         }
         if(capacity%4!=0){
             cap2=(capacity/4+1);
         }
        for(String s:passengers){
            String[]temp=s.split(" ");

            //for checking in and out
            for(int i=0;i< temp.length;i++){
                if(temp[i].trim().startsWith("+")){
                    in++;
                }
                else{
                    out++;
                }
            }//for loop over

            for(int i=0;i< temp.length;i++){
                if(temp[i].trim().equalsIgnoreCase("+"+""+query[1].trim())){

                    //cal the fare;
                    double tempFare=0;
                    int remain=in-out;
                    if(remain>cap1){
                        tempFare=capacity;

                    }
                    else if(remain>cap2){
                        tempFare=capacity+capacity*0.3;

                    }
                    else{
                        tempFare=capacity+capacity*0.6;
                    }
                    totalFare+=Math.round(tempFare*10.0)/10.0;

                    count=true;
                    break;

                }
                else if(temp[i].trim().equalsIgnoreCase("-"+""+query[1].trim())){
                    count=false;
                    break;
                }
                else{
                    if(i== temp.length-1){
                        if(count==true){
                            //cal the fare
                            double tempFare=0;
                            int remain=in-out;
                            if(remain>cap1){
                                tempFare=capacity;

                            }
                            else if(remain>cap2){
                                tempFare=capacity+capacity*0.3;

                            }
                            else{
                                tempFare=capacity+capacity*0.6;
                            }
                            totalFare+=Math.round(tempFare*10.0)/10.0;

                            break;
                        }

                    }
                }
            }

        }
    return Math.round(totalFare*10.0)/10.0;
    }

    //QUERY4
    private static int passengerInandOut(int capacity,List<String>passengers,String[]query){
        int in =0;
        for(String s:passengers){
            String[]temp=s.split(" ");
            for(int i=0;i<temp.length;i++){
                temp[i].trim();
                if(temp[i].equalsIgnoreCase("+"+""+query[1].trim())){
                    in++;
                }
            }
        }
        return in;
    }


    //QUERY5

    private static boolean passengerIsInOrOut(int capacity,List<String>passengers,String[]query){
        boolean IsinOrOut=false;
        for(String s:passengers){
            String []temp=s.split(" ");
            for(int i=0;i<temp.length;i++){
                if(temp[i].trim().equalsIgnoreCase("+"+""+query[1].trim())){
                    IsinOrOut=true;
                }
                if(temp[i].trim().equalsIgnoreCase("-"+""+query[1].trim())){
                    IsinOrOut=false;
                }

            }
        }

        return IsinOrOut;
    }

}

