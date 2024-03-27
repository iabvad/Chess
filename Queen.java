public class Queen extends Piece{

    private final String symbol;

    public Queen(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack == true) {
            this.symbol = "♕";
        } else {
            this.symbol = "♛";
        }
    }
    public String getSymbol(){
        return this.symbol;
    }
}