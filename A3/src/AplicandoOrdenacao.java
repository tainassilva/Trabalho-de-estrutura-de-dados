import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AplicandoOrdenacao {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String desejaOrdenar;

        do {
            int estruturaOrdenacao = escolherMetodoOrdenacao(entrada);
            int tamanhoVetor = escolherTamanhoVetor(entrada);
            int[] vetor = gerarVetorAleatorio(tamanhoVetor);

            int tipoDeOrdenacao = escolherTipoOrdenacao(entrada);
            long duracaoOrdenacao = executarOrdenacao(estruturaOrdenacao, tipoDeOrdenacao, vetor);

            System.out.println("Tempo de execução em milissegundos: " + duracaoOrdenacao / 1_000_000);

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

    public static int escolherMetodoOrdenacao(Scanner entrada) {
        int estruturaOrdenacao;
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
        return estruturaOrdenacao;
    }

    public static int escolherTamanhoVetor(Scanner entrada) {
        int tamanhoVetor = 0;
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
        return tamanhoVetor;
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(1000);
        }
        System.out.println("Vetor original:\n" + Arrays.toString(vetor));
        return vetor;
    }

    public static int escolherTipoOrdenacao(Scanner entrada) {
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
        return tipoDeOrdenacao;
    }

    public static long executarOrdenacao(int metodo, int tipoOrdenacao, int[] vetor) {
        long tempoInicial = System.nanoTime();
        switch (metodo) {
            case 1:
                BubbleSort bubble = new BubbleSort();
                if (tipoOrdenacao == 1) {
                    bubble.bubbleSortCrescente(vetor);
                } else if (tipoOrdenacao == 2) {
                    bubble.bubbleSortDecrescente(vetor);
                } else if (tipoOrdenacao == 3) {
                    Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                    bubble.bubbleSortCrescente(vetor);
                } else if (tipoOrdenacao == 4) {
                    Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                    inverterVetor(vetor); // Inverte o vetor para ordem decrescente
                    bubble.bubbleSortDecrescente(vetor);
                }
                break;
            case 2:
                SelectionSort selection = new SelectionSort();
                if (tipoOrdenacao == 1) {
                    selection.selectionSortCrescente(vetor);
                } else if (tipoOrdenacao == 2) {
                    selection.selectionSortDecrescente(vetor);
                } else if (tipoOrdenacao == 3) {
                    Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                    selection.selectionSortCrescente(vetor);
                } else if (tipoOrdenacao == 4) {
                    Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                    inverterVetor(vetor); // Inverte o vetor para ordem decrescente
                    selection.selectionSortDecrescente(vetor);
                }
                break;
            case 3:
                InsertionSort insertion = new InsertionSort();
                if (tipoOrdenacao == 1) {
                    insertion.insertionSortCrescente(vetor);
                } else if (tipoOrdenacao == 2) {
                    insertion.insertionSortDecrescente(vetor);
                } else if (tipoOrdenacao == 3) {
                    Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                    insertion.insertionSortCrescente(vetor);
                } else if (tipoOrdenacao == 4) {
                    Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                    inverterVetor(vetor); // Inverte o vetor para ordem decrescente
                    insertion.insertionSortDecrescente(vetor);
                    break;
                }
                    case 4:
                        QuickSort quick = new QuickSort();
                        if (tipoOrdenacao == 1) {
                            quick.quickSortCrescente(vetor, 0, vetor.length - 1);
                        }
                        else if (tipoOrdenacao == 2) {
                            quick.quickSortDecrescente(vetor, 0, vetor.length - 1);
                        }else if (tipoOrdenacao == 3) {
                            Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                            quick.quickSortCrescente(vetor, 0, vetor.length - 1);
                        } else if (tipoOrdenacao == 4) {
                            Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                            inverterVetor(vetor); // Inverte o vetor para ordem decrescente
                            quick.quickSortDecrescente(vetor, 0, vetor.length - 1);
                        }
                        break;
                    case 5:
                        MergeSort merge = new MergeSort();
                        if (tipoOrdenacao == 1) {
                            merge.mergeSortCrescente(0, vetor.length, vetor);
                        } else if (tipoOrdenacao == 2){
                            merge.mergeSortDecrescente(0, vetor.length, vetor);
                            } else if (tipoOrdenacao == 3) {
                            Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                            merge.mergeSortCrescente(0, vetor.length, vetor);
                        } else if (tipoOrdenacao == 4) {
                            Arrays.sort(vetor); // Ordena o vetor em ordem crescente
                            inverterVetor(vetor); // Inverte o vetor para ordem decrescente
                            merge.mergeSortDecrescente(0, vetor.length, vetor);
                        }
                        break;
                }
                long tempoFinal = System.nanoTime();
                return tempoFinal - tempoInicial;
        }
    public static void inverterVetor ( int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[n - 1 - i];
            vetor[n - 1 - i] = temp;
        }
    }

}