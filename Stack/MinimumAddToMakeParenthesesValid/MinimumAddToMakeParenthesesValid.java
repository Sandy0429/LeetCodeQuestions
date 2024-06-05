class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count=0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == ')'){
                if(stack.size()!= 0 &&stack.peek() == '('){
                    stack.pop();
                }
                else count++;
            }
            else {
               stack.push(ch);
            }
        }

        if(stack.size() != 0){
            return count+stack.size();
        }

        return count;
    }
}
