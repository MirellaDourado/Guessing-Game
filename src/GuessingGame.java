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

  public void setMaxNumber(int maxNumber) {
    this._maxNumber = maxNumber;
  }

  public void setMinNumber(int minNumber) {
    this._minNumber = minNumber;
  }

  public int getMaxNumber() {
    return _maxNumber;
  }

  public int getMinNumber() {
    return _minNumber;
  }

  public void setRandomNumber() {
    this._randomNumber = (int)Math.floor(Math.random() * (this._maxNumber - this._minNumber + 1) + this._minNumber);
  }

  public int getRandomNumber() {
    return this._randomNumber;
  }

  private void checkMatch() {
    int playerGuess;
    int playerAttempts = 0;
    Boolean endMatch = false;
    do {
      System.out.println("Digite um número: ");
      playerGuess = this._scanner.nextInt();
      playerAttempts++;
      if(playerAttempts == this._attempts || playerGuess == this._randomNumber) {
        endMatch = true;
      }
      System.out.println(this.returnGuessResponse(playerGuess));
    } while (endMatch == false);
    this.finalResult(playerGuess == this._randomNumber, playerAttempts);
  }

  public void startGame() {
  System.out.println("############# BEM VINDO AO GUESSING GAME ################");
  System.out.println(String.format("Você terá %d tentativas para acertar o número", this._attempts));
  this.checkMatch();
  }
}
