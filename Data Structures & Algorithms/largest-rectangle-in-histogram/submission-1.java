class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int area = 0;
        for (int i = 0; i < heights.length; i++) {

            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                area = Math.max(area, height * width);
            }
            stack.push(i);
            hashMap.put(i, heights[i]);
        }

        int lastIndex = heights.length;
//        int index = stack.peek();
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int weidth = stack.isEmpty() ? lastIndex : (lastIndex-stack.peek()-1);
            area = Math.max(area,height*weidth);
//            System.out.println("area: "+area +  "  now-height: "+heights[stack.peek()]*(lastIndex-stack.peek()));
        }

        return area;
    }
}
