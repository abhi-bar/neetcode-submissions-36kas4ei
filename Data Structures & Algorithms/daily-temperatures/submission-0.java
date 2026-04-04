class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Stack<Integer> stack = new Stack<>();

        int[] ans = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {

            while(temperatures[stack.peek()] < temperatures[i]){
                ans[stack.peek()] = i-stack.pop();
                if(stack.isEmpty()){
                    break;
                }
            }
            stack.push(i);
        }

        return ans;
    }
}
