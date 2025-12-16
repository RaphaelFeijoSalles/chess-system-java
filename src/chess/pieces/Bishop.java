package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.enums.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        int[][] bishopDirections = {
                {-1, -1}, // diagonal superior-esquerda
                {-1,  1}, // diagonal superior-direita
                { 1, -1}, // diagonal inferior-esquerda
                { 1,  1}  // diagonal inferior-direita
        };

        addLinearMoves(mat, bishopDirections);

        return mat;
    }

    public String toString(){
        return "B";
    }
}
