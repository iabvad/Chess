public class Board {
    public static Piece[][] board;

    public Board(){
        board = new Piece[8][8];
    }

    public void newBoard(){
        Rook bR1 = new Rook(true, 0,0);
        Horse bH1 = new Horse(true, 0,1);
        Bishop bB1 = new Bishop(true, 0,2);
        Queen bQ1 = new Queen(true, 0,3);
        King bK1 = new King(true, 0,4);
        Bishop bB2 = new Bishop(true, 0,5);
        Horse bH2 = new Horse(true, 0,6);
        Rook bR2 = new Rook(true, 0,7);
        Pawn bP1 = new Pawn(true, 1,0);
        Pawn bP2 = new Pawn(true, 1,1);
        Pawn bP3 = new Pawn(true, 1,2);
        Pawn bP4 = new Pawn(true, 1,3);
        Pawn bP5 = new Pawn(true, 1,4);
        Pawn bP6 = new Pawn(true, 1,5);
        Pawn bP7 = new Pawn(true, 1,6);
        Pawn bP8 = new Pawn(true, 1,7);
// white board
        Rook wR1 = new Rook(false, 0,0);
        Horse wH1 = new Horse(false, 0,1);
        Bishop wB1 = new Bishop(false, 0,2);
        Queen wQ1 = new Queen(false, 0,3);
        King wK1 = new King(false, 0,4);
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
        board = {{bR1, bH1 , bB1, bQ1, bK1, bB2, bH2, bR2},
                {bP1, bP2, bP3, bP4, bP5, bP6, bP7, bP8},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {wP1, wP2, wP3, wP4, wP5, wP6, wP7, wP8},
                {wR1, wH1, wB1, wQ1, wK1, wB2, wH2, wR2}};

    }

    public void showBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j< 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getSymbol());
                }
            }
            System.out.println();
        }
    }
}
