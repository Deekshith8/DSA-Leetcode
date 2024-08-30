package jpProblems;

import java.util.Stack;

public class validParenthesis {

    public static void main(String[] args) {

        String s = "{()}()";
        System.out.println(isvalidParenthesis(s));

    }


    public static  boolean isvalidParenthesis(String s){


        Stack<Character>stack = new Stack<>();

        char[]chars = s.toCharArray();

        for(int i = 0;i<chars.length;i++ ){
            char c = chars[i];
            if(c == '{'|| c == '('|| c == '['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return  false;
                }
                char topchar = stack.peek();
                if( (c == ')' && topchar == '(')
                    || (c == '}' && topchar == '{')
                     || (c == ']' && topchar == '[')
                  ){
                    stack .pop();
                }
                else{
                    return  false;
                }

            }


        }




        return stack.isEmpty();
    }

}
