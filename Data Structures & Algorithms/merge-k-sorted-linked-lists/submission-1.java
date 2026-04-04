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
        if(size==0){
            return null;
        }
        if(size==1){
            return (ListNode) Arrays.stream(lists).toList();
        }
        
        ListNode combineList = lists[0];
        
        
        int i =1;
        while(i<size){
            combineList = combine(combineList,lists[i]);
            i++;
        }
        
        return combineList;
        
    }    
    
    private ListNode combine(ListNode lis1, ListNode lis2){
        ListNode node = new ListNode();
        ListNode head = node;

        while(lis1!=null && lis2!=null){
            if(lis1.val> lis2.val){
                node.next = lis2;
                lis2=lis2.next;
//                node=node.next;
            }else {
                node.next = lis1;
                lis1=lis1.next;
//                node=node.next;
            }
            node = node.next;
        }

        if(lis1!=null){
            node.next=lis1;
        }
        if(lis2!=null){
            node.next=lis2;
        }

        return head.next;
    }
}
