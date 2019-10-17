class Solution {
    public int maxProfit(int[] prices) {
        int hold=Integer.MIN_VALUE, sell=0, rest=0;
        int i=0;
        while(i<prices.length){
            int prev_sell = sell;
            sell = hold+prices[i];
            hold = Math.max(hold,rest-prices[i]);
            rest = Math.max(rest,prev_sell);
            i++;
        }
        return Math.max(sell,rest);
    }
}