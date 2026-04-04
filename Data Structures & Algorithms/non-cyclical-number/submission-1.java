class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = 0;
        
        while (true){
            
            while(n>0){
                num += (int) Math.pow(n%10,2);
                n = n/10;
            }
            
            if(set.contains(num)){
                return false;
            } else if (num==1) {
                return true;
            }else {
                set.add(num);
            }
            
            n = num;
            num = 0;
        }
    }
}
