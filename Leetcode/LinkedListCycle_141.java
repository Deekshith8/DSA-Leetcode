package Leetcode;

public class LinkedListCycle_141 {

    class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
          next = null;
     }

    }
    public static void main(String[] args) {

    }


    public boolean hasCycle(ListNode head) {



        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }

        }

      return  false;
    }


}
