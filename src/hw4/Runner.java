package hw4;

/**
 * Homework #4
 *
 * @author Aleksandr Kurov
 * @version dated Май 20, 2018
 */
public class Runner {

    public static void main(String[] args) {

        boolean debug = false;

        if (debug) {
            testCheckCircleWin(testMap5x5,5,4);
            //testCheckCircleWin(testMap,3,3);
            //testCheckNumWin();
        } else {
            new TicTacToe();
        }

    }

    public static int SIZE = 3;
    public static char[][] map = null;
    public static char[][][] testMap = {
        {{'x', 'x', 'x'}, {'.', '.', '.'}, {'.', '.', '.'}},
        {{'.', '.', '.'}, {'x', 'x', 'x'}, {'.', '.', '.'}},
        {{'.', '.', '.'}, {'.', '.', '.'}, {'x', 'x', 'x'}},

        {{'x', '.', '.'}, {'x', '.', '.'}, {'x', '.', '.'}},
        {{'.', 'x', '.'}, {'.', 'x', '.'}, {'.', 'x', '.'}},
        {{'.', '.', 'x'}, {'.', '.', 'x'}, {'.', '.', 'x'}},

        {{'x', '.', '.'}, {'.', 'x', '.'}, {'.', '.', 'x'}},
        {{'.', '.', 'x'}, {'.', 'x', '.'}, {'x', '.', '.'}},
        {{'x', 'x', '.'}, {'.', 'x', '.'}, {'x', '.', 'x'}},

        // false
        {{'x', 'x', '.'}, {'.', 'x', '.'}, {'x', '.', '.'}},
        {{'.', '.', 'x'}, {'.', '.', '.'}, {'.', '.', 'x'}}
    };

    public static char[][][] testMap5x5 = {
        {{'x', 'x', 'x', 'x', '.'},
         {'.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.'}},

        {{'.', '.', '.', '.', '.'},
         {'.', 'x', 'x', 'x', 'x'},
         {'.', 'x', '.', '.', '.'},
         {'.', 'x', '.', '.', '.'},
         {'x', '.', 'x', '.', '.'}},

        {{'x', '.', '.', '.', 'x'},
         {'x', '.', '.', 'x', '.'},
         {'x', '.', 'x', '.', '.'},
         {'.', 'x', '.', '.', '.'},
         {'.', '.', 'x', '.', '.'}},

        {{'.', '.', '.', '.', 'x'},
         {'.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', 'x'},
         {'.', '.', '.', '.', 'x'}},

        {{'.', '.', '.', '.', '.'},
         {'x', 'x', 'x', '.', '.'},
         {'.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.'},
         {'.', '.', '.', '.', '.'}}
    };

    public static boolean checkCircleWin(char dot) {

        boolean isCheckedDiagB, isCheckedDiagS;
        isCheckedDiagB = isCheckedDiagS = true;

        for (int diag = 0; diag < SIZE; diag++) {

            boolean isRow, isCol;
            isRow = isCol = true;

            for (int i = 0; i < SIZE; i++) {
                isRow = (map[diag][i] == dot) && isRow;
                isCol = (map[i][diag] == dot) && isCol;
                if (i == diag) {
                    isCheckedDiagB = (map[diag][diag] == dot) && isCheckedDiagB;
                    isCheckedDiagS = (map[diag][SIZE - 1 - diag] == dot) && isCheckedDiagS;
                }
            }

            if (isRow || isCol) return true;
        }

        if (isCheckedDiagB || isCheckedDiagS) return true;

        return false;
    }

    public static boolean checkCircleWin(char dot, int size, int whenWon) {

        int sumDiagB, sumDiagS;
        sumDiagB = sumDiagS = 0;

        for (int diag = 0; diag < size; diag++) {

            int sumRow, sumCol;
            sumRow = sumCol = 0;

            for (int i = 0; i < size; i++) {
                sumRow += (map[diag][i] == dot) ? 1 : -1;
                sumCol += (map[i][diag] == dot) ? 1 : -1;
                if (i == diag) {
                    sumDiagB += (map[diag][diag] == dot) ? 1 : -1;
                    sumDiagS += (map[diag][size - 1 - diag] == dot) ? 1 : -1;
                }
                if (sumRow >= whenWon || sumCol >= whenWon) return true;
                if (sumRow < 0) sumRow = 0;
                if (sumCol < 0) sumCol = 0;
            }

            if (sumDiagB >= whenWon || sumDiagS >= whenWon) return true;
            if (sumDiagB < 0) sumDiagB = 0;
            if (sumDiagS < 0) sumDiagS = 0;
        }

        return false;
    }

    public static boolean checkMaskWin(char dot) {
        int [] winCond = {448, 56, 7, 292, 146, 73, 273, 84};
        String bin = "";

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) bin += (map[i][j] == dot) ? "1": "0";
        }

        int total = Integer.parseInt(bin, 2);

        for (int i = 0; i < winCond.length; i++) {
            if ((winCond[i] & total) == winCond[i]) return true;
        }

        return false;
    }

    public static void testCheckCircleWin() {
        for (int i = 0; i < testMap.length; i++) {
            map = testMap[i];
            if (checkCircleWin('x')) {
                System.out.println("check is [true]");
            } else {
                System.out.println("check is [false]");
            }

        }
        System.out.println();
    }

    public static void testCheckCircleWin(Object[] data, int size, int whenWon) {
        for (int i = 0; i < data.length; i++) {
            map = (char[][]) data[i];
            if (checkCircleWin('x', size, whenWon)) {
                System.out.println("check is [true]");
            } else {
                System.out.println("check is [false]");
            }

        }
        System.out.println();
    }

    public static void testCheckNumWin() {
        for (int i = 0; i < testMap.length; i++) {
            map = testMap[i];
            if (checkMaskWin('x')) {
                System.out.println("check is [true]");
            } else {
                System.out.println("check is [false]");
            }

        }
        System.out.println();
    }
}
