import java.util.Arrays;

public class InsertionSort {

    public void insertionSortCrescente(int[] vetor) {
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        int iteracao = 0; // Variável para controlar o número de iterações

        for (int i = 1; i < vetor.length ; i++) {
            iteracao = i;
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação insertion Sort em ordem crescente obteve " + iteracao + " iterações");
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
    }

    public void insertionSortDecrescente(int[] vetor) {
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        int iteracao = 0; // Variável para controlar o número de iterações

        for (int i = 1; i < vetor.length; i++) {
            iteracao = i;
            int chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] < chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }

        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação insertion Sort em ordem decrescente obteve " + iteracao + " iterações");
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
    }
}
