public class Horse extends Piece{

    private final String symbol;

    public Horse(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♞";
        } else {
            this.symbol = "♘";
        }
    }

    public boolean canMove(int newRow, int newCol){
        return (newRow == row - 2 && newCol == col + 1) || (newRow == row - 2 && newCol == col - 1) ||
                (newRow == row - 1 && newCol == col + 2) || (newRow == row - 1 && newCol == col - 2) ||
                (newRow == row + 1 && newCol == col + 2) || (newRow == row + 1 && newCol == col - 2) ||
                (newRow == row + 2 && newCol == col + 1) || (newRow == row + 2 && newCol == col - 1);
    }

    public String getSymbol(){
        return this.symbol;
    }
}