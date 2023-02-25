package chess;

import chess.piece.Piece;

import java.util.Set;

public class BoardConsoleRender {

    public static final String ANSI_RESET = "\u001B";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";
    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "u\001B[47m";
     public void render(Board board, Piece pieceToMove){
         Set<Coordinates> availableMoveSquares = pieceToMove.getAvailibleMoveSquares(board);
         for(int rank = 8; rank >= 1; rank--){
             String line = "";
             for(File file : File.values()){
                Coordinates coordinates = new Coordinates (file, rank);
                boolean isHighlight = availableMoveSquares.contains(coordinates);
                if (board.isSquareEmpty(coordinates)){
                    line += getSpriteForEmptySquare(coordinates, isHighlight);
                } else{
                    line += getPieceSprite(board.getPiece(coordinates), isHighlight);
                }
             }

             line += ANSI_RESET;
             System.out.println(line);
         }
     }

     private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighlighted){
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if(isHighlighted){
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        }
        else if(isSquareDark){
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
     }

     private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighlight){
         return colorizeSprite("   ", Color.WHITE, Board.isSqareDark(coordinates), isHighlight);
     }

     private String selectUnicodeSpriteForPiece(Piece piece){
         switch (piece.getClass().getSimpleName()){
             case "Pawn":
                 return "♟︎";

             case "Knight":
                 return "♞";

             case "Bishop":
                 return "♝";

             case "Rook":
                 return "♜";

             case "Queen":
                 return "♛";

             case "King":
                 return "♚";
         }
         return "";
     }

     private String getPieceSprite(Piece piece, boolean isHighlight){
         return colorizeSprite(
                 " " + selectUnicodeSpriteForPiece(piece) + " ", piece.color, Board.isSqareDark(piece.coordinates),
                 isHighlight);
     }
}
