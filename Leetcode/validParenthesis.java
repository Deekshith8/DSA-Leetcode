package Leetcode;

import java.util.Stack;

public class validParenthesis {
    public static void main(String[] args) {

        validParenthesis vP = new validParenthesis();
        System.out.println(vP.isValid("(())"));

    }

    public boolean isValid(String s) {

        if(s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i< s.length() ; i++){
            char temp = s.charAt(i);
           char c = 0;
            if(!stack.isEmpty()){
             c = stack.peek();
            }
           if( (c == '(' && temp == ')') || (c == '{' && temp == '}') || (c == '[' && temp == ']') ){
               stack.pop();
            }
            else{
               stack.push(temp);
            }


        }

        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
}
