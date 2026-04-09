class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        ans(n,k,0,new ArrayList<>());
        return ans;
    }

    private void ans(int n, int k, int index, List<Integer> list){
        // if(ans.size()==n){
        //     return;
        // }
        if(list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < n; i++) {
            list.add(i+1);
            ans(n,k,i+1,list);
            list.removeLast();    
        }
    }
}