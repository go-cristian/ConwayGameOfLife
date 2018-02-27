package co.iyubinest.conway;

import java.util.List;

enum Cell {
  DEATH,
  ALIVE;

  private static final String EMPTY = " ";
  private static final String VALUE = "X";

  @Override public String toString() {
    switch (this) {
      case DEATH:
        return EMPTY;
      case ALIVE:
        return VALUE;
      default:
        throw new IllegalArgumentException("Not supported value");
    }
  }

  Cell evolve(List<Cell> neightbors) {
    int nearbyAlive = 0;
    for (Cell cell : neightbors) {
      if (cell == ALIVE) {
        nearbyAlive++;
      }
    }
    return rules(nearbyAlive);
  }

  private Cell rules(int aliveNearby) {
    if (this == ALIVE && aliveNearby < 2) {
      return DEATH;
    } else if (this == ALIVE && (aliveNearby == 2 || aliveNearby == 3)) {
      return ALIVE;
    } else if (this == ALIVE && aliveNearby > 3) {
      return DEATH;
    } else if (this == DEATH && aliveNearby == 3) {
      return ALIVE;
    } else {
      return DEATH;
    }
  }
}
