import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private Scanner scanner;

    public Game() {
        player1 = new Player(Symbol.XX);
        player2 = new Player(Symbol.OO);
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void play() {
        printWelcomeMessage();
        playFirstMove();
        while (!board.hasWinner()) {
            if (board.isFull()) {
                break;
            } else {
                playMove();
            }
        }
        printResult();
    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to Tic-Tac-Toe.\n");
        System.out.println("A1 | B1 | C1");
        System.out.println("------------");
        System.out.println("A2 | B2 | C2");
        System.out.println("------------");
        System.out.println("A3 | B3 | C3\n");
    }

    private boolean isComputer(Player player) {
        return player2.getSymbol().equals(player.getSymbol());
    }

    private void setNextPlayer() {
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }

    private void playFirstMove() {
        currentPlayer = player1;
        playPlayer(getFirstInput());
    }

    private void playMove() {
        if (isComputer(currentPlayer)) {
            playCpu();
        } else {
            playPlayer(getInput());
        }
    }

    private void playPlayer(String input) {
        while (board.invalidEntry(input) || board.isOccupied(input)) {
            if (board.invalidEntry(input)) {
                System.out.println("Not a valid entry, please try again...\n");
                input = getInput();
            } else {
                System.out.println("This spot is occupied, please select another one...\n");
                input = getInput();
            }
        }
        board.playPlayer(input);
        setNextPlayer();
    }

    private void playCpu() {
        board.playCpu();
        setNextPlayer();
    }

    private String getFirstInput() {
        System.out.print("Please enter your first move: ");
        return scanner.nextLine().toUpperCase();
    }

    private String getInput() {
        System.out.print("Please enter your next move: ");
        return scanner.nextLine().toUpperCase();
    }

    private void printResult() {
        if (board.isFull() && !board.hasWinner()) {
            System.out.println("It's a draw!");
        } else if (board.hasWinner()) {
            System.out.println(isComputer(board.getWinner()) ? "I beat you!" : "You beat me!");
        }
    }

}
