import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AplicandoOrdenacao {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String desejaOrdenar;
        int estruturaOrdenacao;
        int[] vetor = null;
        long tempoInicialDeExecucao;
        long tempoFinalDeExecucao;
        long duracaoVetorDesorganizado;
        int tamanhoVetor = 0;

        // Instanciando a classe para as ordenações
        BubbleSort bubble = new BubbleSort();
        SelectionSort selection = new SelectionSort();
        InsertionSort insertion = new InsertionSort();
        QuickSort quick = new QuickSort();
        MergeSort merge = new MergeSort();

        do {
            while (true) {
                try {
                    System.out.print("Escolha o método para ordenar o vetor:\n1 - Bubble Sort\n2 - Selection Sort\n3 - Insertion Sort\n" +
                            "4 - Quick Sort\n5 - Merge Sort\n");
                    estruturaOrdenacao = entrada.nextInt();
                    if (estruturaOrdenacao >= 1 && estruturaOrdenacao <= 5) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-5).");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    entrada.next(); // Limpa a entrada inválida
                }
            }

            switch (estruturaOrdenacao) {
                case 1:
                while (true) {
                    try {
                        System.out.print("Digite o tamanho do vetor entre os valores citados abaixo: \n100\n1.000\n10.000\n100.000\n1.000.000\n");
                        tamanhoVetor = entrada.nextInt();
                        if (tamanhoVetor == 10 || tamanhoVetor == 1000 || tamanhoVetor == 10000 || tamanhoVetor == 100000 || tamanhoVetor == 1000000) {
                            break;
                        } else {
                            System.out.println("Por favor, insira um número das opções citadas: \n100\n1.000\n10.000\n100.000\n1.000.000.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        entrada.next(); // Limpa a entrada inválida
                    }
                }

                vetor = new int[tamanhoVetor]; // Inicialização do vetor movida para este ponto
                Random random = new Random();
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random.nextInt(1000);
                }

                System.out.println("Vetor original:\n" + Arrays.toString(vetor));

                int tipoDeOrdenacao;
                while (true) {
                    System.out.print("Qual vetor gostaria de ordenar:\n1 - Vetor desordenado em ordem crescente\n2- Vetor desordenado em ordem crescente" +
                            "\n3 - Vetor ordenado em ordem crescente\n4 - Vetor ordenado em ordem decrescente\n");
                    tipoDeOrdenacao = entrada.nextInt();
                    if (tipoDeOrdenacao >= 1 && tipoDeOrdenacao <= 4) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-4).");
                    }
                }

                switch (tipoDeOrdenacao) {
                    case 1:
                        tempoInicialDeExecucao = System.nanoTime();
                        bubble.bubbleSortCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;
                    case 2:
                        tempoInicialDeExecucao = System.nanoTime();
                        bubble.bubbleSortDecrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;

                    case 3:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente

                        tempoInicialDeExecucao = System.nanoTime();
                        bubble.bubbleSortCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorCrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorCrescente / 1_000_000);
                        break;
                    case 4:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                        inverterVetor(vetor); // Inverte o vetor para ordem decrescente

                        tempoInicialDeExecucao = System.nanoTime();
                        bubble.bubbleSortDecrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorDecrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDecrescente / 1_000_000);
                        break;
                }
                break;
            case 2:
                while (true) {
                    try {
                        System.out.print("Digite o tamanho do vetor entre os valores citados abaixo: \n100\n1.000\n10.000\n100.000\n1.000.000\n");
                        tamanhoVetor = entrada.nextInt();
                        if (tamanhoVetor == 10 || tamanhoVetor == 1000 || tamanhoVetor == 10000 || tamanhoVetor == 100000 || tamanhoVetor == 1000000) {
                            break;
                        } else {
                            System.out.println("Por favor, insira um número das opções citadas: \n100\n1.000\n10.000\n100.000\n1.000.000.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        entrada.next(); // Limpa a entrada inválida
                    }
                }
                vetor = new int[tamanhoVetor]; // Inicialização do vetor movida para este ponto
                Random random1 = new Random();
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random1.nextInt(1000);
                }

                System.out.println("Vetor original:\n" + Arrays.toString(vetor));

                int tipoDeOrdenacao1;
                while (true) {
                    System.out.print("Qual vetor gostaria de ordenar:\n1 - Vetor desordenado em ordem crescente\n2- Vetor desordenado em ordem crescente" +
                            "\n3 - Vetor ordenado em ordem crescente\n4 - Vetor ordenado em ordem decrescente\n");
                    tipoDeOrdenacao1= entrada.nextInt();
                    if (tipoDeOrdenacao1 >= 1 && tipoDeOrdenacao1 <= 4) {
                        break;
                    } else {
                        System.out.println("Por favor, esacolha uma opção válida (1-4).");
                    }
                }
                switch (tipoDeOrdenacao1) {
                    case 1:
                        tempoInicialDeExecucao = System.nanoTime();
                        selection.selectionSortCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;
                    case 2:
                        tempoInicialDeExecucao = System.nanoTime();
                        selection.selectionSortDecrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;

                    case 3:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente

                        tempoInicialDeExecucao = System.nanoTime();
                        selection.selectionSortCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorCrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorCrescente / 1_000_000);
                        break;
                    case 4:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                        inverterVetor(vetor); // Inverte o vetor para ordem decrescente

                        tempoInicialDeExecucao = System.nanoTime();
                        selection.selectionSortDecrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorDecrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDecrescente / 1_000_000);
                        break;
                }
                break;
            case 3:
                while (true) {
                    try {
                        System.out.print("Digite o tamanho do vetor entre os valores citados abaixo: \n100\n1.000\n10.000\n100.000\n1.000.000\n");
                        tamanhoVetor = entrada.nextInt();
                        if (tamanhoVetor == 10 || tamanhoVetor == 1000 || tamanhoVetor == 10000 || tamanhoVetor == 100000 || tamanhoVetor == 1000000) {
                            break;
                        } else {
                            System.out.println("Por favor, insira um número das opções citadas: \n100\n1.000\n10.000\n100.000\n1.000.000.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        entrada.next(); // Limpa a entrada inválida
                    }
                }

                vetor = new int[tamanhoVetor]; // Inicialização do vetor movida para este ponto
                Random random2 = new Random();
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random2.nextInt(1000);
                }

                System.out.println("Vetor original:\n" + Arrays.toString(vetor));

                int tipoDeOrdenacao2;
                while (true) {
                    System.out.print("Qual vetor gostaria de ordenar:\n1 - Vetor desordenado em ordem crescente\n2- Vetor desordenado em ordem crescente" +
                            "\n3 - Vetor ordenado em ordem crescente\n4 - Vetor ordenado em ordem decrescente\n");
                    tipoDeOrdenacao2= entrada.nextInt();
                    if (tipoDeOrdenacao2 >= 1 && tipoDeOrdenacao2 <= 4) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-4).");
                    }
                }
                switch (tipoDeOrdenacao2) {
                    case 1:
                        tempoInicialDeExecucao = System.nanoTime();
                        insertion.insertionSortCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;
                    case 2:
                        tempoInicialDeExecucao = System.nanoTime();
                        insertion.insertionSortDecrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;

                    case 3:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente

                        tempoInicialDeExecucao = System.nanoTime();
                        insertion.insertionSortCrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorCrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorCrescente / 1_000_000);
                        break;
                    case 4:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                        inverterVetor(vetor); // Inverte o vetor para ordem decrescente

                        tempoInicialDeExecucao = System.nanoTime();
                        insertion.insertionSortDecrescente(vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorDecrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDecrescente / 1_000_000);
                        break;
                }
                break;
            case 4:
                while (true) {
                try {
                    System.out.print("Digite o tamanho do vetor entre os valores citados abaixo: \n100\n1.000\n10.000\n100.000\n1.000.000\n");
                    tamanhoVetor = entrada.nextInt();
                    if (tamanhoVetor == 10 || tamanhoVetor == 1000 || tamanhoVetor == 10000 || tamanhoVetor == 100000 || tamanhoVetor == 1000000) {
                        break;
                    } else {
                        System.out.println("Por favor, insira um número das opções citadas: \n100\n1.000\n10.000\n100.000\n1.000.000.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    entrada.next(); // Limpa a entrada inválida
                }
            }

                vetor = new int[tamanhoVetor]; // Inicialização do vetor movida para este ponto
                Random random3 = new Random();
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random3.nextInt(1000);
                }

                System.out.println("Vetor original:\n" + Arrays.toString(vetor));

                int tipoDeOrdenacao3;
                while (true) {
                    System.out.print("Qual vetor gostaria de ordenar:\n1 - Vetor desordenado em ordem crescente\n2- Vetor desordenado em ordem crescente" +
                            "\n3 - Vetor ordenado em ordem crescente\n4 - Vetor ordenado em ordem decrescente\n");
                    tipoDeOrdenacao3= entrada.nextInt();
                    if (tipoDeOrdenacao3 >= 1 && tipoDeOrdenacao3 <= 4) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-4).");
                    }
                }
                switch (tipoDeOrdenacao3) {
                    case 1:
                        tempoInicialDeExecucao = System.nanoTime();
                        quick.quickSortCrescente(vetor, 0, vetor.length-1);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;
                    case 2:
                        tempoInicialDeExecucao = System.nanoTime();
                        quick.quickSortDecrescente(vetor,vetor.length-1, 0 );
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;

                    case 3:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente

                        tempoInicialDeExecucao = System.nanoTime();
                        quick.quickSortCrescente(vetor,0, vetor.length);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorCrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorCrescente / 1_000_000);
                        break;
                    case 4:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                        inverterVetor(vetor); // Inverte o vetor para ordem decrescente

                        tempoInicialDeExecucao = System.nanoTime();
                        quick.quickSortDecrescente(vetor, vetor.length, 0);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorDecrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDecrescente / 1_000_000);
                        break;
                }
                break;
            case 5:
                while (true) {
                    try {
                        System.out.print("Digite o tamanho do vetor entre os valores citados abaixo: \n100\n1.000\n10.000\n100.000\n1.000.000\n");
                        tamanhoVetor = entrada.nextInt();
                        if (tamanhoVetor == 10 || tamanhoVetor == 1000 || tamanhoVetor == 10000 || tamanhoVetor == 100000 || tamanhoVetor == 1000000) {
                            break;
                        } else {
                            System.out.println("Por favor, insira um número das opções citadas: \n100\n1.000\n10.000\n100.000\n1.000.000.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                        entrada.next(); // Limpa a entrada inválida
                    }
                }

                vetor = new int[tamanhoVetor]; // Inicialização do vetor movida para este ponto
                Random random4 = new Random();
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random4.nextInt(1000);
                }

                System.out.println("Vetor original:\n" + Arrays.toString(vetor));

                int tipoDeOrdenacao4;
                while (true) {
                    System.out.print("Qual vetor gostaria de ordenar:\n1 - Vetor desordenado em ordem crescente\n2- Vetor desordenado em ordem crescente" +
                            "\n3 - Vetor ordenado em ordem crescente\n4 - Vetor ordenado em ordem decrescente\n");
                    tipoDeOrdenacao4= entrada.nextInt();
                    if (tipoDeOrdenacao4 >= 1 && tipoDeOrdenacao4 <= 4) {
                        break;
                    } else {
                        System.out.println("Por favor, escolha uma opção válida (1-4).");
                    }
                }
                switch (tipoDeOrdenacao4) {
                    case 1:
                        tempoInicialDeExecucao = System.nanoTime();
                        merge.mergeSortCrescente(0, vetor.length, vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;
                    case 2:
                        tempoInicialDeExecucao = System.nanoTime();
                        merge.mergeSortDecrescente(0, vetor.length, vetor);
                        tempoFinalDeExecucao = System.nanoTime();

                        duracaoVetorDesorganizado = tempoFinalDeExecucao - tempoInicialDeExecucao;

                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDesorganizado / 1_000_000);
                        break;

                    case 3:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente

                        tempoInicialDeExecucao = System.nanoTime();
                        quick.quickSortCrescente(vetor,0, vetor.length);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorCrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorCrescente / 1_000_000);
                        break;
                    case 4:
                        Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                        inverterVetor(vetor); // Inverte o vetor para ordem decrescente

                        tempoInicialDeExecucao = System.nanoTime();
                        quick.quickSortDecrescente(vetor, vetor.length, 0);
                        tempoFinalDeExecucao = System.nanoTime();

                        long duracaoVetorDecrescente = tempoFinalDeExecucao - tempoInicialDeExecucao;
                        System.out.println("Tempo de execução em milissegundos: " + duracaoVetorDecrescente / 1_000_000);
                        break;
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
            while (true) {
                System.out.print("Deseja ordenar com mais algum tipo de algoritmo de ordenação?\n" +
                        "s - Sim\nn - Não\n");
                desejaOrdenar = entrada.next();
                if (desejaOrdenar.equalsIgnoreCase("s") || desejaOrdenar.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("Por favor, insira 's' para sim ou 'n' para não.");
                }
            }

        } while (desejaOrdenar.equalsIgnoreCase("s"));

        entrada.close();
    }
    public static void inverterVetor(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[n - 1 - i];
            vetor[n - 1 - i] = temp;
        }
    }
}
