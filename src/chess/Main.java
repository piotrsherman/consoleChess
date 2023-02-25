package chess;

import chess.piece.BoardFactory;
 import chess.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args){
        Board board = (new BoardFactory()).fromFEN(
                //"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBOKBNR w KQkq - 0 1"
                "3k4/8/5n2/2N5/3B4/8/8/3K4 w - - 0 1"
        );

        BoardConsoleRender renderer = new BoardConsoleRender();
        renderer.render(board);
    }
}
