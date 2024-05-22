public class BubbleSort {
//    boolean houveTrocas;
    int iteracao = 0;

    // Ordenando números em ordem crescente
    public void bubbleSortCrescente(int[] v) {
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        int vetorAuxCresc;
        for (int i = 0; i < v.length - 1; i++) {
            iteracao = i + 1;
//            houveTrocas = false; // Redefinir a variável a cada iteração do loop externo
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] > v[j]) {
                    vetorAuxCresc = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = vetorAuxCresc;
//                    houveTrocas = true;
                }
            }
             //Se não houve troca, a lista está ordenada
//            if (!houveTrocas) {
//                break;
//            }
        }
        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Bubble Sort em ordem crescente obteve " + iteracao + " iterações");
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

    // Ordenando números em ordem decrescente
    public void bubbleSortDecrescente(int[] v) {
        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        int vetorAuxDecres;
        for (int i = 0; i < v.length - 1; i++) {
            iteracao = i + 1;
//            houveTrocas = false; // Redefinir a variável a cada iteração do loop externo
            for (int j = 1; j < (v.length - i); j++) {
                if (v[j - 1] < v[j]) {  // Alteração da condição para ordem decrescente
                    vetorAuxDecres = v[j - 1];
                    v[j - 1] = v[j];
                    v[j] = vetorAuxDecres;
//                    houveTrocas = true;
                }
            }
            // Se não houve troca, a lista está ordenada
//            if (!houveTrocas) {
//                break;
//            }
        }
        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        System.out.println("O método de ordenação Bubble Sort em ordem decrescente obteve " + iteracao + " iterações");

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
