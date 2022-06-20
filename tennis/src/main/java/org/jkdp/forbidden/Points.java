package org.jkdp.forbidden;

import lombok.Getter;

@Getter
public enum Points {
  LOVE(0),
  FIFTEEN(15),
  THIRTY(30),
  FOURTY(40);

  private int value;

  Points(int value) {
    this.value = value;
  }
}
