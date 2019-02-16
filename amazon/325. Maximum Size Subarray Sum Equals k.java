class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // sum right now
            sum = sum + nums[i];
            // if the sum is k itself then set the max to i+1( the largest length that have reached)
            if (sum == k) max = i + 1;
            // if there is a key contained so remove that key can reach the sum, set max to max value reached minus key position
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            // if there is no that sum key, put in sum and position
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
        //it's like a ruler, right side and left side for a substring
    }
}