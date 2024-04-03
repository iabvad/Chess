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
        if (newRow == this.row || newCol == this.col) {
            // Rooks can move along rows or columns
            // Check if there are any pieces in the way
            int minRow = Math.min(this.row, newRow);
            int maxRow = Math.max(this.row, newRow);
            int minCol = Math.min(this.col, newCol);
            int maxCol = Math.max(this.col, newCol);

            // Check for obstruction along rows
            if (newRow == this.row) {
                for (int c = minCol + 1; c < maxCol; c++) {
                    if (Board.board[newRow][c] != null) {
                        return false; // There's a piece in the way
                    }
                }
            }
            // Check for obstruction along columns
            if (newCol == this.col) {
                for (int r = minRow + 1; r < maxRow; r++) {
                    if (Board.board[r][newCol] != null) {
                        return false; // There's a piece in the way
                    }
                }
            }
            return true; // No pieces in the way
        }
        return false; // Rook can't move diagonally
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }
}