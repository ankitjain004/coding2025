package LeetCode75.ArraysORStrings;

/*
Approach 1: It seems reversing the whole string then reversing each word is an old approach

Approach 2:
Step 1: Just trim the string
  List<String> wordList = Arrays.asList(s.split("\\s+")); // \s is 1 space /s+ is multiple //s+ is escape
        Collections.reverse(wordList);
        return String.join(" ", wordList);

Approach 3: Same as 2 but using lamda

return Arrays.stream(s.trim().split("\\s+"))
             .collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
                 Collections.reverse(lst);
                 return String.join(" ", lst);
             }));

Approach 4: Using Deque -
 Step 1:Remove trailing and leading whitespaces by traversal
 Step2: find word by word and ensure to not take any leading and trailing whitespace and then enter in dequeue
 step 3 then return string.join(" " , d)
 */

public class ReverseWordsInString
{
    public static void main(String[] args)
    {
        System.out.println(reverseWords("a good               example"));
    }

    public static String reverseWords(String s)
    {
        StringBuilder stringBuilder = new StringBuilder(s.trim());
        stringBuilder = stringBuilder.reverse();

        String[] splitStr = stringBuilder.toString().split("\\s+");
        for (int i = 0; i < splitStr.length; i++)
        {
            String trimmedStr = splitStr[i].trim();
            splitStr[i] = reverseIndividualWords(trimmedStr);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < splitStr.length; i++)
        {
            result.append(splitStr[i]);
            if(i!= splitStr.length-1)
            {
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static String reverseIndividualWords(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
