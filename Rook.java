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
    public boolean canMove(int row, int col) {
        // Check for horizontal movement
        if (this.row == row && this.col != col) {
            int start = Math.min(this.col, col);
            int end = Math.max(this.col, col);
            for (int i = start + 1; i < end; i++) {
                if (Board.board[row][i] != null) {
                    return false;
                }
            }
            return true;
        }
        // Check for vertical movement
        else if (this.col == col && this.row != row) {
            int start = Math.min(this.row, row);
            int end = Math.max(this.row, row);
            for (int i = start + 1; i < end; i++) {
                if (Board.board[i][col] != null) {
                    return false;
                }
            }
            return true;
        }
        // No movement detected
        return false;
    }




    public String getSymbol(){
        return this.symbol;
    }
}