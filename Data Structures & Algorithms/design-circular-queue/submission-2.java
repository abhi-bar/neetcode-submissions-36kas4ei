class MyCircularQueue {

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode() {}
        public ListNode(int val) { this.val = val; }

        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public ListNode(int val, ListNode next, ListNode prev) { this.val = val; this.next = next; this.prev = prev;}
    }

    int tot;
    int size = 0;

//    ListNode listNode ;
    ListNode head = null;
    ListNode tail = null;

    public MyCircularQueue(int k) {
        this.tot = k;
//        listNode = new ListNode();
    }

    public boolean enQueue(int value) {
        if(this.size==this.tot) return false;

        ListNode curr = new ListNode(value);
        if(size==0){
            head = curr;
            tail = curr;
        }else {
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
        }
        this.size+=1;
        return true;
    }

    public boolean deQueue() {
        if(size==0) return false;
        else if(size==1){
//            listNode = new ListNode();
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        this.size-=1;
        return true;
    }

    public int Front() {
        return this.size==0?-1:head.val;
    }

    public int Rear() {
        return this.size==0?-1:tail.val;
    }

    public boolean isEmpty() {
        return this.size==0;
    }

    public boolean isFull() {
        return this.size==this.tot;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */