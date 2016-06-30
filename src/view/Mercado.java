



package view;

import java.io.IOException;
import model.OperacaoNoBanco;

/**
 *
 * @author romulo
 */
public class Mercado {

    public static void main(String[] args) throws IOException {
        //Runtime.getRuntime().exec("mongod --port 27016");
       // OperacaoNoBanco conexao = new OperacaoNoBanco();
        //conexao.findAll("unitario");
        //conexao.findEquals("unitario");
       // conexao.findOne("unitario", "7893000394209", "preco");
       // new JanelaCadastroProdutoUnitario().setVisible(true);
       
                new Tela().inicializa();

    }

}


