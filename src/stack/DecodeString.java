package stack;

import java.util.Stack;

public class DecodeString
{
    public static void main(String[] args)
    {
        String str = "2[abc]3[cd]ef";
        String str1 = "3[a2[c]]";
        System.out.println(decodeString(str));
        System.out.println(decodeString(str1));
    }

    /*
     * LOGIC:
     * 1. Use a stack to store characters.
     * 2. When encountering a closing bracket ']', extract the encoded substring:
     *    - Pop characters until '[' is found to get the substring.
     *    - Pop digits before '[' to get the repeat count.
     *    - Repeat the extracted substring and push it back onto the stack.
     * 3. If it's not ']', simply push the character onto the stack.
     * 4. Finally, build the decoded string from the stack.
     *
     * TIME COMPLEXITY: O(n) → Each character is processed once.
     * SPACE COMPLEXITY: O(n) → Stack stores characters in worst case.
     */
    /**
     * Decodes an encoded string following the k[encoded_string] pattern.
     * Uses two stacks to store repetition counts and intermediate strings.
     *
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public static String decodeString(String s) {
        Stack<Integer> countStk = new Stack<>();  // Stack to store repetition counts
        Stack<String> stringStack = new Stack<>(); // Stack to store previous substrings
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the repetition count (handle multi-digit numbers)
                count = count * 10 + ch - '0';
            } else if (ch == '[') {
                // Push count and current substring onto stacks
                countStk.push(count);
                stringStack.push(sb.toString());
                // Reset for the new substring inside brackets
                count = 0;
                sb = new StringBuilder();
            } else if (ch == ']') {
                // Pop the count and repeat the substring
                int cnt = countStk.pop();
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < cnt; i++) {
                    str.append(sb.toString());
                }
                // Merge with the previous stored substring
                sb = new StringBuilder().append(stringStack.pop()).append(str);
            } else {
                // Append normal characters
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    //non optimized
    public static String decodeString1(String s)
    {
        Stack<Character> stk = new Stack<>();

        // Iterate through the input string character by character
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == ']')
            {  // Found a closing bracket, process the encoded segment

                // Extract the string inside brackets
                StringBuilder decodedString = new StringBuilder();
                while (stk.peek() != '[')
                {  // Collect characters until opening bracket is found
                    decodedString.append(stk.pop());
                }
                stk.pop();  // Remove the '[' from stack

                // Extract the repeat count (digits before '[')
                int count = 0;
                while (!stk.empty() && Character.isDigit(stk.peek()))
                {
                    count = count * 10 + (stk.pop() - '0');  // Convert multi-digit number
                }

                // Push the extracted substring `count` times back onto the stack
                while (count > 0)
                {
                    for (int j = decodedString.length() - 1; j >= 0; j--)
                    {
                        stk.push(decodedString.charAt(j));  // Push characters back onto stack
                    }
                    count--;
                }
            }
            else
            {
                // Push characters and opening brackets '[' onto stack
                stk.push(s.charAt(i));
            }
        }

        // Build the final decoded string from stack
        StringBuilder answer = new StringBuilder();
        while (!stk.empty())
        {
            answer.append(stk.pop());
        }

        return answer.reverse().toString();  // Reverse as stack stores in reverse order
    }

}
