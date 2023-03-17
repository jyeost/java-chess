package chessgame.domain.piece;

import chessgame.domain.Team;
import chessgame.domain.point.Point;

public class Queen implements Piece {
    private static final String ORIGINAL_NAME = "q";

    private final Team team;

    private Queen(Team team) {
        this.team = team;
    }

    public static Queen from(Team team) {
        return new Queen(team);
    }

    @Override
    public Team team() {
        return team;
    }

    @Override
    public boolean isMovable(Point source, Point target) {
        return source.isHorizontal(target) || source.isVertical(target) || source.isDiagonal(target);
    }

    @Override
    public String failMoveMsg() {
        return "퀸은 상하좌우, 대각선으로만 이동 가능합니다.";
    }

    @Override
    public String toString() {
        return team.calculate(ORIGINAL_NAME);
    }
}
