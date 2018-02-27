package co.iyubinest.conway;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileWorldShould {
  @Test
  public void beacon() throws Exception {
    assertThat(
        FileWorld.create("beacon.txt")
            .next()
            .toString(),
        is(
            String.format(
                ""
                    + "      %n"
                    + " XX   %n"
                    + " X    %n"
                    + "    X %n"
                    + "   XX %n"
                    + "      "
            )
        )
    );
  }
}