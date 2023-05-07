/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package dcc025.sudoku;

import static java.lang.System.exit;
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
        System.out.println("Defina seu jogo:");
        adicionarJogada(board);
        acoes(board);

    }

    public static void jogoAleatorio() {
        System.out.println("Voce escolheu um jogo aleatório");
        int[][] board = new int[9][9];
        System.out.println("Quantos números você gostaria de sortear?");
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void acoes(int board[][]) {
        Scanner teclado = new Scanner(System.in);
        while (true) {
            System.out.println("Selecione qual a ação que gostaria de fazer dentre as opções abaixo:");
            System.out.println("a) Adicionar jogada");
            System.out.println("b) Remover jogada");
            System.out.println("c) Verificar tabuleiro");
            System.out.println("d) Sair do jogo");
            printSudoku(board);
            String option1 = teclado.next().toLowerCase();
            if ("a".equals(option1)) {

                adicionarJogada(board);
                printSudoku(board);

            } else if ("b".equals(option1)) {

                removerJogada(board);
                printSudoku(board);
            } else if ("c".equals(option1)) {
                 boolean verifyLinha = verificarLinhas(board);
                boolean verifyColuna = verificarColunas(board);
                boolean verifyQuadrados = verificarQuadrados(board);
                if (verifyColuna ==true && verifyLinha ==true && verifyQuadrados ) {
                    System.out.println("parabens, voce completou");
                } else {
                    System.out.println("que pena, continue tentando");
                }
                printSudoku(board);
            } else if ("d".equals(option1)) {
                System.out.println("Foi bom jogar com você :) ");
                exit(0);

            }

        }
    }


        // Verifica cada linha

public static boolean verificarLinhas(int[][] board) {
    for (int i = 0; i < 9; i++) { 
        boolean[] numerosEncontrados = new boolean[9]; 
        for (int j = 0; j < 9; j++) { 
            int numeroAtual = board[i][j];
            if (numeroAtual != 0) { 
                if (numerosEncontrados[numeroAtual - 1] ) { 
                    return false;
                } else {
                    numerosEncontrados[numeroAtual - 1] = true; 
                }
            }
            else{
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






    

    public static void removerJogada(int[][] board) {

        Scanner teclado = new Scanner(System.in);
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
