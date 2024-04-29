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
    public void testRookCannotTakeOwnPiece() {
        Board board = new Board();
        board.newBoard();
        assertFalse(Board.board[0][0].canMove(1, 0));
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
    public void testPawnCannotCaptureVertically() {
        Board board = new Board();
        board.newBoard();
        Pawn pawn = new Pawn(true, 1, 0);
        Pawn pawn2 = new Pawn(false, 2, 0);
        assertFalse(pawn.canMove(2, 0)); //  Vertical move
    }
    @Test
    public void testPawnCantMoveBackwards() {
        Board board = new Board();
        board.newBoard();
        Board.board[1][0].move(3,0);
        assertFalse(Board.board[3][0].canMove(2, 0)); // Backwards
    }

    @Test
    public void testPawnCantTakeOwnPiece() {
        Board board = new Board();
        board.newBoard();
        Board.board[1][0].move(2, 0);
        assertFalse((Board.board[1][1].canMove(2, 0))); // Pawn cannot be taken by own color
    }
    @Test
    public void testQueenCanMoveDiagonally() {
        Board board = new Board();
        Queen queen = new Queen(true, 0, 3);
        assertTrue(queen.canMove(3, 6)); // Diagonal move
    }

    @Test
    public void testQueenCanMoveHorizontally() {
        Board board = new Board();
        Queen queen = new Queen(true, 0, 3);
        assertTrue(queen.canMove(0, 6)); // Horizontal move
    }

    @Test
    public void testQueenCanMoveVertically() {
        Board board = new Board();
        Queen queen = new Queen(true, 0, 3);
        assertTrue(queen.canMove(2, 3)); // Vertical move
    }

    @Test
    public void testQueenCantPerformIllegalMoves() {
        Board board = new Board();
        Queen queen = new Queen(true, 0, 3);
        assertFalse(queen.canMove(2, 2));
        assertFalse(queen.canMove(7, 4));
    }

    @Test
    public void testQueenCantTakeOwnPiece() {
        Board board = new Board();
        board.newBoard();
        assertFalse(Board.board[0][4].canMove(1, 4));
        assertFalse(Board.board[0][4].canMove(0, 5));
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
    public void testKingCantPerformIllegalMoves() {
        Board board = new Board();
        King king = new King(true, 0, 4);
        assertFalse(king.canMove(3, 4));
        assertFalse(king.canMove(2, 7));
        assertFalse(king.canMove(2, 2));
    }

    @Test
    public void testKingCantTakeOwnPiece() {
        Board board = new Board();
        board.newBoard();
        assertFalse(Board.board[0][3].canMove(1, 3));
        assertFalse(Board.board[0][3].canMove(0, 2));
        assertFalse(Board.board[0][3].canMove(0, 4));
    }

    @Test
    public void testKnightCanMoveInLShape() {
        Board board = new Board();
        board.newBoard();
        Horse horse = new Horse(true, 0, 1);
        assertTrue(horse.canMove(2, 0)); // L-shape move
    }

    @Test
    public void testKnightCantMoveVertically() {
        Board board = new Board();
        board.newBoard();
        Horse horse = new Horse(true, 0, 1);
        assertFalse(horse.canMove(1, 1));
    }

    @Test
    public void testKnightCantMoveHorizontally() {
        Board board = new Board();
        board.newBoard();
        Horse horse = new Horse(true, 0, 1);
        assertFalse(horse.canMove(0, 3));
    }

    @Test
    public void testKnightCantTakeOwnPiece() {
        Board board = new Board();
        board.newBoard();
        assertFalse(Board.board[0][1].canMove(1, 3));
    }

    @Test
    public void testBishopCanMoveDiagonally() {
        Board board = new Board();
        Bishop bishop = new Bishop(true, 0, 2);
        assertTrue(bishop.canMove(2, 4)); // Diagonal move in the correct direction
    }

    @Test
    public void testBishopCantMoveHorizontally() {
        Board board = new Board();
        Bishop bishop = new Bishop(true, 0, 2);
        assertFalse(bishop.canMove(0, 4));
    }

    @Test
    public void testBishopCanMoveVertically() {
        Board board = new Board();
        Bishop bishop = new Bishop(true, 0, 2);
        assertFalse(bishop.canMove(3, 2));
    }

    @Test
    public void testBishopCantCaptureOwnPiece() {
        Board board = new Board();
        board.newBoard();

        assertFalse(Board.board[0][2].canMove(1, 1));
    }

}