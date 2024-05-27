import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public void insertionSortCrescente(int[] vetor) {
        long tempoInicial = System.nanoTime();
        int iteracao = 0;

        // Loop através de cada elemento do vetor, começando do segundo elemento
        for (int i = 1; i < vetor.length; i++) {
            iteracao = i;
            int chave = vetor[i]; // Seleciona o elemento atual como chave
            int j = i - 1;

            // Move elementos do vetor que são maiores que a chave uma posição para frente
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j]; // Move o elemento uma posição para frente
                j--; // Decrementa j para comparar com o próximo elemento à esquerda
            }
            vetor[j + 1] = chave; // Coloca a chave na posição correta
        }

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Insertion Sort em ordem crescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    public void insertionSortDecrescente(int[] vetor) {
        long tempoInicial = System.nanoTime();
        int iteracao = 0;

        // Loop através de cada elemento do vetor, começando do segundo elemento
        for (int i = 1; i < vetor.length; i++) {
            iteracao = i; // Atualiza a contagem de iterações
            int chave = vetor[i]; // Seleciona o elemento atual como chave
            int j = i - 1;

            // Move elementos do vetor que são menores que a chave uma posição para frente
            while (j >= 0 && vetor[j] < chave) {
                vetor[j + 1] = vetor[j]; // Move o elemento uma posição para frente
                j--; // Decrementa j para comparar com o próximo elemento à esquerda
            }
            vetor[j + 1] = chave; // Coloca a chave na posição correta
        }

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Insertion Sort em ordem decrescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }
    private void exibirTempoExecucao(long duracaoTotal) {
        // Exibe a duração em minutos, segundos, milissegundos ou nanosegundos, conforme apropriado
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
