package LeetCode75;
/*
Approach 1 : One pointer on both and then once the shorter ends run another loop

Approach 2 , same time complexity but if you want to write less code just follow this

run for loop till max (length of both string )
and check if current index is less than length of str1 -> add
same check for str2

Keep doing till max(m,n)


 */
public class MergeStringsAlternately {
    public static void main(String[] args) {
        String str = mergeAlternately("1357", "2468");
        System.out.println(str);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int len1 = word1.length();
        int len2 = word2.length();

        for (int i = 0; i < Math.max(len1, len2); i++) {
            if (i < len1) {
                sb.append(word1.charAt(i));
            }

            if (i < len2) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }


    public static String mergeAlternately1(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);


        int len1 = word1.length();
        int len2 = word2.length();
        int firstPtr = 0, secondPtr = 0;
        while (firstPtr < len1 && secondPtr < len2) {
            mergedString.append(sb1.charAt(firstPtr));
            firstPtr++;
            mergedString.append(sb2.charAt(secondPtr));
            secondPtr++;

        }

        while (firstPtr < len1) {
            mergedString.append(sb1.charAt(firstPtr));
            firstPtr++;
        }

        while (secondPtr < len2) {
            mergedString.append(sb2.charAt(secondPtr));
            secondPtr++;
        }

        return mergedString.toString();
    }
}
