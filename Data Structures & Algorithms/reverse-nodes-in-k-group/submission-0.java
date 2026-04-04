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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
    for (int i = 0; i < k; i++) {
        if (node == null) {
            return head; // fewer than k → don't reverse
        }
        node = node.next;
    }

    // reverse first k nodes
    ListNode prev = null, curr = head;
    for (int i = 0; i < k; i++) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // head is now the tail of the reversed group
    // connect it with the result of next group
    head.next = reverseKGroup(curr, k);

    // prev is the new head of this group
    return prev;
    }
}
