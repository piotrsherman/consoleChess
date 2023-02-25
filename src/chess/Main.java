package chess;

import chess.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.setupDefaultPiecesPositions();

        //int a = 123;

        Game game = new Game(board);
        game.gameLoop();
    }
}
