class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(beginWord.equals(endWord) || !wordList.contains(endWord)){
            return 0;
        }

        int n = wordList.size();
        int m = wordList.get(0).length();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(wordList.get(i),i);
        }

//        Computing Graph
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    if(wordList.get(i).charAt(k)!=wordList.get(j).charAt(k)){
                        cnt++;
                    }
                }
                if(cnt==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for(char c='a';c<='z';c++){
                if(c==beginWord.charAt(i)){
                    continue;
                }
                String word = beginWord.substring(0,i)+c+beginWord.substring(i+1);
                if(map.containsKey(word) && !visited.contains(map.get(word))){
                    visited.add(map.get(word));
                    queue.add(map.get(word));
                }
            }
        }


        int res = 1;
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if(wordList.get(node).equals(endWord)){
                    return res;
                }
                for(int nei: graph.get(node)){
                    if(!visited.contains(nei)){
                        visited.add(nei);
                        queue.add(nei);
                    }
                }
            }
        }
        
        return 0;
    }
}
