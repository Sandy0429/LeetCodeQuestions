class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> toRemove = new HashSet<>();

        // First pass: identify indices of parentheses to remove
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    toRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // Add remaining unmatched opening parentheses to the removal set
        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }

        // Build the resulting string excluding the indices in the removal set
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
       
   }
}
