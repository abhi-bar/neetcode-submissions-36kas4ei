class Solution {
    public String longestPalindrome(String s) {
        //        Principle is start filling from bottom to right
//        if( bottom, left ) is true that means
//          1. i==j
//          2. possible palindrome

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int maxLen = 0;
        int macI =0;

        for (int i = n-1; i >=0 ; i--) {
            for (int j = i; j <n ; j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i+1<=2 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    if(maxLen<j-i+1){
                        macI = i;
                        maxLen=j-i+1;
                    }
                }
            }
        }

        return s.substring(macI, macI+maxLen);   
    }
}
