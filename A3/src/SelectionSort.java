import java.util.Arrays;

public class SelectionSort {

    // Implementação do algoritmo Selection Sort em ordem crescente
    public void selectionSortCrescente(int[] vetor) {
        int n = vetor.length; // Tamanho do vetor

        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        // Percorre todo o vetor
        for (int i = 0; i < n - 1; i++) {
            // Mostra a iteração atual
            System.out.println("Iteração " + (i + 1) + ": " + Arrays.toString(vetor));
            int indiceMenor = i; // Assume que o menor elemento é o primeiro do vetor

            // Encontra o índice do menor elemento não ordenado
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            // Troca o menor elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMenor];
            vetor[indiceMenor] = vetor[i];
            vetor[i] = temp;
        }
        long endTime = System.currentTimeMillis(); // Captura o tempo final
        long duration = endTime - tempoInicial; // Calcula a duração da execução
        System.out.println("Tempo de execução: " + duration + " milissegundos");
    }

    // Implementação do algoritmo Selection Sort em ordem decrescente
    public void selectionSortDecrescente(int[] vetor) {
        int n = vetor.length; // Tamanho do vetor

        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        // Percorre todo o vetor
        for (int i = 0; i < n - 1; i++) {
            // Mostra a iteração atual
            System.out.println("Iteração " + (i + 1) + ": " + Arrays.toString(vetor));
            int indiceMaior = i; // Assume que o maior elemento é o primeiro do vetor

            // Encontra o índice do maior elemento não ordenado
            for (int j = i + 1; j < n; j++) {
                if (vetor[j] > vetor[indiceMaior]) {
                    indiceMaior = j;
                }
            }

            // Troca o maior elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMaior];
            vetor[indiceMaior] = vetor[i];
            vetor[i] = temp;
        }
        long endTime = System.currentTimeMillis(); // Captura o tempo final
        long duration = endTime - tempoInicial; // Calcula a duração da execução
        System.out.println("Tempo de execução: " + duration + " milissegundos");
    }
}
