import org.apache.commons.math3.analysis.function.Multiply;

import java.util.Scanner;

public class ListaBanco {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String auxiliar;
        int opcao;
        double valor;
        System.out.println("Digite o nome do titular da Conta: ");
        auxiliar = in.nextLine();
        Conta c1 = new Conta(auxiliar);
        do {
            System.out.println("------- Menu -------");
            System.out.println("1- Dados Bancarios");
            System.out.println("2- Depositar");
            System.out.println("3- Sacar");
            System.out.println("4- Consultar Juros");
            System.out.println("0- Sair");
            System.out.println("--------------------");
            System.out.println("Digite sua opção: ");
            opcao = in.nextInt();
            if (opcao == 1) {
                c1.DadosBancarios();
            } else if (opcao == 2) {
                System.out.println("Digite o valor do deposito: ");
                valor = in.nextDouble();
                c1.Depositar(valor);
            } else if (opcao == 3) {
                System.out.println("Digite o valor do saque: ");
                valor = in.nextDouble();
                c1.Sacar(valor);
            } else if (opcao == 4) {
                System.out.println("Qual será a forma de consulta:");
                System.out.println("1 - Consulta de forma pré definida");
                System.out.println("2 - Consulta por valor inserido");
                System.out.println("Digite o numero da opção desejada:");
                int escolha = in.nextInt();
                if (escolha == 1) {
                    System.out.println("Consultando os dias...");
                    double result30 = new Multiply().value(c1.getSaldo(), 0.05);
                    double result60 = new Multiply().value(c1.getSaldo(), 0.10);
                    double result90 = new Multiply().value(c1.getSaldo(), 0.15);
                    System.out.printf("[30 dias] R$ %.2f\n", result30);
                    System.out.printf("[60 dias] R$ %.2f\n", result60);
                    System.out.printf("[90 dias] R$ %.2f\n", result90);
                } else if (escolha == 2) {
                    System.out.println("Consultar por: \n 30 dias \n 60 dias \n 90 dias");
                    c1.setJuros(in.nextInt());
                    in.nextLine();
                    System.out.println("Entre com o valor que você deseja acrescentar os juros:");
                    valor = in.nextDouble();
                    int juros = c1.getJuros();
                    if (juros == 30) {
                        double valorFinal = valor + new Multiply().value(valor, 0.05);
                        System.out.println("R$ " + valorFinal);
                    } else if (juros == 60) {
                        double valorFinal = valor + new Multiply().value(valor, 0.10);
                        System.out.println("R$ " + valorFinal);
                    } else if (juros == 90) {
                        double valorFinal = valor + new Multiply().value(valor, 0.15);
                        System.out.println("R$ " + valorFinal);
                    }
                }
            } else if (opcao != 0) {
                System.out.println("Opção Invalida!");
            }
            System.out.println("");
        } while (opcao != 0);
    }
}
