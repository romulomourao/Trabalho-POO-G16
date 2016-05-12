
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author romul
 */
public class Mercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Gerente manager = new Gerente("Romulo", "12925654703", "123456");
        System.out.println(manager.getCpf() + " " + manager.getNome());
        
        
        novoProduto(in);
        novaVenda(in);

    }

    private static void novaVenda(Scanner in) {
        //Inicializa ArrayList com os produtos que serão comprados pelo cliente
        ArrayList<Produto> compraAtual;
        compraAtual = new ArrayList<>();
        Produto sendoComprado;
        int gramas, unidades;
        double total = 0;
        boolean computando = true;
        while (computando) {
            System.out.println("");
            String codBarras = in.nextLine();
            sendoComprado = procuraProduto(codBarras);
            if (sendoComprado.isVendidoPorPeso()) {
                //Se for TRUE ele vai pegar o valor 
                System.out.println("Qual a quantidade em gramas de" + sendoComprado.getNome() + "? (apenas números)");
                gramas = in.nextInt();
                total += ((gramas * sendoComprado.getPreco()) / 1000);

            } else {
                System.out.println("Quantas unidades de " + sendoComprado.getNome() + "? (apenas números)");
                unidades = in.nextInt();
                total += (unidades * sendoComprado.getPreco());
            }

            System.out.println("Subtotal: " + total);

        }
    }

    private static Produto procuraProduto(String novoItem) {     
        return Colecoes.findProduto(novoItem);
    }

    private static void novoProduto(Scanner in) {
        boolean vendidoPorPeso = false;
        System.out.println("---| NOVO PRODUTO |---");
        System.out.println("COD.  : ");
        String codBarras = in.nextLine();
        System.out.println("NOME  : ");
        String nome = in.nextLine();
        System.out.println("DESCR.: ");
        String descricao = in.nextLine();
        System.out.println("PREÇO : ");
        double preco = in.nextDouble();
        System.out.println("QTD   : ");
        double qtdEstoque = in.nextDouble();
        System.out.println(nome+" é vendido por peso? (s/n): ");
        if(in.next().equals("s")){
            vendidoPorPeso = true;
        }
        //Cria novo produto com a entrada do gerente e adiciona no "banco de dados"
        Produto novo = new Produto(nome, descricao, vendidoPorPeso, codBarras, preco, qtdEstoque);
        Colecoes.addProduto(novo);

    }

}
