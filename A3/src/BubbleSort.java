public class BubbleSort {
    // Método para ordenação em ordem crescente
    public void bubbleSortCrescente(int[] vetor) {
        long tempoInicial = System.nanoTime(); // Captura o tempo inicial
        int vetorAuxCresc;
        int iteracao = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            //boolean houveTrocas = false; // Redefinir a variável a cada iteração do loop externo
            for (int j = 1; j < (vetor.length - i); j++) {
                if (vetor[j - 1] > vetor[j]) {
                    vetorAuxCresc = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = vetorAuxCresc;
                    //houveTrocas = true;
                }
            }
            // Se não houve troca, a lista está ordenada
//            if (!houveTrocas) {
//                break;
//            }
        }

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Bubble Sort em ordem crescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    // Método para ordenação em ordem decrescente
    public void bubbleSortDecrescente(int[] v) {
        long tempoInicial = System.nanoTime(); // Captura o tempo inicial
        int vetorAuxDecres;
        int iteracao = 0;

        for (int i = 0; i < v.length - 1; i++) {
            iteracao = i + 1;
            //boolean houveTrocas = false; // Redefinir a variável a cada iteração do loop externo
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] < v[j]) {  // Alteração da condição para ordem decrescente
                    vetorAuxDecres = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = vetorAuxDecres;
                    //houveTrocas = true;
                }
            }
            // Se não houve troca, a lista está ordenada
//            if (!houveTrocas) {
//                break;
//            }
        }

        long tempoFinal = System.nanoTime(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Bubble Sort em ordem decrescente obteve " + iteracao + " iterações");
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
}
