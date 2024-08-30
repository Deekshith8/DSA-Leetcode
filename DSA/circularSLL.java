package DSA;

public class circularSLL {

    private Node last;

    class  Node{
        private int val;

        private Node next;

        public  Node(int val){
            this.val = val;
        }

    }

    public void printMyCSL(){

        Node current = this.last.next;

        while(current != this.last){
            System.out.print(current.val+"->");
            current = current.next;
        }
        System.out.print(current.val+"->");
        System.out.println();

    }

    public void addLast(int val){
        Node newNode = new Node(val);

        if(this.last == null){
            this.last = newNode;
            this.last.next = newNode;
            return;
        }

        newNode.next = last.next;
        last.next = newNode;
        last = last.next;

    }


    public void addfirst(int val){
        Node newNode = new Node(val);

        if(this.last == null){
            this.last = newNode;
            this.last.next = newNode;
            return;
        }

        newNode.next = last.next;
        last.next = newNode;


    }

    public void removeFirst(){
        if(this.last == null){
            this.last = null;
            return;
        }

        Node temp = this.last.next.next;
        this.last.next.next = null;
        this.last.next = temp;

    }

    public static void main(String[] args) {

        circularSLL csl1 = new circularSLL();
        csl1.addLast(2);
        csl1.addLast(3);
        csl1.addLast(4);
        csl1.addLast(5);
        System.out.println(csl1.last.val);
        System.out.println(csl1.last.next.val);
        csl1.printMyCSL();


        System.out.println("Adding at first");
        circularSLL csl2 = new circularSLL();
        csl2.addfirst(2);
        csl2.addfirst(3);
        csl2.addfirst(4);
        csl2.addfirst(5);
        System.out.println(csl2.last.val);
        System.out.println(csl2.last.next.val);
        csl2.printMyCSL();



        System.out.println("removing at first");
        circularSLL csl3 = new circularSLL();
        csl3.addfirst(2);
        csl3.addfirst(3);
        csl3.addfirst(4);
        csl3.addfirst(5);
        System.out.println(csl3.last.val);
        System.out.println(csl3.last.next.val);
        csl3.printMyCSL();
        csl3.removeFirst();
        System.out.println("After removing");
        csl3.printMyCSL();
        System.out.println(csl3.last.val);
        System.out.println(csl3.last.next.val);


    }






}
