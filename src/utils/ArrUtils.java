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
     * Print two dimensional array as line or matrix
     *
     * @param arr two dimensional array
     * @param isMatrix print mode
     */
    public static void printArr(int[][] arr, boolean isMatrix) {
        if (isMatrix) {
            for (int i = 0; i < arr.length - 1; i++) {
                printArr(arr[i]);
                System.out.println();
            }
            printArr(arr[arr.length - 1]);
        } else {
            System.out.print(Arrays.deepToString(arr));
        }
    }

}
