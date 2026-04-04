class Solution {
    private static final Map<Character, String> phoneMap = Map.of(
            
            '2', "abc", '3', "def",
            '4', "ghi", '5', "jkl", '6', "mno",
            '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0) return result;
        backtracking(digits, new StringBuilder(), 0, result);
//        System.out.println(result);
        return result;
    }

    List<String> globalList = new ArrayList<>();
    private void backtracking(String digits, StringBuilder list, int index, List<String> re
    ){
        if(list.length()==digits.length()){
//            System.out.println(list);
            re.add(String.valueOf(list));
            return;
        }

        String integer = phoneMap.get(digits.charAt(index));
        for(char ch: integer.toCharArray()){
            list.append(ch);
            backtracking(digits, list, index+1,re);
            list.deleteCharAt(list.length()-1);
        }
    }

    
}
