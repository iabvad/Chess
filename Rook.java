public class Rook extends Piece{

    private final String symbol;

    public Rook(boolean isBlack, int row, int col){
        super(isBlack, row, col);
        if(this.isBlack) {
            this.symbol = "♖";
        } else {
            this.symbol = "♜";
        }
    }

    @Override
    public boolean canMove ( int row, int col ) {
        if(this.row == row){
                if(col > this.col){
                    for(int i = this.col; i < col; i++){
                        if(Board.board[row][i] != null){
                            return false;
                        }
                    }
                } else if(col < this.col){
                    for(int i = this.col; i >= col; i--){
                        if(Board.board[row][i] != null){
                            return false;
                        }
                    }
                }
            }
        else if(this.col == col){
            if(row > this.row){
                for(int i = this.row; i < row; i++){
                    if(Board.board[col][i] != null){
                        return false;
                    }
                }
            } else {
                for(int i = this.row; i >= row; i--){
                    if(Board.board[col][i] != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String getSymbol(){
        return this.symbol;
    }
}