public class BubbleSort {
    public void bubbleSortCrescente(int[] vetor) {
        long tempoInicial = System.nanoTime();
        int vetorAuxCresc; // Variável auxiliar para troca de elementos
        int iteracao = 0;

        // Loop externo para controlar o número de passagens pelo vetor
        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            //boolean houveTrocas = false;

            // Loop interno para realizar a comparação e troca de elementos
            for (int j = 1; j < (vetor.length - i); j++) {
                if (vetor[j - 1] > vetor[j]) { // Verifica se o indice anterior é maior que o seguinte
                    // Troca os elementos sempre levando o maior para o fim do vetor
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

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Bubble Sort em ordem crescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    public void bubbleSortDecrescente(int[] v) {
        long tempoInicial = System.nanoTime();
        int vetorAuxDecres; // Variável auxiliar para troca de elementos
        int iteracao = 0;

        // Loop externo para controlar o número de passagens pelo vetor
        for (int i = 0; i < v.length - 1; i++) {
            iteracao = i + 1;

            //boolean houveTrocas = false;

            // Loop interno para realizar a comparação e troca de elementos
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] < v[j]) { // Verifica índice anterior é menor que o seguinte
                    // Troca os elementos, sempre levando o menor para o inicio do vetor
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

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Bubble Sort em ordem decrescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
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
