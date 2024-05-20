import java.util.Arrays;

public class InsertionSort {

    public void insertionSortCrescente(int[] vetor) {
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        int n = vetor.length;
        int iteracoes = 0;

        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
                iteracoes++; // Incrementa o contador de iterações

                // Mostra o estado atual do vetor a cada iteração
                System.out.println("Iteração " + iteracoes + ": " + Arrays.toString(vetor));
            }
            vetor[j + 1] = chave;
        }

        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        // Imprime o número de iterações e o tempo de execução
        System.out.println("Número de iterações (Insertion Sort Crescente): " + iteracoes);
        System.out.println("Tempo de execução do Insertion Sort Crescente: " + duracaoTotal + " milissegundos");
        System.out.println("Vetor ordenado crescente: " + Arrays.toString(vetor));
    }

    public void insertionSortDecrescente(int[] vetor) {
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        int n = vetor.length;
        int iteracoes = 0;

        for (int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] < chave) {
                vetor[j + 1] = vetor[j];
                j--;
                iteracoes++; // Incrementa o contador de iterações

                // Mostra o estado atual do vetor a cada iteração
                System.out.println("Iteração " + iteracoes + ": " + Arrays.toString(vetor));
            }
            vetor[j + 1] = chave;
        }

        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        // Imprime o número de iterações e o tempo de execução
        System.out.println("Número de iterações (Insertion Sort Decrescente): " + iteracoes);
        System.out.println("Tempo de execução do Insertion Sort Decrescente: " + duracaoTotal + " milissegundos");
        System.out.println("Vetor ordenado decrescente: " + Arrays.toString(vetor));
    }
}
