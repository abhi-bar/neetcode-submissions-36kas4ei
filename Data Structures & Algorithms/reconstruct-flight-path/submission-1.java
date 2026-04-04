class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

//        if we want the answers in Lexicographically sorted order we must move in the same order
        HashMap<String,List<String>> hashMap = new HashMap<>();


        for(List<String> l: tickets) {
            if (hashMap.get(l.get(0)) == null) {
                List<String> pq = new ArrayList<>();
                pq.add(l.get(1));
                hashMap.put(l.get(0), pq);
            } else{
                hashMap.get(l.get(0)).add(l.get(1));
            }
        }

        for(List<String> s:hashMap.values()){
            Collections.sort(s);
        }


        ans.add("JFK");
        helper(hashMap, ans, "JFK");
        return ans;
    }
    Boolean found = false;

    private void helper(HashMap<String,List<String>> hashMap, List<String> list, String poll){
        if(found) return;
        boolean x=false;
        for(List<String> pq: hashMap.values()){
            if(!pq.isEmpty()){
                x=true;
                break;
            }
        }
        if(!x){
            ans = new ArrayList<>(list);
            found = true;
            return;
        }

        List<String> strings = hashMap.get(poll);
        if(strings==null || strings.isEmpty()){
            return;
        }

        int pqSize = strings.size();

        for (int j = 0; j < pqSize; j++) {
            String poll1 = strings.getFirst();
            strings.remove(poll1);
            list.add(poll1);
            helper(hashMap,list,poll1);

            list.removeLast();
            strings.addLast(poll1);
        }
    }
}
