import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TestandoOrdenacao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String desejaOrdenar;

        // Instanciando a classe para as ordenações
        BubbleSort bubble = new BubbleSort();

        // Variável para o tamanho do vetor
        int tamanhoVetor = 0;

        // Solicitar o tamanho do vetor até que uma entrada válida seja fornecida
        while (true) {
            try {
                System.out.print("Qual o tamanho do vetor desejado entre 0 e 999999? ");
                tamanhoVetor = entrada.nextInt();
                if (tamanhoVetor >= 0 && tamanhoVetor <= 999999) {
                    break;
                } else {
                    System.out.println("Por favor, insira um número entre 0 e 999999.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                entrada.next(); // Limpa a entrada inválida
            }
        }

        int[] vetor = new int[tamanhoVetor]; // Mova a declaração do vetor para fora do bloco if

        Random random = new Random();

        // Gera números aleatórios no intervalo de 0 a 999
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(1000);
        }
        System.out.printf("Vetor original:\n" + Arrays.toString(vetor) + "\n");

        do {
            int tipoOrdenacao = 0;

            // Solicitar o tipo de ordenação até que uma entrada válida seja fornecida
            while (true) {
                try {
                    System.out.print("Escolha o método para ordenar o vetor:\n1 - Bubble Sort\n2 - Selection Sort\n3 - Insertion Sort\n" +
                            "4 - Quick Sort\n5 - Merge Sort\n");
                    tipoOrdenacao = entrada.nextInt();
                    if (tipoOrdenacao >= 1 && tipoOrdenacao <= 5) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-5).");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    entrada.next(); // Limpa a entrada inválida
                }
            }

            switch (tipoOrdenacao) {
                case 1:
                    int crescenteOuDecrescente = 0;

                    // Solicitar a ordem de ordenação até que uma entrada válida seja fornecida
                    while (true) {
                        try {
                            System.out.print("Como gostaria de ordenar o vetor:\n1 - Ordem crescente\n2 - Ordem decrescente\n");
                            crescenteOuDecrescente = entrada.nextInt();
                            if (crescenteOuDecrescente == 1 || crescenteOuDecrescente == 2) {
                                break;
                            } else {
                                System.out.println("Por favor, escolha uma opção válida (1-2).");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                            entrada.next(); // Limpa a entrada inválida
                        }
                    }

                    if (crescenteOuDecrescente == 1) {
                        medirTempoDeExecucao(() -> bubble.bubbleSortOrdemCrescente(vetor));
                    } else {
                        medirTempoDeExecucao(() -> bubble.bubbleSortOrdemDecrescente(vetor));
                    }
                    break;
                // Adicione casos para outros algoritmos de ordenação aqui
            }

            // Solicitar se o usuário deseja ordenar novamente
            while (true) {
                System.out.print("Deseja ordenar com mais algum tipo de algoritmo de ordenação?\n" +
                        "s - Sim\nn - Não\n");
                desejaOrdenar = entrada.next();
                if (desejaOrdenar.equalsIgnoreCase("s") || desejaOrdenar.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Por favor, insira 's' para sim ou 'n' para não.");
                }
            }

        } while (desejaOrdenar.equalsIgnoreCase("s"));

        entrada.close();
    }

    public static void medirTempoDeExecucao(Runnable runnable) {
        // Captura o tempo inicial
        long tempoInicial = System.nanoTime();

        // Executa o algoritmo
        runnable.run();

        // Captura o tempo final
        long tempoFinal = System.nanoTime();

        // Calcula o tempo de execução
        long duracao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + duracao / 1_000_000);
    }
}
