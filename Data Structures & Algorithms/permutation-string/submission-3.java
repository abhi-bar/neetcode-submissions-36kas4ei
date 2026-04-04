class Solution {
    public boolean checkInclusion(String s1, String s2) {
//        Sliding window problem
//        s2 = full, s1 = question

        int distance = s1.length();
        int i = 0;

        while(i+distance<=s2.length()){
            String check = s2.substring(i,i+distance);
            if(checkAnagram(check, s1)){
                return true;
            }
            i++;
        }

        return false;

    }

    private boolean checkAnagram(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(char c:c1){
            arr1[c-'a']++;
        }

        for(char c:c2){
            arr2[c-'a']++;
        }

        return Arrays.equals(arr1, arr2);
    }
}
