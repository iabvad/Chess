public class Queen extends Piece{

    private final String symbol;

    public Queen(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♕";
        } else {
            this.symbol = "♛";
        }
    }

    @Override
    public boolean canMove(int row, int col) {
        return false;
    }

    public String getSymbol(){
        return this.symbol;
    }
}