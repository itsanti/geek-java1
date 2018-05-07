package hw1;

/**
 * Homework #1
 *
 * @author Aleksandr Kurov
 * @version dated Май 07, 2018
 */
public class Runner {

    /**
     * task 1
     */
    public static void main(String[] args) {

        // task 1
        System.out.println("task 1: method main is running");

        // task 2
        printTypes();

        // task 3
        if (calcExpr(2, 3, 10, 5) == 10) {
            System.out.println("task 3: test passed. 2 * (3 + 10/5) == 10");
        }

        // task 4
        if (isSumInRange(7, 8)) {
            System.out.println("task 4: test passed. 10 <= (7 + 8) <= 20");
        }

        // task 5
        System.out.print("task 5: ");
        printPosOrNeg(-345);

        // task 6
        if (isNegative(-1)) {
            System.out.println("task 6: test passed. -1 is negative");
        }

        // task 7
        System.out.print("task 7: ");
        sayHello("Александр");

        // task 8
        System.out.println("task 8: check year");
        int[] years = {200, 1600, 1700, 2016, 2017, 2020};
        for (int year : years) {
            System.out.print("  ");
            printIsLeapYear(year);
        }

    }

    /**
     * task 2
     */
    public static void printTypes() {
        byte a = 13;      // -128..127
        short b = -32000; // -32768..32767
        int c = 483647;   // -2147483648..2147483647
        long d = 4_073_709_551_615L; // -18446744073709551616..18446744073709551615
        float e = 2.7f;
        double f = 3.14;
        char g = 'S';
        boolean h = true;

        System.out.printf("task 2: a = %d, b = %d, c = %d, d = %d, e = %f, f = %f, g = %c, h = %b%n", a, b, c, d, e, f, g, h);
    }

    /**
     * task 3:function for {@code a​​ *​​ (b​​ +​​ (c​​ /​​ d))} calculating
     *
     * @param a int
     * @param b int
     * @param c int
     * @param d int
     * @return int
     */
    public static int calcExpr(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    /**
     * task 4: check sum of a and b in range [10, 20]
     *
     * @param a int
     * @param b int
     * @return boolean
     */
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /**
     * task 5: print arg positive or negative
     *
     * @param a int
     */
    public static void printPosOrNeg(int a) {
        if (a >= 0) {
            System.out.printf("argument %d is positive%n", a);
        } else {
            System.out.printf("argument %d is negative%n", a);
        }
    }

    /**
     * task 6: {@code true} if a is negative
     *
     * @param a int
     * @return boolean
     */
    public static boolean isNegative(int a) {
        return a < 0;
    }

    /**
     * task 7: print msg for name
     *
     * @param name String
     */
    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    /**
     * task 8: print is leap year or not in console
     *
     * @param year int
     */
    public static void printIsLeapYear(int year) {
        if (year % 400 == 0) {
            System.out.printf("year %d is leap%n", year);
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.printf("year %d is leap%n", year);
        } else {
            System.out.printf("year %d is NOT leap%n", year);
        }
    }

}
