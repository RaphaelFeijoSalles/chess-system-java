package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.enums.Color;

public class Knight extends ChessPiece {

    private static final int[][] KNIGHT_MOVES = {
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
    };

    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        for (int[] d : KNIGHT_MOVES) {
            Position aux = new Position(position.getRow() + d[0], position.getColumn() + d[1]);

            if (canMove(aux)) {
                mat[aux.getRow()][aux.getColumn()] = true;
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "N";
    }
}

