package chessgame.domain.piece;

import chessgame.domain.Team;
import chessgame.domain.point.Points;

public interface Piece {

    boolean isMovable(Points points, boolean isBlocked, boolean hasTarget);

    Team team();

    String failMoveMsg();

    double score(Team team, boolean hasPawn);

    boolean isPawn();

    boolean isKing();

    String name();
}
