/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // first lets create next pointer node
       Map<Node, Node> map  = new HashMap<>();
        Node node = head;
        while(node!=null){
            map.put(node, new Node(node.val));
            node= node.next;
        }

        node = head;

        while(node!=null){
            Node cod = map.get(node);
            cod.next = map.get(node.next);
            cod.random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}
