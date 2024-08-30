package DSA;

public class addTwoList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


    public static void main(String[] args) {

        ListNode ls = new ListNode(1);
        ls.next = new ListNode(2);
        ls.next.next = new ListNode(3);
        ls.next.next.next = new ListNode(4);
        ls.next.next.next.next = new ListNode(5);

        addTwoList obj = new addTwoList();


        ListNode head =  obj.removeNthFromEnd(ls , 2);

        while(head != null){
            System.out.print(head.val+" ->");
            head = head.next;
        }




    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();

        ListNode head = new ListNode();
        dummy.next = head;
        int carry = 0;

        ListNode current1 = l1;
        ListNode current2 = l2;

        while(current1 != null && current2 != null){

            int val = current1.val + current2.val + carry;

            if(val >= 10){
                carry = val /10;
                val = val%10;
            }
           ListNode temp = new ListNode(val);
            head.next = temp;
            head = head.next;
            current1 = current1.next;
            current2 = current2.next;
        }

        while(current1 != null){
            int val = current1.val + carry;

            if(val >= 10){
                carry = val /10;
                val = val%10;
            }
            ListNode temp = new ListNode(val);
            head.next = temp;
            head = head.next;
            current1 = current1.next;

        }

        while(current2 != null){
            int val =  current2.val + carry;

            if(val >= 10){
                carry = val /10;
                val = val%10;
            }
            ListNode temp = new ListNode(val);
            head.next = temp;
            head = head.next;
            current2 = current2.next;

        }
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            head.next = temp;
        }

     return  dummy.next;
    }


    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;

        ListNode current = head;

        while(current != null && current.next != null){
            temp.next = current.next;

            current.next = current.next.next;

            temp.next.next = current;

            temp = current;
            current = current.next;
        }

        return dummy.next;
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = head;
        int size = 0;

        while(current != null){
            size++;
            current = current.next;
        }

        current = dummy;
        int i = 0;
        while(i < size-n){
            i++;
            current = current.next;
        }
        ListNode temp = current.next.next;
        current.next.next = null;
        current.next = temp;


       return dummy.next;

    }


}
