package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.enums.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        int[][] queenDirections = {
                // direções da torre
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                // direções do bispo
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        addLinearMoves(mat, queenDirections);

        return mat;
    }

    public String toString(){
        return "Q";
    }
}
