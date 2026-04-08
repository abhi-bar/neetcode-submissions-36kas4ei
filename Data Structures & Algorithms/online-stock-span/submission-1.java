class StockSpanner {

    Stack<Integer> stack;
    Stack<Integer> revStack ;
    
    public StockSpanner() {
        stack = new Stack<>();
        revStack = new Stack<>();
    }

    public int next(int price) {
       if(stack.isEmpty() || stack.peek()>price){
            stack.add(price);
            return 1;
        }

        int count = 0;

        stack.add(price);
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            revStack.add(pop);

            if(pop>price){
                break;
            }
            count++;
        }

//        count = revStack.size();

        while (!revStack.isEmpty()){
//            count++;
            stack.add(revStack.pop());
        }



        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */