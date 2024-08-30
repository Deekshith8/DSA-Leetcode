package DSA;

public class DoublyLL {

    private Node head;

    private Node tail;

    private int length;

    public  DoublyLL(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public class Node {

        private int val;
        private Node next;

       private Node prev;

        public Node(int data) {
            this.val = data;
            this.next = null;
            this.prev = null;
        }

    }

    public void printMyDll(){

        Node current = this.head;

        while(current != null){
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println();

    }


    public void addAtfirst(int val){

        Node newNode = new Node(val);

        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }
        this.head.prev = newNode;
        newNode.next = this.head;
        this.head = this.head.prev;
        this.length++;

    }

    public void addAtLast(int val){

        Node newNode = new Node(val);

        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        this.length++;
    }

    public void deleteAtFirst(){

        if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length--;
            return;
        }
       this. head = this. head.next;
       this. head.prev.next = null;
       this. head.prev = null;
        this.length--;


    }

    public  void deleteAtLast(){

        if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length--;
            return;
        }
        this.tail = this.tail.prev;
        this.tail.next.prev = null;
        this.tail.next = null;
        this.length--;

    }

    public boolean isEmpty(){
        return  this.length == 0;
    }


    public static void main(String[] args) {

        System.out.println("adding Node at first");
        DoublyLL dll1 = new DoublyLL();
        dll1.addAtfirst(10);
        dll1.addAtfirst(15);
        dll1.addAtfirst(20);
        dll1.printMyDll();
        System.out.println(dll1.tail.val);
        System.out.println(dll1.head.val);


        System.out.println("Adding new Node at End");
        DoublyLL dll2 = new DoublyLL();
        System.out.println(dll2.length+" "+dll2.isEmpty());
        dll2.addAtLast(1);
        dll2.addAtLast(5);
        dll2.addAtLast(0);
        dll2.printMyDll();
        System.out.println(dll2.tail.val);
        System.out.println(dll2.head.val);
        System.out.println(dll2.length+" "+dll2.isEmpty());


        System.out.println("Deleting the first ");
        DoublyLL dll3 = new DoublyLL();
        dll3.addAtLast(1);
        dll3.addAtLast(5);
        dll3.addAtLast(0);
        dll3.printMyDll();
        dll3.deleteAtFirst();
        dll3.printMyDll();
        System.out.println(dll3.head.val);


        System.out.println("Deleting the last ");
        DoublyLL dll4= new DoublyLL();
        dll4.addAtLast(1);
        dll4.addAtLast(5);
        dll4.addAtLast(0);
        dll4.printMyDll();
        dll4.deleteAtLast();
        dll4.printMyDll();
        System.out.println(dll4.tail.val);

    }


}
