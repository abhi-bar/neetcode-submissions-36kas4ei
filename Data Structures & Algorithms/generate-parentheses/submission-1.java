class Solution {
    public List<String> generateParenthesis(int n) {
        parenthesisHelper(n,0,0,"");
        return listParenthesis;
    }
    List<String> listParenthesis = new ArrayList<>();
    private void parenthesisHelper(int n, int c1, int c2, String s){
        if(c1==n && c1==c2){
            listParenthesis.add(s);
        }
        if(c1<n){
            s = s+"(";
            parenthesisHelper(n,c1+1,c2,s);
            s = s.substring(0,s.length()-1);
        }

        if(c2<c1){
             s = s+")";
             parenthesisHelper(n, c1,c2+1,s);
             s = s.substring(0,s.length()-1);
        }

//        return;
    }
}
