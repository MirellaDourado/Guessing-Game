package br.com.game.guessing;

import java.util.Scanner;

import br.com.game.colors.ConsoleColors;

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

  private void endGame() {
    String playerResponse;
    System.out.println(ConsoleColors.RESET + "Foi muito divertido! Você quer jogar de novo? (y/n)");
    do {
      playerResponse = this._scanner.next();
      if ("y".equalsIgnoreCase(playerResponse) || "yes".equalsIgnoreCase(playerResponse)) {
        this.setRandomNumber();
        this.checkMatch();
      } if ("n".equalsIgnoreCase(playerResponse) || "no".equalsIgnoreCase(playerResponse)) {
        System.out.println(ConsoleColors.CYAN_BACKGROUND + "######## Tchau! #########");
      } else {
        System.out.println(ConsoleColors.RED + "Essa não é uma opção válida, digite de novo: " + ConsoleColors.RESET);
      }
    } while (!"n".equalsIgnoreCase(playerResponse) || !"no".equalsIgnoreCase(playerResponse));
    this._scanner.close();
  }

  private void finalResult(boolean isWinner, int playerAttempts) {
    if (isWinner) {
      System.out.println(String
        .format(
          "Você conseguiu acertar o número na %dª tentativa!", playerAttempts
        ));
    } else {
      System.out.println(
        ConsoleColors.RED_BOLD +
        String.format(
            "\nQue pena, seu número era %d e você não conseguiu acertar em %d tentativas,\n mas não desista!",
            this._randomNumber,
            this._attempts
          ));
    }

    this.endGame();
  }

  private String returnGuessResponse(int playerGuess) {
    if (playerGuess < this._randomNumber) {
      return String.format(ConsoleColors.YELLOW_BRIGHT + "O número é maior do que %d. ", playerGuess);
    } else if (playerGuess > this._randomNumber) {
      return String.format(ConsoleColors.BLUE_BOLD + "O número é menor do que %d. ", playerGuess);
    } else {
      return ConsoleColors.GREEN_BOLD_BRIGHT + String.format("Parabéns, você acertou o resultado, o número era %d! ", this._randomNumber);
    }
  }

  private void checkMatch() {
    int playerGuess;
    int playerAttempts = 0;
    Boolean endMatch = false;
    try {
      do {
        System.out.print(ConsoleColors.RESET + "Digite um número: " + ConsoleColors.CYAN_UNDERLINED);
        playerGuess = this._scanner.nextInt();
        playerAttempts++;
  
        if (playerAttempts == this._attempts || playerGuess == this._randomNumber) {
          endMatch = true;
        }
  
        System.out.println(
          ConsoleColors.RESET +
          this.returnGuessResponse(playerGuess)
        );
      } while (endMatch == false);
      this.finalResult(playerGuess == this._randomNumber, playerAttempts);
    } catch (Exception error) {
      System.out.println(ConsoleColors.RESET + ConsoleColors.RED + "OPA! Entrada inesperada, finalizando o jogo...");
    }
  }

  public void startGame() {
    System.out.println(
      ConsoleColors.CYAN_BACKGROUND +
      "############# BEM VINDO AO GUESSING GAME ################\n" +
      ConsoleColors.RESET +
      String.format(
         "Você terá %d tentativas para acertar o número",
        this._attempts
        )
    );
    this.checkMatch();
  }
}
