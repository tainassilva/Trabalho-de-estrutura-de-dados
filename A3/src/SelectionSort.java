public class SelectionSort {

    int iteracao = 0;

    // Implementação do algoritmo Selection Sort em ordem crescente
    public void selectionSortCrescente(int[] vetor) {
        long tempoInicial = System.nanoTime(); // Captura o tempo inicial

        // Percorre todo o vetor
        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            int indiceMenor = i; // Assume que o menor elemento é o primeiro do vetor

            // Encontra o índice do menor elemento não ordenado
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            // Troca o menor elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMenor];
            vetor[indiceMenor] = vetor[i];
            vetor[i] = temp;
        }

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Selection Sort em ordem crescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Implementação do algoritmo Selection Sort em ordem decrescente
    public void selectionSortDecrescente(int[] vetor) {
        long tempoInicial = System.nanoTime(); // Captura o tempo inicial

        // Percorre todo o vetor
        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            int indiceMaior = i; // Assume que o maior elemento é o primeiro do vetor

            // Encontra o índice do maior elemento não ordenado
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] > vetor[indiceMaior]) {
                    indiceMaior = j;
                }
            }

            // Troca o maior elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMaior];
            vetor[indiceMaior] = vetor[i];
            vetor[i] = temp;
        }

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Selection Sort em ordem decrescente obteve " + iteracao + " iterações");
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

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        // Criação de um array grande para garantir que o tempo de execução seja significativo
        int tamanho = 10000;
        int[] arrayCrescente = new int[tamanho];
        int[] arrayDecrescente = new int[tamanho];

        // Inicializando o array com valores aleatórios
        for (int i = 0; i < tamanho; i++) {
            arrayCrescente[i] = (int) (Math.random() * tamanho);
            arrayDecrescente[i] = (int) (Math.random() * tamanho);
        }

        // Ordenação em ordem crescente
        selectionSort.selectionSortCrescente(arrayCrescente);

        // Ordenação em ordem decrescente
        selectionSort.selectionSortDecrescente(arrayDecrescente);
    }
}
