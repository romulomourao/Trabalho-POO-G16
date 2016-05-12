
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author romul
 */
public class Colecoes {

    private static java.util.List<Produto> produtos = new ArrayList<>();
    private static java.util.List<Caixa> caixa = new ArrayList<>();
    private static java.util.List<Gerente> gerentes = new ArrayList<>();

    static void addProduto(Produto produto) {
        boolean existe = false;
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodBarras() == produto.getCodBarras()) {
                existe = true;
            } else {
                existe = false;
            }
        }

        if (!existe) {
            produtos.add(produto);
        }
    }
   
     static Produto findProduto(String cod) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodBarras().equals(cod)) {
                return produtos.get(i);
            }
        }

        return null;
    }

}
