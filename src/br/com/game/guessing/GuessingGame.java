package br.com.game.guessing;

import javax.swing.JOptionPane;

/**
 *
 * @author Mirella Dourado
 */
public class GuessingGame extends javax.swing.JFrame {
    private int _minNumber;
    private int _maxNumber;
    private int _randomNumber;
    private int _attempts;
    private int _counterAttempts;

    /**
     * Creates GuessingGame
     * @param maxNumber
     * @param minNumber
     * @param attempts
     */
    public GuessingGame(int maxNumber, int minNumber, int attempts) {
        this._maxNumber = maxNumber;
        this._minNumber = minNumber;
        this._randomNumber = (int)Math.floor(Math.random() * (maxNumber - minNumber + 1) + minNumber);
        this._attempts = attempts;
        this._counterAttempts = attempts;
        initComponents();
        this.remove(Game);
        this.remove(EndGame);
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
  
    public void setCounterAttemps(int counterAttempts) {
        this._counterAttempts = counterAttempts;
    }
  
    public int getCounterAttempts() {
      return this._counterAttempts;
    } 
  
    public void setAttempts(int attempts) {
      this._attempts = attempts;
    }
  
    public int getAttempts() {
      return this._attempts;
    }
    
    private void backToMenu() {
      this.add(Menu);
      this.repaint();
    }
    
    private void resetGame() {
        this.setCounterAttemps(this._attempts);
        attemptsText.setText(String.format(
               "Tentativas: %d",
               this._counterAttempts));
        hintText.setText(String.format(
                "Dica: Lembre-se que o número pode ser de %d até %d",
                this._minNumber,
                this._maxNumber));
        guessField.setText("0");
        this.setRandomNumber();
    }
  
    private void startGame() {
      this.add(Game);
      this.resetGame();
      this.repaint();
    }
  
    private void returnEndGame(boolean isWinner) {
        this.remove(Game);
        this.add(EndGame);
        this.repaint();
        if (!isWinner) {
            resultGame.setText(String.format(
                    "Você não conseguiu acertar o número %d",
                    this._randomNumber
            ));
        } if (isWinner) {
            resultGame.setText(String.format(
                    "Você conseguiu acertar o número %d",
                    this._randomNumber));
        }
    }
  
    private void handleAttempts() {
        attemptsText.setText(String.format("Tentativas: %d",
            this._counterAttempts-= 1)
        );
    
        if (this._counterAttempts == 0) {
            this.returnEndGame(false);
        }
    }
  
    private void setHint() {
        try {
            int playerGuess = Integer.parseInt(guessField.getText());
            if (playerGuess > this._randomNumber) {
                hintText.setText(String.format("O número é menor que %d.", playerGuess, this._randomNumber));
            } if (playerGuess < this._randomNumber) {
                hintText.setText(String.format("O número é maior que %d.", playerGuess));
            } if (playerGuess == this._randomNumber) {
                this.returnEndGame(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Você deve digitar um número inteiro");
        } finally {
            this.handleAttempts();   
        }
    }
                            
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        Game = new javax.swing.JPanel();
        guessButton = new javax.swing.JButton();
        guessField = new javax.swing.JTextField();
        guessLabel = new javax.swing.JLabel();
        hintText = new javax.swing.JLabel();
        attemptsText = new javax.swing.JLabel();
        EndGame = new javax.swing.JPanel();
        resultGame = new javax.swing.JLabel();
        restartLabel = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        playButton.setText("Play");
        playButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playButtonMouseClicked(evt);
            }
        });

        title.setFont(new java.awt.Font("Liberation Sans", 0, 28)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("The Guessing Number");

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        guessButton.setText("Advinhar");
        guessButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guessButtonMouseClicked(evt);
            }
        });

        guessField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        guessField.setText("0");
        guessField.setToolTipText("");

        guessLabel.setText("Digite um número:");

        hintText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hintText.setText(String.format("Dica: Lembre-se que o número pode ser de %d até %d", this._minNumber, this._maxNumber));

        attemptsText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        attemptsText.setText(String.format("Tentativas: %d", this._attempts)
        );

        javax.swing.GroupLayout GameLayout = new javax.swing.GroupLayout(Game);
        Game.setLayout(GameLayout);
        GameLayout.setHorizontalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGap(0, 64, Short.MAX_VALUE)
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(guessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GameLayout.createSequentialGroup()
                                .addComponent(guessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(guessField)))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addComponent(hintText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(attemptsText, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        GameLayout.setVerticalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(attemptsText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(hintText)
                .addGap(56, 56, 56)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guessLabel)
                    .addComponent(guessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(guessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        resultGame.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        resultGame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resultGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        restartLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        restartLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restartLabel.setText("Deseja jogar novamente?");

        yesButton.setText("Sim");
        yesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yesButtonMouseClicked(evt);
            }
        });

        noButton.setText("Não");
        noButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                noButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EndGameLayout = new javax.swing.GroupLayout(EndGame);
        EndGame.setLayout(EndGameLayout);
        EndGameLayout.setHorizontalGroup(
            EndGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EndGameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(restartLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EndGameLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(noButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        EndGameLayout.setVerticalGroup(
            EndGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EndGameLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(resultGame)
                .addGap(45, 45, 45)
                .addComponent(restartLabel)
                .addGap(18, 18, 18)
                .addGroup(EndGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(EndGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(EndGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)))
        );

        pack();
    }                      

    private void playButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
      this.remove(Menu);
      this.startGame();
    }                                       

    private void yesButtonMouseClicked(java.awt.event.MouseEvent evt) {                                       
        this.remove(EndGame);
        this.startGame();
    }                                      

    private void noButtonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        this.remove(EndGame);
        this.backToMenu();
    }                                     

    private void guessButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        this.setHint();
    }                                        

    // Variables declaration              
    private javax.swing.JPanel EndGame;
    private javax.swing.JPanel Game;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel attemptsText;
    private javax.swing.JButton guessButton;
    private javax.swing.JTextField guessField;
    private javax.swing.JLabel guessLabel;
    private javax.swing.JLabel hintText;
    private javax.swing.JButton noButton;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel restartLabel;
    private javax.swing.JLabel resultGame;
    private javax.swing.JLabel title;
    private javax.swing.JButton yesButton;
    // End of variables declaration                   
}
