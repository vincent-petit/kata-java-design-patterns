package org.jkdp;

import org.jkdp.forbidden.PlayerName;
import org.jkdp.state.InProgressSetState;
import org.jkdp.state.SetState;

public class Set {
  PlayerScore player1Score;
  PlayerScore player2Score;

  PlayerName advantagePlayer;

  PlayerName winner;
  private SetState setState;

  public Set() {
    this(PlayerName.NADAL, PlayerName.DJOKOVIC);
  }

  public Set(PlayerName player1, PlayerName player2) {
    player1Score = new PlayerScore(player1);
    player2Score = new PlayerScore(player2);
    setState = new InProgressSetState(this);
  }
  public PlayerScore getPlayer1Score() {
    return player1Score;
  }
  public PlayerScore getPlayer2Score() {
    return player2Score;
  }
  public PlayerName getWinner() {
    return winner;
  }

  public void setWinner(PlayerName winner) {
    this.winner = winner;
  }

  public PlayerName getAdvantagePlayer() {
    return advantagePlayer;
  }

  public void setAdvantagePlayer(PlayerName advantagePlayer) {
    this.advantagePlayer = advantagePlayer;
  }

  public PlayerScore getPlayerScore(PlayerName playerName) {
    return player1Score.matchPlayer(playerName)? player1Score : player2Score;
  }

  public PlayerScore getOpponentPlayerScore(PlayerName playerName) {
    return player1Score.matchPlayer(playerName)? player2Score : player1Score;
  }

  String ballScored(PlayerName playerName) {
    setState.ballScored(playerName);
    return setState.renderScore();
  }
  public void changeState(SetState setState) {
    this.setState = setState;
  }
}
