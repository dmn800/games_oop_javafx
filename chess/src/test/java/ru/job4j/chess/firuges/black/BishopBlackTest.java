package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static ru.job4j.chess.firuges.Cell.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenEqualsPosition() {
        BishopBlack bishopBlack = new BishopBlack(A2);
        Cell ps = bishopBlack.position();
        assertThat(ps).isEqualTo(A2);
    }

    @Test
    public void whenEqualsCopy() {
        BishopBlack bishopBlack = new BishopBlack(B1);
        Figure bishopCopy = bishopBlack.copy(H7);
        assertThat(bishopCopy.position()).isEqualTo(H7);
    }

    @Test
    public void whenEqualsWay() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] bishopWay = bishopBlack.way(G5);
        Cell[] extend = {D2, E3, F4, G5};
        assertThat(bishopWay).isEqualTo(extend);
    }

    @Test
    public void whenIsNotDiagonalException() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell source = bishopBlack.position();
        Cell dest = H7;
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(dest)
        );
        String expected = String.format("Could not way by diagonal from %s to %s", source, dest);
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}