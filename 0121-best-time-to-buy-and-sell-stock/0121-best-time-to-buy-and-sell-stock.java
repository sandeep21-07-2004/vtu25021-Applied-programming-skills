class Solution {
    public int maxProfit(int[] prices) {
        int minval = prices[0];
        int ans=0;
        for (int i=1;i<prices.length;i++){
            ans=Math.max(ans ,prices[i]-minval);
            minval = Math.min(minval , prices[i]);
        }
        return ans;
    }
}