class Solution {
    public boolean isAnagram(String s, String t) {
int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        char[] chars = s.toCharArray();
        for(char c: chars){
            arr1[c-'a']++;
        }

        char[] chars2 = t.toCharArray();
        for(char c: chars2){
            arr2[c-'a']++;
        }
        
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));
    }
}
