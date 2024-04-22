import org.junit.Test;
import static org.junit.Assert.*;

public class ChessTest {
    @Test
    public void testRookCanMoveHorizontally() {
        // Create a new board with a rook at position (0, 0)

        Board board = new Board();
        Rook rook = new Rook(true, 0, 0);
        // Test if the rook can move to position (0, 1)
        assertEquals(true, rook.canMove(0, 1));

        // Test if the rook can move to position (0, 7)
        assertEquals(true, rook.canMove(0, 7));

        // Test if the rook cannot move to position (1, 0)
        assertEquals(true, rook.canMove(1, 0));

        // Test if the rook cannot move to position (2, 0)
        assertEquals(true, rook.canMove(2, 0));
    }

    @Test
    public void testRookCanMoveVertically() {
        // Create a new board with a rook at position (0, 0)
        Board yo = new Board();
        yo.newBoard();
        Rook rook = (Rook) Board.board[0][0];
        Board.board[1][0].move(3,0);
        Board.board[3][0].move(4,0);
        Board.board[4][0].move(5,0);

        // Test if the rook can move to position (1, 0)
        assertEquals(true, rook.canMove(1, 0));

        // Test if the rook can move to position (7, 0)
        assertEquals(true, rook.canMove(4, 0));

        // Test if the rook cannot move to position (0, 1)
        assertEquals(false, rook.canMove(0, 1));

        // Test if the rook cannot move to position (0, 2)
        assertEquals(false, rook.canMove(0, 2));
    }

    @Test
    public void testRookCannotMoveDiagonally() {
        Board board = new Board();
        board.newBoard();
        Rook rook = new Rook(true, 0, 0);
        assertFalse(rook.canMove(3, 3)); // Diagonal move
    }

    @Test
    public void testPawnCanMoveTwoStepsFromStartingPosition() {
        Board board = new Board();
        board.newBoard();
        assertTrue(Board.board[1][0].canMove(3, 0)); // Two-step move from starting position
        assertTrue(Board.board[6][0].canMove(4, 0)); // Two-step move from starting position
    }

    @Test
    public void testPawnCanMoveOneStep() {
        Board board = new Board();
        board.newBoard();
        assertTrue(Board.board[1][0].canMove(2, 0)); // One-step move
    }

    @Test
    public void testPawnCannotMoveTwoStepsFromNonStartingPosition() {
        Board board = new Board();
        board.newBoard();
        Pawn pawn = new Pawn(true, 2, 0);
        assertFalse(pawn.canMove(4, 0)); // Two-step move from non-starting position
    }

    @Test
    public void testPawnCannotMoveDiagonallyWithoutCapturing() {
        Board board = new Board();
        board.newBoard();
        Pawn pawn = new Pawn(true, 1, 0);
        assertFalse(pawn.canMove(2, 1)); // Diagonal move without capturing
    }

    @Test
    public void testPawnCantMoveBackwards() {
        Board board = new Board();
        board.newBoard();
        Board.board[1][0].move(3,0);
        assertFalse(Board.board[3][0].canMove(2, 0)); // Backwards
    }
    @Test
    public void testQueenCanMoveDiagonally() {
        Board board = new Board();
        Queen queen = new Queen(true, 0, 3);
        assertTrue(queen.canMove(3, 6)); // Diagonal move
    }

    @Test
    public void testKingCanMoveOneStepInAnyDirection() {
        Board board = new Board();
        King king = new King(true, 0, 4);
        assertTrue(king.canMove(1, 4)); // One-step move vertically
        assertTrue(king.canMove(0, 5)); // One-step move horizontally
        assertTrue(king.canMove(1, 5)); // One-step move diagonally
    }

    @Test
    public void testKnightCanMoveInLShape() {
        Board board = new Board();
        board.newBoard();
        Horse horse = new Horse(true, 0, 1);
        assertTrue(horse.canMove(2, 0)); // L-shape move
    }

    @Test
    public void testBishopCanMoveDiagonally() {
        Board board = new Board();
        Bishop bishop = new Bishop(true, 0, 2);
        assertTrue(bishop.canMove(2, 4)); // Diagonal move in the correct direction
    }

    @Test
    public void testKingInCheck() {
        Board board = new Board();
        board.newBoard();
        King king = new King(false,5 , 0);
        Board.board[5][0] = king;
        assertTrue(king.isInCheck()); // Diagonal move in the correct direction
    }

    @Test
    public void testKingIsNotInCheck() {
        Board board = new Board();
        board.newBoard();
        King king = new King(false,0 , 3);
        Board.board[0][3] = king;
        assertFalse(((King)Board.board[0][3]).isInCheck()); // King in check at start of game
    }

    @Test
    public void testKingIsInCheckmate() {
        Board board = new Board();
        board.newBoard();
        King king = new King(false,4 , 0);
        Board.board[4][0] = king;
        Queen q1 = new Queen(true,4 , 1);
        Board.board[4][1] = q1;
        Queen q2 = new Queen(true,3 , 0);
        Board.board[3][0] = q2;
        Queen q3 = new Queen(true,5 , 0);
        Board.board[5][0] = q3;
        assertTrue(((King)Board.board[4][0]).isCheckmate()); // King in check at start of game
    }
}