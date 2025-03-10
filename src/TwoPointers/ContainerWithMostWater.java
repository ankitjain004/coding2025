package TwoPointers;
/*

Moving the pointer at the larger height does not increase the area,
as the limiting factor is always the smaller height. Additionally,
since the width is decreasing, the new area will either remain the same
or decrease further, especially if a smaller height is encountered.

The optimal approach is to move the pointer at the smaller height,
as this maximizes the chance of finding a taller height while sacrificing
only minimal width.
*/

public class ContainerWithMostWater
{
    public static void main(String[] args)
    {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height)
    {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        int currArea;
        while (start < end)
        {
            currArea = (end - start) * Integer.min(height[start], height[end]);
            maxArea = Integer.max(currArea, maxArea);

            if (height[start] < height[end])
            {
                start++;
            }
            else
            {
                end--;
            }
        }
        return maxArea;
    }
}
