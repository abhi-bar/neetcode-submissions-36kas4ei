class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = 0;
        int l2 = 0;
        
        StringBuffer stringBuffer = new StringBuffer();
        while (l1<word1.length() && l2<word2.length()){
            stringBuffer.append(word1.charAt(l1));
            stringBuffer.append(word2.charAt(l2));
            l1++;
            l2++;
        }
        
        while (l1<word1.length()){
            stringBuffer.append(word1.charAt(l1));
            l1++;
        }

        while (l2<word2.length()){
            stringBuffer.append(word2.charAt(l2));
            l2++;
        }
        
        return stringBuffer.toString();
    }
}