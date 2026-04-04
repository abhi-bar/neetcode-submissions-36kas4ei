class Solution {
    public String minWindow(String s, String t) {
//        create a minHashMap
//        make a sliding window once condition satisfies then reduce from left

//        s = fullString
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> hashMapCollect = new HashMap<>();

        for (char c:t.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }


        int i =0;
        int j =0;

        int length  = Integer.MAX_VALUE;
        String sample = "";

        while(i<=j){

            if(check(hashMap, hashMapCollect)){
                if(length>j-i){
                    length=j-i;
                    sample= s.substring(i,j);
                }
                char remove = s.charAt(i);
                hashMapCollect.put(remove, hashMapCollect.get(remove)-1);
                i++;
            }else {
                if(j==s.length()) break;
                char c = s.charAt(j);
                hashMapCollect.put(c, hashMapCollect.getOrDefault(c,0)+1);
                j++;
            }
        }

//        System.out.println(s.length());
//        System.out.println(j+"+"+i);
//
//        System.out.println(sample);
        return sample;

    }

    private boolean check(HashMap<Character,Integer> hashMapFull, HashMap<Character,Integer> hashMapToCheck){
        if(hashMapFull.size()>hashMapToCheck.size()) return false;

        for (Character c : hashMapFull.keySet()) {
            if (!hashMapToCheck.containsKey(c)) {
                return false;
            }
            if (hashMapToCheck.get(c) < hashMapFull.get(c)) {
                return false;
            }
        }

        return true;
    }
}
