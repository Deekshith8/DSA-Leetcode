package Leetcode;

public class ReverseKnodes {

    public  static  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ReverseKnodes reverseKnodes = new ReverseKnodes();
        ListNode current = reverseKnodes.reverseKGroup(head,4);

        while(current != null){
            System.out.print(current.val+ "-> ");
            current = current.next;
        }

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1){
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;


        ListNode left = head;
        ListNode right = head;
        ListNode prev = dummy;

        while(left != null){

            int temp = 0;
            while (temp < k && right != null){
                right = right.next;
                temp++;
            }

            if(temp == k){
                ListNode tempNode = left.next;
                while(tempNode != right){
                    left.next = tempNode.next ;
                    tempNode.next = prev.next;
                    prev.next = tempNode ;
                    tempNode = left.next;
                }
                prev = left;
                left = right;

            }
            else{
                break;
            }
        }


        return dummy.next;
    }



}
