class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        if(sum%k!=0) return false;

        int fraction = sum%k;

        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < k; i++) {
            workout(visited, nums, sum/k, 0,0);
            if(!gl){
                return false;
            }
            gl = false;
        }

        System.out.println(Arrays.toString(visited));

        return true;
    }

    boolean gl = false;

    private void workout (boolean[] visited, int[] nums, int sum, int index, int currSum){
        if(currSum>sum){
            return;
        }
        if(currSum==sum){
            gl = true;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;   // ✅ avoid reuse

            visited[i] = true;
            currSum += nums[i];

            workout(visited, nums, sum, i + 1, currSum);  // ✅ use i, not index

            if (gl) return;  // ✅ stop early if found

            visited[i] = false;  // ✅ backtrack
            currSum -= nums[i];
        }

    }
}