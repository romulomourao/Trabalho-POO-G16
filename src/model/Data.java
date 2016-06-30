/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author romulo
 */
public class Data {

    private String dia;
    private String mes;
    private String ano;
    private String horario;

    public Data() {
        formatar();
    }

    private void formatar() {
        DateFormat dateFormat;
        Date date = new Date();
        dateFormat = new SimpleDateFormat("yyyy");
        this.ano = dateFormat.format(date);
        dateFormat = new SimpleDateFormat("MM");
        this.mes = dateFormat.format(date);
        dateFormat = new SimpleDateFormat("dd");
        this.dia = dateFormat.format(date);
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        this.horario = dateFormat.format(date);
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAno() {
        return ano;
    }

    public String getHorario() {
        return horario;
    }

    public String getHorarioJunto() {
        String resp = horario.replace(":", "");
        return resp;
    }

}
