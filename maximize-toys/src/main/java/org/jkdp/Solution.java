package org.jkdp;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
  public static int toyCount(int size, int budget, int[] toys) {
    var consumedBudget = new AtomicInteger(0);
    return (int) Arrays.stream(toys).sorted().takeWhile(toyPrice -> budget >= consumedBudget.addAndGet(toyPrice)).count();
  }

}

