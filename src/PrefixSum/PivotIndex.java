package PrefixSum;

import java.util.Arrays;
/**
 * This method finds the pivot index in an array where:
 * Sum of elements on the left of the index == Sum of elements on the right.
 * Steps:
 * 1. Compute the total sum of the array.
 * 2. Iterate through the array while maintaining a left sum.
 * 3. For each index 'i', check if leftSum == (totalSum - leftSum - nums[i]).
 * 4. If the condition is met, return 'i' as the pivot index.
 * 5. Otherwise, update leftSum and continue.
 * 6. If no pivot index is found, return -1.
 * Time Complexity: O(N) - One pass to compute totalSum and one pass to find the pivot.
 * Space Complexity: O(1) - Uses only a few integer variables.
 * Example:
 * Input: nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 */
public class PivotIndex
{
    public static void main(String[] args)
    {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));

    }

    public static int pivotIndex(int[] nums) {
        // Step 1: Initialize leftSum to 0
        int leftSum = 0;

        // Step 2: Calculate total sum of the array
        int totalSum = Arrays.stream(nums).reduce(0, Integer::sum);

        // Step 3: Iterate through the array to check for pivot index
        for (int i = 0; i < nums.length; i++) {
            /*
             * Step 4: Check if the current index is a pivot index
             * A pivot index satisfies the condition:
             * 2 * leftSum + nums[i] == totalSum
             */
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;  // Return the first valid pivot index found
            }

            // Step 5: Update leftSum for the next index
            leftSum += nums[i];
        }

        // Step 6: If no pivot index is found, return -1
        return -1;
    }
}
