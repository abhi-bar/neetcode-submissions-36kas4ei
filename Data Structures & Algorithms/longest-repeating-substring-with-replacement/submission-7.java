class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];  // frequency of chars in window
        int l = 0, maxFreq = 0, maxLen = 0;

    for (int r = 0; r < s.length(); r++) {
        char c = s.charAt(r);
        count[c - 'A']++;
        maxFreq = Math.max(maxFreq, count[c - 'A']);

        // If window is invalid, shrink it
        while ((r - l + 1) - maxFreq > k) {
            count[s.charAt(l) - 'A']--;
            l++;
        }

        maxLen = Math.max(maxLen, r - l + 1);
    }

    return maxLen;
    }
}
