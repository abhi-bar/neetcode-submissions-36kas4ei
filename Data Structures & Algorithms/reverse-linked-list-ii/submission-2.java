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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right-left<1 || head==null) return head;

        ListNode node = head;
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode prev = dummy;

        int leftShift = left;
        int rightShift = right;

        while (left>1) {
            prev=prev.next;
            node = node.next;
            left--;
        }

        ListNode newN = head;
        while (right>0){
            right--;
            newN = newN.next;
        }

        int itteration = (rightShift-leftShift)+1;
        ListNode[] ans = helper(node,itteration);

        prev.next=ans[1];
        ans[0].next=newN;
        

        return (leftShift>1)?head:prev.next;
    }

    private ListNode[] helper(ListNode val, int itteration){
        System.out.println(itteration);
        ListNode node = val;
        ListNode newN = null;
        ListNode prev = null;

        while (itteration>0){
            itteration--;
            newN = node.next;
            node.next = prev;
            prev = node;
            node = newN;
        }

        System.out.println(val.val);
        System.out.println(prev.val);
        return new ListNode[]{val,prev};
    }
}