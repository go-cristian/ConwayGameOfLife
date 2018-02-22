package co.iyubinest.conway;

enum Cell {
  DEATH,
  ALIVE;

  private static final String NONE = "";
  private static final String EMPTY = " ";
  private static final String VALUE = "X";

  @Override public String toString() {
    switch (this) {
      case DEATH:
        return EMPTY;
      case ALIVE:
        return VALUE;
      default:
        return NONE;
    }
  }
}
