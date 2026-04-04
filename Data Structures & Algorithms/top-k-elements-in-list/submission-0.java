class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i:nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        int[] ans = new int[hashMap.size()];
        int index = 0;
        for (Integer i:hashMap.values()) {
            ans[index] = i;
            index++;
        }

        System.out.println("hash: "+hashMap.values());

        List<Map.Entry<Integer,Integer>> values = new ArrayList<>(hashMap.entrySet());
        values.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        int[] ans2 = new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer,Integer> entry = values.get(i);
            ans2[i] = entry.getKey();
        }

        return ans2;
    }
}
