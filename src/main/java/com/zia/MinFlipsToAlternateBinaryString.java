package com.zia;

public class MinFlipsToAlternateBinaryString {

    public static void main(String[] args) {
        String str = "0001010111";
        System.out.println(minFlipToMakeStringAlternate(str));
    }

    private static int minFlipToMakeStringAlternate(String str) {
        return Math.min(getFlipWithStartingCharcter(str, '0'), getFlipWithStartingCharcter(str, '0'));
    }

    private static int getFlipWithStartingCharcter(String str, char expected) {
        int flipcount = 0;
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) != expected) {
                flipcount++;
            }
            expected = flip(expected);
        }
        return flipcount;
    }

    private static char flip(char c) {
        return c == '0' ? '1' : '0';
    }
}
