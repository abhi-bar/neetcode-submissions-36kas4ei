class Solution {
    List<List<String>> lists = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(0, s, new ArrayList<>());
//        System.out.println(list);
        return lists;
    }


    private void backtracking(int start, String s, List<String> list){
        if(start==s.length()){
            System.out.println(list);
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            System.out.println("substrings are "+ s.substring(start,i));

            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                backtracking(i+1, s, list);
                list.remove(list.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
