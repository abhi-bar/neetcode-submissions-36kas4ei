class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String t = "";
        int max = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {

            int l=i;
            int r=i+1;

            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(max<(r-l)+1){
                    max = r-l+1;
                    t = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            l=i;
            r=i;

            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                if(max<(r-l)+1){
                    max = r-l+1;
                    t = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }

        return t;
    }
}
