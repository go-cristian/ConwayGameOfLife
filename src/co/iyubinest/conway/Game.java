package co.iyubinest.conway;

public class Game {
  public static void main(final String... args) throws Exception {
    World world = FileWorld.create("beacon.txt");
    while (true) {
      System.out.println(world);
      System.out.println("======");
      Thread.sleep(100);
      world = world.next();
    }
  }
}
