package org.jkdp;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void toyCount() {
    var toys = new int[] {1, 12, 5, 111, 200, 1000, 10};
    var budget = 50;

    var result = Solution.toyCount(toys.length, budget, toys);

    assertThat(result).isEqualTo(4);
  }
}
