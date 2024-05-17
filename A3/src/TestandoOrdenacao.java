import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestandoOrdenacao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String desejaOrdenar;
        // Instanciando a classe para as ordenações
        BubbleSort bubble = new BubbleSort();

        System.out.print("Qual o tamanho do vetor desejado? ");
        int tamanhoVetor = entrada.nextInt();
        int[] vetor = new int[tamanhoVetor]; // Mova a declaração do vetor para fora do bloco if

        //Gerando o vetor menor que um milhão
        if(tamanhoVetor < 1_000_000) {
            Random random = new Random();

            // Gera números aleatórios no intervalo de 0 a 999
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = random.nextInt(1000);
            }
            System.out.printf("Vetor original:\n" + Arrays.toString(vetor)+ "\n");
        }

        do {
            System.out.print("Escolha o método para ordenar o vetor:\n1 - Bubble Sort\n2 - Selection Sort\n3 - Insertion Sort\n" +
                    "4 - Quick Sort\n5 - Merge Sort\n");
            int tipoOrdenacao = entrada.nextInt();

            switch(tipoOrdenacao){
                case 1:
                    System.out.print("Como gostaria de ordenar o vetor:\n1 - Ordem crescente\n2 - Ordem decrescente\n");
                    int crescenteOuDecrescente = entrada.nextInt();

                    if (crescenteOuDecrescente == 1) {
                        medirTempoDeExecucao(() -> bubble.bubbleSortOrdemCrescente(vetor));
                    } else {
                        medirTempoDeExecucao(() -> bubble.bubbleSortOrdemDecrescente(vetor));
                    }
                    break;
            }
            System.out.print("Deseja ordenar com mais algum tipo de algoritmo de ordenação?\n" +
                    "s - Sim\nn - Não\n");
            // Atualiza desejaOrdenar com a entrada do usuário
            desejaOrdenar = entrada.next();

        } while(desejaOrdenar.equalsIgnoreCase("s"));

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
