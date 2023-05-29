import br.com.game.guessing.GuessingGame;

public class Main {
  public static void main(String[] args) throws Exception {
    GuessingGame game = new GuessingGame(100, 1, 10);
    game.startGame();
  }
}
