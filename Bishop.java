public class Bishop extends Piece{

    private final String symbol;

    public Bishop(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♗";
        } else {
            this.symbol = "♝";
        }
    }

    @Override
    public boolean canMove(int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - this.row);
        int colDiff = Math.abs(newCol - this.col);

        if (rowDiff == colDiff) {
            int rowIncrement = (newRow > this.row) ? 1 : -1;
            int colIncrement = (newCol > this.col) ? 1 : -1;
            int currentRow = this.row + rowIncrement;
            int currentCol = this.col + colIncrement;

            while (currentRow != newRow && currentCol != newCol) {
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