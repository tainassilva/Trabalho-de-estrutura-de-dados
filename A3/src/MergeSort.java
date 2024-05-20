import java.util.Arrays;

public class MergeSort {

    // Classe auxiliar para armazenar o contador de iterações
    static class Iteracoes {
        int valor = 0;
    }

    // Método principal para ordenar em ordem crescente
    public void mergeSortCrescente(int inicio, int fim, int[] v) {
        Iteracoes iteracoes = new Iteracoes(); // Contador de iterações
        mergeSortCrescente(inicio, fim, v, iteracoes);
    }

    // Método principal para ordenar em ordem crescente com contador de iterações
    private void mergeSortCrescente(int inicio, int fim, int[] v, Iteracoes iteracoes) {
        if (inicio < fim - 1) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSortCrescente(inicio, meio, v, iteracoes);
            mergeSortCrescente(meio, fim, v, iteracoes);
            intercalarCrescente(inicio, meio, fim, v);
            iteracoes.valor++; // Incrementa o contador de iterações
            System.out.println("Iteração " + iteracoes.valor + ": " + Arrays.toString(v));
        }
    }

    // Método principal para ordenar em ordem decrescente
    public void mergeSortDecrescente(int inicio, int fim, int[] v) {
        Iteracoes iteracoes = new Iteracoes(); // Contador de iterações
        mergeSortDecrescente(inicio, fim, v, iteracoes);
    }

    // Método principal para ordenar em ordem decrescente com contador de iterações
    private void mergeSortDecrescente(int inicio, int fim, int[] v, Iteracoes iteracoes) {
        if (inicio < fim - 1) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSortDecrescente(inicio, meio, v, iteracoes);
            mergeSortDecrescente(meio, fim, v, iteracoes);
            intercalarDecrescente(inicio, meio, fim, v);
            iteracoes.valor++; // Incrementa o contador de iterações
            System.out.println("Iteração " + iteracoes.valor + ": " + Arrays.toString(v));
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
