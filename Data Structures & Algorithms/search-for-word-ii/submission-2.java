class Solution {
    public static class Trie{
        Trie[] nodes ;
        boolean isEndLetter;

        public Trie(){
            nodes = new Trie[26];
            isEndLetter = false;
        }
    }

    Trie root = new Trie();

    public List<String> findWords(char[][] board, String[] words) {

//        add all in the Trie
        for(String s: words){
            addWord(s);
        }


        //        check if words can be formed that are present in the Trie
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                listWords(board, i, j, "", new boolean[board.length][board[0].length], root);
            }
        }

        return new ArrayList<>(stringSet);
    }

    Set<String> stringSet = new HashSet<>();

    private void listWords(char[][] board, int i, int j, String s, boolean[][] visited, Trie curr){
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || visited[i][j]){
            return;
        }

        char c = board[i][j];
        if(curr.nodes[c-'a']==null){
            return;
        }
        curr = curr.nodes[c-'a'];

        s = s + board[i][j];
        visited[i][j] = true;

        if(curr.isEndLetter){
            stringSet.add(s);
        }

        listWords(board, i+1, j, s, visited,curr);
        listWords(board, i-1, j, s, visited,curr);
        listWords(board, i, j+1, s, visited, curr);
        listWords(board, i, j-1, s, visited, curr);


        s = s.substring(0, s.length()-1);
        visited[i][j] = false;
    }


    public void addWord(String word) {
        Trie curr = root;

        for(char c : word.toCharArray()){
            if(curr.nodes[c-'a']==null){
//               create
                curr.nodes[c-'a']= new Trie();
            }
            curr = curr.nodes[c-'a'];
        }
        curr.isEndLetter = true;
    }
}
