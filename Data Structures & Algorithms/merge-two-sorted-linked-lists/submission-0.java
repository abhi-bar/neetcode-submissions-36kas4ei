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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;

        ListNode node = new ListNode();
        ListNode head = node;

        while(node1!=null && node2!=null){

            if(node1.val>=node2.val){
                node.next = new ListNode(node2.val);
                node = node.next;
                node2= node2.next;
            }else{
                node.next = new ListNode(node1.val);
                node=node.next;
                node1=node1.next;
            }
        }
        
        if(node1==null){
            node.next = node2;
        }else{
            node.next = node1;
        }

        return head.next;
    }
}