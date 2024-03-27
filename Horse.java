public class Horse extends Piece{

    private final String symbol;

    public Horse(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♘";
        } else {
            this.symbol = "♞";
        }
    }

    public boolean canMove(int newRow, int newCol){
        return true;
    }

    public String getSymbol(){
        return this.symbol;
    }
}