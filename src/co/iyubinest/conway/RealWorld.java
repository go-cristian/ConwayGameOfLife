package co.iyubinest.conway;

import static co.iyubinest.conway.Cell.ALIVE;
import static co.iyubinest.conway.Cell.DEATH;

final class RealWorld implements World {

  static RealWorld create(final Cell... cells) {
    final int size = (int) Math.sqrt(cells.length);
    return new RealWorld(new SquareMatrix<>(cells));
  }

  private final Matrix<Cell> matrix;

  private RealWorld(final Matrix matrix) {
    this.matrix = matrix;
  }

  @Override public World next() {
    final Matrix newMatrix = matrix.map((x, y, cell) -> survival(x, y));
    return new RealWorld(newMatrix);
  }

  @Override public String toString() {
    return matrix.toString();
  }

  private Cell survival(final int x, final int y) {
    final Cell current = matrix.at(x, y);
    int aliveNearby = 0;
    aliveNearby = countNearbyAlives(x, y, aliveNearby);
    return valueFor(current, aliveNearby);
  }

  private Cell valueFor(Cell current, int aliveNearby) {
    if (current == ALIVE && aliveNearby < 2) {
      return DEATH;
    } else if (current == ALIVE && (aliveNearby == 2 || aliveNearby == 3)) {
      return ALIVE;
    } else if (current == ALIVE && aliveNearby > 3) {
      return DEATH;
    } else if (current == DEATH && aliveNearby == 3) {
      return ALIVE;
    } else {
      return DEATH;
    }
  }

  private int countNearbyAlives(int x, int y, int aliveNearby) {
    for (int row = y - 1; row <= y + 1; row++) {
      for (int col = x - 1; col <= x + 1; col++) {
        if (validCell(row, col) && notActualCell(x, y, row, col)) {
          Cell loopedCell = matrix.at(col, row);
          if (loopedCell == ALIVE) {
            aliveNearby++;
          }
        }
      }
    }
    return aliveNearby;
  }

  private boolean notActualCell(final int x, final int y, final int row, final int col) {
    return !actualCell(x, y, row, col);
  }

  private boolean actualCell(final int x, final int y, final int row, final int col) {
    return y == row && x == col;
  }

  private boolean validCell(final int row, final int col) {
    return row >= 0 &&
        row < matrix.size(Matrix.SIZE.VERTICAL) &&
        col >= 0 &&
        col < matrix.size(Matrix.SIZE.HORIZONTAL);
  }
}
