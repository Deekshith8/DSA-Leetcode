package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static void main(String[] args) {

        generateParenthesis gP = new generateParenthesis();
        System.out.println(gP.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        helpingMethod(result , n, 0 , 0 , new StringBuilder(""));

        return result;
    }


    public void helpingMethod(List<String> results , int n , int countOpen, int countclosed, StringBuilder s){

        if(countOpen < countclosed  ){
            return;
        }

        if(s.length() == n*2 && countclosed == n && countOpen == n ){
            results.add(s.toString());
        }



        if (countOpen < n) {
                s.append('(');
                helpingMethod(results, n, ++countOpen, countclosed, s);
                countOpen--;
              s.deleteCharAt(s.length()-1);
        }

        if (countclosed < n) {
                s.append(')');
                helpingMethod(results, n, countOpen, ++countclosed, s);
                countclosed--;
                s.deleteCharAt(s.length()-1);
        }

    }


}
