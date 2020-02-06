package com.zia.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.leftRotate(arr, 2, 7);
        System.out.println(Arrays.toString(arr));
    }

    private void leftRotate(int[] arr, int d, int length) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr, length);
        }
    }

    private void leftRotateByOne(int[] arr, int length) {
        int temp = arr[0], i;
        for (i = 0; i < length - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
    }


}
