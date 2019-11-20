package com.v.amazon.VO;

import java.util.Random;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2019-11-19 03:11
 * @leetcode :  https://leetcode.com/problems/shuffle-an-array/
 * @timeComplexity : On
 * @spaceComplexity : On
 */
public class ShuffleAnArray {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleAnArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
