package SlidingWindow;

public class MaximumAverageSubarray
{

    public static void main(String[] args)
    {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k)
    {
        double maxTillNow = Integer.MIN_VALUE;
        double currSum = 0;
        if (nums.length < k) return 0;

        for (int i = 0; i < nums.length; i++)
        {
            currSum = currSum + nums[i];
            if (i >= k - 1)
            {
                maxTillNow = Double.max(currSum, maxTillNow);
                currSum = currSum - nums[i - (k - 1)];
            }
        }

        return maxTillNow/k;

    }
}
