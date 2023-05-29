import java.util.Scanner;

import br.com.game.guessing.GuessingGame;
import br.com.game.guessing.panel.GuessingGamePanel;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Você deseja jogar pelo terminal? (y/n)");
    String playerChoice;

    do {
      playerChoice = scanner.next();
      if (playerChoice.equalsIgnoreCase("y")) {
        GuessingGame game = new GuessingGame(100, 1, 10);
        game.startGame();
        break;
      } else if (playerChoice.equalsIgnoreCase("n")) {
        try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuessingGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuessingGamePanel(100, 1, 10).setVisible(true);
            }
        });
        scanner.close();
        break;
      } else {
        System.out.println("Opção inválida, digite novamente: (y/n) ");
      }
    } while (!playerChoice.equalsIgnoreCase("y") || !playerChoice.equalsIgnoreCase("n"));
    scanner.close();
  }
}
