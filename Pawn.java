public class Pawn extends Piece{

    private final String symbol;
    public Pawn(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♟";
        } else {
            this.symbol = "♙";
        }
    }

    public boolean canMove(int newRow, int newCol) {
        if (!isBlack) {
            if(row == 6) {
                if (Board.board[ newRow ][ newCol ] == null && this.col == newCol && this.row - newRow <= 2) {
                    if (this.row - newRow == 2) {
                        return Board.board[ newRow + 1 ][ newCol ] == null;
                    }
                    return true;
                }
            } else{
                if (Board.board[ newRow ][ newCol ] == null && this.col == newCol && this.row - newRow == 1) {
                    if (this.row - newRow == 2) {
                        return Board.board[ newRow + 1 ][ newCol ] == null;
                    }
                    return true;
                }
            }
        } else {
            if(row == 1){
                if (Board.board[ newRow ][ newCol ] == null && this.col == newCol && newRow - this.row <= 2) {
                    if(newRow - this.row == 2){
                        return Board.board[ newRow - 1 ][ newCol ] == null;
                    }
                    return true;
                }
            } else {
                if (Board.board[ newRow ][ newCol ] == null && this.col == newCol && newRow - this.row == 1) {
                    if (newRow - this.row == 2) {
                        return Board.board[ newRow - 1 ][ newCol ] == null;
                    }
                    return true;
                }
            }
            return false;

        }

        return false;
    }

    public String getSymbol(){
        return this.symbol;
    }

}

