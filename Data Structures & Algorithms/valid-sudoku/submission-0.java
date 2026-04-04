class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> setCol = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                if(ch!='.'){
                    if(setCol.contains(ch)){
                        return false;
                    }
                    setCol.add(board[j][i]);
                }
            }
        }

//        Row Check
        for (int i = 0; i < 9; i++) {
            HashSet<Character> setCol = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if(ch!='.'){
                    if(setCol.contains(ch)){
                        return false;
                    }
                    setCol.add(ch);
                }
            }
        }

//      Square Check
        
        HashMap<Integer, HashSet<Character>> hashMap = new HashMap<>();
        
        for (int i = 0; i < 9; i++) {
            HashSet<Character> setCol = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int square = (i/3)*3 + (j/3);
                char ch = board[i][j];
                if(ch!='.'){
                    setCol = hashMap.get(square);
                    if(!hashMap.containsKey(square)){
                        HashSet<Character> set =  new HashSet<>();
                        set.add(ch);
                        hashMap.put(square,set);
                        
                    }
                    else if(!setCol.isEmpty() && setCol.contains(ch)){
                        return false;
                    }else{
                        setCol.add(ch);
                        hashMap.put(square,setCol);
                    }
                }
            }
        }
        
        return true;
    }
}
