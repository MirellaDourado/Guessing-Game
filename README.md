# Guessing Game

## Estrutura das pastas

O projeto contém uma pasta:

- `src` : a pasta que contém todo o código
  
  - `br.com.colors`: pacote criado que possui as cores para personalizar saídas e entradas no terminal.
    
    - `ConsoleColors.java`: classe que possui cores a serem exibidas no console.
  
  - `br.com.colors`: pacote criado que possui as funções do jogo.

    - `GuessingGame.java`: classe que possui a lógica do jogo.
  
  - `Main.java`: classe Main que inicia o jogo quando o arquivo é executado.

> Este código foi desenvolvido no editor de texto VSCODE

## Como jogar

### Propósito

O foi desenvolvido para rodar no terminal do computador e ao ser executado irá sortear um número aleatório que poderá ir de 1 até 100. O objetivo do jogo é acertar-lo em até 10 tentativas.

### Regras

O jogo se encerra caso:

1. **Caso de derrota**: Você esgote as tentativas de acertar o número.

2. **Caso de vitória**: Você acerte o número secreto dentro do número de tentativas do jogo.

### Encerramento do jogo

O jogo possui duas formas de encerramento:

1. Ao final do jogo, caso ganhe ou perca, o jogo perguntará ao jogador se deseja continuar, caso a resposta seja: **n** ou **no**, o jogo será encerrado

2. Durante o jogo caso o jogador digite algo diferente de um número inteiro.