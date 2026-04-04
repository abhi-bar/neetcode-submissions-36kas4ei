class Solution {
    public boolean checkValidString(String s){

        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        int i=0;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                left.add(i);
            } else if (ch=='*') {
                star.add(i);
            } else {
                if(left.isEmpty() && star.isEmpty()){
                    return false;
                }
                if(!left.isEmpty()){
//                    initially considering * as empty string
                    left.pop();
                }else {
                    star.pop();
                }
            }
            i++;
        }

        while(!left.isEmpty() && !star.isEmpty()){
            if(left.pop()>star.pop()){
                return false;
            }
        }

        return left.isEmpty();
    }
}
