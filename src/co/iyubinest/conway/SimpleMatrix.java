package co.iyubinest.conway;

import java.util.ArrayList;
import java.util.List;

final class SimpleMatrix<T> implements Matrix<T> {

  private final SquareMatrix<T> matrix;

  SimpleMatrix(SquareMatrix<T> matrix) {
    this.matrix = matrix;
  }

  @Override public <R> Matrix<R> map(Map<T, R> map) {
    return matrix.map(map);
  }

  @Override public List<T> neightbors(int x, int y) {
    return matrix.neightbors(x, y);
  }

  static final class Builder<T> {

    private List<List<T>> elems = new ArrayList<>();

    public void add(T elem) {
      if (elems.size() == 0) {
        elems.add(new ArrayList<>());
      }
      List<T> xElems = elems.get(elems.size() - 1);
      xElems.add(elem);
    }

    public void addLine() {
      elems.add(new ArrayList<>());
    }

    public Matrix build() {
      int sizeY = elems.size();
      int sizeX = elems.get(0).size();
      T[][] matrix = (T[][]) new Object[sizeX][sizeY];
      for (int col = 0; col < sizeX; col++) {
        for (int row = 0; row < sizeY; row++) {
          matrix[col][row] = elems.get(col).get(row);
        }
      }
      return new SimpleMatrix<T>(new SquareMatrix(matrix));
    }
  }
}
