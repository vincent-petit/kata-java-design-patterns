package org.jkdp;

import java.util.Arrays;

public class Solution {
  public static int toyCount(int size, int budget, int[] toys) {
    //compter le nb de toys
    //deduire du budget

    // sort asc
    Arrays.stream(toys).sorted().reduce(0, (a, b) -> 0);

    return 0;
  }
}
