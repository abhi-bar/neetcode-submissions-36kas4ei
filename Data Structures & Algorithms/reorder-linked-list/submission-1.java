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
    public void reorderList(ListNode head) {
        ListNode slow= head;
        ListNode fast = head;
        int size = 0;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            size++;
        }

        ListNode revNode = reverseNode(slow);
        ListNode node = head;

        while(revNode!=null && node!=null){
            ListNode temp1  = node.next;
            ListNode temp2 = revNode.next;
            
            node.next = revNode;
            revNode.next = temp1;
            
            revNode = temp2;
            node = temp1;
        }
    }

    private ListNode reverseNode(ListNode node){
//        1-> 2-> 4-> 5

        ListNode current=node;
        ListNode prev = null;
        ListNode pro;

        while(current!=null){
            pro = current.next;
            current.next=prev;
            prev=current;
            current=pro;
        }
        return prev;
    }
}
