import java.util.*;

public class Calculo {
    Scanner input = new Scanner(System.in);
    private int opcao;
    private List<Double> numeros = new ArrayList<>();

    public void iniciar() {
        preencherLista();
        if (!numeros.isEmpty()) {
            for(double n : numeros) {
                if (n >= 0) {
                    exibirResultados();
                }
            }
        }else {
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

    public void exibirMenu() {

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
    }

    public void exibirResultados() {

        do {
            exibirMenu();
            switch (opcao) {
                case 1:
                    double soma = somar();
                    System.out.printf("""
                    ---------------------------------
                    |  Resultados                   |
                    | ----------------------------- | 
                    |  Números digitados:           |
                    |  %s                           |
                    |  Vamos somar os números!      |
                    |  O resultado da soma é: %.2f  |
                    ---------------------------------
                    """, numeros, soma);
                    break;
                case 2:
                    double media = calcularMedia();

                    System.out.printf("""
                    ----------------------------------
                    | Resultados                     |
                    | ------------------------------ | 
                    | Números digitados:             |
                    | %s                             |
                    | Vamos ver a média dos números! |
                    | O resultado da média é: %.2f%n |
                    ----------------------------------
                    """, numeros, media);
                    break;
                case 3:
                    double maior = descobrirMaior();

                    System.out.printf("""
                    ------------;.m----------------------
                    | Resultados                     |
                    | ------------------------------ | 
                    | Números digitados:             |
                    | %s                             |
                    | Vamos ver o maior dos números! |
                    | Descobrimos o resultado: %.2f%n|
                    ---------------------------------- 
                    """, numeros, maior);
                    break;
                case 4:
                    double menor = descobrirMenor();

                    System.out.printf("""
                    ----------------------------------
                    | Resultados                     |
                    | ------------------------------ | 
                    | Números digitados:             |
                    | %s                             |
                    | Vamos ver o menor dos números! |
                    | Descobrimos o resultado: %.2f%n|
                    ---------------------------------- 
                    """, numeros, menor);
                    break;
                default:
                    System.out.println("Ocorreu um erro. Tente novamente!");
                    exibirResultados();
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