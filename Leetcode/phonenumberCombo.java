package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class phonenumberCombo {
    public static void main(String[] args) {
        phonenumberCombo pNc = new phonenumberCombo();
        List<String> results = pNc.letterCombinations("234");
        System.out.println(results);


    }
    public List<String> letterCombinations(String digits) {

        String[] aplhabets = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        helpingMethod(aplhabets, digits, result , new StringBuilder(""));

        return result;
    }


    public void helpingMethod(String[]alphabets, String digits , List<String>result , StringBuilder sB){

        if(digits.length() == 0){
            result.add(sB.toString());
            if(sB.length() != 0){
                sB.deleteCharAt(sB.length()-1);
            }
            return;
        }



            int num = Integer.parseInt(String.valueOf(digits.charAt(0)));

            for(int j = 0;j< alphabets[num].length() ; j++){
                sB.append(alphabets[num].charAt(j));
                helpingMethod(alphabets , digits.substring( 1 , digits.length()) , result , sB);
            }

            if(sB.length() != 0){
                sB.deleteCharAt(sB.length()-1);
            }


    }
}
