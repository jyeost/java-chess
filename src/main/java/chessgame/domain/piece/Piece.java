package chessgame.domain.piece;

import chessgame.domain.Team;
import chessgame.domain.point.Point;

public interface Piece {

    boolean isMovable(Point source, Point target);

    Team team();

    String failMoveMsg();
}
