import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Player 1, please write your name");
        String playerOneName = scanner.nextLine();
        System.out.println("Hello, " + playerOneName + "!");

        System.out.println("Player 2, please write your name");
        String playerTwoName = scanner.nextLine();
        System.out.println("Hello, " + playerTwoName + "!");
    }
}
