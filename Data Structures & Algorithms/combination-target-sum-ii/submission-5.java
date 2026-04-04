class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), 0);
        return list;
    }
    
    List<List<Integer>> list = new ArrayList<>();
    
    private void helper(int[] candidates, int target, int index, List<Integer> list, int sum){
        if(sum>target) return;

        if(sum==target){
            if(!this.list.contains(list)){
                this.list.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target, i+1, list, sum+candidates[i]);
            list.removeLast();
        }
    }
}
