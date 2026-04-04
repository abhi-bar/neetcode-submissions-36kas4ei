class PrefixTree {

    public static class Trie{
        Trie[] nodes ;
        boolean isEndLetter;
        char c;

        public Trie(){
            nodes = new Trie[26];
            isEndLetter = false;
        }
    }

    public PrefixTree() {
         
    }

    Trie root = new Trie(); 


    public void insert(String word) {
        Trie curr = root;
        for(char c : word.toCharArray()){
            if(curr.nodes[c-'a']==null){
//               create
                Trie t = new Trie();
                curr.nodes[c-'a']= t;
            }
            curr = curr.nodes[c-'a'];
        }
        curr.isEndLetter = true;
    }

    public boolean search(String word) {
        Trie curr = root;

        for(char c : word.toCharArray()){
            if(curr.nodes[c-'a']==null){
                return false;
            }
            curr = curr.nodes[c-'a'];
        }
        return curr.isEndLetter;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;

        for(char c : prefix.toCharArray()){
            if(curr.nodes[c-'a']==null){
                return false;
            }
            curr = curr.nodes[c-'a'];
        }
        return true;
    }
}
