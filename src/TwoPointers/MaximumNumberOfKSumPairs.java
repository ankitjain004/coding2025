package TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfKSumPairs
{
    public static void main(String[] args)
    {
        int[] nums = {3, 1, 3, 4, 3};
        System.out.println(maxOperations(nums, 5));
    }

    public static int maxOperations(int[] nums, int k)
    {
        Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        for (int num : nums)
        {
            if (mp.getOrDefault(k - num, 0)>0)
            {
                mp.put(k - num, mp.get(k - num) - 1);
                cnt++;
            }
            else
            {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }
        }

        return cnt;

    }

}
