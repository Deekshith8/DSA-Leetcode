package Leetcode;


import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack_155 {
    public static void main(String[] args) {

        System.out.println(2147483646 < Integer.MAX_VALUE);
    }
}
class MinStack {
    private Stack stack;

    private Stack minStack;

    private  int min;

  //  private PriorityQueue<Integer> priorityQueue;

    public MinStack() {
      this.stack = new Stack();
       this.min = Integer.MAX_VALUE;
        this.minStack = new Stack();
    }

    public void push(int val) {
       stack.push(val);
       if(val <= min){
           this.min = val;
           minStack.push(min);
       }else{
           minStack.push(min);
       }
    }

    public void pop() {

         stack.pop();

      minStack.pop();
      if(minStack.isEmpty()){
          min = Integer.MAX_VALUE;
      }else{
          min = (int) minStack.peek();
      }

    }

    public int top() {
     return (int) stack.peek();
    }

    public int getMin() {
      return (int) minStack.peek();
    }
}
