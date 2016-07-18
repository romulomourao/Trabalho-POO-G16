/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.ItemDeRelatorio;
import model.OperacaoNoBanco;
import model.Relatorio;

/**
 *
 * @author romulo
 */
public class EventoBotaoRelatorio implements ActionListener {

    private String dia, mes, ano, data;

    @Override
    public void actionPerformed(ActionEvent e) {
        dataRelatorio();
        Relatorio relatorio = OperacaoNoBanco.getInstance().relatorioDeVendas(dia, mes, ano);
        if (relatorio.vazio()) {
            JOptionPane.showMessageDialog(null, "Não há vendas nesta data.");
        }
        geraRelatorio(relatorio);

    }

    private void dataRelatorio() {
        String escolha = JOptionPane.showInputDialog(null, "DATA no formato: (dd/mm/aaaa)");
        String[] data = escolha.split("/");
        if (data.length == 3) {
            this.dia = data[0];
            this.mes = data[1];
            this.ano = data[2];
            this.data = ano + mes + dia;
        } else {
            dataRelatorio();
        }

    }

    private void geraRelatorio(Relatorio relatorio) {
        String idDaVenda, horario, numeroDoCaixa, nomeFuncionario, valorTotal, novaLinha;
        try {
            FileWriter fw = new FileWriter("relatorios/relatorio-" + data + ".html");
            for (String line : Files.readAllLines(Paths.get("relatorios/start.txt"))) {
                fw.write(line);
            }

            for (ItemDeRelatorio item : relatorio.getRelatorio()) {

                idDaVenda = "<td class=\"id\">" + item.getIdDaVenda() + "</td>";
                horario = "<td class=\"horario\">" + item.getHorario() + "</td>";
                numeroDoCaixa = "<td class=\"caixa\">" + item.getNumeroDoCaixa() + "</td>";
                nomeFuncionario = "<td class=\"funcionario\">" + item.getNomeFuncionario() + "</td>";
                valorTotal = "<td class=\"valor\">" + item.getValorTotal() + "</td>";
                novaLinha = "<tr>" + idDaVenda + horario + numeroDoCaixa + nomeFuncionario + valorTotal + "</tr>";
                fw.write(novaLinha);

            }

            String end = "</tbody>\n"
                    + "	  </table>\n"
                    + "\n"
                    +"Relatório do dia "+dia+"/"+mes+"/"+ano+"  -  TOTAL DO DIA: R$ "+relatorio.getTotal()
                    + "	</div>\n"
                    + "		\n"
                    + "	</div>\n"
                    + "	<script src=\"list.js\"></script>\n"
                    + "	<script src=\"entradaRelatorio.js\"></script>\n"
                    + "</body>\n"
                    + "</html>";
            fw.write(end);
            fw.close();

            String diretorio = System.getProperty("user.dir");
            Runtime.getRuntime().exec("firefox " + diretorio + "/relatorios/relatorio-" + data + ".html");
            
        } catch (IOException e) {
            return;
        }

    }

}
