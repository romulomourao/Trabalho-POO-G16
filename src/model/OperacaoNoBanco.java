package model;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import java.util.HashMap;
import java.util.Map;

public class OperacaoNoBanco {

    private static OperacaoNoBanco instancia = new OperacaoNoBanco();
    private static final MongoClient mongoClient = new MongoClient("localhost", 27016);
    private static final MongoDatabase db = mongoClient.getDatabase("mercado");

    private OperacaoNoBanco() {

    }

    public static synchronized OperacaoNoBanco getInstance() {
        if (instancia == null) {
            instancia = new OperacaoNoBanco();
        }
        return instancia;
    }

    public void findAll(String colection) {
        FindIterable<Document> iterable = db.getCollection(colection).find();

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }

    public void findEquals(String colection) {
        FindIterable<Document> iterable = db.getCollection(colection).find(
                new Document("marca", "SADIA"));

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document);
            }
        });
    }

    public void findOne(String colection, String codigo, String campo) {
        FindIterable<Document> iterable = db.getCollection(colection).find(
                new Document("codigo", codigo));
        System.out.println(iterable.first().getDouble(campo));

        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.getDouble(campo));
            }
        });
    }

    public void insereNovoProduto(String codigo, String nome, String marca, String categoria, double preco, int quantidade, boolean unitario) {
        Document novo = new Document("codigo", codigo);
        novo.append("nome", nome);
        novo.append("marca", marca);
        novo.append("categoria", categoria);
        novo.append("preco", preco);
        novo.append("quantidade", quantidade);
        novo.append("unitario", unitario);
        db.getCollection("produtos").insertOne(novo);

    }

    public void salvaVenda(Venda itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);
        // Parse to bson document and insert
        Document doc = Document.parse(json);
        db.getCollection("vendas").insertOne(doc);
    }


    public ItemEstoque consultaERetornaItemDeEstoque(String codigo) {
        ItemEstoque resp = null;
        Gson gson = new Gson();
        FindIterable<Document> iterable = db.getCollection("produtos").find(new Document("produto.codigo", codigo));
        if (iterable.first() == null) {
            return resp;
        }

        Document document = iterable.first();
        Document produto = (Document) document.get("produto");
        int quantidade = document.getInteger("quantidade");
        boolean unitario = (boolean) produto.get("unitario");
        if (unitario) {
            Produto p = gson.fromJson(produto.toJson(), ProdutoUnidade.class);
            resp = new ItemEstoqueUnidade(p, quantidade);
            return resp;
        }
        Produto p = gson.fromJson(produto.toJson(), ProdutoQuilo.class);
        resp = new ItemEstoqueQuilo(p, quantidade);
        return resp;

    }

    public void atualizaQuantidade(String codigo, int quantidade) {
        db.getCollection("produtos").updateOne(new Document("produto.codigo", codigo),
                new Document("$set", new Document("quantidade", quantidade)));

    }

    public void atualizaQuantidade(Map<String, ItemDeVenda> conjuntoDositens) {
        int qtdComprada, qtdEmEstoque;        
        for (String codigo : conjuntoDositens.keySet()) {
            qtdComprada = conjuntoDositens.get(codigo).getQuantidade();
          FindIterable<Document> iterable = db.getCollection("produtos").find(new Document("produto.codigo", codigo));
           qtdEmEstoque = iterable.first().getInteger("quantidade");
           qtdEmEstoque = qtdEmEstoque - qtdComprada;
            db.getCollection("produtos").updateOne(new Document("produto.codigo", codigo),
                    new Document("$set", new Document("quantidade", qtdEmEstoque)));
        }

    }

    public boolean existeCodigo(String codigo) {
        boolean resp = false;
        FindIterable<Document> iterable = db.getCollection("produtos").find(new Document("produto.codigo", codigo));
        if (iterable.first() == null) {
            return resp;
        } else {
            resp = true;
        }
        return resp;
    }

    public int quantidadeEmEstoque(String codigo) {

        FindIterable<Document> iterable = db.getCollection("produtos").find(new Document("produto.codigo", codigo));
        int quantidadeEmEstoque = iterable.first().getInteger("quantidade");
        return 0;

    }

    public Relatorio relatorioDeVendas(String dia, String mes, String ano) {
        Map<String, Object> data = new HashMap();
        data.put("data.dia", dia);
        data.put("data.mes", mes);
        data.put("data.ano", ano);
        Gson gson = new Gson();
        FindIterable<Document> iterable = db.getCollection("vendas").find(new Document(data));
        Relatorio relatorio = new Relatorio();
        iterable.forEach(relatorio);
        return relatorio;

    }

    public Inventario invetarioDeEstoque() {
        FindIterable<Document> iterable = db.getCollection("produtos").find();
        Inventario inventario = new Inventario();
        iterable.forEach(inventario);
        return inventario;
    }

}
