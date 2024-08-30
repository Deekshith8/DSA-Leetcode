package DSA;

public class Stack {

    private  Node top;

    public class Node{

        private int val;

        private Node down;

        public Node(int val){
            this.val = val;
            this.down = null;
        }


    }

    public void push(int val){
        // we can add only at top (One way)
        Node newNode = new Node(val);

        if(this.top == null){
            this.top = newNode;
            return;
        }

        newNode.down = this.top;
        this.top = newNode;

    }

    public void push(char val){
        // we can add only at top (One way)
        Node newNode = new Node(val);

        if(this.top == null){
            this.top = newNode;
            return;
        }

        newNode.down = this.top;
        this.top = newNode;

    }

    public Integer pop(){
        if(this.top == null){
            return null;
        }

        Node temp = this.top;
        this.top = this.top.down;

        return temp.val;
    }


    public void printMyStack(){

        Node current = this.top;
        while(current != null){
            System.out.println(current.val);
            System.out.println("||");
            current = current.down;
        }
        System.out.println("null");

    }


    public static void main(String[] args) {

        System.out.println("stack -> adding at top");
        Stack stack1 = new Stack();
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        stack1.push(40);
        stack1.push(50);
        stack1.printMyStack();

        System.out.println("poping the top ");
        System.out.println(stack1.pop());
        stack1.printMyStack();
        System.out.println(stack1.top.val);

        System.out.println("Reversing a string using stack");

        String deek = "deek";
        Stack stack2 = new Stack();
        for(char c: deek.toCharArray()){
            stack2.push(c);
        }





    }

}
