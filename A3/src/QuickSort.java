public class QuickSort {

    static class Iteracoes {
        int valor = 0;
    }
    public void quickSortCrescente(int[] vetor) {
        Iteracoes iteracao = new Iteracoes();

        long tempoInicial = System.nanoTime();

        // Chama o método recursivo para ordenar o vetor
        quickSortCrescente(vetor, 0, vetor.length - 1, iteracao);

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Quick Sort em ordem crescente obteve " + iteracao.valor + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Implementação do algoritmo QuickSort para ordenação crescente com contador de iterações
    private void quickSortCrescente(int[] vetor, int inicio, int fim, Iteracoes iteracao) {
        if (inicio < fim) {
            // Particiona o vetor e obtém o índice do pivô
            int indicePivo = particionarCrescente(vetor, inicio, fim);
            iteracao.valor++; // Incrementa o contador de iterações antes da chamada recursiva
            // Chama recursivamente o QuickSort para as submatrizes à esquerda e à direita do pivô
            quickSortCrescente(vetor, inicio, indicePivo - 1, iteracao);
            quickSortCrescente(vetor, indicePivo + 1, fim, iteracao);
        }
    }

    public void quickSortDecrescente(int[] vetor) {
        Iteracoes iteracao = new Iteracoes();

        long tempoInicial = System.nanoTime();

        // Chama o método recursivo para ordenar o vetor
        quickSortDecrescente(vetor, 0, vetor.length - 1, iteracao);

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Quick Sort em ordem decrescente obteve " + iteracao.valor + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Implementação do algoritmo QuickSort para ordenação decrescente com contador de iterações
    private void quickSortDecrescente(int[] vetor, int inicio, int fim, Iteracoes iteracao) {
        if (inicio < fim) {
            // Particiona o vetor e obtém o índice do pivô
            int indicePivo = particionarDecrescente(vetor, inicio, fim);
            iteracao.valor++;
            // Chama recursivamente o QuickSort para as submatrizes à esquerda e à direita do pivô
            quickSortDecrescente(vetor, inicio, indicePivo - 1, iteracao);
            quickSortDecrescente(vetor, indicePivo + 1, fim, iteracao);
        }
    }
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

    private int particionarDecrescente(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; // Escolhe o último elemento como pivô
        int i = inicio - 1; // Índice do menor elemento

        // Percorre o vetor, se o elemento atual for maior ou igual ao pivô, faz a troca
        for (int j = inicio; j < fim; j++) {
            if (vetor[j] >= pivo) {
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
