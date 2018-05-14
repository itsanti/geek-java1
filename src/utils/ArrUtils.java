package utils;

import java.util.Arrays;

/**
 * Array utilities for homework
 *
 * @author Aleksandr Kurov
 * @version dated Май 12, 2018
 */
public class ArrUtils {

    /**
     * Generate array given length with random numbers in [min, max]
     *
     * @param length of array
     * @param min lower bound of numbers in array
     * @param max upper bound of numbers in array
     * @return array
     */
    public static int[] genArr(int length, int min, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }

    /**
     * Generate square array given length
     *
     * @param length of array
     * @return array[][]
     */
    public static int[][] genSquareArr(int length) {
        return new int[length][length];
    }

    /**
     * Print one dimensional array
     *
     * @param arr one dimensional array
     */
    public static void printArr(int[] arr) {
        System.out.print(Arrays.toString(arr));
    }

    /**
     * Print one dimensional array
     *
     * @param arr one dimensional array
     * @param padding from left side
     */
    public static void printArr(int[] arr, String padding) {
        System.out.print(padding + Arrays.toString(arr));
    }

    /**
     * Print two dimensional array as line or matrix
     *
     * @param arr two dimensional array
     * @param isMatrix print mode line or table
     * @param padding from left side
     */
    public static void printArr(int[][] arr, boolean isMatrix, String padding) {
        if (isMatrix) {
            for (int i = 0; i < arr.length - 1; i++) {
                printArr(arr[i], padding);
                System.out.println();
            }
            printArr(arr[arr.length - 1], padding);
        } else {
            System.out.print(Arrays.deepToString(arr));
        }
    }

    /**
     * Search min and max value in array
     */
    public static int[] searchMinMaxArr(int[] arr) {

        int min, max;
        min = max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        return arr;
    }

    /**
     * Check if array is balanced
     *
     * @param arr of integers
     * @return boolean balanced or not
     */
    public static boolean checkBalance(int[] arr) {

        if (arr.length < 2) return false;

        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];

        if (sum % 2 == 0) {

            int leftSum = 0;
            sum /= 2;

            for (int i = 0; i < arr.length - 1; i++) {
                leftSum += arr[i];
                if (leftSum == sum) {
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * Rotate array elements by n positions
     *
     * @param arr initial array
     * @param n positive and negative offset
     * @return rotated array
     */
    public static int[] rotateArr(int[] arr, int n) {

        n %= arr.length;

        if (n == 0 || arr.length == 1) return arr;

        if (n < 0) n += arr.length;

        for (int it = 0; it < n; it++) {

            int before = arr[arr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                int current = arr[i];
                arr[i] = before;
                before = current;
            }

        }

        return arr;
    }

}
