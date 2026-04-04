class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        int[] s1Ans  = helper(s1);
        int r  = length;
        int l = 0;
        while (r<=s2.length()){
            System.out.println(s2.substring(l,r));

            if(Arrays.equals(s1Ans, helper(s2.substring(l, r)))){
                return true;
            }
            l++;
            r++;

        }

        return false;
    }

    private int[] helper(String s1){
        int[] dope = new int[26];
        char[] chars = s1.toCharArray();
        for(char ch:chars){
            dope[ch - 'a']++;
        }

        return dope;
    }
}
