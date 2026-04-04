class Solution {
    public List<String> generateParenthesis(int n) {
        return backtrack(0,0,new Stack<>(),n, new ArrayList<>());
    }

    private List<String> backtrack(int open, int close, Stack<Character> s, int n, List<String> list){
        if(open==close && open==n){
            StringBuilder st = new StringBuilder();
            for(char ch:s){
                st.append(ch);
            }
//            System.out.println(s.toString().replace(",",""));
            list.add(st.toString());
            return list;

        }
        if(open<n){
            s.add('(');
            backtrack(open+1,close,s,n,list);
            s.pop();
        }
        if(close<open){
            s.add(')');
            backtrack(open,close+1,s,n,list);
            s.pop();
        }
        return list;
    }
}
