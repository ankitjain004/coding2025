package HashMapAndSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPair
{
    /**
     * Counts the number of equal row-column pairs in a grid.
     *
     * Approach:
     * - Store all row representations in a HashMap with their frequencies.
     * - Iterate through columns, convert them into string form, and check if they match any row.
     */
    public int equalPairs(int[][] grid) {
        if (grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        Map<String, Integer> rowHashMap = new HashMap<>();

        // Iterate over rows and store their string representations in the HashMap
        for (int i = 0; i < row; i++) {
            String currentRow = Arrays.toString(grid[i]);
            rowHashMap.put(currentRow, rowHashMap.getOrDefault(currentRow, 0) + 1);
        }

        int answer = 0;
        int[] tempCol = new int[row]; // Temporary array to store column values

        // Iterate over columns to check for matches in the HashMap
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                tempCol[j] = grid[j][i]; // Extract column values
            }

            // Check if this column representation exists in rowHashMap
            answer += rowHashMap.getOrDefault(Arrays.toString(tempCol), 0);
        }

        return answer;
    }

    public static void main(String[] args)
    {

    }
}
