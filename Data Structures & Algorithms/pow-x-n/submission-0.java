class Solution {
    public double myPow(double x, int n) {
        int m = Math.abs(n);
        double y =1.0d;
        while(m>0){
            y *= x;
            m--;
        }

        return n>0?y:1/y;
    }
}
