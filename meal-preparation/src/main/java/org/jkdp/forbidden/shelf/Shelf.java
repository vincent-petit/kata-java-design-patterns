package org.jkdp.forbidden.shelf;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Shelf {
  private File sourceFile;

  public void getOne(String input) throws IOException {
    var linesBefore = Files.readAllLines(sourceFile.toPath());
    var linesAfter = new ArrayList<String>();
    var found = false;
    for (String line: linesBefore) {
      var splitted = line.split(";");
      if (input.equals(splitted[0])) {
        var qty = Integer.valueOf(splitted[1]);
        if(qty <= 0){throw new ShelfException("No more " + input);}
        linesAfter.add(splitted[0] + ";" + (qty - 1));
        found = true;
      } else {
        linesAfter.add(line);
      }
    }
    if(!found){throw new ShelfException(input + " was not found");}
    Files.write(sourceFile.toPath(), linesAfter, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
  }

}
