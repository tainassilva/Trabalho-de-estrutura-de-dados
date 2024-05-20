import java.util.Arrays;

public class QuickSort {
    // Implementação do algoritmo Quicksort para ordenação crescente
    public void quickSortCrescente(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // Particiona o vetor e obtém o índice do pivô
            int[] iteracoes = {0}; // Contador de iterações
            int indicePivo = particionarCrescente(vetor, inicio, fim, iteracoes);

            // Chama recursivamente o Quicksort para as submatrizes à esquerda e à direita do pivô
            quickSortCrescente(vetor, inicio, indicePivo - 1);
            quickSortCrescente(vetor, indicePivo + 1, fim);
        }
    }

    // Implementação do algoritmo Quicksort para ordenação decrescente
    public void quickSortDecrescente(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            // Particiona o vetor e obtém o índice do pivô
            int[] iteracoes = {0}; // Contador de iterações
            int indicePivo = particionarDecrescente(vetor, inicio, fim, iteracoes);

            // Chama recursivamente o Quicksort para as submatrizes à esquerda e à direita do pivô
            quickSortDecrescente(vetor, inicio, indicePivo - 1);
            quickSortDecrescente(vetor, indicePivo + 1, fim);
        }
    }

    // Função auxiliar para particionar o vetor em ordem crescente
    private int particionarCrescente(int[] vetor, int inicio, int fim, int[] iteracoes) {
        int pivo = vetor[fim]; // Escolhe o último elemento como pivô
        int i = inicio - 1; // Índice do menor elemento

        // Percorre o vetor, se o elemento atual for menor ou igual ao pivô, faz a troca
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++; // Incrementa o índice do menor elemento
                // Troca vetor[i] com vetor[j]
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
            iteracoes[0]++; // Incrementa o contador de iterações
        }

        // Troca vetor[i+1] com o pivô
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        // Mostra a iteração atual
        System.out.println("Iteração: " + Arrays.toString(vetor));

        return i + 1; // Retorna o índice do pivô após a partição
    }

    // Função auxiliar para particionar o vetor em ordem decrescente
    private int particionarDecrescente(int[] vetor, int inicio, int fim, int[] iteracoes) {
        int pivo = vetor[fim]; // Escolhe o último elemento como pivô
        int i = inicio - 1; // Índice do maior elemento

        // Percorre o vetor, se o elemento atual for maior ou igual ao pivô, faz a troca
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] >= pivo) {
                i++; // Incrementa o índice do maior elemento
                // Troca vetor[i] com vetor[j]
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
            iteracoes[0]++; // Incrementa o contador de iterações
        }

        // Troca vetor[i+1] com o pivô
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        // Mostra a iteração atual
        System.out.println("Iteração: " + Arrays.toString(vetor));

        return i + 1; // Retorna o índice do pivô após a partição
    }
}
