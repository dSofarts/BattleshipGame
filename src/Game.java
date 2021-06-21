import java.util.Scanner;

public class Game {
    static final int FIELD_LENGTH = 10;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Player 1, please write your name");
        String playerOneName = scanner.nextLine();
        System.out.println("Hello, " + playerOneName + "!");

        System.out.println("Player 2, please write your name");
        String playerTwoName = scanner.nextLine();
        System.out.println("Hello, " + playerTwoName + "!");

        char[][] playerFieldOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerFieldTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        char[][] playerBattleOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerBattleTwo = new char[FIELD_LENGTH][FIELD_LENGTH];
    }
}
