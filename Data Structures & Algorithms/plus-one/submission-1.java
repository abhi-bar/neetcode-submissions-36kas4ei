class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        digits[digits.length-1]++;
        int x  =0;
        for (int i = digits.length-1; i >=0; i--) {
            x += digits[i];
            
            if(x>9){
                list.add(0,x%10);
                x=x/10;
            }else {
                list.add(0,x);
                x=0;
            }
        }
        if(x>0){
            list.add(0,x);
        }

        System.out.println(list);
return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
