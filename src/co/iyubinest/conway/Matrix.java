package co.iyubinest.conway;

import java.util.List;

interface Matrix<T> {

  enum SIZE {
    HORIZONTAL,
    VERTICAL;
  }

  int size(SIZE size);

  interface Map<T, R> {

    R apply(int x, int y, T object);
  }

  T at(int x, int y);

  <R> Matrix<R> map(Map<T, R> map);

  List<T> neightbors(int x, int y);
}