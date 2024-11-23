package turing_quizzes.lesson_quizzes.shipBattleGame;

import java.util.Random;
import java.util.Scanner;

public class ShipBattleGameApp {
    static int SIZE = 10; // Xəritənin ölçüsü 10x10
    static int BOMBS = 25; // İstifadəçinin bombalarının sayı
    static char[][] map = new char[SIZE][SIZE]; // Oyunun xəritəsi
    static int[][] ships = {{1, 5}, {1, 4}, {2, 3}, {2, 2}}; // Gəmilərin sayı və uzunluqları

    public static void main(String[] args) {
        initializeMap();
        placeShips();
        playGame();
    }

    public static void initializeMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '.'; // Boş hüceyrələr '.' ilə doldurulur
            }
        }
    }

    static boolean canPlaceShip(int x, int y, int length, boolean horizontal) {
        if (horizontal) {
            if (y + length > SIZE) return false; // Sərhədi aşırsa, uyğun deyil
            for (int i = 0; i < length; i++) {
                if (map[x][y + i] != '.') return false; // Bu xəttdə gəmi varsa, uyğun deyil
            }
        } else {
            if (x + length > SIZE) return false; // Sərhədi aşırsa, uyğun deyil
            for (int i = 0; i < length; i++) {
                if (map[x + i][y] != '.') return false; // Bu sütunda gəmi varsa, uyğun deyil
            }
        }
        return true;
    }


    public static void placeShips() {
        Random rand = new Random();
        for (int[] ship : ships) {
            int count = ship[0]; // Gəminin sayı
            int length = ship[1]; // Gəminin uzunluğu

            while (count > 0) {
                int x = rand.nextInt(SIZE); // Təsadüfi x koordinatı
                int y = rand.nextInt(SIZE); // Təsadüfi y koordinatı
                boolean horizontal = rand.nextBoolean(); // Üfüqi və ya şaquli

                if (canPlaceShip(x, y, length, horizontal)) {
                    placeShip(x, y, length, horizontal); // Gəmini yerləşdir
                    count--; // Bir gəmi yerləşdirildi, sayı azald
                }
            }
        }
    }

    static void placeShip(int x, int y, int length, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < length; i++) {
                map[x][y + i] = 'S'; // Üfüqi yerləşdir
            }
        } else {
            for (int i = 0; i < length; i++) {
                map[x + i][y] = 'S'; // Şaquli yerləşdir
            }
        }
    }

    static int countTotalShipBlocks() {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == 'S') count++;
            }
        }
        return count;
    }


    static void printMap(boolean revealShips) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == 'S' && !revealShips) {
                    System.out.print(". "); // Gəmiləri gizlə
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void playGame() {
        Scanner scanner = new Scanner(System.in);
        int bombsLeft = BOMBS;
        int shipsLeft = countTotalShipBlocks();

        while (bombsLeft > 0 && shipsLeft > 0) {
            System.out.println("Qalan bombalar: " + bombsLeft);
            printMap(false); // Xəritəni istifadəçiyə göstər

            System.out.print("Koordinat daxil edin (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

//            x = x - 1;
//            y = y - 1;

            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("Düzgün koordinat daxil edin!");
                continue;
            }

            if (map[x][y] == 'S') {
                map[x][y] = 'X'; // Gəmi blokunu zədələ
                shipsLeft--;
                System.out.println("Zədələndi!");
            } else if (map[x][y] == '.') {
                map[x][y] = 'O'; // Boş atış
                System.out.println("Zədələnmədi.");
            } else {
                System.out.println("Bu koordinata artıq bomba atılıb!");
            }

            bombsLeft--;
        }

        if (shipsLeft == 0) {
            System.out.println("Qələbə! Bütün gəmilər məhv edildi!");
        } else {
            System.out.println("Məğlubiyyət. Bombalar bitdi!");
        }
    }


}
