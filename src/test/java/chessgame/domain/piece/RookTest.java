package chessgame.domain.piece;

import static chessgame.domain.point.PointFixture.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chessgame.domain.Team;
import chessgame.domain.point.Points;

class RookTest {

    @Test
    @DisplayName("Rook은 수평으로 움직일 수 있다")
    void Should_Move_When_Horizontal() {
        Rook rook = Rook.from(Team.BLACK);
        boolean result = rook.isMovable(new Points(List.of(A1, F1)), false, false);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Rook은 수직으로 움직일 수 있다")
    void Should_Move_When_Vertical() {
        Rook rook = Rook.from(Team.BLACK);
        boolean result = rook.isMovable(new Points(List.of(F1, F8)), false, false);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Rook의 이동정책에 맞지 않으면, Rook은 움직일 수 없다.")
    void Should_NotMove_When_Unmovable() {
        Rook rook = Rook.from(Team.BLACK);
        boolean result = rook.isMovable(new Points(List.of(A1, F8)), false, false);
        Assertions.assertThat(result).isFalse();
    }
}