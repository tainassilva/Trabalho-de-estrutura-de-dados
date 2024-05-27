public class MergeSort {

    static class Iteracoes {
        int valor = 0;
    }

    // Método principal para ordenar em ordem crescente
    public void mergeSortCrescente(int inicio, int fim, int[] v) {
        Iteracoes iteracao = new Iteracoes();

        long tempoInicial = System.nanoTime();

        mergeSortCrescente(inicio, fim, v, iteracao); // Chama o método recursivo de ordenação

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método Merge Sort em ordem crescente obteve " + iteracao.valor + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Método recursivo para ordenar em ordem crescente com contador de iterações
    private void mergeSortCrescente(int inicio, int fim, int[] v, Iteracoes iteracoes) {
        if (inicio < fim - 1) { // Verifica se a sublista tem mais de um elemento
            int meio = inicio + (fim - inicio) / 2; // Calcula o ponto médio da sublista
            mergeSortCrescente(inicio, meio, v, iteracoes); // Ordena a primeira metade
            mergeSortCrescente(meio, fim, v, iteracoes); // Ordena a segunda metade
            intercalarCrescente(inicio, meio, fim, v); // Intercala as duas metades ordenadas
            iteracoes.valor++;
        }
    }

    // Método principal para ordenar em ordem decrescente
    public void mergeSortDecrescente(int inicio, int fim, int[] v) {
        Iteracoes iteracao = new Iteracoes();

        long tempoInicial = System.nanoTime();

        mergeSortDecrescente(inicio, fim, v, iteracao); // Chama o método recursivo de ordenação

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método Merge Sort em ordem decrescente obteve " + iteracao.valor + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Método recursivo para ordenar em ordem decrescente com contador de iterações
    private void mergeSortDecrescente(int inicio, int fim, int[] v, Iteracoes iteracoes) {
        if (inicio < fim - 1) { // Verifica se a sublista tem mais de um elemento
            int meio = inicio + (fim - inicio) / 2; // Calcula o ponto médio da sublista
            mergeSortDecrescente(inicio, meio, v, iteracoes); // Ordena a primeira metade
            mergeSortDecrescente(meio, fim, v, iteracoes); // Ordena a segunda metade
            intercalarDecrescente(inicio, meio, fim, v); // Intercala as duas metades ordenadas
            iteracoes.valor++; // Incrementa o contador de iterações
        }
    }

    // Intercalação para ordenação crescente
    private void intercalarCrescente(int inicio, int meio, int fim, int[] v) {
        int i, j, k;
        int[] auxiliar = new int[fim - inicio]; // Array auxiliar para armazenar os elementos intercalados
        i = inicio; // Índice inicial da primeira metade
        j = meio; // Índice inicial da segunda metade
        k = 0; // Índice inicial do array auxiliar

        // Intercala os elementos das duas metades em ordem crescente
        while (i < meio && j < fim) {
            if (v[i] <= v[j]) {
                auxiliar[k] = v[i];
                i++;
            } else {
                auxiliar[k] = v[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes da primeira metade, se houver
        while (i < meio) {
            auxiliar[k] = v[i];
            i++;
            k++;
        }

        // Copia os elementos restantes da segunda metade, se houver
        while (j < fim) {
            auxiliar[k] = v[j];
            j++;
            k++;
        }

        // Copia os elementos do array auxiliar de volta para o array original
        for (i = inicio; i < fim; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    // Intercalação para ordenação decrescente
    private void intercalarDecrescente(int inicio, int meio, int fim, int[] v) {
        int i, j, k;
        int[] auxiliar = new int[fim - inicio]; // Array auxiliar para armazenar os elementos intercalados
        i = inicio; // Índice inicial da primeira metade
        j = meio; // Índice inicial da segunda metade
        k = 0; // Índice inicial do array auxiliar

        // Intercala os elementos das duas metades em ordem decrescente
        while (i < meio && j < fim) {
            if (v[i] >= v[j]) {
                auxiliar[k] = v[i];
                i++;
            } else {
                auxiliar[k] = v[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes da primeira metade, se houver
        while (i < meio) {
            auxiliar[k] = v[i];
            i++;
            k++;
        }

        // Copia os elementos restantes da segunda metade, se houver
        while (j < fim) {
            auxiliar[k] = v[j];
            j++;
            k++;
        }

        // Copia os elementos do array auxiliar de volta para o array original
        for (i = inicio; i < fim; i++) {
            v[i] = auxiliar[i - inicio];
        }
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
