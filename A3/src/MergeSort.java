import java.util.Arrays;

public class MergeSort {

    // Método principal para ordenar em ordem crescente
    public void mergeSortCrescente(int inicio, int fim, int[] v) {
        if (inicio < fim - 1) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSortCrescente(inicio, meio, v);
            mergeSortCrescente(meio, fim, v);
            intercalarCrescente(inicio, meio, fim, v); // Junta os dois vetores
            System.out.println("Merge Sort Crescente: " + Arrays.toString(v));
        }
    }

    // Método principal para ordenar em ordem decrescente
    public void mergeSortDecrescente(int inicio, int fim, int[] v) {
        if (inicio < fim - 1) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSortDecrescente(inicio, meio, v);
            mergeSortDecrescente(meio, fim, v);
            intercalarDecrescente(inicio, meio, fim, v); // Junta os dois vetores
            System.out.println("Merge Sort Decrescente: " + Arrays.toString(v));
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
