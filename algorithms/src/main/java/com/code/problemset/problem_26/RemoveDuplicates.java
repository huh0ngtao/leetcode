package com.code.problemset.problem_26;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);

 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * Constraints:
 * 0 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in ascending order.
 */
public class RemoveDuplicates {

    /**
     * 找到不重复项，则将值赋值给num[i+1]
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
