package HashMapAndSet;

import java.util.*;

public class DetermineIfTwoStringsAreClose
{
    public static void main(String[] args)
    {
        System.out.println(closeStrings("uau", "ssx"));
    }

    /**
     * Determines if two words are "close" based on:
     * 1. Having the same set of unique characters.
     * 2. The ability to rearrange character frequencies to match.
     * <p>
     * Approach:
     * - Use HashMaps to count character occurrences.
     * - Compare unique character sets using HashSet.
     * - Compare sorted frequency values to determine rearrangeability.
     */
    public static boolean closeStrings(String word1, String word2)
    {
        // If the lengths are different, they cannot be close
        if (word1.length() != word2.length()) return false;

        HashMap<Character, Integer> word1CountMap = new HashMap<>();
        HashMap<Character, Integer> word2CountMap = new HashMap<>();

        // Count the frequency of characters in both words
        for (int i = 0; i < word1.length(); i++)
        {
            word1CountMap.put(word1.charAt(i), word1CountMap.getOrDefault(word1.charAt(i), 0) + 1);
            word2CountMap.put(word2.charAt(i), word2CountMap.getOrDefault(word2.charAt(i), 0) + 1);
        }

        // Convert keys (unique characters) into sets for comparison
        HashSet<Character> keys1 = new HashSet<>(word1CountMap.keySet());
        HashSet<Character> keys2 = new HashSet<>(word2CountMap.keySet());

        // If the unique characters don't match, return false
        if (!keys1.equals(keys2)) return false;

        // Convert frequency values into lists and sort them
        List<Integer> list1Value = new ArrayList<>(word1CountMap.values());
        List<Integer> list2Value = new ArrayList<>(word2CountMap.values());
        Collections.sort(list1Value);
        Collections.sort(list2Value);

        // Return true if sorted frequency lists match
        return list1Value.equals(list2Value);
    }
}
