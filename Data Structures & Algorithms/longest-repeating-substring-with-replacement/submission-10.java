class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;

        int l  = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int r = 0; r < s.length(); r++) {
            hashMap.put(chars[r], hashMap.getOrDefault(chars[r],0)+1);

            if((r-l+1 - Collections.max(hashMap.values())>k)){
                hashMap.put(chars[l], hashMap.get(chars[l])-1);
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        
        return maxLength;
    }
}
