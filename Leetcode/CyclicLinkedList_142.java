package Leetcode;

public class CyclicLinkedList_142 {

  static   class ListNode {
        int val;
       ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    public static void main(String[] args) {

        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(0);
        l1.next.next.next = new ListNode(-4);
        l1.next.next.next.next = l1.next;

        CyclicLinkedList_142 obj = new CyclicLinkedList_142();

        System.out.println(obj.detectCycle(l1).val);

    }

    public ListNode detectCycle(ListNode head) {

      if(head == null || head.next == null){
          return null;
      }

        int count = 0;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                count++;
                break;
            }

        }
        if(count == 0){
            return new ListNode(-1);
        }

        ListNode current = head;
        count = 0;
        while(current != slow){
            count++;
            current = current.next ;
            slow = slow.next;
        }

        return current;

    }

    public boolean isCyclic(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
               return  true;
            }

        }

        return false;
    }

}
