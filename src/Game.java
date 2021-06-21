import java.util.Scanner;

public class Game {
    static final int FIELD_LENGTH = 10;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Игрок 1, пожалуйста введите ваше имя");
        String playerOneName = scanner.nextLine();
        System.out.println("Привет, " + playerOneName + "!");

        System.out.println("Игрок 2, пожалуйста введите ваше имя");
        String playerTwoName = scanner.nextLine();
        System.out.println("Привет, " + playerTwoName + "!");

        System.out.println();

        char[][] playerFieldOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerFieldTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        try {
            System.out.println(playerOneName + " заполните поле корбалями");
            fillPlayerField(playerFieldOne);
            System.out.println();
            System.out.println(playerTwoName + " заполните поле корбалями");
            fillPlayerField(playerFieldTwo);
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
    }

    private static void fillPlayerField(char[][] playerField) {
        for (int i = 4; i >= 1; i--) {
            int numberShips = 5 - i;
            for (int k = 0; k < numberShips; k++) {
                System.out.println("Расставляем " + i + "-палубный корабль. Осталось расставить: " + numberShips);

                int validationResult = -1;
                int x = -1;
                int y = -1;
                int position = -1;

                while (validationResult != 0) {
                    System.out.println("Введите координату по оси X ");
                    x = scanner.nextInt() - 1;

                    System.out.println("Введите координату по оси Y ");
                    y = scanner.nextInt() - 1;

                    System.out.println("1 - горизонтально; 2 - вертикально");
                    position = scanner.nextInt();

                    validationResult = validateCoordForShip(playerField, x, y, position, i);
                }

                try {
                    if (position == 1) {
                        for (int q = 0; q < i; q++) {
                            playerField[y][x + q] = '1';
                        }
                    }
                    if (position == 2) {
                        for (int m = 0; m < i; m++) {
                            playerField[y + m][x] = '1';
                        }
                    }
                    if (position != 1 || position != 2) {
                        System.err.println("Не верная команда положения!");
                    }
                    printField(playerField);
                } catch (Exception ex) {
                    System.err.println("Не возможно так поставить корабль! Повторите попытку!");
                }
            }
        }
    }

    static void printField(char[][] field) {
        for (char[] cells : field) {
            for (char cell : cells) {
                if (cell == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(cell + "|");
                }
            }
            System.out.println("");
            System.out.println("--------------------");
        }
    }

    private static void playGame(String playerOneName, String playerTwoName, char[][] playerFieldOne, char[][] playerFieldTwo) {
        char[][] playerBattleOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerBattleTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        String currentPlayerName = playerOneName;
        char[][] currentPlayerField = playerFieldTwo;
        char[][] currentPlayerBattleField = playerBattleOne;

        while (isPlayerAlive(playerFieldOne) && isPlayerAlive(playerFieldTwo)) {
            System.out.println("Ход игрока " + currentPlayerName);
            printField(currentPlayerBattleField);
            System.out.println(currentPlayerName + ", пожалуйста введите координату X для выстрела");
            int xShot = scanner.nextInt();

            System.out.println(currentPlayerName + ", пожалуйста введите координату Y для выстрела");
            int yShot = scanner.nextInt();

            int shotResult = handleShot(currentPlayerBattleField, currentPlayerField, xShot, yShot);

            if (shotResult == 0) {
                currentPlayerName = playerTwoName;
                currentPlayerField = playerFieldOne;
                currentPlayerBattleField = playerBattleTwo;
            }
        }
        System.out.println(currentPlayerName + " выиграл!");
    }

    private static int handleShot(char[][] battleField, char[][] field, int x, int y) {
        if (field[y][x] == '1') {
            field[y][x] = '#';
            battleField[y][x] = '#';
            System.out.println("Хороший выстрел");
            return 1;
        }
        battleField[y][x] = '*';
        field[y][x] = '*';
        return 0;
    }

    private static boolean isPlayerAlive(char[][] field) {
        for (char[] cells : field) {
            for (char cell : cells) {
                if (cell == '1') {
                    return true;
                }
            }
        }
        return false;
    }

    private static int validateCoordForShip(char[][] field, int x, int y, int position, int shipType) {
        if (position == 1) {
            for (int i = 0; i < shipType - 1; i++) {
                if (field[y][x + i] == '1' || field[y - 1][x + i] == '1' || field[y + 1][x + i] == '1' || field[y][x + i + 1] == '1' || field[y][x + i - 1] == '1' || (x + i) > 9) {
                    return -1;
                }
            }
        } else if (position == 2) {
            for (int i = 0; i < shipType - 1; i++) {
                if (field[y][x + i] == '1' || field[y - 1][x + i] == '1' || field[y + 1][x + i] == '1' || field[y][x + i + 1] == '1' || field[y][x + i - 1] == '1' || (y + i) > 9) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
