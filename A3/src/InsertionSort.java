import java.util.Arrays;

public class InsertionSort {

    public void insertionSortCrescente(int[] vetor) {
        long tempoInicial = System.nanoTime(); // Captura o tempo inicial
        int iteracao = 0; // Variável para controlar o número de iterações

        for (int i = 1; i < vetor.length; i++) {
            iteracao = i;
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Insertion Sort em ordem crescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    public void insertionSortDecrescente(int[] vetor) {
        long tempoInicial = System.nanoTime(); // Captura o tempo inicial
        int iteracao = 0; // Variável para controlar o número de iterações

        for (int i = 1; i < vetor.length; i++) {
            iteracao = i;
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] < chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Insertion Sort em ordem decrescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Método auxiliar para exibir o tempo de execução
    private void exibirTempoExecucao(long duracaoTotal) {
        if (duracaoTotal >= 60000000000L) {
            double duracaoEmMinutos = duracaoTotal / 60000000000.0;
            System.out.printf("Tempo de execução: %.2f minutos%n", duracaoEmMinutos);
        } else if (duracaoTotal >= 1000000000) {
            double duracaoEmSegundos = duracaoTotal / 1000000000.0;
            System.out.printf("Tempo de execução: %.2f segundos%n", duracaoEmSegundos);
        } else if (duracaoTotal >= 1000000) {
            double duracaoEmMilissegundos = duracaoTotal / 1000000.0;
            System.out.printf("Tempo de execução: %.2f milissegundos%n", duracaoEmMilissegundos);
        } else {
            System.out.printf("Tempo de execução: %d nanosegundos%n", duracaoTotal);
        }
    }
}
