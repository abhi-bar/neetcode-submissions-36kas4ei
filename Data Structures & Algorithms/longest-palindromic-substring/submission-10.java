class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();

        int max = 0;
        int left = 0;
        int right  = 0;

        for (int i = 1; i <length; i++) {

            int l = i-1;
            int r = i+1;
            while (l>=0 && r<length){
                if(s.charAt(l)==s.charAt(r)){
                    if(r-l+1>max){
                        left = l;
                        right = r;
                    }
                    max = Math.max(max, r-l+1);
                    l--;
                    r++;
                }else {
                    break;
                }
            }

            l = i-1;
            r = i;

            while (l>=0 && r<length){
                if(s.charAt(l)==s.charAt(r)){
                    if(r-l+1>max){
                        left = l;
                        right = r;
                    }
                    max = Math.max(max, r-l+1);
                    l--;
                    r++;
                }else {
                    break;
                }
            }
        }

        String ans = s.substring(left,right+1);
        System.out.println(ans);

        return ans;
    }
}
