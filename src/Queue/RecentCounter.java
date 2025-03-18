package Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Logic Summary:
 * - Implements a request counter with a sliding window of 3000 milliseconds.
 * - Uses a deque to store timestamps efficiently.
 * - Adds new requests and removes outdated ones to maintain the window.
 * - Returns the count of valid requests in O(1) time.
 * <p>
 * Time Complexity: O(1) per request (Each request is added and removed once).
 * Space Complexity: O(N) (Stores requests within the last 3000 ms).
 */
class RecentCounter
{
    // Deque to store the request timestamps
    Deque<Integer> dequeue;

    public RecentCounter()
    {
        dequeue = new LinkedList<>();
    }

    /**
     * Adds a request at timestamp t and returns the number of requests in the last 3000 ms.
     *
     * @param obj The RecentCounter object.
     * @param t   The timestamp of the request.
     * @return Number of requests in the last 3000 ms.
     */
    public static int ping(RecentCounter obj, int t)
    {
        // Add the new request timestamp to the deque
        obj.dequeue.offerLast(t);

        // Remove timestamps older than t - 3000
        while (!obj.dequeue.isEmpty() && obj.dequeue.peekFirst() < t - 3000)
        {
            obj.dequeue.removeFirst();
        }

        // Return the number of valid requests in the time window
        return obj.dequeue.size();
    }
}

/**
 * Usage:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = RecentCounter.ping(obj, t);
 */
