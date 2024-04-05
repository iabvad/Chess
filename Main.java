public class Main{
    public static void main(String[] args){

        Board board = new Board();
        board.newBoard();

        board.showBoard();
        Board.board[1][0].move(3,0);
        board.showBoard();

        Board.board[0][0].move(1, 0);
        board.showBoard ();

        board.newBoard();
        board.showBoard();
        Board.board[1][0].move(3, 0);

        System.out.println(Board.board[0][0].canMove(1,2));
            }
        }