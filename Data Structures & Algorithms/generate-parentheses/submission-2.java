class Solution {
    public List<String> generateParenthesis(int n) {
        helper(new ArrayList<>(),0,0,n,"");
        return ans;
    }

    List<String> ans = new ArrayList<>();

    private void helper(List<String> list, int left, int right, int target, String s){
        if(left==right && right==target){
            ans.add(s);
            return;
        }

        if(left<target){
            s+="(";
            helper(list, left+1,right,target,s);
            s = s.substring(0,s.length()-1);
        }

        if(right<left){
            s = s+")";
            helper(list,left,right+1,target,s);
            s = s.substring(0,s.length()-1);
        }
    }
}
