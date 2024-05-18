import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AplicandoOrdenacao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String desejaOrdenar;
        int estruturaOrdenacao;
        long tempoInicialDeExecucao;
        long tempoFinalDeExecucao;
        // Instanciando a classe para as ordenações
        BubbleSort bubble = new BubbleSort();

        int[] vetor = null; // Movida a declaração e inicialização do vetor para o escopo externo

        do {
            while (true) {
                try {
                    System.out.print("Escolha o método para ordenar o vetor:\n1 - Bubble Sort\n2 - Selection Sort\n3 - Insertion Sort\n" +
                            "4 - Quick Sort\n5 - Merge Sort\n");
                    estruturaOrdenacao = entrada.nextInt();
                    if (estruturaOrdenacao >= 1 && estruturaOrdenacao <= 5) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-5).");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    entrada.next(); // Limpa a entrada inválida
                }
            }

            int tamanhoVetor = 0;

            switch (estruturaOrdenacao) {
                case 1:
                while (true) {
                    try {
                        System.out.print("Digite o tamanho do vetor entre os valores citados abaixo: \n100\n1.000\n10.000\n100.000\n1.000.000\n");
                        tamanhoVetor = entrada.nextInt();
                        if (tamanhoVetor == 10 || tamanhoVetor == 1000 || tamanhoVetor == 10000 || tamanhoVetor == 100000 || tamanhoVetor == 1000000) {
                            break;
                        } else {
                            System.out.println("Por favor, insira um número das opções citadas: \n100\n1.000\n10.000\n100.000\n1.000.000.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        entrada.next(); // Limpa a entrada inválida
                    }
                }

                vetor = new int[tamanhoVetor]; // Inicialização do vetor movida para este ponto
                Random random = new Random();
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random.nextInt(1000);
                }

                System.out.println("Vetor original:\n" + Arrays.toString(vetor));

                int tipoDeOrdenacao;
                while (true) {
                    System.out.print("Qual vetor gostaria de ordenar:\n1 - Vetor desordenado\n2 - Vetor ordenado em ordem crescente\n3 - Vetor ordenado em ordem decrescente\n");
                    tipoDeOrdenacao = entrada.nextInt();
                    if (tipoDeOrdenacao >= 1 && tipoDeOrdenacao <= 3) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-3).");
                    }
                }

                switch (tipoDeOrdenacao) {
                    case 1:
                        tempoInicialDeExecucao = System.nanoTime();
                        bubble.bubbleSortOrdemCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;

                    case 2:

                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente

                        tempoInicialDeExecucao = System.nanoTime();
                        bubble.bubbleSortOrdemCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorCrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorCrescente / 1_000_000);
                        break;
                    case 3:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                        inverterVetor(vetor); // Inverte o vetor para ordem decrescente

                        tempoInicialDeExecucao = System.nanoTime();
                        bubble.bubbleSortOrdemDecrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorDecrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDecrescente / 1_000_000);
                        break;
                }
                break;
            case 2:
                // Implementar e chamar Selection Sort aqui
                System.out.println("Selection Sort não implementado.");
                break;
            case 3:
                // Implementar e chamar Insertion Sort aqui
                System.out.println("Insertion Sort não implementado.");
                break;
            case 4:
                // Implementar e chamar Quick Sort aqui
                System.out.println("Quick Sort não implementado.");
                break;
            case 5:
                // Implementar e chamar Merge Sort aqui
                System.out.println("Merge Sort não implementado.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
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
        long tempoInicial = System.nanoTime();
        runnable.run();
        long tempoFinal = System.nanoTime();
        long duracao = tempoFinal - tempoInicial;
        System.out.println("Tempo de execução em milissegundos: " + duracao / 1_000_000);
    }

    public static void inverterVetor(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[n - 1 - i];
            vetor[n - 1 - i] = temp;
        }
    }
}
