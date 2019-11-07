package com.v.bloomberg.coding;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-11-06 16:58
 * @leetcode : https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {

    // 1

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int rotate = find_rotate_index(0, len - 1, nums);

        // if target is the smallest element
        if (nums[rotate] == target) {
            return rotate;
        }
        // if array is not rotated, search in the entire array
        if (rotate == 0) {
            return search(0, len - 1, nums, target);
        }
        if (target < nums[0])
            // search in the right side
        {
            return search(rotate, len - 1, nums, target);
        }
        // search in the left side
        return search(0, rotate, nums, target);
    }

    public int find_rotate_index(int left, int right, int[] nums) {
        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right, int[] nums, int target) {
    /*
    Binary search
    */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }



    // 2
    public int search3(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }

}
