package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position auxP = new Position(0, 0);


        //above
        auxP.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
            mat[auxP.getRow()][auxP.getColumn()] = true;
            auxP.setRow(auxP.getRow() - 1);
        }
        if(getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)){
            mat[auxP.getRow()][auxP.getColumn()] = true;
        }

        //left
        auxP.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
            mat[auxP.getRow()][auxP.getColumn()] = true;
            auxP.setColumn(auxP.getColumn() - 1);
        }
        if(getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)){
            mat[auxP.getRow()][auxP.getColumn()] = true;
        }

        //right
        auxP.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
            mat[auxP.getRow()][auxP.getColumn()] = true;
            auxP.setColumn(auxP.getColumn() + 1);
        }
        if(getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)){
            mat[auxP.getRow()][auxP.getColumn()] = true;
        }

        //below
        auxP.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(auxP) && !getBoard().thereIsAPiece(auxP)) {
            mat[auxP.getRow()][auxP.getColumn()] = true;
            auxP.setRow(auxP.getRow() + 1);
        }
        if(getBoard().positionExists(auxP) && isThereOpponentPiece(auxP)){
            mat[auxP.getRow()][auxP.getColumn()] = true;
        }
        return mat;
    }
}

