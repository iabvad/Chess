import java.sql.SQLOutput;

public class Board {
    public static Piece[][] board;

    public Board(){
        board = new Piece[8][8];
    }

    public void clearBoard(){
        board = new Piece[8][8];
    }
    public void newBoard(){
        Rook bR1 = new Rook(true, 7,0);
        Horse bH1 = new Horse(true, 7,1);
        Bishop bB1 = new Bishop(true, 7,2);
        Queen bQ1 = new Queen(true, 7,4);
        King bK1 = new King(true, 7,3);
        Bishop bB2 = new Bishop(true, 7,5);
        Horse bH2 = new Horse(true, 7,6);
        Rook bR2 = new Rook(true, 7,7);
        Pawn bP1 = new Pawn(true, 6,0);
        Pawn bP2 = new Pawn(true, 6,1);
        Pawn bP3 = new Pawn(true, 6,2);
        Pawn bP4 = new Pawn(true, 6,3);
        Pawn bP5 = new Pawn(true, 6,4);
        Pawn bP6 = new Pawn(true, 6,5);
        Pawn bP7 = new Pawn(true, 6,6);
        Pawn bP8 = new Pawn(true, 6,7);
// white board
        Rook wR1 = new Rook(false, 0,0);
        Horse wH1 = new Horse(false, 0,1);
        Bishop wB1 = new Bishop(false, 0,2);
        Queen wQ1 = new Queen(false, 0,4);
        King wK1 = new King(false, 0,3);
        Bishop wB2 = new Bishop(false, 0,5);
        Horse wH2 = new Horse(false, 0,6);
        Rook wR2 = new Rook(false, 0,7);
        Pawn wP1 = new Pawn(false, 1,0);
        Pawn wP2 = new Pawn(false, 1,1);
        Pawn wP3 = new Pawn(false, 1,2);
        Pawn wP4 = new Pawn(false, 1,3);
        Pawn wP5 = new Pawn(false, 1,4);
        Pawn wP6 = new Pawn(false, 1,5);
        Pawn wP7 = new Pawn(false, 1,6);
        Pawn wP8 = new Pawn(false, 1,7);
        board = new Piece[][]{{wR1, wH1 , wB1, wK1, wQ1, wB2, wH2, wR2},
                                {wP1, wP2, wP3, wP4, wP5, wP6, wP7, wP8},
                                {null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null},
                                {bP1, bP2, bP3, bP4, bP5, bP6, bP7, bP8},
                                {bR1, bH1, bB1, bK1, bQ1, bB2, bH2, bR2}};

    }

    public void showBoard(){
        System.out.println(" ---------------------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j< 8; j++) {
                System.out.print (" | ");
                if (board[ i ][ j ] != null) {
                    System.out.print (board[ i ][ j ].getSymbol ());

                } else {
                    System.out.print (" ");
                }
            }
            System.out.println(" | " + (8 - i));
            System.out.println(" ---------------------------------");
        }
        System.out.println("   a   b   c   d   e   f   g   h  ");

    }
}
