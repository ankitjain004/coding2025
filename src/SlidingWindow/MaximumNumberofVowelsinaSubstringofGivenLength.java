package SlidingWindow;

public class MaximumNumberofVowelsinaSubstringofGivenLength
{

    public static void main(String[] args)
    {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
    }

    public static int maxVowels(String s, int k)
    {
        int maxVowelCount = 0;
        int len = s.length();
        int currentAnswer = 0;
        int index = 0;
        while (index < len)
        {
            if (index < k)
            {
                if (isVowel(s.charAt(index)))
                {
                    currentAnswer++;
                }
            }

            else
            {
                if (isVowel(s.charAt(index - k)))
                {
                    currentAnswer--;
                }
                if (isVowel(s.charAt(index)))
                {
                    currentAnswer++;
                }

            }
            index++;
            maxVowelCount = Integer.max(maxVowelCount, currentAnswer);

        }

        return maxVowelCount;
    }

    public static boolean isVowel(Character ch)
    {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
        {
            return true;
        }

        return false;
    }

}
