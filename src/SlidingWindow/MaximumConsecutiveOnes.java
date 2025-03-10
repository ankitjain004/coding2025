package SlidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumConsecutiveOnes
{
    public static void main(String[] args)
    {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1} ;
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k)
    {
        Queue<Integer> queue = new LinkedList<>();
        int flipUsed = 0;
        int maxLength = 0;
        int currLength = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                if (flipUsed < k)
                {
                    flipUsed++;
                    queue.add(i);
                    maxLength = i + 1;
                    currLength = i + 1;
                }

                else
                {
                    queue.add(i);
                    currLength = i - queue.poll();
                    maxLength = Integer.max(maxLength, currLength); // current index made 1 - (polled index +1) +1
                }
            }

            else
            {
                currLength = currLength + 1;
                maxLength = Integer.max(maxLength, currLength);
            }
        }

        return maxLength;
    }
}
