import java.util.Scanner;

public class GameState {

    private Board board;
    private boolean isBlackTurn;

    public GameState() {
        board = new Board();
        isBlackTurn = false;
        startNewGame();
    }


    private void startNewGame() {
        board.newBoard();
        board.showBoard();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            if (isBlackTurn) {
                System.out.println("Black's Turn");
            } else {
                System.out.println("White's Turn");
            }


            System.out.print("Enter move (e.g., 'a2 a4'): ");
            String move = scanner.nextLine();

            String[] moveParts = move.split(" ");
            if (moveParts.length != 2) {
                System.out.println("Invalid move format. Please try again.");
                continue;
            }
            String srcPos = moveParts[0];
            String destPos = moveParts[1];

            int currentCol = 0;
            int currentRow;

            int desiredCol = 0;
            int desiredRow;

            if(srcPos.charAt(0) == 'a'){
                currentCol = 0;
            } else if(srcPos.charAt(0) == 'b'){
                currentCol = 1;
            }else if(srcPos.charAt(0) == 'c'){
                currentCol = 2;
            }else if(srcPos.charAt(0) == 'd'){
                currentCol = 3;
            }else if(srcPos.charAt(0) == 'e'){
                currentCol = 4;
            }else if(srcPos.charAt(0) == 'f'){
                currentCol = 5;
            }else if(srcPos.charAt(0) == 'g'){
                currentCol = 6;
            }else if(srcPos.charAt(0) == 'h'){
                currentCol = 7;
            }

            currentRow = 8 - (srcPos.charAt(1) - '0');

            if(destPos.charAt(0) == 'a'){
                desiredCol = 0;
            } else if(destPos.charAt(0) == 'b'){
                desiredCol = 1;
            }else if(destPos.charAt(0) == 'c'){
                desiredCol = 2;
            }else if(destPos.charAt(0) == 'd'){
                desiredCol = 3;
            }else if(destPos.charAt(0) == 'e'){
                desiredCol = 4;
            }else if(destPos.charAt(0) == 'f'){
                desiredCol = 5;
            }else if(destPos.charAt(0) == 'g'){
                desiredCol = 6;
            }else if(destPos.charAt(0) == 'h'){
                desiredCol = 7;
            }

            desiredRow = 8 - (destPos.charAt(1) - '0');


            if (!makeMove(currentRow, currentCol, desiredRow, desiredCol)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }


            isBlackTurn = !isBlackTurn;


            board.showBoard();

            // Add logic for checkmate, stalemate, etc.
        }
    }


    private boolean makeMove(int currentRow, int currentCol, int newRow, int newCol) {
        Piece srcPiece = Board.board[currentRow][currentCol];

        if (srcPiece == null) {
            return false;
        }


        if (srcPiece.isBlack == isBlackTurn) {
            return false;
        }


        if (!srcPiece.canMove(newRow, newCol)) {
            return false;
        }

        srcPiece.move(newRow, newCol);

        return true;
    }

    public static void main(String[] args) {
        GameState game = new GameState();
        game.playGame();
    }
}
