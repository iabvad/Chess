public class King extends Piece{

    private final String symbol;

    public King(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♔";
        } else {
            this.symbol = "♚";
        }
    }

    @Override
    public boolean canMove ( int newRow, int newCol ) {
        int rowDiff = Math.abs(newRow - this.row);
        int colDiff = Math.abs(newCol - this.col);

        if (rowDiff <= 1 && colDiff <= 1) {
            Piece pieceAtNewPosition = Board.board[newRow][newCol];
            if (pieceAtNewPosition == null || pieceAtNewPosition.isBlack != this.isBlack) {
                return true;
            }
        }
        return false;
    }

    public String getSymbol(){
        return this.symbol;
    }
    public boolean isInCheck() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = Board.board[i][j];
                if (piece != null && piece.isBlack != this.isBlack) {
                    if (piece.canMove(row, col)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
