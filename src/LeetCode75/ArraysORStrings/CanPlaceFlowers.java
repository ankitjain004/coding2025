package LeetCode75.ArraysORStrings;
/*
Approach simple

Just check if left and right is empty and then assign flowerbed = 1
only thing is check if i==0 and i==n-1 then no need to check previous for i=0 and next for i=n-1

 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean ans = canPlaceFlowers(flowerbed, n);
        System.out.println(ans);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++)
        {
            if (flowerbed[i] == 0)
            {
                boolean isLeftEmpty = i == 0 || flowerbed[i - 1] == 0;
                boolean isRightEmpty = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if (isLeftEmpty && isRightEmpty)
                {
                    flowerbed[i] = 1;
                    count++;
                    if (count == n) return true;
                }

            }
        }

        return false;

    }
}
