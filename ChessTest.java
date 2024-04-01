import org.junit.Test;
import static org.junit.Assert.*;

public class ChessTest {
    @Test
public void testRookCanMoveHorizontally() {
    Board board = new Board();
    board.newBoard();
    Rook rook = new Rook(true, 0, 0);
    assertTrue(rook.canMove(0, 3)); // Horizontal move
}

    @Test
    public void testRookCanMoveVertically() {
        Board board = new Board();
        board.newBoard();
        Rook rook = new Rook(true, 0, 0);
        assertTrue(rook.canMove(3, 0)); // Vertical move
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
        Pawn pawn = new Pawn(true, 1, 0);
        assertTrue(pawn.canMove(3, 0)); // Two-step move from starting position
    }

    @Test
    public void testPawnCanMoveOneStep() {
        Board board = new Board();
        board.newBoard();
        Pawn pawn = new Pawn(true, 1, 0);
        assertTrue(pawn.canMove(2, 0)); // One-step move
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
    public void testQueenCanMoveDiagonally() {
        Board board = new Board();
        board.newBoard();
        Queen queen = new Queen(true, 0, 3);
        assertTrue(queen.canMove(3, 6)); // Diagonal move
    }

    @Test
    public void testKingCanMoveOneStepInAnyDirection() {
        Board board = new Board();
        board.newBoard();
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
        board.newBoard();
        Bishop bishop = new Bishop(true, 0, 2);
        assertTrue(bishop.canMove(2, 0)); // Diagonal move
    }
}