class MinStack {

    LinkedList<Integer> list;
    LinkedList<Integer> minList = new LinkedList<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
        list = new LinkedList<>();
    }

    public void push(int val) {
        list.push(val);
        if (minList.isEmpty()) {
            minList.push(val);
        } else {
            minList.push(Math.min(val, minList.peek()));
        }
    }

    public void pop() {
        if(!list.isEmpty()){
            minList.pop();
            list.pop();
        }
    }

    public int top() {
        if(!list.isEmpty()){
            return list.getFirst();
        }
        return 0;
    }

    public int getMin() {
        return minList.getFirst();
    }
}
