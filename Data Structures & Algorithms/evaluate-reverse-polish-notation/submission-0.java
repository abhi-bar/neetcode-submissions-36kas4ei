class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        int s = tokens.length-1;
//        for(String a:tokens){
//            stack.push(a);
//        }

        for(String as:tokens){
            if(as.equals("+")|| as.equals("-")||as.equals("*") || as.equals("/")){

                String s1 = as;
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());

                switch (s1) {
                    case "+" -> stack.push(String.valueOf(a + b));
                    case "-" -> stack.push(String.valueOf(b - a));
                    case "*" -> stack.push(String.valueOf(a * b));
                    case "/" -> stack.push(String.valueOf(b / a));
                }
            }
            else {
                stack.push(as);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
