public class Rook extends Piece {

    private final String symbol;

    public Rook(boolean isBlack, int row, int col) {
        super(isBlack, row, col);
        if (this.isBlack) {
            this.symbol = "♖";
        } else {
            this.symbol = "♜";
        }
    }

    @Override
    public boolean canMove(int newRow, int newCol) {
        if (newRow == this.row) {
            int distance = Math.abs(newCol - this.col);
            if (newCol < this.col) {
                for (int i = 1; i < distance; i++) {
                    if (Board.board[this.row][this.col - i] != null) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i <= distance; i++) {
                    if (Board.board[this.row][this.col + i] != null) {
                        return false;
                    }
                }
            }
            return true;
        } else if (newCol == this.col) {
            int distance = Math.abs(newRow - this.row);
            if (newRow < this.row) {
                for (int i = 1; i < distance; i++) {
                    if (Board.board[this.row - i][this.col] != null) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i <= distance; i++) {
                    if (Board.board[this.row + i][this.col] != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return this.symbol;
    }
}