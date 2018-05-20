package hw4;

import java.util.Random;
import java.util.Scanner;

class TicTacToe {

    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    TicTacToe() {
        initMap();
        while (true) {
            humanTurn();
            if (checkCircleWin(DOT_X, 3,3)) {
                System.out.println("YOU WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            aiTurnImp();
            printMap();
            if (checkMaskWin(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    boolean checkWin(char dot) {
        // check horizontals
        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
        // check verticals
        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;
        // check diagonals
        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;
        return false;
    }

    /**
     * task 2: refactor checkWin method with circle
     *
     * @param dot
     * @return
     */
    boolean checkCircleWin(char dot) {

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

    /**
     * task 2: refactor checkWin method with bit mask
     *
     * @param dot
     * @return
     */
    boolean checkMaskWin(char dot) {
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

    /**
     * task 3: refactor checkWin method with board size
     *
     * @param dot
     * @param size
     * @param whenWon
     * @return
     */
    boolean checkCircleWin(char dot, int size, int whenWon) {

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

    /**
     * task 4: improved ai
     */
    void aiTurnImp() {
        int turn[];
        do {
            turn = searchAiPlace();
            if (turn[0] == -1) {
                turn = new int[]{rand.nextInt(SIZE), rand.nextInt(SIZE)};
            }
        } while (!isCellValid(turn[1], turn[0]));
        map[turn[0]][turn[1]] = DOT_O;
    }

    int [] searchAiPlace() {

        int[] place = new int[]{-1, -1};
        int sumR, sumC;

        for (int i = 0; i < SIZE; i++) {
            sumR = sumC =0;
            for (int j = 0; j < SIZE; j++) {
                sumR += (map[i][j] == DOT_X) ? 1 : (map[i][j] == DOT_EMPTY) ? 0 : -1;
                sumC += (map[j][i] == DOT_X) ? 1 : (map[j][i] == DOT_EMPTY) ? 0 : -1;
            }
            if (SIZE - 1 == Math.abs(sumR)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) place = new int[]{i, j};
                }
                if (1 - SIZE == sumR) return place;
            }
            if (SIZE - 1 == Math.abs(sumC)) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] == DOT_EMPTY) place = new int[]{j, i};
                }
                if (1 - SIZE == sumC) return place;
            }
        }

        int sumDiagB, sumDiagS;
        sumDiagB = sumDiagS = 0;
        for (int i = 0; i < SIZE; i++) {
            sumDiagB += (map[i][i] == DOT_X) ? 1 : (map[i][i] == DOT_EMPTY) ? 0 : -1;
            sumDiagS += (map[i][SIZE - 1 - i] == DOT_X) ? 1 : (map[i][SIZE - 1 - i] == DOT_EMPTY) ? 0 : -1;
        }
        if (1 - SIZE == sumDiagB) {
            for (int i = 0; i < SIZE; i++) {
                     if (map[i][i] == DOT_EMPTY) return new int[]{i, i};
            }
        }
        if (1 - SIZE == sumDiagS) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][SIZE - 1 - i] == DOT_EMPTY) return new int[]{i, SIZE - 1 - i};
            }
        }
        if (SIZE - 1 == sumDiagB) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][i] == DOT_EMPTY) place = new int[]{i, i};
            }
        }
        if (SIZE - 1 == sumDiagS) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][SIZE - 1 - i] == DOT_EMPTY) place = new int[]{i, SIZE - 1 - i};
            }
        }

        return place;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }
}