package HashMapAndSet;

import java.util.*;

public class DifferentOfTwoArrays
{
    public static void main(String[] args)
    {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2)
    {
        List<List<Integer>> answer = new LinkedList<>();
        answer.add(findingElementsFromFirstListNotInSecondList(nums1, nums2));
        answer.add(findingElementsFromFirstListNotInSecondList(nums2, nums1));
        return answer;
    }

    public List<Integer> findingElementsFromFirstListNotInSecondList(int[] nums1, int[] nums2)
    {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums2)
        {
            hashSet.add(num);
        }

        HashSet<Integer> uniqueElementsFromFirstList = new HashSet<>();

        for (int i = 0; i < nums1.length; i++)
        {
            if (!hashSet.contains(nums1[i]))
            {
                uniqueElementsFromFirstList.add(nums1[i]);
            }
        }

        return new ArrayList<>(uniqueElementsFromFirstList);

    }
}
