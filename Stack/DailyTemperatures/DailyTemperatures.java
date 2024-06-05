class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // int [] answer = new int[temperatures.length];
        // for(int i=0;i<temperatures.length-1;i++){
        //     if(temperatures[i]<temperatures[i+1]){
        //         answer[i] = 1;
        //     }
        //     else{
        //         int count =0;
        //         for(int j=i+1;j<temperatures.length;j++){
        //             if(temperatures[j]<=temperatures[i])
        //                 count++;
        //             else{
        //                 answer[i]=count+1;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // answer[temperatures.length-1] = 0;

        // return answer;
          int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stack to keep track of the indices of temperatures

        for (int i = 0; i < n; i++) {
            // Pop indices from stack while current temperature is greater than the temperature at those indices
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // calculate the number of days waited
            }
            stack.push(i); // push current index onto stack
        }

        // Indices remaining in the stack have no warmer future days, so they are already initialized to 0
        return answer;
    }
}
