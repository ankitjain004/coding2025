package Queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Logic Summary:
 * - Implements a voting simulation using a queue.
 * - Uses HashMaps to track active senators and banned votes.
 * - Processes senators in order, banning opponents as needed.
 * - A sentinel (`'*'`) helps determine when one party is eliminated.
 * - Returns the victorious party.
 * <p>
 * Time Complexity: O(N) - Each senator is processed at most twice.
 * Space Complexity: O(N) - Queue and HashMaps store senator states.
 */
class Dota2Senate
{

    public static void main(String[] args)
    {
        System.out.println(predictPartyVictory("RDD"));
    }
    public static String predictPartyVictory(String senate)
    {
        Deque<Character> dq = new LinkedList<>();
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> banned = new HashMap<>();

        // Count the number of senators and enqueue them
        for (Character ch : senate.toCharArray())
        {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
            dq.offerLast(ch);
        }
        dq.offerLast('*'); // Sentinel to check the end of a round

        while (!dq.isEmpty())
        {
            Character ch = dq.pollFirst();

            if (ch == '*')
            { // Sentinel check
                if (count.getOrDefault('R', 0) == 0) return "Dire";
                if (count.getOrDefault('D', 0) == 0) return "Radiant";
                dq.offerLast('*'); // Continue checking in the next round
            }
            else if (banned.getOrDefault(ch, 0) > 0)
            {
                // Remove banned senators
                banned.put(ch, banned.get(ch) - 1);
                count.put(ch, count.get(ch) - 1);
            }
            else
            {
                // Ban the next senator from the opposing party
                if (ch == 'D')
                {
                    banned.put('R', banned.getOrDefault('R', 0) + 1);
                }
                else
                {
                    banned.put('D', banned.getOrDefault('D', 0) + 1);
                }
                dq.offerLast(ch); // Put the senator back in queue
            }
        }
        return "";
    }
}
