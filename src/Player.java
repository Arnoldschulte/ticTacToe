public class Player {

    private Symbol symbol;

    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol.toString();
    }
}
