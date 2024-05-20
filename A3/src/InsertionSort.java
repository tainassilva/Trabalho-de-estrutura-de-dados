import java.util.Arrays;

public class InsertionSort {

    // Implementação do algoritmo Insertion Sort para ordenação crescente
    public void insertionSortCrescente(int[] vetor) {
        int n = vetor.length; // Tamanho do vetor

        // Loop para percorrer todo o vetor
        for (int i = 1; i < n; i++) {
            int chave = vetor[i]; // Armazena o valor atual sendo comparado
            int j = i - 1;

            // Move os elementos do vetor que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            // Coloca a chave na posição correta
            vetor[j + 1] = chave;
            // Mostra o vetor após cada iteração
            System.out.println("Iteração " + i + ": " + Arrays.toString(vetor));
        }
    }

    // Implementação do algoritmo Insertion Sort para ordenação decrescente
    public void insertionSortDecrescente(int[] vetor) {
        int n = vetor.length; // Tamanho do vetor

        // Loop para percorrer todo o vetor
        for (int i = 1; i < n; i++) {
            int chave = vetor[i]; // Armazena o valor atual sendo comparado
            int j = i - 1;

            // Move os elementos do vetor que são menores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && vetor[j] < chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }

            // Coloca a chave na posição correta
            vetor[j + 1] = chave;
            // Mostra o vetor após cada iteração
            System.out.println("Iteração " + i + ": " + Arrays.toString(vetor));
        }
    }
}
