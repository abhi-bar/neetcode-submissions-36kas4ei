class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()]=true;

        for (int i = s.length()-1; i>=0; i--) {
            for (String word: wordDict){
                if(dp[i]) continue;

                if(i + word.length() <= s.length()){
                    if(word.equals(s.substring(i, i+word.length()))){

                        System.out.println(word + "  " + s.substring(i, i+word.length()));
                        dp[i] = dp[i+word.length()];
                    }
                }
            }
        }

        return dp[0];
    }
}
 