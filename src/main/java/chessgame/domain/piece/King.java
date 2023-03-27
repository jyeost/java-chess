package chessgame.domain.piece;

import chessgame.domain.Team;
import chessgame.domain.point.Points;

public class King implements Piece {
    private static final String ORIGINAL_NAME = "k";
    private static final int DISTANCE = 1;

    private final Team team;

    private King(Team team) {
        this.team = team;
    }

    public static King from(Team team) {
        return new King(team);
    }

    @Override
    public boolean isMovable(Points points, boolean isBlocked, boolean hasTarget) {
        if (isBlocked) {
            throw new IllegalArgumentException("킹은 기물을 건너 뛸 수 없습니다.");
        }
        return isKingMove(points);
    }

    public boolean isKingMove(Points points) {
        if (points.isHorizontal() && points.isSameFileDistance(DISTANCE)) {
            return true;
        }
        if (points.isVertical() && points.isSameRankDistance(DISTANCE)) {
            return true;
        }
        return points.isDiagonal() && points.isSameFileDistance(DISTANCE);
    }

    @Override
    public String failMoveMsg() {
        return "킹은 상하좌우, 대각선으로 1칸만 이동 가능합니다.";
    }

    @Override
    public double score(Team team, boolean hasPawn) {
        return 0;
    }

    @Override
    public boolean isPawn() {
        return false;
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public Team team() {
        return team;
    }

    @Override
    public String toString() {
        return team.convertName(ORIGINAL_NAME);
    }

    @Override
    public String name() {
        return "king";
    }
}
