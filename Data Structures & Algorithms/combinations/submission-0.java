class Solution {
    public List<List<Integer>> combine(int n, int k) {
        helper(new ArrayList<>(), k,n,1);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    private void helper(List<Integer> list,int k,int n, int index){
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            helper(list,k,n,i+1);
            list.removeLast();
        }
    }
}