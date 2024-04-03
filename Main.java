public class Main{
    public static void main(String[] args){

        Board board = new Board();
        board.newBoard();

        Board.board[1][0].move(2,0);
        Board.board[0][0].move(1, 0);
        board.showBoard();

        Board.board[1][0].move(3,0);
        board.showBoard();

        Board.board[2][0].move(3,0);
        board.showBoard();

            }
        }