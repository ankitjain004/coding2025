package stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision
{
    public static void main(String[] args)
    {
        // 1 2 3 4 -5 -2 -3 -4
        int[] asteroids = {10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for (int ast : asteroids) {
            // Process collisions while stack has positive asteroid and new asteroid is negative
            while (!stk.isEmpty() && stk.peek() > 0 && ast < 0) {
                if (Math.abs(ast) > stk.peek()) {
                    // Current asteroid is larger, destroy top of stack and continue checking
                    stk.pop();
                    continue;
                } else if (Math.abs(ast) == stk.peek()) {
                    // Both asteroids destroy each other
                    stk.pop();
                }
                // Current asteroid is destroyed, set to 0 so it's not added
                ast = 0;
            }

            // Push asteroid into stack only if it survived collisions
            if (ast != 0) {
                stk.push(ast);
            }
        }

        // Convert stack to array
        int[] ans = new int[stk.size()];
        for (int i = stk.size() - 1; i >= 0; i--) {
            ans[i] = stk.pop();
        }
        return ans;
    }

    /**
     * Simulates asteroid collisions based on movement directions.
     * Positive values move right, negative move left.
     * <p>
     * Approach:
     * - Use a stack to keep track of surviving asteroids.
     * - If a moving asteroid collides:
     * - Larger asteroid survives.
     * - If equal, both get destroyed.
     * - After processing, convert the stack to an array.
     */
    public static int[] asteroidCollision1(int[] asteroids)
    {
        int len = asteroids.length;
        Stack<Integer> stk = new Stack<>();

        int index = 0; // Index to traverse the asteroid array
        int currVal;

        while (index < len)
        {
            currVal = asteroids[index];

            if (stk.isEmpty())
            {
                stk.push(currVal); // Push if stack is empty
                index++;
            }
            else
            {
                while (!stk.isEmpty())
                {
                    // If both are moving in the same direction, push normally
                    if (stk.peek() > 0 && currVal > 0 || stk.peek() < 0 && currVal < 0)
                    {
                        stk.push(currVal);
                        index++;
                        break;
                    }

                    // Collision scenario: positive asteroid meets a negative asteroid
                    else if (stk.peek() > 0 && currVal < 0)
                    {
                        if (Math.abs(currVal) > stk.peek())
                        {
                            stk.pop(); // Destroy the smaller asteroid and continue checking
                        }
                        else if (Math.abs(currVal) == stk.peek())
                        {
                            stk.pop(); // Both asteroids are destroyed
                            index++;
                            break;
                        }
                        else
                        {
                            index++; // The current asteroid gets destroyed
                            break;
                        }
                    }

                    // Otherwise, push normally
                    else
                    {
                        stk.push(currVal);
                        index++;
                        break;
                    }
                }
            }
        }

        // Convert stack to array for final output
        int stkLen = stk.size();
        if (stk.isEmpty()) return new int[]{};

        int[] ans = new int[stkLen];
        for (int i = stkLen - 1; i >= 0; i--)
        {
            ans[i] = stk.pop();
        }
        return ans;
    }
}
