class Solution {
    public boolean validPalindrome(String s) {
//        int l,r;

//        if(s.length()%2==0){
//            l=s.length()/2-1;
//            r=(s.length()/2);
//        }else {
//            l = s.length()/2;
//            r = s.length()/2;
//        }
        int l =0;
        int r = s.length()-1;
        int k =1;

        while (k>-1 && l<r){
            if(s.charAt(l)!=s.charAt(r)){
//                boolean b = checkPalindrome(s.substring(l,r));
//                boolean x = checkPalindrome(s.substring(l+1,r+1));
//                System.out.println(x);
//                System.out.println(b);
                return (checkPalindrome(s.substring(l,r)) || checkPalindrome(s.substring(l+1,r+1)));
            }
            l++;
            r--;
        }

        return true;

    }

    private boolean checkPalindrome(String s){
        int l,r;
        if(s.length()%2==0){
            l=s.length()/2-1;
            r=(s.length()/2);
        }else {
            l = s.length()/2;
            r = s.length()/2;
        }

        while (l>=0 && r<s.length() ){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l--;
            r++;
        }

        return true;
    }
}