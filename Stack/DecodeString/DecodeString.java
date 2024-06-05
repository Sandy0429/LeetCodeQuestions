class Solution {
    public String decodeString(String s) {
         Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the multiplier k
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current multiplier and string onto their respective stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset the current multiplier and string
                k = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                // Pop the multiplier and previous string
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                // Repeat the current string and append to the decoded string
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // Append the current character to the current string
                currentString.append(c);
            }
        }

        return currentString.toString();

    }
}
