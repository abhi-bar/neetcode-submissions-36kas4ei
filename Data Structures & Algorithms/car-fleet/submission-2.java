class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] fleet = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            fleet[i][0] = position[i];
            fleet[i][1] = speed[i];
        }

        Arrays.sort(fleet, (a,b)-> Integer.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
stack.push((double)(target - fleet[i][0]) / fleet[i][1]);
            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}
