package DSA;




public class singlyLL {

    private Node head;

    private static class Node {

        int val;
        Node next;

        public Node(int data) {
            this.val = data;
            this.next = null;
        }

    }


    public void addNodeAtLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.head.next = null;
            return;
        }
        Node temp = this.head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.next = null;

    }

    public void addNodeAtFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.head.next = null;
            return;
        }
        node.next = this.head;
        this.head = node;

    }

    public void deleteNodeAtFirst() {

        if (this.head == null) {

            return;
        }
        Node currentNode = this.head.next;

        this.head = currentNode;
    }

    public void deleteNodeAtLast() {

        if (this.head == null) {

            return;
        }
        if (this.head.next == null) {

            this.head.next = null;
            return;
        }

        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;

    }

    public int size() {
        if (this.head == null) {
            return 0;
        }
        Node currentNode = this.head;
        int size = 0;

        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;

    }


    //taken index starting from 0
    public void addAtGivenIndex(int index, int data) {
        if (index == 0) {
            addNodeAtFirst(data);
            return;
        }
        if (index == this.size()) {
            addNodeAtLast(data);
            return;
        }

        int size = this.size();

        Node currentNode = this.head;

        int temp = 1;
        while (temp < index) {
            currentNode = currentNode.next;
            temp++;
        }
        Node tempNode = currentNode.next;
        currentNode.next = new Node(data);
        currentNode.next.next = tempNode;


    }


    public void printMyll() {

        if (this.head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println();


    }

    public void deleteAtGivenIndex(int index) {
        // we need take some exception like if index is out of bound etcc..
        // we will dpo that later
        if (index == 0) {
            this.deleteNodeAtFirst();
            return;
        } else if (index == this.size() - 1) {
            this.deleteNodeAtLast();
            return;
        }

        Node currentNode = this.head;

        int temp = 1;

        while (temp < index) {
            currentNode = currentNode.next;
            temp++;
        }
        Node tempNode = currentNode.next;

        currentNode.next = currentNode.next.next;

        tempNode.next = null;


    }


    public boolean isPresent(int data) {
        // we can add some checks like head is null etc for now we wont do that

        Node currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.val == data) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void reverseMySll() {
        //if only head is there return
        if (this.size() == 1) {
            return;
        } else if (this.size() == 2) {
            Node currentNode = this.head.next;
            currentNode.next = this.head;

            this.head.next = null;
            this.head = currentNode;
            return;
        }

        Node prev = null;
        Node current = this.head;
        Node next = null;//why didnt we give this as current.next ? Becoz it will give null pointer exception
        while (current != null) {
            next = current.next;

            current.next = prev;
            prev = current;
            current = next;

        }
        this.head = prev;

    }


    public int middleNode() {

        if (this.size() == 1) {
            return this.head.val;
        } else if (this.size() == 2) {
            return this.head.next.val;
        }

        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.val;
    }

    public int nthNodeFromEnd(int n) {

        Node front = this.head;
        Node back = this.head;

        int count = 0;

        while (count < n) {
            front = front.next;
            count++;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        return back.val;
    }


    public void removeDuplicatesFromSortedSLL() {

        Node current = this.head;

        while (current.next != null) {

            Node temp = current.next;
            if (current.val == temp.val) {
                current.next = temp.next;
                temp.next = null;
            }
            if (current.next != null && current.val != current.next.val) {
                current = current.next;
            }

        }

    }

    public void addDataInSortedSLL(int data) {
        if (this.head.val > data) {
            this.addNodeAtFirst(data);
            return;
        }
        if (this.size() == 1) {
            this.addNodeAtLast(data);
            return;
        }

        Node current = this.head;
        Node temp = null;
        Node newNode = new Node(data);
        while (current != null && current.val < data) {
            temp = current;
            current = current.next;
        }

        temp.next = newNode;
        newNode.next = current;

    }

    public boolean isLoopSLL() {

        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return  true;
            }
        }

        return  false;
    }

    public Node startOfLoop(){
        Node slow = this.head;
        Node fast = this.head;
        Node temp = this.head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
               while(temp != null){
                   if(temp == slow){
                       return  slow;
                   }
                   slow = slow.next;
                   temp = temp.next;
               }
            }
        }

        return null;

    }

    public void removeLoopOfSLL() {


        Node slow = this.head;
        Node fast = this.head;
        Node temp = this.head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){

                while(temp != null){
                    if(temp.next == slow.next){
                       slow.next = null;
                       return;
                    }

                    slow = slow.next;
                    temp = temp.next;
                }
            }
        }

    }

    public static singlyLL merge(singlyLL sll1, singlyLL sll2) {

        singlyLL newSinglyll = new singlyLL();

        Node current1 = sll1.head;

        Node current2 = sll2.head;

        Node dummy = new Node(0);
        Node tail = dummy;


        while(current1 != null && current2 != null){

            if(current2.val > current1.val){
                tail.next = current1;
                current1 = current1.next;
            }
            else{
                tail.next = current2;
                current2 = current2.next;

            }
            tail = tail.next;
        }

        if(current2 !=null){
            tail.next = current2;
        }
        else if(current1 != null){
            tail.next = current1;
        }


        newSinglyll.head = dummy.next;
        dummy.next = null;

      return newSinglyll;
    }

    public static Node mergeTwoLists(Node list1, Node list2) {

        Node dummy = new Node(0);

        Node tail = dummy;

        while(list1 != null && list2 != null){

            if(list1.val > list2.val){
                tail.next = list2;
                list2 = list2.next;
            }
            else{
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;

        }

        if(list1 != null){
            tail.next = list1;
        }
        else{
            tail.next = list2;
        }

        return dummy.next;


    }


//    public ListNode mergeLL(singlyLL sll1 , singlyLL sll2) {
//
//       singlyLL newSll = new singlyLL();
//
//       ListNode dummy = new ListNode(0);
//
//       ListNode current1 = sll1.head;
//
//       ListNode current2 = sll2.head;
//
//       while(current1 != null && current2 != null){
//
//       }
//
//
//        return ;
//    }

    public singlyLL addTwoSll(Node a , Node b){

        singlyLL ansSll =  new singlyLL();
        Node dummy = new Node(0);

        Node tail = dummy;
        int carry = 0;

        while(a != null && b != null){
            int sum = a.val + b.val +carry;
            a.val = sum %10 ;
            carry = sum/10;

            tail.next = a;
            tail = a;
            a = a.next;
            b = b.next;
        }

        while(b!= null){
            int sum = b.val +carry;

            b.val = sum%10;
            carry = sum/10;
            tail.next = b;
            b = b.next;

        }

        if(carry != 0){
            Node newNode = new Node(carry);
            tail.next = newNode;
        }
        ansSll.head = dummy.next;

        return  ansSll;

    }


    public static void main(String[] args) {

        singlyLL obj = new singlyLL(); //just to call methods

        singlyLL sll = new singlyLL();
        sll.addNodeAtLast(5);
        sll.addNodeAtLast(10);
        sll.printMyll();

        sll.addNodeAtFirst(15);
        sll.addNodeAtFirst(20);
        sll.printMyll();;

        sll.deleteNodeAtFirst();
        sll.printMyll();
        System.out.println(sll.size());

        sll.addNodeAtLast(25);
        sll.printMyll();
        System.out.println(sll.size());


        sll.deleteNodeAtLast();
        sll.printMyll();
        System.out.println(sll.size());

        sll.addAtGivenIndex(2,30);
        sll.addAtGivenIndex(4,40);
        sll.addAtGivenIndex(1,40);
        sll.printMyll();

        sll.deleteNodeAtLast();
        sll.printMyll();
        sll.deleteNodeAtFirst();
        sll.printMyll();


        System.out.println("Deleting at given Position");
        //deleting at given position
        sll.deleteAtGivenIndex(3);
        sll.printMyll();

        System.out.println("Checking if data is present or not");
        System.out.println(sll.isPresent(5));
        System.out.println(sll.isPresent(42));


        System.out.println("reversing SLL with 2 elements");
        singlyLL sll2 = new singlyLL();
        sll2.addNodeAtFirst(2);
        sll2.addNodeAtLast(5);
        sll2.printMyll();
        System.out.println(sll2.head.val);
        sll2.reverseMySll();
        sll2.printMyll();
        System.out.println(sll2.head.val);


        System.out.println("Reversing SLL more than 2 elements");
        singlyLL sll3 = new singlyLL();
        sll3.addNodeAtFirst(15);
        sll3.addNodeAtLast(20);
        sll3.addNodeAtLast(25);
        sll3.addNodeAtLast(30);
        sll3.printMyll();
        System.out.println(sll3.head.val);
        sll3.reverseMySll();
        sll3.printMyll();
        System.out.println(sll3.head.val);


        System.out.println("Finding Middle element");
        singlyLL sll4 = new singlyLL();
        sll4.addNodeAtFirst(15);
        sll4.addNodeAtLast(20);
        sll4.addNodeAtLast(25);
        sll4.addNodeAtLast(30);
        System.out.println(sll4.middleNode());
        sll4.addNodeAtLast(35);
        sll4.addNodeAtLast(40);
        sll4.addNodeAtLast(45);
        System.out.println(sll4.middleNode());


        System.out.println("retrieving nth Node from Back");
        singlyLL sll5 = new singlyLL();
        sll5.addNodeAtFirst(15);
        sll5.addNodeAtLast(20);
        sll5.addNodeAtLast(25);
        sll5.addNodeAtLast(30);
        sll5.addNodeAtLast(35);
        sll5.addNodeAtLast(40);
        sll5.printMyll();
        System.out.println(sll5.nthNodeFromEnd(2));
        System.out.println(sll5.nthNodeFromEnd(5));


        System.out.println("Removing duplicates form a sorted SLL");
        singlyLL sll6 = new singlyLL();
        sll6.addNodeAtFirst(15);
        sll6.addNodeAtLast(15);
        sll6.addNodeAtLast(15);
        sll6.addNodeAtLast(30);
        sll6.addNodeAtLast(35);
        sll6.addNodeAtLast(40);
        sll6.addNodeAtLast(45);
        sll6.addNodeAtLast(45);
        sll6.printMyll();
        sll6.removeDuplicatesFromSortedSLL();
        sll6.printMyll();


        System.out.println("inserting element in a sorted SLL");
        singlyLL sll7= new singlyLL();
        sll7.addNodeAtFirst(15);
        sll7.addNodeAtLast(20);
        sll7.addNodeAtLast(25);
        sll7.addNodeAtLast(30);
        sll7.addNodeAtLast(35);

        sll7.printMyll();
        sll7.addDataInSortedSLL(27);
        sll7.printMyll();


        System.out.println("creting a loop in SLL");
        singlyLL sll8 = new singlyLL();
        sll8.addNodeAtFirst(15);
        Node node2 = new Node(20);
        Node node3 = new Node(25);
        Node node4 = new Node(30);
        Node node5 = new Node(35);
        sll8.head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        System.out.println(sll8.isLoopSLL());

        System.out.println(sll8.startOfLoop().val);



        System.out.println("removing a loop in SLL");
        singlyLL sll9 = new singlyLL();
        Node start = new Node(15);
        Node node6 = new Node(20);
        Node node7 = new Node(25);
        Node node8 = new Node(30);
        Node node9 = new Node(35);
        sll9.head = start;
        sll9.head.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node7;
        System.out.println(sll9.isLoopSLL());

        sll9.removeLoopOfSLL();
        sll9.printMyll();


        System.out.println("Merging 2 SLL in Sorted way");
        singlyLL sll10= new singlyLL();
        sll10.addNodeAtFirst(18);
        sll10.addNodeAtLast(25);
        sll10.addNodeAtLast(25);
        sll10.addNodeAtLast(30);
        sll10.addNodeAtLast(35);

        singlyLL sll11= new singlyLL();
        sll11.addNodeAtFirst(16);
        sll11.addNodeAtLast(22);
        sll11.addNodeAtLast(28);
        sll11.addNodeAtLast(29);
        sll11.addNodeAtLast(36);

        Node head = mergeTwoLists(sll10.head , sll11.head);
        System.out.println(head.val + " "+ head.next.next.val + " "+ head.next.next.val);
        //ypurs also correct




        System.out.println("adding 2 SLL in Sorted way");
        singlyLL sll12= new singlyLL();
        sll12.addNodeAtFirst(8);
        sll12.addNodeAtLast(2);
        sll12.addNodeAtLast(5);
        sll12.addNodeAtLast(10);
        sll12.addNodeAtLast(5);

        singlyLL sll13= new singlyLL();
        sll13.addNodeAtFirst(6);
        sll13.addNodeAtLast(2);
        sll13.addNodeAtLast(2);
        sll13.addNodeAtLast(0);
        sll13.addNodeAtLast(6);

        obj.addTwoSll(sll12.head , sll13.head).printMyll();//passed Leetcode








    }




    public static void main(int[] args) {
        System.out.println("hii");
    }

}
