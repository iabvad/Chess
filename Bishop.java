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

        int rowDistance = Math.abs(newRow - row);
        int colDistance = Math.abs(newCol - col);

        // Bishops can only move diagonally
        if (rowDistance != colDistance) {
            return false;
        }

        int rowDirection = (newRow - row) > 0 ? 1 : -1;
        int colDirection = (newCol - col) > 0 ? 1 : -1;

        int currentRow = row + rowDirection;
        int currentCol = col + colDirection;

        while (currentRow != newRow && currentCol != newCol) {
            if (Board.board[currentRow][currentCol] != null) {
                return false; // There's a piece in the way
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return true;
    }


    public String getSymbol(){
        return this.symbol;
    }
}