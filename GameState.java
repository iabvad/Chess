import java.util.Scanner;
public class GameState {

    private Board board;
    private boolean isBlackTurn; // Flag to track player turns

    public GameState() {
        board = new Board();
        isBlackTurn = false; // Assuming white starts first
        startNewGame();
    }

    // Start a new game by initializing the board and showing it
    private void startNewGame() {
        board.newBoard();
        board.showBoard();
    }

    // Main method to run the game
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display current player's turn
            if (isBlackTurn) {
                System.out.println("Black's Turn");
            } else {
                System.out.println("White's Turn");
            }

            // Get user input for move
            System.out.print("Enter move (e.g., 'a2 a4'): ");
            String move = scanner.nextLine();

            // Parse user input to get source and destination positions
            String[] moveParts = move.split(" ");
            if (moveParts.length != 2) {
                System.out.println("Invalid move format. Please try again.");
                continue;
            }
            String srcPos = moveParts[0];
            String destPos = moveParts[1];

            // Convert algebraic notation to row and column indices
            int srcRow = 8 - Character.getNumericValue(srcPos.charAt(1));
            int srcCol = srcPos.charAt(0) - 'a';
            int destRow = 8 - Character.getNumericValue(destPos.charAt(1));
            int destCol = destPos.charAt(0) - 'a';

            // Validate and make the move
            if (!makeMove(srcRow, srcCol, destRow, destCol)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Toggle player turn
            isBlackTurn = !isBlackTurn;

            // Display updated board
            board.showBoard();

            // Add logic for checkmate, stalemate, etc.
        }
    }

    // Method to make a move on the board
    private boolean makeMove(int srcRow, int srcCol, int destRow, int destCol) {
        Piece srcPiece = Board.board[srcRow][srcCol];

        // Check if the source position contains a piece
        if (srcPiece == null) {
            return false;
        }

        // Check if it's the correct player's turn
        if (srcPiece.isBlack != isBlackTurn) {
            return false;
        }

        // Check if the move is valid for the piece
        if (!srcPiece.canMove(destRow, destCol)) {
            return false;
        }

        // Move the piece
        srcPiece.move(destRow, destCol);

        return true;
    }

    public static void main(String[] args) {
        GameState game = new GameState();
        game.playGame();
    }
}

