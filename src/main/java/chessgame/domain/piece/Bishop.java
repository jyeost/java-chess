package chessgame.domain.piece;

import chessgame.domain.Team;
import chessgame.domain.point.Point;

public class Bishop implements Piece {
    private static final String ORIGINAL_NAME = "b";

    private final Team team;

    private Bishop(Team team) {
        this.team = team;
    }

    public static Bishop from(Team team) {
        return new Bishop(team);
    }

    @Override
    public String toString() {
        return team.calculate(ORIGINAL_NAME);
    }

    @Override
    public boolean isMovable(Point source, Point target) {
        return source.isDiagonal(target);
    }

    @Override
    public Team team() {
        return team;
    }

    @Override
    public String failMoveMsg() {
        return "비숍은 대각선으로만 이동할 수 있습니다.";
    }
}
