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

            currentRow = srcPos.charAt(1);


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

            desiredRow = destPos.charAt(1);

            // Validate and make the move
            if (!makeMove(currentRow, currentCol, desiredRow, desiredCol)) {
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

