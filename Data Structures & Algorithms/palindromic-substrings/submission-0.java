class Solution {
    public int countSubstrings(String s) {
        int maxLen = 0;
        String palindrome = "";
        int n = s.length();
        int count =0;

        for (int i = 0; i < n; i++) {
//                case 1
            int l=i;
            int r=i;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                // if(r-l+1>maxLen){
                //     maxLen = r-l+1;
                //     palindrome = s.substring(l,r+1);
                // }
                count++;
                r++;
                l--;
            }

            l=i;
            r=i+1;
            while (l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                // if(r-l+1>maxLen){
                //     maxLen = r-l+1;
                //     palindrome = s.substring(l,r+1);
                // }
                count++;
                r++;
                l--;
            }
        }
        
        return count;
    }
}
