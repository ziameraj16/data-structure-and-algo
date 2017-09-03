package com.zia;

import java.util.Arrays;

public class Algo {

    public static void main(String[] args) {
        System.out.println(lcm(12, 8));
    }

    // GCD - Eucid algorithm
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }

    }

    // LCM - Eucid algorithm
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a,b);
    }

    /**
     * Min num of platforms required
     - Compare current element in arrival and departure array and pick smaller one among both.
     - If element is pick up from arrival array then increment platform_needed.
     - If element is pick up from departure array then decrement platform_needed.
     - While performing above steps, we need track count of maximum value reached for platform_needed.
     - In the end, we will return maximum value reached for platform_needed.
     */
    private int findPlatformRequiredForStation(int[] arrival, int[] departure, int n) {
        int platformNeeded = 0, maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arrival[i] < departure[j]) {
                platformNeeded++;
                i++;
                if (platformNeeded > maxPlatforms) {
                    maxPlatforms = platformNeeded;
                }
            } else {
                platformNeeded--;
                j++;
            }
        }
        return maxPlatforms;
    }

    private static int[] intersection(int[] a, int[] b) {
        return Arrays.stream(a).filter(x -> Arrays.stream(b).anyMatch(y -> y == x)).toArray();
    }

}
