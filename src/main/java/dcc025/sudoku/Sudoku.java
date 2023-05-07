/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package dcc025.sudoku;

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marlo
 */
public class Sudoku {

    public static void main(String[] args) {
        apresentacao();
    }

    public static void printSudoku(int board[][]) {
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.println("-------------------------");
            }
            if (i % 3 == 0 && i != 0) {
                System.out.println("+-------+-------+-------+");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");
                }
                int value = board[i][j];
                if (value == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(value + " ");
                }
                if (j == 8) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i == 8) {
                System.out.println("-------------------------");
            }
        }
    }

    public static void apresentacao() {
        System.out.println("Boas vindas!! Você inicializou o jogo SUDOKU");
        System.out.println("Defina os valores de seu tabuleiro no seguinte formato:");
        System.out.println("(linha,coluna,valor) podendo definir mais de uma jogada por vez no seguinte formato: ");
        System.out.println("(linha,coluna,valor) (linha,coluna,valor),etc.");
        System.out.println("Basta digitar Sair para mudar de ação");
        System.out.println("Como você gostaria de jogar esse jogo?");
        System.out.println("Opções disponíveis:");
        System.out.println("a : Jogo aleatório");
        System.out.println("b : Definir próprio jogo");
        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.next().toLowerCase();
        switch (escolha) {
            case "a" ->
                jogoAleatorio();
            case "b" ->
                jogoDefinido();
        }

    }

    public static void jogoDefinido() {
        System.out.println("Voce escolheu definir o próprio jogo");
        int[][] board = new int[9][9];
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Digite: Sair - Quando tiver terminado de definir seu jogo");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Defina seu jogo:");
        adicionarJogada(board);
        acoes(board);

    }

    public static void jogoAleatorio() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Voce escolheu um jogo aleatório");
        int[][] board = new int[9][9];
        System.out.println("Quantos números você gostaria de sortear?");
        int quantidade =0;
        while(quantidade <=0 || quantidade >65){
            System.out.println("Por favor, digite um número entre 1 e 65");
            quantidade = teclado.nextInt();
        }
        adicionarNumerosAleatorios(board, quantidade);
        System.out.println("Tabuleiro gerado de forma aleatória:");
        printSudoku(board);
        acoes(board);

    }

    public static void adicionarNumerosAleatorios(int[][] board, int quantidade) {
        Random random = new Random();
        int tentativas = 0;
        while (quantidade > 0 && tentativas < 100000) {
            int linha = random.nextInt(9);
            int coluna = random.nextInt(9);
            int valor = random.nextInt(9) + 1;
            if (board[linha][coluna] == 0 && verificarColunas(board, coluna, valor) && verificarLinhas(board, linha, valor) && verificarQuadrados(board, linha, coluna, valor)) {
                board[linha][coluna] = valor;
                quantidade--;
            }
            tentativas++;
        }
    }

    public static void acoes(int board[][]) {
        printSudoku(board);
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.println("Selecione qual a ação que gostaria de fazer dentre as opções abaixo:");
            System.out.println("a) Adicionar jogada");
            System.out.println("b) Remover jogada");
            System.out.println("c) Verificar tabuleiro");
            System.out.println("d) Sair do jogo");
            String option1 = teclado.next().toLowerCase();
            if ("a".equals(option1)) {
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.println("Você Selecionou adicionar uma ou mais jogadas, quando tiver terminado digite a palavra: sair");
                System.out.println("-----------------------------------------------------------------------------------------------");
                adicionarJogada(board);
                printSudoku(board);

            } else if ("b".equals(option1)) {

                removerJogada(board);
                printSudoku(board);
            } else if ("c".equals(option1)) {
                boolean verifyLinha = verificarLinhas(board);
                boolean verifyColuna = verificarColunas(board);
                boolean verifyQuadrados = verificarQuadrados(board);
                
                if (verifyColuna == true && verifyLinha == true && verifyQuadrados) {
                    System.out.println("Parabens, você completou o SUDOKU, Gostaria de jogar novamente?");
                    System.out.println("a) SIM)");
                    System.out.println("Pressione qualquer outra para sair");
                    String option3 = teclado.next().toLowerCase();
                        if("a".equals(option3)){
                            apresentacao();
                        }
                        else {
                            System.out.println("Obrigado por jogar!");
                            exit(0);
                        }
                        
                } else {
                    System.out.println("que pena, continue tentando");
                }

            } else if ("d".equals(option1)) {
                System.out.println("Foi bom jogar com você :) ");
                exit(0);

            }

        }
    }

    public static boolean verificarLinhas(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] numerosEncontrados = new boolean[9];
            for (int j = 0; j < 9; j++) {
                int numeroAtual = board[i][j];
                if (numeroAtual != 0) {
                    if (numerosEncontrados[numeroAtual - 1]) {
                        
                        return false;
                    } else {
                        numerosEncontrados[numeroAtual - 1] = true;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verificarColunas(int[][] board) {
        for (int j = 0; j < 9; j++) {
            boolean[] numerosEncontrados = new boolean[9];
            for (int i = 0; i < 9; i++) {
                int numeroAtual = board[i][j];
                if (numeroAtual != 0) {
                    if (numerosEncontrados[numeroAtual - 1]) {
                        
                        return false;
                    } else {
                        numerosEncontrados[numeroAtual - 1] = true;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verificarQuadrados(int[][] board) {
        for (int k = 0; k < 9; k++) {
            boolean[] numerosEncontrados = new boolean[9];
            int linhaInicial = (k / 3) * 3;
            int colunaInicial = (k % 3) * 3;
            for (int i = linhaInicial; i < linhaInicial + 3; i++) {
                for (int j = colunaInicial; j < colunaInicial + 3; j++) {
                    int numeroAtual = board[i][j];
                    if (numeroAtual != 0) {
                        if (numerosEncontrados[numeroAtual - 1]) {
                            return false;
                        } else {
                            numerosEncontrados[numeroAtual - 1] = true;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean verificarLinhas(int[][] board, int linha, int valor) {
        for (int j = 0; j < 9; j++) {
            if (board[linha][j] == valor) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarColunas(int[][] board, int coluna, int valor) {
        for (int i = 0; i < 9; i++) {
            if (board[i][coluna] == valor) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarQuadrados(int[][] board, int linha, int coluna, int valor) {
        int linhaInicial = (linha / 3) * 3;
        int colunaInicial = (coluna / 3) * 3;
        for (int i = linhaInicial; i < linhaInicial + 3; i++) {
            for (int j = colunaInicial; j < colunaInicial + 3; j++) {
                if (board[i][j] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void removerJogada(int[][] board) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Digite: Sair - Quando tiver terminado de remover sua(s) jogada(s)");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Digite a jogada que deseja remover no seguinte formato: (linha,coluna)");
        while (true) {
            String remoc = teclado.next();
            if (remoc.equals("sair")) {
                break;
            } else {
                String[] remocSeparada;
                remoc = remoc.replaceAll("\\(", "");
                remoc = remoc.replaceAll("\\)", "");
                remoc = remoc.replaceAll("\\s+", "");
                remocSeparada = remoc.split(",");
                for (int i = 0; i < remocSeparada.length; i += 2) {
                    int linha = Integer.parseInt(remocSeparada[i]);
                    int coluna = Integer.parseInt(remocSeparada[i + 1]);
                    remocao(linha, coluna, board);

                }

            }

        }

    }

    public static void remocao(int linha, int coluna, int[][] board) {
        if (linha > 0 && linha <= 9 && coluna > 0 && coluna <= 9) {
            board[linha - 1][coluna - 1] = 0;
            System.out.println("jogada (" + linha + "," + coluna + ") removida");

        } else {
            System.out.println("A jogada: (" + linha + "," + coluna + ") não foi removida pois há um erro na entrada, tente novamente");
        }
    }

    public static void adicionarJogada(int[][] board) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Faça sua(s) jogada(s)");

        while (true) {
            String adc = teclado.next();
            if (adc.equals("sair")) {
                break;
            } else {
                String[] adcSeparada;
                adc = adc.replaceAll("\\(", "");
                adc = adc.replaceAll("\\)", "");
                adc = adc.replaceAll("\\s+", "");
                adcSeparada = adc.split(",");
                for (int i = 0; i < adcSeparada.length; i += 3) {
                    int linha = Integer.parseInt(adcSeparada[i]);
                    int coluna = Integer.parseInt(adcSeparada[i + 1]);
                    int valor = Integer.parseInt(adcSeparada[i + 2]);
                    jogada(linha, coluna, valor, board);
                }

            }

        }

    }

    public static void jogada(int linha, int coluna, int valor, int[][] board) {
        if (linha > 0 && linha <= 9 && coluna > 0 && coluna <= 9 && valor >= 0 && valor <= 9) {
            board[linha - 1][coluna - 1] = valor;
            System.out.println("jogada (" + linha + "," + coluna + "," + valor + ") inserida");

        } else {
            System.out.println("A jogada: (" + linha + "," + coluna + "," + valor + ") não foi inserida pois há um erro na entrada, tente novamente");
        }
    }

}
