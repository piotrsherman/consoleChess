package chess.piece;

import chess.Board;
import chess.BoardUtils;
import chess.Color;
import chess.Coordinates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends LongRangePiece implements IBishop{

    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {

        return getBishopMoves();
    }
}
