import java.util.Arrays;

public class MergeSort {

    // Classe auxiliar para armazenar o contador de iterações
    static class Iteracoes {
        int valor = 0;
    }

    // Método principal para ordenar em ordem crescente
    public void mergeSortCrescente(int inicio, int fim, int[] v) {
        Iteracoes iteracao = new Iteracoes(); // Contador de iterações

        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial

        mergeSortCrescente(inicio, fim, v, iteracao);

        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução
        // Exibição do tempo de execução
        if (duracaoTotal >= 60000) {
            double duracaoEmMinutos = duracaoTotal / 60000.0;
            System.out.println("Tempo de execução : " + duracaoEmMinutos + " minutos");
        } else if (duracaoTotal >= 1000) {
            double duracaoEmSegundos = duracaoTotal / 1000.0;
            System.out.println("Tempo de execução : " + duracaoEmSegundos + " segundos");
        } else {
            System.out.println("Tempo de execução : " + duracaoTotal + " milissegundos");
        }
        System.out.println("O método Merge Sort em ordem crescente obteve " + iteracao.valor + " iterações");
    }

    // Método principal para ordenar em ordem crescente com contador de iterações
    private void mergeSortCrescente(int inicio, int fim, int[] v, Iteracoes iteracoes) {
        if (inicio < fim - 1) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSortCrescente(inicio, meio, v, iteracoes);
            mergeSortCrescente(meio, fim, v, iteracoes);
            intercalarCrescente(inicio, meio, fim, v);
            iteracoes.valor++; // Incrementa o contador de iterações
        }
    }

    // Método principal para ordenar em ordem decrescente
    public void mergeSortDecrescente(int inicio, int fim, int[] v) {
        Iteracoes iteracao = new Iteracoes(); // Contador de iterações
        mergeSortDecrescente(inicio, fim, v, iteracao);
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial

        mergeSortDecrescente(inicio, fim, v, iteracao);

        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução
        // Exibição do tempo de execução
        if (duracaoTotal >= 60000) {
            double duracaoEmMinutos = duracaoTotal / 60000.0;
            System.out.println("Tempo de execução : " + duracaoEmMinutos + " minutos");
        } else if (duracaoTotal >= 1000) {
            double duracaoEmSegundos = duracaoTotal / 1000.0;
            System.out.println("Tempo de execução : " + duracaoEmSegundos + " segundos");
        } else {
            System.out.println("Tempo de execução : " + duracaoTotal + " milissegundos");
        }
        System.out.println("O método Merge Sort em ordem decrescente obteve " + iteracao.valor + " iterações");
    }

    // Método principal para ordenar em ordem decrescente com contador de iterações
    private void mergeSortDecrescente(int inicio, int fim, int[] v, Iteracoes iteracoes) {
        if (inicio < fim - 1) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSortDecrescente(inicio, meio, v, iteracoes);
            mergeSortDecrescente(meio, fim, v, iteracoes);
            intercalarDecrescente(inicio, meio, fim, v);
            iteracoes.valor++; // Incrementa o contador de iterações
        }
    }

    // Intercalação para ordenação crescente
    private void intercalarCrescente(int inicio, int meio, int fim, int[] v) {
        int i, j, k;
        int[] auxiliar = new int[fim - inicio];
        i = inicio;
        j = meio;
        k = 0;

        while (i < meio && j < fim) {
            if (v[i] <= v[j]) {
                auxiliar[k] = v[i];
                k++;
                i++;
            } else {
                auxiliar[k] = v[j];
                k++;
                j++;
            }
        }

        while (i < meio) {
            auxiliar[k] = v[i];
            k++;
            i++;
        }

        while (j < fim) {
            auxiliar[k] = v[j];
            k++;
            j++;
        }

        for (i = inicio; i < fim; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }

    // Intercalação para ordenação decrescente
    private void intercalarDecrescente(int inicio, int meio, int fim, int[] v) {
        int i, j, k;
        int[] auxiliar = new int[fim - inicio];
        i = inicio;
        j = meio;
        k = 0;

        while (i < meio && j < fim) {
            if (v[i] >= v[j]) {
                auxiliar[k] = v[i];
                k++;
                i++;
            } else {
                auxiliar[k] = v[j];
                k++;
                j++;
            }
        }

        while (i < meio) {
            auxiliar[k] = v[i];
            k++;
            i++;
        }

        while (j < fim) {
            auxiliar[k] = v[j];
            k++;
            j++;
        }

        for (i = inicio; i < fim; i++) {
            v[i] = auxiliar[i - inicio];
        }
    }
}
