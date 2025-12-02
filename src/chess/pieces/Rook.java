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

        int[][] rookDirections = {
                {-1, 0}, // cima
                {1, 0},  // baixo
                {0, -1}, // esquerda
                {0, 1}   // direita
        };

        addLinearMoves(mat, rookDirections);

        return mat;
    }

}

