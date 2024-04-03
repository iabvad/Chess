
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
        if (canMove(newRow, newCol)) {
            Piece destinationPiece = Board.board[newRow][newCol];
            if (destinationPiece != null) {
                if (destinationPiece.isBlack != this.isBlack) {
                    destinationPiece.takePiece();
                } else {
                    return;
                }
            }

            Board.board[row][col] = null;
            Board.board[newRow][newCol] = this;
            this.row = newRow;
            this.col = newCol;
        }
    }



        public void takePiece() {
            for (int y = 0; y < Board.board.length; y++) {
                for (int x = 0; x < Board.board[y].length; x++) {
                    if (Board.board[y][x] == this) {
                        Board.board[y][x] = null;
                        return;
                    }
                }
            }
        }
    }


