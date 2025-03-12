package PrefixSum;

public class HighestAttitude
{
    public static void main(String[] args)
    {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain)
    {
        int maxAttitude = 0;
        int currAttitude = 0;
        for (int i = 0; i < gain.length; i++)
        {
            currAttitude = currAttitude + gain[i];
            maxAttitude = Integer.max(maxAttitude, currAttitude);
        }

        return maxAttitude;
    }
}
