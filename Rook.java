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
    public boolean canMove ( int newRow, int newCol ) {
        if (this.row == newRow) {
            if (newCol > this.col) {
                for (int i = this.col; i < newCol; i++) {
                    if (Board.board[this.row ][ i ] != null) {
                        return false;
                    }
                }
                return true;
            } else if (newCol < this.col) {
                for (int i = this.col; i >= newCol; i--) {
                    if (Board.board[ this.row ][ i ] != null) {
                        return false;
                    }
                }
                return true;
            }
        } else if (this.col == newCol) {
            if (newRow > this.row) {
                for (int i = this.row; i < newRow; i++) {
                    if (Board.board[ this.col ][ i ] != null) {
                        return false;
                    }
                }
                return true;
            } else if (newRow < this.row) {
                for (int i = this.row; i >= newRow; i--) {
                    if (Board.board[ this.col ][ i ] != null) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }



    public String getSymbol(){
        return this.symbol;
    }
}