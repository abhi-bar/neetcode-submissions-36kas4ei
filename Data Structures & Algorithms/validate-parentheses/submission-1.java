class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();

        char[] chars = s.toCharArray();
        System.out.println(chars);
        for (char aChar : chars) {
            if(aChar == '[' || aChar=='{' || aChar=='('){
                stack.push(aChar);
            }
            else if (aChar == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            else if (aChar == '}') {
                if (stack.isEmpty() ||stack.pop() != '{') {
                    return false;
                }
            }
            else if (aChar == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
    }
}
