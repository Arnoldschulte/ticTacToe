import java.util.HashMap;
import java.util.List;

public class Board {

    private static final String EMPTY_VALUE_BOARD = "  ";
    private HashMap<String, String> board = new HashMap<>();
    private List<String> choices = List.of("A1", "B1", "C1", "A2", "B2", "C2", "A3", "B3", "C3");
    private Player winner;


    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (String choice : choices) {
            board.put(choice, EMPTY_VALUE_BOARD);
        }
    }

    private void displayBoard() {
        System.out.println(String.format(
                " %s | %s | %s \n" +
                        "------------- \n" +
                        " %s | %s | %s \n" +
                        "------------- \n" +
                        " %s | %s | %s \n",
                board.get("A1"),
                board.get("B1"),
                board.get("C1"),
                board.get("A2"),
                board.get("B2"),
                board.get("C2"),
                board.get("A3"),
                board.get("B3"),
                board.get("C3")
        ));
    }

    public boolean invalidEntry(String input) {
        return !board.containsKey(input);
    }

    public boolean isOccupied(String input) {
        return !EMPTY_VALUE_BOARD.equals(board.get(input));
    }

    private void updateBoard(Symbol symbol, String input) {
        board.replace(input, symbol.toString());
    }

    public void playCpu() {
        String move = "";
        for (String key : board.keySet()) {
            if (board.get(key).equals(EMPTY_VALUE_BOARD)) {
                updateBoard(Symbol.OO, key);
                move = key;
                break;
            }
        }
        System.out.println("I will play at " + move);
        displayBoard();
    }

    public void playPlayer(String input) {
        updateBoard(Symbol.XX, input);
        displayBoard();
    }

    public boolean isFull() {
        return !board.containsValue(EMPTY_VALUE_BOARD);
    }

    public boolean hasWinner() {
        if ((board.get("A1").equals(board.get("A2"))) && (board.get("A1").equals(board.get("A3"))) && !(board.get("A1").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("A1")));
            return true;
        }

        if ((board.get("B1").equals(board.get("B2")) && (board.get("B1").equals(board.get("B3")))) && !(board.get("B1").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("B1")));
            return true;
        }

        if ((board.get("C1").equals(board.get("C2")) && (board.get("C1").equals(board.get("C3")))) && !(board.get("C1").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("C1")));
            return true;
        }

        if ((board.get("A1").equals(board.get("B1")) && (board.get("A1").equals(board.get("C1")))) && !(board.get("A1").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("A1")));
            return true;
        }

        if ((board.get("A2").equals(board.get("B2")) && (board.get("A2").equals(board.get("C2")))) && !(board.get("A2").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("A2")));
            return true;
        }
        if ((board.get("A3").equals(board.get("B3")) && (board.get("A3").equals(board.get("C3")))) && !(board.get("A3").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("A3")));
            return true;
        }

        if ((board.get("A1").equals(board.get("B2")) && (board.get("A1").equals(board.get("C3")))) && !(board.get("A1").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("A1")));
            return true;
        }

        if ((board.get("A3").equals(board.get("B2")) && (board.get("A3").equals(board.get("C1")))) && !(board.get("A3").equals(EMPTY_VALUE_BOARD))) {
            winner = new Player(Symbol.valueOf(board.get("A3")));
            return true;
        }
        return false;
    }

    public Player getWinner() {
        return winner;
    }
}
