package com.company.mathwork;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-29 19:40
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int num1 = 55, num2 = 121;
        while (num1 != num2) {
            if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        System.out.printf("GCD of given numbers is: %d", num2);
    }
}
