class Solution {
    public String simplifyPath(String path) {
        String[] splits = path.split("/");

        Stack<String> stack= new Stack<>();
        System.out.println(Arrays.toString(splits));

        for(String split: splits) {
            if (split.isEmpty() || split.equals(".")) {
                continue;
            } 
            else if (split.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {
                stack.push(split);
            }
        }
        
        if(stack.isEmpty()){
            return "/";
        }
        
        StringBuilder s = new StringBuilder();

        while (!stack.isEmpty()){
            s.insert(0, stack.pop()+"/");
        }
        s.insert(0, "/");

        return s.substring(0,s.length()-1);
    }
}