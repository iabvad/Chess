public class Rook extends Piece{

    private final String symbol;

    public Rook(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♖";
        } else {
            this.symbol = "♜";
        }
    }

    @Override
    public boolean canMove ( int row, int col ) {
        if(this.row == row || this.col == col){
            if(isBlack){
                for(int i = 0; i < row; i++){
                        
                }
            } else{

            }
        }
        return false;
    }

    public String getSymbol(){
        return this.symbol;
    }
}