class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        helper(nums, new ArrayList<>(), 0);
        return ans;
    }

    List<List<Integer>> ans = new ArrayList<>();

    private void helper(int[] arr, List<Integer> list, int index){
        if(list.size()==arr.length && !ans.contains(list)){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            exchanger(i,index,arr);

            helper(arr,list,index+1);

            exchanger(i,index,arr);
            list.removeLast();
        }
    }

    private void exchanger(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}