package co.iyubinest.conway;

import static co.iyubinest.conway.Cell.ALIVE;
import static co.iyubinest.conway.Cell.DEATH;

public class Game {
  public static void main(final String... args) throws Exception {
    World world = RealWorld.create(
        DEATH,DEATH,DEATH,DEATH,DEATH,DEATH,
        DEATH,ALIVE,ALIVE,DEATH,DEATH,DEATH,
        DEATH,ALIVE,DEATH,DEATH,DEATH,DEATH,
        DEATH,DEATH,DEATH,DEATH,ALIVE,DEATH,
        DEATH,DEATH,DEATH,ALIVE,ALIVE,DEATH,
        DEATH,DEATH,DEATH,DEATH,DEATH,DEATH
    );
    while (true) {
      System.out.println(world);
      System.out.println("======");
      Thread.sleep(100);
      world = world.next();
    }
  }
}
