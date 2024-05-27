public class SelectionSort {

    int iteracao = 0;

    public void selectionSortCrescente(int[] vetor) {
        long tempoInicial = System.nanoTime();

        // Percorre todo o vetor
        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            int indiceMenor = i; // Assume que o menor elemento é o primeiro do vetor

            // Encontra o índice do menor elemento não ordenado
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j; // Atualiza o índice do menor elemento
                }
            }
            // Troca o menor elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMenor];
            vetor[indiceMenor] = vetor[i];
            vetor[i] = temp;
        }

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Selection Sort em ordem crescente obteve " + iteracao + " iterações");
        exibirTempoExecucao(duracaoTotal);
    }

    public void selectionSortDecrescente(int[] vetor) {
        long tempoInicial = System.nanoTime();
        // Percorre todo o vetor
        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            int indiceMaior = i; // Assume que o maior elemento é o primeiro do vetor

            // Encontra o índice do maior elemento não ordenado
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] > vetor[indiceMaior]) {
                    indiceMaior = j; // Atualiza o índice do maior elemento
                }
            }

            // Troca o maior elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMaior];
            vetor[indiceMaior] = vetor[i];
            vetor[i] = temp;
        }

        long tempoFinal = System.nanoTime();
        long duracaoTotal = tempoFinal - tempoInicial;

        System.out.println("O método de ordenação Selection Sort em ordem decrescente obteve " + iteracao + " iterações");
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
