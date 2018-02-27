package co.iyubinest.conway;

final class MatrixWorld implements World {

  private final Matrix<Cell> matrix;

  private MatrixWorld(final Matrix matrix) {
    this.matrix = matrix;
  }

  static MatrixWorld create(final Cell... cells) {
    final int size = (int) Math.sqrt(cells.length);
    return MatrixWorld.create(new SquareMatrix<>(cells));
  }

  static MatrixWorld create(final Matrix matrix) {
    return new MatrixWorld(matrix);
  }

  @Override public World next() {
    final Matrix newMatrix = matrix.map((x, y, cell) -> cell.evolve(matrix.neightbors(x, y)));
    return new MatrixWorld(newMatrix);
  }

  @Override public String toString() {
    return matrix.toString();
  }
}
