class MedianFinder {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(min.isEmpty() || num< min.peek()){
            max.add(num);
        } else {
            min.add(num);
        }
        
        if(Math.abs(min.size()-max.size())>1){
            if(min.size()>max.size()){
                max.add(min.poll());
            }
            else {
                min.add(max.poll());
            }
        }
    }

    public double findMedian() {
        if(min.isEmpty() && max.isEmpty()){
            return 0;
        }
        if(!min.isEmpty() && !max.isEmpty() && min.size()==max.size()){
            return (double) (min.peek() + max.peek()) /2;
        }
        if(min.isEmpty()){
            return max.peek();
        }
        if(max.isEmpty()){
            return min.peek();
        }
        if(max.size()>min.size()){
            return max.peek();
        }
        else return min.peek();
        
    }
}
