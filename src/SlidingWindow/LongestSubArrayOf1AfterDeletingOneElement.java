package SlidingWindow;

public class LongestSubArrayOf1AfterDeletingOneElement
{
    public static void main(String[] args)
    {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(Solution.longestSubarray(nums));
    }

    class Solution {
        public static int longestSubarray(int[] nums) {
            int left = 0, right = 0; // Two pointers for the sliding window
            int flipUsed = 0; // Tracks if we've already flipped one zero
            int maxAnswer = 0; // Stores the maximum length of the valid subarray

            // Iterate through the array with the right pointer
            for (right = 0; right < nums.length; right++) {
                if (nums[right] == 0) {
                    flipUsed++; // A zero is encountered, count it as a "flip"

                    // If more than one zero is encountered, adjust the left pointer
                    while (flipUsed > 1 && left <= right) {
                        if (nums[left] == 0) {
                            flipUsed--; // Move past the first zero
                        }
                        left++; // Shrink the window from the left
                    }

                    // If we have at most one zero in the window, update maxAnswer
                    if (flipUsed <= 1) {
                        maxAnswer = Integer.max(maxAnswer, right - left);
                    }
                } else {
                    // If it's a 1, update maxAnswer considering the current window size
                    maxAnswer = Integer.max(maxAnswer, right - left);
                }
            }

            return maxAnswer;
        }
    }

}
