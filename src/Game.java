import java.util.Scanner;

public class Game {
    static final int FIELD_LENGTH = 10;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Игрок 1, пожалуйста введите ваше имя");
        String playerOneName = scanner.nextLine();
        System.out.println("Привет, " + playerOneName + "!");

        System.out.println("Игрок 1, пожалуйста введите ваше имя");
        String playerTwoName = scanner.nextLine();
        System.out.println("Привет, " + playerTwoName + "!");

        char[][] playerFieldOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerFieldTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

//        char[][] playerBattleOne = new char[FIELD_LENGTH][FIELD_LENGTH];
//        char[][] playerBattleTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        fillPlayerField(playerFieldOne);
        fillPlayerField(playerFieldTwo);
    }

    private static void fillPlayerField(char[][] playerField) {
        for (int i = 4; i >= 1; i--) {
            int numberShips = 5 - i;
            for (int k = 0; k < numberShips; k++) {
                System.out.println("Расставляем " + i + "-палубный корабль. Осталось расставить: " + numberShips);

                System.out.println("Введите координату по оси X ");
                int x = scanner.nextInt() - 1;

                System.out.println("Введите координату по оси Y ");
                int y = scanner.nextInt() - 1;

                System.out.println("1 - горизонтально; 2 - вертикально");
                int position = scanner.nextInt();

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

                printField(playerField);
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
}
