package jpProblems;

public class Keypad {
    public static void main(String[] args) {

      String[] arr=new String[8];
      arr[0]="abc";
      arr[1]="def";
      arr[2]="ghi";
      arr[3]="jkl";
      arr[4]="mno";
      arr[5]="pqrs";
      arr[6]="tuv";
      arr[7]="wxyz";

       // System.out.println(arr[0].charAt(1));
      String digits="23";


    }

    public  static void Combination(String []arr,String digits){


      for(int i=0;i<digits.length();i++){
        int []arrnew=new int[digits.length()];
        arrnew[i]=digits.charAt(i);
      }




    }

}
