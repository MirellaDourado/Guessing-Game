import java.util.Scanner;

public class GuessingGame {
  private int _minNumber;
  private int _maxNumber;
  private int _randomNumber;
  private int _attempts;
  private Scanner _scanner;

  public GuessingGame(int maxNumber, int minNumber, int attempts) {
    this._maxNumber = maxNumber;
    this._minNumber = minNumber;
    this._randomNumber = (int)Math.floor(Math.random() * (maxNumber - minNumber + 1) + minNumber);
    this._attempts = attempts;
    this._scanner = new Scanner(System.in);
  }
}
