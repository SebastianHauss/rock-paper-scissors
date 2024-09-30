import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String ROCK = "r";
    private static final String PAPER = "p";
    private static final String SCISSORS = "s";
    private static final String[] RPS = {ROCK, PAPER, SCISSORS};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String computerMove = getComputerMove();
            String playerMove = getPlayerMove(scanner);

            System.out.println("You played: " + moveToString(playerMove));
            System.out.println("Computer played: " + moveToString(computerMove));

            String result = getResult(playerMove, computerMove);
            System.out.println(result);

            System.out.println("Play again? (y/n)");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("y")) {
                break;
            }
        }

        scanner.close();
    }

    private static String getComputerMove() {
        return RPS[new Random().nextInt(RPS.length)];
    }

    private static String getPlayerMove(Scanner scanner) {
        String playerMove;
        while (true) {
            System.out.println("Please enter your move (r, p, or s):");
            playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals(ROCK) || playerMove.equals(PAPER) || playerMove.equals(SCISSORS)) {
                return playerMove;
            }
            System.out.println(playerMove + " is not a valid move.");
        }
    }

    private static String getResult(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "The game was a tie!";
        }

        return switch (playerMove) {
            case ROCK -> (computerMove.equals(SCISSORS)) ? "You win!" : "You lose!";
            case PAPER -> (computerMove.equals(ROCK)) ? "You win!" : "You lose!";
            case SCISSORS -> (computerMove.equals(PAPER)) ? "You win!" : "You lose!";
            default -> "Invalid game state";
        };
    }

    private static String moveToString(String move) {
        return switch (move) {
            case ROCK -> "Rock";
            case PAPER -> "Paper";
            case SCISSORS -> "Scissors";
            default -> "Unknown";
        };
    }
}