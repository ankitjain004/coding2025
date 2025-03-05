package TwoPointers;

import java.util.Arrays;

public class MoveZeros
{
    public static void main(String[] args)
    {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums)
    {
        int readerIndex = 0;
        int writerIndex = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
            {
                nums[writerIndex++] = nums[i];
            }
        }
        for (int i = writerIndex; i < nums.length; i++)
        {
            nums[i] = 0;
        }
    }
}
