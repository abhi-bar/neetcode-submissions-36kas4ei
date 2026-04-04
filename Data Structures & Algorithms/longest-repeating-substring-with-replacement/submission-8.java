class Solution {
    public int characterReplacement(String s, int k) {
        int maxL = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        int l =0 ;

        for (int r = 0; r < s.length(); r++) {
            hashMap.put(s.charAt(r),hashMap.getOrDefault(s.charAt(r),0)+1);

            while((r-l+1 - Collections.max(hashMap.values()))>k){
                hashMap.put(s.charAt(l), hashMap.get(s.charAt(l))-1);
                l++;
            }

            maxL = Math.max(maxL,r-l+1);

        }
        return maxL;
    }
}
