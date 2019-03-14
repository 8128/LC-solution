/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (27.61%)
 * Total Accepted:    295K
 * Total Submissions: 1.1M
 * Testcase Example:  '2.00000\n10'
 *
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * Example 1:
 * 
 * 
 * Input: 2.00000, 10
 * Output: 1024.00000
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * Note:
 * 
 * 
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * 
 * 
 */
class Solution {
    public double myPow(double x, int i) {
        if(i==1) return x;
        if(i==0) return 1;
        if(i<0){
            if(i==Integer.MIN_VALUE){
                x=1/(x*x);
                int a = i/2;
                i=-a;
            }else{
                x=1/x;
                i=-i;
            }   
        }
        if(i%2==0){
            double temp = myPow(x,i/2);
            return temp*temp;
        } else{
            double temp = myPow(x,(int)i/2);
            return temp*temp*x;
        }
    }
}
