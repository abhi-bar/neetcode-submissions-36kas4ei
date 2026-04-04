class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char c: s.toCharArray()){
            hashMap.put(c, hashMap.getOrDefault(c,0)+1);
        }

        List<Integer> ans = new ArrayList<>();
//        char[] charArr = ;

        List<Character> queue = new ArrayList<>();
        int i =0;
        queue.add(s.charAt(i));

        while (!hashMap.isEmpty()) {
            int length = 0;

            while (!queue.isEmpty() && i<s.length()) {
                if (!queue.contains(s.charAt(i))) {
                    queue.add(s.charAt(i));
                }
                Character peek = s.charAt(i);

                hashMap.put(peek, hashMap.get(peek) - 1);

                if (hashMap.get(peek) == 0) {
                    hashMap.remove(peek);
                    queue.remove(peek);
                }
                i++;
                length++;
            }
            ans.add(length);

            if(i==s.length()){
                break;
            }
            queue.add(s.charAt(i));
        }

        return ans;
    }
}
