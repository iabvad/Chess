public class Queen extends Piece{

    private final String symbol;

    public Queen(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♛";
        } else {
            this.symbol = "♕";
        }
    }

    @Override
    public boolean canMove(int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - this.row);
        int colDiff = Math.abs(newCol - this.col);

        if (rowDiff == 0 || colDiff == 0 || rowDiff == colDiff) {
            int rowIncrement = Integer.compare(newRow, this.row);
            int colIncrement = Integer.compare(newCol, this.col);
            int currentRow = this.row + rowIncrement;
            int currentCol = this.col + colIncrement;
            while (currentRow != newRow || currentCol != newCol) {
                if (Board.board[currentRow][currentCol] != null) {
                    return false;
                }
                currentRow += rowIncrement;
                currentCol += colIncrement;
            }
            return true;
        }
        return false;

    }

    public String getSymbol(){
        return this.symbol;
    }
}