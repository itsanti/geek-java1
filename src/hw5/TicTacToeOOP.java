package hw5;
import java.util.Random;
import java.util.Scanner;

class TicTacToeOOP {

    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';

    GameLogic gl = new GameLogic(new Map(3));
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    class Map {
        private char[][] map;
        private int SIZE;

        Map(int size) {
            SIZE = size;
            map = new char[SIZE][SIZE];
        }

        public char[][] getMap() {
            return map;
        }

        public int getSIZE() {
            return SIZE;
        }

        void init() {
            for (int i = 0; i < SIZE; i++)
                for (int j = 0; j < SIZE; j++)
                    map[i][j] = DOT_EMPTY;
        }

        void print() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    System.out.print(map[i][j] + " ");
                System.out.println();
            }
            System.out.println();
        }

        boolean isFull() {
            for (int i = 0; i < SIZE; i++)
                for (int j = 0; j < SIZE; j++)
                    if (map[i][j] == DOT_EMPTY)
                        return false;
            return true;
        }
    }

    class GameLogic {

        private Map map;

        GameLogic(Map map) {
            this.map = map;
        }

        void play() {
            map.init();
            while (true) {
                humanTurn();
                if (checkWin(DOT_X)) {
                    System.out.println("YOU WON!");
                    break;
                }
                if (map.isFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
                aiTurn();
                map.print();
                if (checkWin(DOT_O)) {
                    System.out.println("AI WON!");
                    break;
                }
                if (map.isFull()) {
                    System.out.println("Sorry, DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER.");
            map.print();
        }

        void humanTurn() {
            int x, y;
            do {
                System.out.println("Enter X and Y (1..3):");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(x, y));
            map.getMap()[y][x] = DOT_X;
        }

        void aiTurn() {
            int x, y;
            do {
                x = rand.nextInt(map.getSIZE());
                y = rand.nextInt(map.getSIZE());
            } while (!isCellValid(x, y));
            map.getMap()[y][x] = DOT_O;
        }

        boolean checkWin(char dot) {
            char [][] map = this.map.getMap();
            // check horizontals
            if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
            if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
            if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
            // check verticals
            if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
            if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
            if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;
            // check diagonals
            if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
            if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;
            return false;
        }

        boolean isCellValid(int x, int y) {
            if (x < 0 || y < 0 || x >= map.getSIZE() || y >= map.getSIZE())
                return false;
            return map.getMap()[y][x] == DOT_EMPTY;
        }
    }

    TicTacToeOOP() {
     gl.play();
    }
}