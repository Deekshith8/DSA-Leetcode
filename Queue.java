package DSA;

public class Queue {

    private Node front;

    private  Node rear;


    class  Node{

        private  int val;

        private  Node next;

        public Node(int val){
            this.val = val;
            this.next = null;
        }

    }


    public void enQueue(int val){

        Node newNode = new Node(val);
        if(this.front == null){
            this.front = newNode;
            this.rear = newNode;
        }
        this.rear.next = newNode ;
        this.rear = newNode;
    }


    //queue is FIFO so only one way out
    public Integer deQueue(){

        if(this.front == null){
            return null;
        }
        Node temp = this.front;
        this.front = this.front.next;
        temp.next = null;

        return temp.val;
    }

    public void printMyQ(){

        Node current = this.front;

        while(current != null){
            System.out.print(current.val+"->");
            current = current.next;
        }
        System.out.println();

    }


    public static void main(String[] args) {


        Queue q1 = new Queue();
        q1.enQueue(2);
        q1.enQueue(3);
        q1.enQueue(4);
        q1.enQueue(5);
        q1.printMyQ();
        System.out.println(q1.front.val +" "+q1.rear.val);

        System.out.println(q1.deQueue());
        q1.printMyQ();



    }



}
