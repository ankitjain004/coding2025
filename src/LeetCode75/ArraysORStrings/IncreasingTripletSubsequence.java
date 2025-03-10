package LeetCode75.ArraysORStrings;

import java.util.Arrays;

public class IncreasingTripletSubsequence
{
    public static void main(String[] args)
    {
        int[] nums = {1,1,1};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums)
    {
        if (nums.length < 3) return false;

        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i]<=first_num)
            {
                first_num = nums[i];
            }
            else if(nums[i]<=second_num)
            {
                second_num = nums[i];
            }
            else if(nums[i]>second_num)
            {
                return true;
            }
        }
        return false;
    }
}
