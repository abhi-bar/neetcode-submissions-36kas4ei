class WordDictionary {

    public static class Trie{
        Trie[] nodes ;
        boolean isEndLetter;

        public Trie(){
            nodes = new Trie[26];
            isEndLetter = false;
        }
    }

    Trie root = new Trie();


    public WordDictionary() {

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

    public boolean search(String word){
        return searchBFS(word, 0, root);
    }

    public boolean searchBFS(String word, int index, Trie node){
        if(node==null){
            return false;
        }
        if(index==word.length()){
            return  node.isEndLetter;
        }

        char c  = word.charAt(index);

        if(c=='.'){
            for(int i=0;i<26;i++){
                if(node.nodes[i]!=null){
                    if(searchBFS(word,index+1,node.nodes[i])){
                        return true;
                    }
                }
            }
            return false;
        }else {
            return searchBFS(word,index+1,node.nodes[c-'a']);
        }
    }
    
}