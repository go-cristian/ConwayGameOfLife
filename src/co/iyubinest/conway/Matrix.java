package co.iyubinest.conway;

import java.util.List;

interface Matrix<T> {

  enum SIZE {
    HORIZONTAL,
    VERTICAL
  }

  interface Map<T, R> {

    R apply(int x, int y, T object);
  }

  <R> Matrix<R> map(Map<T, R> map);

  List<T> neightbors(int x, int y);
}