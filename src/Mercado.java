
import model.ItemDeVenda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javafx.scene.input.KeyEvent;

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
    

    }
    /*

    private static void novaVenda(Scanner in, Estoque estoque) {
        //Inicializa ArrayList com os produtos que serão comprados pelo cliente
        ArrayList<ItemDeVenda> compraAtual;
        compraAtual = new ArrayList<>();

        ItemDeVenda itemComprado;

        //Declara um objeto que será usado pra alocar cada produto encontrado pelo leitor
        ItemDeEstoque sendoComprado;
        int gramas, unidades;
        double total = 0;
        boolean computando = true;
        while (computando) {
            System.out.println("0 - CANCELAR COMPRA");
            System.out.println("1 - FINALIZAR COMPRA");
            System.out.print("Cod. do Produto: ");
            String codBarras = in.nextLine();

            //Cancela compra se for digitado 0
            if (codBarras.equals("0")) {
                System.out.println("| COMPRA CANCELADA |");
                break;
            }else if(codBarras.equals("1")){
                System.out.println("TOTAL: "+total);
                break;
            }

            //Procura o produto no estoque, caso não exista ele voltará para o while
            sendoComprado = procuraItemNoEstoque(codBarras, estoque);
            if (sendoComprado == null) {
                System.out.println("PRODUTO NÃO EXISTE");
                System.out.println("");
                //Se for vendido por peso, o calculo é diferente    
            } else if (sendoComprado.getProduto().isVendidoPorPeso()) {
                //Se for TRUE ele vai pegar o valor 
                System.out.println("Qual a quantidade em gramas de" + sendoComprado.getProduto().getNome() + "? (apenas números)");
                gramas = in.nextInt();
                total += ((gramas * sendoComprado.getPrecoItem()) / 1000);
                in.nextLine();
                //Perguntará quantas unidades do produto atual    
            } else {
                System.out.println("Quantas unidades de " + sendoComprado.getProduto().getNome() + "? (apenas números)");
                unidades = in.nextInt();
                in.nextLine();
                //testa se a quantidade que o consumidor quer é superior a quantidade em estoque
                if (sendoComprado.getQuantidade() < unidades) {
                    System.out.println("Só temos " + sendoComprado.getQuantidade() + " unidade em estoque");
                    System.out.println("Quantas unidades deseja?");
                    unidades = in.nextInt();
                    in.nextLine();
                }
                //Faz o calculo da quantidade * preço e vai adicionando na variavel total
                total += ((int) unidades * sendoComprado.getPrecoItem());
                //Cria um objeto ItemDeVenda com o produto em questão
                itemComprado = new ItemDeVenda(sendoComprado.getProduto(), unidades);
                //Adiciona o ItemDeVenda na lista de itens de venda
                compraAtual.add(itemComprado);
                System.out.println("+-----PRODUTO------+----PREÇO----+---QTD---+----SUBTOTAL----+");
                String alinhamento = "| %-16s | %-11.2f | %-7d | %-14.2f |%n";
                System.out.format(alinhamento, sendoComprado.getProduto().getNome(), sendoComprado.getPrecoItem(), unidades, (unidades * sendoComprado.getPrecoItem()));
            }

        }

        System.out.println("+-----PRODUTO------+----PREÇO----+---QTD---+----SUBTOTAL----+");
        String alinhamento = "| %-16s | %-11.2f | %-7.2f | %-14.2f |%n";
        double subtotal;
        for (int i = 0; i < compraAtual.size(); i++) {
            subtotal = compraAtual.get(i).getProduto().getPreco() * compraAtual.get(i).getQuantidade();
            System.out.format(alinhamento, compraAtual.get(i).getProduto().getNome(), compraAtual.get(i).getProduto().getPreco(), compraAtual.get(i).getQuantidade(), subtotal);
            
        }
        
        boolean pago = pagamento(total);
            if (pago) {

            }

    }

    private static Produto procuraProdutoNoEstoque(String codBarras, Estoque estoque) {
        return estoque.findProduto(codBarras);
    }

    private static ItemDeEstoque procuraItemNoEstoque(String codBarras, Estoque estoque) {
        return estoque.findItemNoEstoque(codBarras);
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
        System.out.println(nome + " é vendido por peso? (s/n): ");
        if (in.next().equals("s")) {
            vendidoPorPeso = true;
        }
        //Cria novo produto com a entrada do gerente e adiciona no "banco de dados"
        Produto novo = new Produto(nome, descricao, vendidoPorPeso, codBarras, preco);
        Colecoes.addProduto(novo);

    }

    private static boolean pagamento(double total) {
        return true;
    }

*/

}
