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
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;

        ListNode node = head;

        ListNode prev = null;
        ListNode newN = null;


        while (node!=null){
            newN = node.next;
            node.next = prev;
            prev = node;
            node = newN;
        }

        return prev;
    }
}
