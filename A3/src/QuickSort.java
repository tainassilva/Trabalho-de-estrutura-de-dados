public class QuickSort {

    // Classe auxiliar para armazenar o contador de iterações
    static class Iteracoes {
        int valor = 0;
    }

    public void quickSortCrescente(int[] vetor, int inicio, int fim) {
        Iteracoes iteracao = new Iteracoes(); // Contador de iterações

        long tempoInicial = System.nanoTime(); // Captura o tempo inicial

        quickSortCrescente(vetor, inicio, fim, iteracao);

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Quick Sort em ordem crescente obteve " + iteracao.valor + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Implementação do algoritmo Quicksort para ordenação crescente
    public void quickSortCrescente(int[] vetor, int inicio, int fim, Iteracoes iteracao) {
        if (inicio < fim) {
            // Particiona o vetor e obtém o índice do pivô
            int indicePivo = particionarCrescente(vetor, inicio, fim);

            // Chama recursivamente o Quicksort para as submatrizes à esquerda e à direita do pivô
            quickSortCrescente(vetor, inicio, indicePivo - 1, iteracao);
            quickSortCrescente(vetor, indicePivo + 1, fim, iteracao);
            iteracao.valor++; // Incrementa o contador de iterações
        }
    }

    // Função auxiliar para particionar o vetor em ordem crescente
    private int particionarCrescente(int[] vetor, int inicio, int fim) {
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
        }

        // Troca vetor[i+1] com o pivô
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1; // Retorna o índice do pivô após a partição
    }

    public void quickSortDecrescente(int[] vetor, int inicio, int fim) {
        Iteracoes iteracao = new Iteracoes(); // Contador de iterações

        long tempoInicial = System.nanoTime(); // Captura o tempo inicial

        quickSortDecrescente(vetor, inicio, fim, iteracao);

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Quick Sort em ordem decrescente obteve " + iteracao.valor + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Implementação do algoritmo Quicksort para ordenação decrescente
    public void quickSortDecrescente(int[] vetor, int inicio, int fim, Iteracoes iteracao) {
        if (inicio < fim) {
            // Particiona o vetor e obtém o índice do pivô
            int indicePivo = particionarDecrescente(vetor, inicio, fim);

            // Chama recursivamente o Quicksort para as submatrizes à esquerda e à direita do pivô
            quickSortDecrescente(vetor, inicio, indicePivo - 1, iteracao);
            quickSortDecrescente(vetor, indicePivo + 1, fim, iteracao);
            iteracao.valor++; // Incrementa o contador de iterações
        }
    }

    // Função auxiliar para particionar o vetor em ordem decrescente
    private int particionarDecrescente(int[] vetor, int inicio, int fim) {
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
        }

        // Troca vetor[i+1] com o pivô
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1; // Retorna o índice do pivô após a partição
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
