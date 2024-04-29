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

        if(Board.board[newRow][newCol] != null){
            if(Board.board[newRow][newCol].isBlack == this.isBlack){
                return false;
            }
        }
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





}
