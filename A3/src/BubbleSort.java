import java.util.Arrays;

public class BubbleSort {
    //Ordenando números em ordem crescente
    public void bubbleSortOrdemCrescente(int[] v) {
        int vetorAuxCresc;
        for (int i = 0; i < v.length - 1; i++) {
            System.out.println("Iteracao: " + (i + 1));
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] > v[j]) {
                    vetorAuxCresc = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = vetorAuxCresc;
                }
                System.out.println(Arrays.toString(v));
            }
        }
    }

    public void bubbleSortOrdemDecrescente(int[] v) {
        int vetorAuxDecres;
        for (int i = 0; i < v.length - 1; i++) {
            //System.out.println("Iteracao: " + (i + 1));
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] < v[j]) {  // Alteração da condição para ordem decrescente
                    vetorAuxDecres = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = vetorAuxDecres;
                }
                System.out.println(Arrays.toString(v));
            }
        }
    }
}