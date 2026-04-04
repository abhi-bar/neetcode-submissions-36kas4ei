class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.add(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {

            while (!stack.isEmpty() && willCollide(stack.peek(), asteroids[i])) {
                Integer pop = stack.pop();
                if (Math.abs(pop) == Math.abs(asteroids[i])) {
                    asteroids[i] = 0;
                    break;
                }
                
                int max = max(pop, asteroids[i]);

                if (max == pop) {
                    stack.push(pop);
                    break;
                }
            }

            if (asteroids[i] != 0 && (stack.isEmpty() || !willCollide(stack.peek(), asteroids[i]))) {
                stack.push(asteroids[i]);
            }
        }

        if(stack.isEmpty()) return new int[]{};

        int[] ans = new int[stack.size()];
        int i=stack.size()-1;
        while (!stack.isEmpty()){
            ans[i--]=stack.pop();
        }
        return ans;
    }

    private int max(int a, int b){
        int ax = Math.abs(a);
        int bx = Math.abs(b);

        return bx>ax?b:a;
    }

    private boolean willCollide(int a, int b){
        return a > 0 && b < 0;
    }
}