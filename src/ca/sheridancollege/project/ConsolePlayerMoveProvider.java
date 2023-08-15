package ca.sheridancollege.project;

import java.util.Scanner;

public class ConsolePlayerMoveProvider implements PlayerMoveProvider {
    private final Scanner scanner;

    public ConsolePlayerMoveProvider() {
        scanner = new Scanner(System.in);
    }

    @Override
public PlayerMove getMove() {
    System.out.println("Enter your move (HIT/STAND): ");
    String input = scanner.nextLine().toUpperCase();

    if (input.equals("HIT")) {
        return PlayerMove.HIT;
    } else if (input.equals("STAND")) {
        return PlayerMove.STAND;
    } else {
        System.out.println("Invalid move. Try again.");
        return getMove();
    }
}

        }
    



