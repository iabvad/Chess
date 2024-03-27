
public abstract class Piece {

    protected boolean isBlack;
    protected int row;
    protected int col;


    public Piece(boolean isBlack, int row, int col){
        this.isBlack = isBlack;
        this.row = row;
        this.col = col;
    }

    public abstract boolean canMove(int row, int col);
    public abstract String getSymbol();

    public void move(int newRow, int newCol) {
        if(canMove(newRow, newCol)){
            for (Piece[] p : Board.board) {
                for(Piece d : Board.board[p]){
                    if (d.row == row && d.col == col) {
                        d.takePiece();
                }

                }
            }
            this.row = newRow;
            this.col = newCol;
        }

    }



        public void takePiece() {
            Board.board.remove(this);
        }
}
