package Easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {


    public static void main(String[] args) {
        int[] candies = {1, 2, 3, 4, 5};
        int extraCandies = 5;

        List<Boolean> list = kidsWithCandies(candies, extraCandies);
        System.out.println(list);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
