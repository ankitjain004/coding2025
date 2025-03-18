package stack;

import java.util.Stack;

public class RemoveStarFromString
{
    public String removeStars(String s)
    {
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            stk.push(s.charAt(i));
        }
        final Character STAR = '*';
        int validStars = 0;

        StringBuilder processedString = new StringBuilder();
        while (!stk.isEmpty())
        {
            Character current = stk.pop();
            if(current.equals(STAR))
            {
                validStars++;
            }
            else if(validStars >0)
            {
                validStars--;
            }
            else
            {
                processedString.insert(0, current);
            }
        }

        return processedString.toString();
    }
}
