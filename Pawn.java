public class Pawn extends Piece{

    private final String symbol;
    public Pawn(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♙";
        } else {
            this.symbol = "♟";
        }
    }

    public boolean canMove(int newRow, int newCol) {
        if (!this.isBlack) {
            if (Board.board[ newRow ][ newCol ] == null && this.col == newCol && this.row - newRow <= 2) {
                if(this.row - newRow == 2){
                    if(Board.board[newRow + 1][newCol] == null){
                        return true;
                    } else{
                        return false;
                    }
                }
                return true;
            }
        } else if (this.isBlack) {
            if (Board.board[ newRow ][ newCol ] == null && this.col == newCol && newRow - this.row <= 2) {
                if(newRow - this.row == 2){
                    if(Board.board[newRow - 1][newCol] == null){
                        return true;
                    } else{
                        return false;
                    }
                }
                return true;
            }
            System.out.println ("Invalid Move! Retry");
            return false;

        }


    }

    public String getSymbol(){
        return this.symbol;
    }

}

