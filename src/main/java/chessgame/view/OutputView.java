package chessgame.view;

import java.util.Map;

import chessgame.domain.Board;
import chessgame.domain.piece.Piece;
import chessgame.domain.point.Point;

public class OutputView {
    public void printChessBoard(Board board) {
        int count = 0;
        Map<Point, Piece> chessBoard = board.getBoard();
        for(Point point : board.getBoard().keySet()){
            Piece value = chessBoard.get(point);
            printPiece(value, ++count);
        }
    }

    private void printPiece(Piece value,int count) {
        if(value ==null){
            System.out.print(".");
        }
        if(value != null) {
            System.out.print(value);
        }
        if(count % 8 ==0)  {
            System.out.println();
        }
    }
}