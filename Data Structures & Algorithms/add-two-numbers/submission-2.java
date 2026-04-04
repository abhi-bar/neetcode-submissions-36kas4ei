/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return null;
        }
        ListNode node = new ListNode();
        ListNode head = node;

        int co = 0;

        while(l1!=null && l2!=null){
            int x = co + l1.val + l2.val;
            co=0;

            if(x>9){
                node.next = new ListNode(x%10);
                co = 1;
                // node = node.next;
            }else{
                node.next = new ListNode(x);
                // node = node.next;
            }
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        
        
       while(l1!=null){
            int x = co + l1.val;
            co=0;

            if(x>9){
                node.next = new ListNode(x%10);
                co = 1;
            }else{
                node.next = new ListNode(x);
            }
            node = node.next;
            l1 = l1.next;
//            l2 = l2.next;

        }

        while (l2!=null){
            int x = co + l2.val;
            co=0;

            if(x>9){
                node.next = new ListNode(x%10);
                co = 1;
            }else{
                node.next = new ListNode(x);
            }
            node = node.next;
            l2 = l2.next;
        }

        if(co!=0 && l1==null && l2==null){
            node.next = new ListNode(co);
        }

        return head.next;
    }
}
