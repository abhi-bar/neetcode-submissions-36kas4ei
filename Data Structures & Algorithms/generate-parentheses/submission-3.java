class Solution {
    public List<String> generateParenthesis(int n) {
        pp(n,0,0,new StringBuilder());
        return ans;
    }

    List<String> ans = new ArrayList<>();
    private void  pp(int n, int l, int r, StringBuilder sb){
        if(l==n && r==n){
            ans.add(sb.toString());
        }
        
        if(l<n){
            sb.append("(");
            pp(n,l+1,r,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(r<l){
            sb.append(")");
            pp(n,l,r+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
