package chess.piece;

import chess.Board;
import chess.BoardUtils;
import chess.Color;
import chess.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rook extends LongRangePiece implements IRook{
    public Rook(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        return getRookMoves();
    }
}
