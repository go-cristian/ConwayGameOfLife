package co.iyubinest.conway;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareMatrixShould {

  @Test public void be() {
    assertThat(
        new SquareMatrix(new Integer[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }).toString(),
        is(
            String.format(
                "123%n"
                    + "456%n"
                    + "789"
            )
        )
    );
  }

  @Test public void calculateNeightbors() {
    assertThat(
        new SquareMatrix(new Integer[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }).neightbors(1, 1),
        is(
            Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9)
        )
    );
  }

  @Test public void map() {
    assertThat(
        new SquareMatrix<>(new Integer[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }).map((x, y, number) -> number + 1),
        is(
            new SquareMatrix<>(new Integer[][] {
                {2, 3, 4},
                {5, 6, 7},
                {8, 9, 10}
            })
        )
    );
  }

  @Test public void buildeable() {
    assertThat(
        new SquareMatrix.Builder<>()
            .add(1).add(2).add(3).addLine()
            .add(4).add(5).add(6).addLine()
            .add(7).add(8).add(9).build(),
        is(
            new SquareMatrix<>(new Integer[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            })
        )
    );
  }
}
