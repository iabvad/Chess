public class King extends Piece {

    private final String symbol;

    public King(boolean isBlack, int row, int col) {
        super(isBlack, row, col);
        if (this.isBlack) {
            this.symbol = "♔";
        } else {
            this.symbol = "♚";
        }
    }

    @Override
    public boolean canMove(int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - this.row);
        int colDiff = Math.abs(newCol - this.col);

        if (rowDiff <= 1 && colDiff <= 1) {
            Piece pieceAtNewPosition = Board.board[newRow][newCol];
            return pieceAtNewPosition == null || pieceAtNewPosition.isBlack != this.isBlack;
        }
        return false;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public boolean isInCheck() {
        // Check if the king is in check
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = Board.board[i][j];
                if (piece != null && piece.isBlack != this.isBlack && piece.canMove(this.row, this.col)) {
                    return true; // King is in check if any opponent piece can attack its position
                }
            }
        }
        return false;
    }

    public boolean isCheckmate() {
        // Check if the king is in checkmate
        if (!isInCheck()) {
            return false; // If the king is not in check, it's not checkmate
        }

        // Check if the king can move to any safe square
        for (int newRow = this.row - 1; newRow <= this.row + 1; newRow++) {
            for (int newCol = this.col - 1; newCol <= this.col + 1; newCol++) {
                if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                    if (canMove(newRow, newCol) && !isInCheckAfterMove(newRow, newCol)) {
                        return false; // King can escape check by moving to this square
                    }
                }
            }
        }

        // Check if any friendly piece can capture the attacking piece or block the check
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = Board.board[i][j];
                if (piece != null && piece.isBlack == this.isBlack) {
                    for (int newRow = 0; newRow < 8; newRow++) {
                        for (int newCol = 0; newCol < 8; newCol++) {
                            if (piece.canMove(newRow, newCol)) {
                                Piece capturedPiece = Board.board[newRow][newCol];
                                Board.board[newRow][newCol] = piece; // Simulate the move
                                if (!isInCheck()) {
                                    Board.board[newRow][newCol] = capturedPiece; // Revert the move
                                    return false; // Piece can capture or block the check
                                }
                                Board.board[newRow][newCol] = capturedPiece; // Revert the move
                            }
                        }
                    }
                }
            }
        }

        return true; // If no escape moves and no pieces can capture or block, it's checkmate
    }

    private boolean isInCheckAfterMove(int newRow, int newCol) {
        Piece pieceAtNewPosition = Board.board[newRow][newCol];
        Board.board[newRow][newCol] = this; // Simulate the move
        boolean result = isInCheck();
        Board.board[newRow][newCol] = pieceAtNewPosition; // Revert the move
        return result;
    }
}
