import java.util.Arrays;

public class BubbleSort {
    // Variável para controlar se houve trocas para a ordenação do vetor
    boolean houveTrocas;

    // Ordenando números em ordem crescente
    public void bubbleSortCrescente(int[] v) {
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        int vetorAuxCresc;
        for (int i = 0; i < v.length - 1; i++) {
            System.out.println("Iteracao: " + (i + 1));
            houveTrocas = false; // Redefinir a variável a cada iteração do loop externo
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] > v[j]) {
                    vetorAuxCresc = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = vetorAuxCresc;
                    houveTrocas = true;
                }
                System.out.println(Arrays.toString(v));
            }
            // Se não houve troca, a lista está ordenada
            if (!houveTrocas) {
                break;
            }
        }
        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução
        System.out.println("Tempo de execução do Bubble Sort Crescente: " + duracaoTotal+ " milissegundos");
    }

    // Ordenando números em ordem decrescente
    public void bubbleSortDecrescente(int[] v) {
        long startTime = System.currentTimeMillis(); // Captura o tempo inicial
        int vetorAuxDecres;
        for (int i = 0; i < v.length - 1; i++) {
            System.out.println("Iteracao: " + (i + 1));
            houveTrocas = false; // Redefinir a variável a cada iteração do loop externo
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] < v[j]) {  // Alteração da condição para ordem decrescente
                    vetorAuxDecres = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = vetorAuxDecres;
                    houveTrocas = true;
                }
                System.out.println(Arrays.toString(v));
            }
            // Se não houve troca, a lista está ordenada
            if (!houveTrocas) {
                break;
            }
        }
        long endTime = System.currentTimeMillis(); // Captura o tempo final
        long duration = endTime - startTime; // Calcula a duração da execução
        System.out.println("Tempo de execução: " + duration + " milissegundos");
    }
}
