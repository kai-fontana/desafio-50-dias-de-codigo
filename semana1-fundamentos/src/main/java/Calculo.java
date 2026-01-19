import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Calculo {
    Scanner input = new Scanner(System.in);
    private ArrayList<Double> numeros = new ArrayList<>();

    public void iniciar() {
        preencherLista();
        if (!numeros.isEmpty()) {
            exibirResultados();
        } else {
            System.out.println("Nenhum número válido foi inserido. Encerrando.");
        }
    }

    private void preencherLista() {
        System.out.println("Digite os números separados por espaço (ex: 10 20.5 30):");
        String linha = input.nextLine();

        String[] partes = linha.split("\\s+");

        for (String parte : partes) {
            try {
                double num = Double.parseDouble(parte.replace(",", "."));
                numeros.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Aviso: '" + parte + "' não é um número válido e foi ignorado.");
            }
        }
    }

    public void exibirResultados() {
        int opcao;
        do {
            System.out.println(""" 
                    --------------------------------- 
                    |           Cálculos            |
                    | ----------------------------- | 
                    | 1 - Calcular a soma;          | 
                    | 2 - Calcular a média;         | 
                    | 3 - Descobrir o maior número; |
                    | 4 - Descobrir o menor número; | 
                    | 0 - Sair;                     |
                    --------------------------------- 
                    """);
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    preencherLista();
                    System.out.println("\n------- RESULTADOS -------");
                    System.out.printf("Números digitados: %s%n", numeros);
                    System.out.println("----------------");
                    System.out.println("Você escolheu somar os números.");
                    double soma = somar();
                    System.out.println("O resultado da soma é: " + soma);
                    System.out.printf("Soma: %.2f%n", soma);
                    System.out.println("------------------\n");
                    break;
                case 2:
                    preencherLista();
                    System.out.println("\n------- RESULTADOS -------");
                    System.out.printf("Números digitados: %s%n", numeros);
                    System.out.println("----------------");
                    System.out.println("Você escolheu calcular a média");
                    double media = calcularMedia();
                    System.out.printf("Média: %.2f%n", media);
                    System.out.println("------------------\n");
                    break;
                case 3:
                    preencherLista();
                    System.out.println("\n------- RESULTADOS -------");
                    System.out.printf("Números digitados: %s%n", numeros);
                    System.out.println("----------------");
                    System.out.println("Você escolheu descobrir o maior");
                    double maior = descobrirMaior();
                    System.out.printf("Maior número: %.2f%n", maior);
                    System.out.println("------------------\n");
                    break;
                case 4:
                    preencherLista();
                    System.out.println("\n------- RESULTADOS -------");
                    System.out.printf("Números digitados: %s%n", numeros);
                    System.out.println("----------------");
                    System.out.println("Você escolheu descobrir o menor");
                    double menor = descobrirMenor();
                    System.out.printf("Menor número: %.2f%n",menor);
                    System.out.println("------------------\n");
                    break;
                default:
                    System.out.println("Ocorreu um erro");
            }
        } while (opcao != 0);
    }

    public double somar() {
        double soma = 0;
        for (double n : numeros) {
            soma += n;
        }
        return soma;
    }

    public double calcularMedia() {
        double media = somar() / numeros.size();
        return media;
    }

    public double descobrirMaior() {
        double maior = Collections.max(numeros);
        return maior;
    }

    public double descobrirMenor() {
        double menor = Collections.min(numeros);
        return menor;
    }
}