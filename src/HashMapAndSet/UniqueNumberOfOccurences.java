package HashMapAndSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class UniqueNumberOfOccurences
{
    public static void main(String[] args)
    {

    }

    public boolean uniqueOccurrences(int[] arr)
    {
        HashMap<Integer, Integer> valueCountHashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for(int num: arr)
        {
            valueCountHashMap.put(num, valueCountHashMap.getOrDefault(num, 0)+1);
        }

        for(int count : valueCountHashMap.values())
        {
            hashSet.add(count);
        }
        int count = 0;

        for(Integer currentrval : hashSet)
        {
            count = count + currentrval;
        }
        return count == arr.length;
    }
}
