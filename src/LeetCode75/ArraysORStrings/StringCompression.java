package LeetCode75.ArraysORStrings;

/*
Note: This was an interesting problem because I was missing the last case or last scenario

That I handled after for loop because what was happening was that when I was at index i , I was taking care of all
the characters till i-1 , hence at i=n-1 i was writing off till i-2 and then was exiting which was leading to failure

Also array of length 0 or 1 can be returned as it is.

Approach is to have a readerindex and writerindex. readerindex can be used for iteration and writer can be used for
writing into the char array
 */
public class StringCompression
{
    public static void main(String[] args)
    {
        char[] chars = new char[]{'a', 'b', 'c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars)
    {
        if (chars.length <= 1) return chars.length;
        int writerIndex = 0;
        char currentchar = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++)
        {

            if (chars[i] != currentchar)
            {
                chars[writerIndex] = currentchar;
                writerIndex++;
                if (count > 1)
                {
                    writeCountAsCharacterInPassedArray(count, chars, writerIndex);
                    writerIndex += Integer.toString(count).length();
                }
                count = 1;
                currentchar = chars[i];

            }
            else
            {
                count++;
            }
        }
        chars[writerIndex] = currentchar;
        writerIndex++;
        if (count > 1)
        {
            writeCountAsCharacterInPassedArray(count, chars, writerIndex);
            writerIndex += Integer.toString(count).length();
        }

        return writerIndex;
    }

    private static void writeCountAsCharacterInPassedArray(int count, char[] chars, int writerIndex)
    {
        String countStr = Integer.toString(count);
        for (int i = 0; i < countStr.length(); i++)
        {
            chars[writerIndex++] = countStr.charAt(i);
        }
    }
}
