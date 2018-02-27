package co.iyubinest.conway;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

final class FileWorld implements World {

  private final World world;

  private FileWorld(String filename) throws IOException {
    world = MatrixWorld.create(contentOf(filename));
  }

  static World create(String filename) throws IOException {
    return new FileWorld(filename);
  }

  private static Matrix contentOf(String filename) throws IOException {
    final SimpleMatrix.Builder<Cell> builder = new SimpleMatrix.Builder<>();
    List<String> lines = Files.readAllLines(Paths.get(filename));
    for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
      String line = lines.get(lineIndex);
      for (int index = 0; index < line.length(); index++) {
        Character character = line.charAt(index);
        switch (character) {
          case '-':
            builder.add(Cell.DEATH);
            break;
          case 'X':
            builder.add(Cell.ALIVE);
            break;
          default:
            break;
        }
      }
      if (lastLine(lines, lineIndex)) {
        builder.addLine();
      }
    }
    return builder.build();
  }

  private static boolean lastLine(List<String> lines, int lineIndex) {
    return lineIndex != lines.size() - 1;
  }

  @Override public World next() {
    return world.next();
  }
}
