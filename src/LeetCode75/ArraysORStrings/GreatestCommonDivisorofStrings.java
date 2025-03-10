package LeetCode75.ArraysORStrings;

import java.math.BigInteger;

public class GreatestCommonDivisorofStrings
{
    public static void main(String[] args)
    {

    }
    public String gcdOfStrings(String str1, String str2)
    {
        if(!str1.concat(str2).equals(str2.concat(str1)))
            return "";

        BigInteger gcd = BigInteger.valueOf(str1.length()).gcd(BigInteger.valueOf(str2.length()));

        return str1.substring(0,gcd.intValue());

    }
}