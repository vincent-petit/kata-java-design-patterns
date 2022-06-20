package org.jkdp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jkdp.forbidden.PlayerName.DJOKOVIC;
import static org.jkdp.forbidden.PlayerName.NADAL;

import org.junit.jupiter.api.Test;

class SetTest {

  //Bobby's test

  @Test
  void ballScored_nadal3andDjokovic1_NADAL40DJOKOVIC15() {
    Set set = new Set();
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    var result = set.ballScored(DJOKOVIC);
    assertThat(result).isEqualTo("NADAL 40 / DJOKOVIC 15");
  }

  //Tammy's tests below, these do not work yet !

  @Test
  void ballScored_nadal0andDjokovic1_NADAL0DJOKOVIC15() {
    Set set = new Set();
    var result = set.ballScored(DJOKOVIC);
    assertThat(result).isEqualTo("NADAL 0 / DJOKOVIC 15");
  }

  @Test
  void ballScored_nadal3andDjokovic3_DEUCE() {
    Set set = new Set();
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(DJOKOVIC);
    set.ballScored(DJOKOVIC);
    var result = set.ballScored(DJOKOVIC);
    assertThat(result).isEqualTo("DEUCE");
  }

  @Test
  void ballScored_nadal3andDjokovic4_NADAL40DJOKOVIC40A() {
    Set set = new Set();
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(DJOKOVIC);
    set.ballScored(DJOKOVIC);
    set.ballScored(DJOKOVIC); //deuce
    var result = set.ballScored(DJOKOVIC);
    assertThat(result).isEqualTo("NADAL 40 / DJOKOVIC 40 (A)");
  }

  @Test
  void ballScored_nadal3andDjokovic4andNadal1_NADAL40ADJOKOVIC40() {
    Set set = new Set();
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(DJOKOVIC);
    set.ballScored(DJOKOVIC);
    set.ballScored(DJOKOVIC); //deuce
    set.ballScored(DJOKOVIC); // Av Djokovic
    set.ballScored(NADAL); //deuce
    var result = set.ballScored(NADAL);
    assertThat(result).isEqualTo("NADAL 40 (A) / DJOKOVIC 40");
  }

  @Test
  void ballScored_nadal4andDjokovic0_NADALWON() {
    Set set = new Set();
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    set.ballScored(NADAL);
    var result = set.ballScored(NADAL);
    assertThat(result).isEqualTo("NADAL WON");
  }
}
