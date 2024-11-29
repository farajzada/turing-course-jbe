package turing_quizzes.lesson_quizzes.shipBattleGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;

public class ShipBattleGameApp {
    private static int GRID_SIZE = 10; // Xəritənin ölçüsü
    private static char EMPTY = '.'; // Boş hüceyrə
    private static char SHIP = 'S'; // Gəmi
    private static char HIT = 'X'; // Vurulmuş gəmi
    private static char MISS = 'O'; // Qaçırılmış bomba
    private static char[][] grid = new char[GRID_SIZE][GRID_SIZE]; // Xəritə
    private static int bombsLeft = 25; // İstifadəçiyə verilən bombalar
    private static int shipsLeft = 5; // Məhv edilməsi gərəkən gəmilər
    private static List<List<int[]>> shipsCoordinates = new ArrayList<>(); // Gəmi koordinatları


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Xəritəni ilkin olaraq boş qoyuruq
        initializeGrid();

        // Gəmiləri xəritəyə yerləşdiririk
        placeShips();

        // Oyunu başlatırıq
        System.out.println("Ship Battle Game başladı!");
        while (bombsLeft > 0 && shipsLeft > 0) {
            printGrid(false); // Xəritəni ekranda göstəririk (gəmilər gizlidir)
            System.out.println("Qalan bombalar: " + bombsLeft);
            System.out.print("Satır nömrəsini daxil edin (0-9): ");
            int row = scanner.nextInt();
            System.out.print("Sütun nömrəsini daxil edin (0-9): ");
            int col = scanner.nextInt();

            // Koordinatları yoxlayırıq
            if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE) {
                System.out.println("Yanlış koordinatlar, yenidən cəhd edin.");
                continue;
            }

            // Atəşin nəticəsini yoxlayırıq
            if (grid[row][col] == SHIP) {
                System.out.println("Vuruldu!");
                grid[row][col] = HIT; // Vurulmuş gəmi işarəsi
                if (isShipDestroyed()) { // Gəmi tamamilə məhv edildimi yoxlayırıq
                    shipsLeft--;
                    System.out.println("Gəmi məhv edildi!");
                }
            } else if (grid[row][col] == EMPTY) {
                System.out.println("Qaçırdınız!");
                grid[row][col] = MISS; // Qaçırılmış bomba işarəsi
            } else {
                System.out.println("Bu koordinata artıq atəş açmısınız.");
            }

            bombsLeft--; // Hər atışda bomba sayını bir azaldırıq
        }

        // Oyunun nəticəsi
        if (shipsLeft == 0) {
            System.out.println("Təbriklər! Siz qazandınız!");
        } else {
            System.out.println("Oyunu uduzdunuz. Bombalarınız tükəndi.");
        }

        // Xəritəni sonunda göstəririk (gəmilər açıqdır)
        printGrid(true);
    }

    // Xəritəni sıfırlayır
    private static void initializeGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = EMPTY; // Xəritəni boş hüceyrələrlə doldururuq
            }
        }
    }

    // Gəmiləri yerləşdiririk
    private static void placeShips() {
        // Gəmi ölçüləri (xəritəyə yerləşdirmə metodunda istifadə olunacaq)
        int[] shipSizes = {5, 4, 3, 3, 2}; // 5 bloklu, 4 bloklu, 3 bloklu (iki dəfə), 2 bloklu gəmi

        Random rand = new Random();
        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                // Gəminin yerləşdirilməsinin mümkünlüyünü yoxlayırıq
                int row = rand.nextInt(GRID_SIZE);
                int col = rand.nextInt(GRID_SIZE);
                boolean horizontal = rand.nextBoolean(); // Gəminin istiqamətini təsadüfi müəyyən edirik

                if (canPlaceShip(row, col, size, horizontal)) {
                    placeShip(row, col, size, horizontal);
                    placed = true; // Gəmi yerləşdirildi
                }
            }
        }
    }

    // Gəminin xəritəyə yerləşdirilib-yerləşdirilmədiyini yoxlayır
    private static boolean canPlaceShip(int row, int col, int size, boolean horizontal) {
        // Yerləşdirmənin sərhədləri keçib-keçmədiyini yoxlayırıq
        if (horizontal) {
            if (col + size > GRID_SIZE) return false; // Gəmi yatay yerləşirsə, sağa sığarmı?
            for (int i = 0; i < size; i++) {
                if (grid[row][col + i] != EMPTY) return false; // Hər bir hüceyrə boş olmalıdır
            }
        } else {
            if (row + size > GRID_SIZE) return false; // Gəmi şaquli yerləşirsə, aşağıya sığarmı?
            for (int i = 0; i < size; i++) {
                if (grid[row + i][col] != EMPTY) return false; // Hər bir hüceyrə boş olmalıdır
            }
        }
        return true; // Bütün yoxlamalar keçərsə, gəmi yerləşdirilə bilər
    }

    // Gəmini xəritəyə yerləşdirir
    private static void placeShip(int row, int col, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            LinkedTransferQueue<int[]> shipCoordinates = new LinkedTransferQueue<>();
            if (horizontal) {
                grid[row][col + i] = SHIP; // Yatay yerləşdirir
                shipCoordinates.add(new int[] {row, col + i});
            } else {
                grid[row + i][col] = SHIP; // Şaquli yerləşdirir
                shipCoordinates.add(new int[] {row + i, col});
            }
        }
    }

    // Bütün gəmilərin məhv olub-olmamasını yoxlayır
    private static boolean isShipDestroyed() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == SHIP) return false; // Hələ də gəmi var
            }
        }
        return true; // Heç bir gəmi qalmayıb
    }

    // Xəritəni ekranda göstərir
    private static void printGrid(boolean revealShips) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == SHIP && !revealShips) {
                    System.out.print(EMPTY + " "); // Gəmiləri gizlətmək üçün boş göstəririk
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void printShipCoordinates() {
        System.out.println("Gəmilərin koordinatları:");
        for (List<int[]> ship : shipsCoordinates) {
            for (int[] coordinate : ship) {
                System.out.print("[" + coordinate[0] + "," + coordinate[1] + "] ");
            }
            System.out.println();
        }
    }

}
