# Trabalho Disciplina DCC025 - 
Sudoku
Sudoku é um jogo de raciocínio e lógica que consiste em
preencher, com números de 1 a 9, espaços em branco em uma
tabela com nove linhas, nove colunas e nove quadrados 3x3.
Para completar esses espaços, as seguintes regras devem ser
respeitadas:
1. Não repetir números na horizontal (linha).
2. Não repetir números na vertical (colunas).
3. Não repetir números nos quadrados de tamanho 3x3.


Atividade 1 (criando a configuração inicial do jogo)
Criar uma tela de boas-vindas para o jogador e perguntar ao
usuário se ele pretende gerar um jogo aleatório ou definir o
próprio jogo.
a) Jogo aleatório
o O programa pergunta ao usuário quantos números ele
deseja sortear e cria o jogo.

b) Definir jogo
o O usuário define os valores iniciais do jogo
utilizando uma string com o seguinte formato
“([linha],[coluna],[valor])”. Por exemplo, (2,5,3)
que representa a célula da linha=2, e coluna=5
recebe o valor=3. O programa também deve permitir
várias entradas simultâneas, por exemplo,
(2,5,3)(2,6,4)(2,8,1) que representa linha=2,
coluna=5, valor=3; linha=2, coluna=6, valor=4; e
linha=2, coluna=8, valor=1. Para simplificar a
implementação, assuma que o usuário não vai inserir
espaços nas entradas; e
o Para finalizar a definição, o usuário deverá
preencher a entrada com a palavra “sair”.

Atividade 2 (vamos jogar?)
Após a definição da configuração inicial do jogo, nessa
atividade deve ser criada uma tela com as seguintes opções:
a) Adicionar jogada
o Para adicionar uma jogada o usuário entra com os
dados no formato “([linha],[coluna],[valor])”,
apresentado na Atividade 1 - b.

b) Remover jogada
o Para remover uma jogada o usuário entra com os dados
no formato “([linha],[coluna])”.

c) Verificar
o Para avaliar se o jogo está correto. Caso tenha
alguma violação nas regras, pelo menos uma deve ser
informada ao jogador.

d) Sair
o Para sair do jogo.

Atividade 3 (indicar o fim do jogo)
Criar uma tela que escreva uma mensagem parabenizando o
vencedor e ofereça a opção de jogar novamente.
