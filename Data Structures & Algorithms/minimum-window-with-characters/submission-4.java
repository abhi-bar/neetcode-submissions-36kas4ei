class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for target string
        int[] need = new int[128]; 
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = t.length();  // total chars we need to match
        int left = 0, right = 0;    // sliding window
        int start = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);

            // If this char is needed, decrease required
            if (need[c] > 0) required--;

            // Decrease frequency whether needed or not
            need[c]--;
            right++;

            // When window is valid (all chars matched)
            while (required == 0) {
                // Update best window
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);

                // Restore frequency
                need[lc]++;

                // If char was required, losing it makes window invalid
                if (need[lc] > 0) required++;

                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
}
