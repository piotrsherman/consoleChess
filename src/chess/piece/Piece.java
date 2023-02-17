package chess.piece;

import chess.Board;
import chess.Color;
import chess.Coordinates;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailibleMoveSquares(Board board){
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift shift : getPieceMoves()){
            if(coordinates.canShift(shift)){
                Coordinates newCoordinates = coordinates.shift(shift);

                if(isSquareAvailableForMove(newCoordinates, board)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        return board.isSquareEmply(coordinates) || board.getPiece(coordinates).color != color;
    }

    protected abstract Set<CoordinatesShift> getPieceMoves();
}
