package org.jkdp.forbidden.shelf;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class ShelfTest {

  @Test
  @SneakyThrows
  void getOne() {
    File sourceFile = manufactureStartingStock();
    Shelf shelf = new Shelf(sourceFile);

    shelf.getOne("ONION");

    assertThat(Files.readAllLines(sourceFile.toPath())).containsExactly("SALT;999","ONION;9");
  }

  private File manufactureStartingStock() throws IOException {
    var startingStock = List.of("SALT;999","ONION;10");
    File sourceFile = File.createTempFile("shelf", ".txt");
    Files.write(sourceFile.toPath(), startingStock, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    return sourceFile;
  }
}
