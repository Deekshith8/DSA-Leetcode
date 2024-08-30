package Leetcode;

public class mergeKSortedLists {

    public static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode [] lists = new ListNode[]{l1,l2,l3};

        mergeKSortedLists MSL = new mergeKSortedLists();
       ListNode current = MSL.mergeKLists2(lists);
       while(current != null){
           System.out.print(current.val+"->");
           current = current.next;
       }


    }

    //brute force approach O(n^2);
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0){
            return new ListNode();
        }

        if(lists.length == 1){
            return lists[0];
        }

        ListNode dummy = new ListNode();
        dummy = lists[0];
        for(int i = 1; i< lists.length ; i++){
           dummy =  helpingMethod(dummy, lists[i]);
        }

        return dummy ;
    }


    public ListNode helpingMethod(ListNode head1 , ListNode head2){

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1 != null && temp2 != null){
            if(temp1.val > temp2.val){
                temp.next = temp2;
                temp2 = temp2.next;
            }
            else{
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }

        while(temp1 != null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;
        }
        while(temp2 != null){
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }

        return  dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists){

        if(lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        boolean flag = true;

        while(flag){
            int min = Integer.MAX_VALUE ; int index = -1;

            for(int i = 0 ;i< lists.length ; i++){
                if(lists[i] != null && lists[i].val < min){
                    min = lists[i].val ;
                    index = i;
                }
            }

            if(index == -1 ){
                flag = false;
            }else{
                temp.next = new ListNode(min);
                lists[index] = lists[index].next;
                temp = temp.next;
            }
        }

     return  dummy.next;
    }


}
