import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); // copy original prices
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            // find next smaller or equal price
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }

        return result;
    }
}