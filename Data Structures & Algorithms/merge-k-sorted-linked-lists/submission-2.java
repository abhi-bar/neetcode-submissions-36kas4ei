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
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int min = Integer.MAX_VALUE;
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode node = head;

        int x =0;
        
        while (size>0) {
            min= Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]!=null && min>=lists[i].val){
                    min = Math.min(lists[i].val,min);
                    x = i;
                }
            }
            
            node.next = lists[x];
            node = node.next;
            lists[x] = lists[x].next;
            
            if(lists[x]==null){
                size--;
            }
        }

        return head.next;
    }
}
