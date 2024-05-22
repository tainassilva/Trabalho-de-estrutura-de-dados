public class SelectionSort {

    int iteracao = 0;
    // Implementação do algoritmo Selection Sort em ordem crescente
    public void selectionSortCrescente(int[] vetor) {

        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        // Percorre todo o vetor
        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            int indiceMenor = i; // Assume que o menor elemento é o primeiro do vetor

            // Encontra o índice do menor elemento não ordenado
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            // Troca o menor elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMenor];
            vetor[indiceMenor] = vetor[i];
            vetor[i] = temp;
        }
        System.out.println("O método de ordenação Selection Sort em ordem crescente obteve " + iteracao + " iterações");


        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

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

    // Implementação do algoritmo Selection Sort em ordem decrescente
    public void selectionSortDecrescente(int[] vetor) {

        long tempoInicial = System.currentTimeMillis(); // Captura o tempo inicial
        // Percorre todo o vetor
        for (int i = 0; i < vetor.length - 1; i++) {
            iteracao = i + 1;
            int indiceMaior = i; // Assume que o maior elemento é o primeiro do vetor

            // Encontra o índice do maior elemento não ordenado
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] > vetor[indiceMaior]) {
                    indiceMaior = j;
                }
            }

            // Troca o maior elemento com o primeiro elemento não ordenado
            int temp = vetor[indiceMaior];
            vetor[indiceMaior] = vetor[i];
            vetor[i] = temp;
        }
        System.out.println("O método de ordenação Selection Sort em ordem decrescente obteve " + iteracao + " iterações");

        long tempoFinal = System.currentTimeMillis(); // Captura o tempo final
        long duracaoTotal = tempoFinal - tempoInicial; // Calcula a duração da execução

        if (duracaoTotal >= 60000) {
            double duracaoEmMinutos = duracaoTotal / 60000.0;
            System.out.println("Tempo de execução: " + duracaoEmMinutos + " minutos");
        } else if (duracaoTotal >= 1000) {
            double duracaoEmSegundos = duracaoTotal / 1000.0;
            System.out.println("Tempo de execução : " + duracaoEmSegundos + " segundos");
        } else {
            System.out.println("Tempo de execução : " + duracaoTotal + " milissegundos");
        }
    }
}
