package co.iyubinest.conway;

import java.util.Arrays;
import java.util.Iterator;

final class SquareMatrix<T> implements Matrix<T> {

  private static final String LINE_BREAK = String.format("%n");
  private final T[][] matrix;

  SquareMatrix(final T[] elements) {
    this(matrixFrom(elements));
  }

  SquareMatrix(final T[][] matrix) {
    this.matrix = matrix;
  }

  @Override public int size(final SIZE size) {
    switch (size) {
      case VERTICAL:
        return matrix.length;
      case HORIZONTAL:
        return matrix[0].length;
      default:
        throw new IllegalArgumentException("Not valid size");
    }
  }

  @Override public T at(final int x, final int y) {
    return matrix[y][x];
  }

  @Override public <R> Matrix<R> map(final Map<T, R> map) {
    int size = this.matrix.length;
    R[][] newMatrix = (R[][]) new Object[size][size];
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        newMatrix[row][col] = map.apply(col, row, matrix[row][col]);
      }
    }
    return new SquareMatrix(newMatrix);
  }

  @Override public String toString() {
    StringBuilder builder = new StringBuilder();
    for (T[] array : matrix) {
      for (T elem : array) {
        builder.append(elem.toString());
      }
      builder.append(LINE_BREAK);
    }
    builder.deleteCharAt(builder.length() - 1);
    return builder.toString();
  }

  private static <T> T[][] matrixFrom(final T[] elements) {
    int size = (int) Math.sqrt(elements.length);
    T[][] matrix = (T[][]) new Object[size][size];
    Iterator<T> iterator = Arrays.asList(elements).iterator();
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        matrix[row][col] = iterator.next();
      }
    }
    return matrix;
  }
}