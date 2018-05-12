package hw2;

import utils.ArrUtils;

/**
 * Homework #2
 *
 * @author Aleksandr Kurov
 * @version dated Май 12, 2018
 */
public class Runner {

    public static void main(String[] args) {

        // task 1
        invertArr();

        // task 2
        fillArr();

        // task 3
        changeArr();

        // task 4
        fillDiagonalsArr();

        // task 5
        searchMinMaxArr();

        // task 6


        // task 7

    }

    /**
     * task 1: invert given array - 0 to 1 and 1 to 0
     */
    public static void invertArr() {
        int[] arr = ArrUtils.genArr(10, 0, 1);

        System.out.print("task 1:\n  before - ");
        ArrUtils.printArr(arr);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }

        System.out.print("\n  after  - ");
        ArrUtils.printArr(arr);
        System.out.println();
    }

    /**
     * task 2: fill array with values: {@code 0 3 6 9 12 15 18 21}
     */
    public static void fillArr() {
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }

        System.out.print("task 2: sequence ");
        ArrUtils.printArr(arr);
        System.out.println();
    }

    /**
     * task 3: mul by 2 numbers less than 6
     */
    public static void changeArr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.print("task 3:\n  before - ");
        ArrUtils.printArr(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }

        System.out.print("\n  after  - ");
        ArrUtils.printArr(arr);
        System.out.println();
    }

    /**
     * task 4: fill array diagonals with 1
     */
    public static void fillDiagonalsArr() {
        int[][] arr = ArrUtils.genSquareArr(4);

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }

        System.out.printf("task 4: matrix %dx%d\n", arr.length, arr.length);
        ArrUtils.printArr(arr, true);
        System.out.println();
    }

    /**
     * task 5: search min and max value in array
     */
    public static void searchMinMaxArr() {
        int[] arr = ArrUtils.genArr(10, -30, 50);

        int min, max;
        min = max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        System.out.print("task 5: Min and Max search\n  sequence: ");
        ArrUtils.printArr(arr);
        System.out.printf("\n  Min = %d, Max = %d\n", min, max);
    }

    /**
     * task 6:
     */

    /**
     * task 7:
     */

}
