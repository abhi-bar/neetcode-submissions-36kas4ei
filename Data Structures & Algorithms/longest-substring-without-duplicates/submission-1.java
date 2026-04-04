class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0 || s.isEmpty() || s==null) return 0;

        int left = 0;
        int r = left+1;

        char[] chars = s.toCharArray();
        int max = 1;

        HashSet<Character> set = new HashSet<>();
        set.add(chars[left]);

        while(r<chars.length){
            if(left==r){
                set.add(chars[left]);
                r++;
            }

            else if(set.contains(chars[r])){
                set.remove(chars[left]);
                left++;
            }

            else{
                set.add(chars[r]);
                max = Math.max(max, r-left+1);
                r++;
            }
        }

        return max;
    }
}
