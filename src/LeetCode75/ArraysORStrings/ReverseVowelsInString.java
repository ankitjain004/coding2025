package LeetCode75.ArraysORStrings;
/*
Strings cant be manipulated in Java So take help from stringbuilder

Create a string-builder of all vowels by traversing the string

then create a copy of original str in new str and add a condition
that whenever a vowel is encountered , append the vowels from vowelextractedstr from end

Code Quality Perspective

You can extract the conditional check for vowels in a method

 */
public class ReverseVowelsInString
{
    public static void main(String[] args)
    {
        String str = "AEIOU";
        System.out.println(reverseVowels(str));
    }

    public static String reverseVowels(String s)
    {
        StringBuilder vowelStr = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < s.length(); i++)
        {
            if (isVowel(s, i)
            )
            {
                vowelStr.append(s.charAt(i));
            }
        }


        StringBuilder reversedString = new StringBuilder();
        int vowelStrLen = vowelStr.length();
        int count = vowelStrLen - 1;
        for (int i = 0; i < len; i++)
        {
            if (isVowel(s, i)
            )
            {
                reversedString.append(vowelStr.charAt(count));
                count--;
            } else
            {
                reversedString.append(s.charAt(i));
            }
        }

        return reversedString.toString();
    }

    private static boolean isVowel(String s, int i)
    {
        return s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
                s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U';
    }
}
