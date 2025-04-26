import java.util.Locale;
import java.util.Scanner;

import static java.util.Locale.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Olá, seja bem-vindo(a) ao Poupe Pague.\n");
        System.out.println("Para começar, Digite o limite do seu cartão: ");
        double limite = sc.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while(sair != 0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = sc.next();

            System.out.println("Digite o valor da compra: ");
            double valor = sc.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 1 para realizar uma nova compra ou 0 para sair.");
                sair = sc.nextInt();
            } else {
                System.out.println("Desculpe, saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("**********************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        for (Compra c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - R$" + c.getValor());
        }
        System.out.println("\n**********************************");

        System.out.println("\nSaldo do cartão: R$" + cartao.getSaldo());
        System.out.println("Obrigado(a) por utilizar nossos serviços. Volte sempre :) .");

        sc.close();
    }
}
