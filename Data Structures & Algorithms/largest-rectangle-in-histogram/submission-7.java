class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        int i = 0;

        while(i< heights.length){

            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int pop = stack.pop();
                if(stack.isEmpty()) {
                    max = Math.max(max, heights[pop] * i);
                }else {
                    max = Math.max(max, heights[pop] * (i-1 - stack.peek()));
                }
            }
            stack.push(i);
            i++;
        }
        int last = 0;
        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(!stack.isEmpty()){
                last = stack.peek()+1;
                max = Math.max(max, heights[pop]*(i-1-stack.peek()));
            }else {
                max = Math.max(max, heights[pop] * i);
            }
        }

        return max;
    }
}
