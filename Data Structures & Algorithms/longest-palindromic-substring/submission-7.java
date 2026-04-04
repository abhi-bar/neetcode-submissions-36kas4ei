class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();

        if(n==1) return s;

        int max = 0;
        String t = "";

        for (int i = 0; i < n-1; i++) {

            int l1 = i;
            int r1 = i+1;

            while(l1>=0 && r1<n && s.charAt(l1)==s.charAt(r1)){
                if(max<(r1-l1)+1){
                    max = r1-l1+1;
                    t = s.substring(l1,r1+1);
                }
                l1--;
                r1++;
            }

            l1 = i;
            r1 = i;

            while(l1>=0 && r1<n && s.charAt(l1)==s.charAt(r1)){
                if(max < (r1-l1)+1){
                    max = r1-l1+1;
                    t = s.substring(l1, r1+1);
                }
                l1--;
                r1++;
            }
        }

        return t;
    }
}
