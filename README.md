# Guessing Game

## Estrutura do código

O projeto contém uma pasta:

- `src` : a pasta que contém todo o código
  
  - `br.com.game.colors`: pacote criado que possui a classe com as cores para personalizar saídas e entradas no terminal.
    
    - `ConsoleColors.java`: classe que possui cores a serem exibidas no console.
  
  - `br.com.game.guessing`: pacote criado que possui a classe do jogo.

    - `GuessingGame.java`: classe que possui a lógica do jogo via terminal.
    
    - `br.com.game.guessing.panel`: pacote criado que possui a classe do jogo via interface gráfica.
     
      - `GuessingGamePanel.java`: classe que possui a lógica do jogo em interfacce gráfica.
  
  - `Main.java`: classe Main que inicia o jogo quando o arquivo é executado.

## Como jogar

> ATENÇÃO: Este jogo possui duas formas de jogar: via terminal ou via interface gráfica e a escolha deve ser feita com `y` ou `n` via terminal ao executar o código.

### Propósito

Ao ser iniciado o jogo sorteará um número aleatório que poderá ir de 1 até 100. O objetivo do jogo é acertar-lo em até 10 tentativas.

### Regras

1. O jogador perde caso não acerte o número em 10 tentativas.

2. O jogador ganha caso acerte o número secreto dentro de 10 tentativas.

### Encerramento do jogo

- **Terminal**: O jogo possui duas formas de encerramento

  1. Ao final do jogo, caso ganhe ou perca, o jogo perguntará ao jogador se deseja continuar, caso a resposta seja: **n** ou **no**, o jogo será encerrado

  2. Durante o jogo caso o jogador digite algo diferente de um número inteiro.

- **Interface gráfica**:

  1. O jogador poderá, a qualquer momento, clicar no botão de fechar (X)
