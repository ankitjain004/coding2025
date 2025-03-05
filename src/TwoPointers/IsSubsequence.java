package TwoPointers;

public class IsSubsequence
{
    public static void main(String[] args)
    {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t)
    {
        if (s.length() > t.length()) return false;
        int readerIndex = 0;
        for (int i = 0; i < t.length() && readerIndex < s.length(); i++)
        {
            if (t.charAt(i) == s.charAt(readerIndex))
            {
                readerIndex++;
            }
        }
        return readerIndex == t.length();

    }
}
