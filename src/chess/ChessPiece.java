package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.enums.Color;

public abstract class ChessPiece extends Piece {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void increaseMoveCount(){
        moveCount++;
    }


    public void decreaseMoveCount(){
        moveCount--;
    }

    public int getMoveCount(){
        return moveCount;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().getPiece(position);
        return p!= null && p.getColor() != color;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected void addLinearMoves(boolean[][] mat, int[][] directions) {
        for (int[] d : directions) {
            Position aux = new Position(position.getRow() + d[0], position.getColumn() + d[1]);

            // enquanto a posição existe e é vazia
            while (getBoard().positionExists(aux) && !getBoard().thereIsAPiece(aux)) {
                mat[aux.getRow()][aux.getColumn()] = true;
                aux.setValues(aux.getRow() + d[0], aux.getColumn() + d[1]);
            }

            // se parar numa posição válida e for peça adversária, marca
            if (getBoard().positionExists(aux) && isThereOpponentPiece(aux)) {
                mat[aux.getRow()][aux.getColumn()] = true;
            }
        }
    }

    protected void addSingleStepMoves(boolean[][] mat, int[][] directions){
        for(int[] d: directions){
            Position aux = new Position(
                    position.getRow() + d[0],
                    position.getColumn() + d[1]
            );

            if(getBoard().positionExists(aux) &&
                (!getBoard().thereIsAPiece(aux)|| isThereOpponentPiece(aux))
            ) {
                mat[aux.getRow()][aux.getColumn()] = true;
            }


        }
    }

}
