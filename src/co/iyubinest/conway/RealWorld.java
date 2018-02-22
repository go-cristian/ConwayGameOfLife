package co.iyubinest.conway;

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
    final Matrix newMatrix = matrix.map((x, y, cell) -> cell.evolve(matrix.neightbors(x, y)));
    return new RealWorld(newMatrix);
  }

  @Override public String toString() {
    return matrix.toString();
  }
}
