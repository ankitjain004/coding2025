package Easy;/*
https://leetcode.com/problems/remove-element/description/

There are 2 ways basically to solve the problem

The least optimal approach is to keep shifting the element matching with val in the last
by maintaining 2 pointers start and lastPtr

When the nums[start] matches val start with last and decrement last pointer
when it does not match just increase the start. This runs in a while loop
while(start<lastPtr)

Now you can return the number by checking a boundary case if start is same as val or not

Optimal approach is to just maintain a reader pointer and writer pointer

Reader pointer keeps comparing the current element with val and
writer pointer keeps writing the element when reader is not equal to val

the writer pointer is always at a place wherein none of the elements equal to val
is present before or at its location
*/


public class RemoveElementWithGIvenValueFromArrayInPlace {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        int val = 5;
        int ans = removeElement(nums, val);
        System.out.println(ans);
    }

    public static int removeElement(int[] nums, int val) {

        int size = nums.length;
        if (size == 0) return 0;
        int reader = 0, writer = 0;
        while (reader < size) {
            if (nums[reader] == val) {
                reader++;
            } else {
                nums[writer] = nums[reader];
                writer++;
                reader++;
            }
        }
        return writer;
    }

}

