package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.enums.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        int[][] kingDirections = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1},  {1, 0}, { 1, 1}
        };

        //specialmove castling
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            //specialmove castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if(getBoard().getPiece(p1) == null && getBoard().getPiece(p2) == null){
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            //specialmove castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if(testRookCastling(posT2)){
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);

                if(getBoard().getPiece(p1) == null && getBoard().getPiece(p2) == null && getBoard().getPiece(p3) == null){
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        addSingleStepMoves(mat, kingDirections);

        return mat;
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().getPiece(position);
        return p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }
}
