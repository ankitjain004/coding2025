package LeetCode75.ArraysORStrings;

import java.util.Arrays;
/*
Approach 1: left and right array
Appproach 2: Just left array and then traverse from right and
Step2: keep the right product in a variable to use constant space
Understandably so, the output array does not count towards the space complexity.
 */
public class ProductOfArrayElementsExceptSelf
{
    public static void main(String[] args)
    {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums)
    {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = nums[0];

        for (int i = 1; i < answer.length; i++)
        {
            answer[i] = nums[i] * answer[i - 1];
        }

        int R = nums[len - 1];

        answer[len - 1] = answer[len - 2];

        for (int i = len - 2; i >= 1; i--)
        {
            answer[i] = answer[i - 1] * R;
            R = R * nums[i];
        }
        answer[0] = R;

        return answer;


    }


    public static int[] productExceptSelf1(int[] nums)
    {

        int len = nums.length;
        int[] pre = new int[len];
        int[] suff = new int[len];
        for (int i = 0; i < pre.length; i++)
        {
            if (i != 0)
            {
                pre[i] = nums[i] * pre[i - 1];
            } else
            {
                pre[i] = nums[i];
            }

        }

        for (int i = len - 1; i >= 0; i--)
        {
            if (i != len - 1)
            {
                suff[i] = nums[i] * suff[i + 1];
            } else
            {
                suff[i] = nums[i];
            }
        }

        int[] prod = new int[len];

        for (int i = 0; i < prod.length; i++)
        {
            if (i == 0)
            {
                prod[i] = suff[i + 1];
            } else if (i == len - 1)
            {
                prod[i] = pre[i - 1];
            } else
            {
                prod[i] = pre[i - 1] * suff[i + 1];
            }

        }

        return prod;

    }
}
