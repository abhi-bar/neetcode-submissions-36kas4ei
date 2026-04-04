class Solution {
    private Map<Character, Set<Character>> adj = new HashMap<>();
    private Map<Character, Boolean> visited = new HashMap<>();
    private List<Character> result = new ArrayList<>();

    public String foreignDictionary(String[] words) {

        for(String word: words){
            for(char ch: word.toCharArray()){
                adj.put(ch, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minL = Math.min(w1.length(), w2.length());

            if(w1.length()>w2.length() && w1.substring(0,minL).equals(w2.substring(0,minL))){
//                this case is logically not possible
                return "";
            }
            for (int j = 0; j < minL; j++) {
                if(w1.charAt(j)!=w2.charAt(j)){
                    char a = w1.charAt(j);
                    char b = w2.charAt(j);
                    adj.get(a).add(b);
                    break;
                }
            }
        }

        for(char ch: adj.keySet()){
            if(dfs(ch)){
//                cycle exist
                return "";
            }
        }

        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for(char ch: result){
            sb.append(ch);
        }
        return sb.toString();
    }

    private boolean dfs(char ch){
        if(visited.containsKey(ch)){
            return visited.get(ch);
        }

        visited.put(ch, true);
        for(char next: adj.get(ch)){
            if(dfs(next)){
                return true;
            }
        }
        visited.put(ch,false);
        result.add(ch);
        return false;
    }
}
