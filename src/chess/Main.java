package chess;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.setupDefaultPiecesPositions();

        BoardConsoleRender renderer = new BoardConsoleRender();
        renderer.render(board);

        int a = 123;
    }
}
