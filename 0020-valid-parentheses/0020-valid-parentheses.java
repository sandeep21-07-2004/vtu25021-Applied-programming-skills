class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // push opening brackets
            } else {
                if (stack.isEmpty()) return false; // no opening bracket available
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // mismatch
                }
            }
        }
        
        return stack.isEmpty(); // valid if nothing is left
    

    

       
    }
}