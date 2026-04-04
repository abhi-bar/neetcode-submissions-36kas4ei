class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT);
        char char1;
        char char2;
        char[] chararr = s.toCharArray();

        int start =0;
        int end = chararr.length-1;

        while(end>=start){
            char1 = chararr[start];
            char2 = chararr[end];
            System.out.println("Char1: "+ char1);
            System.out.println("Char2: "+char2);

            if(!Character.isLetterOrDigit(char1)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(char2)){
                end--;
                continue;
            }
            if(char1!=char2){
                return false;
            }
            end--;
            start++;
        }

        return true;
    }
}
