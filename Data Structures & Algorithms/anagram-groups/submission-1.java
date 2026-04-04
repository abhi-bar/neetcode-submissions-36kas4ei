class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> hashMap = new HashMap<>();
        for(String s:strs){
            String val = value(s);
            List<String> list = hashMap.getOrDefault(val,new ArrayList<>());
            list.add(s);
            hashMap.put(val,list);
        }

        List<List<String>> ans = new ArrayList<>();
        for(String i: hashMap.keySet()){
            List<String> list = hashMap.get(i);
            ans.add(list);
        }

        return ans;
    }

    private String value(String s){
        int[] ans = new int[26];
        char[] chars = s.toCharArray();
        for (char c:chars){
            ans[c-'a']++;
        }
        return Arrays.toString(ans);
    }
}
