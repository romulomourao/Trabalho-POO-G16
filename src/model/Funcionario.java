/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author romulo
 */
public class Funcionario extends Pessoa{

    public Funcionario(String nome, String cpf) {
        super(nome, cpf);
    }
    
       public Map tabelaDeClientes() {
        //le do arquivo e preenche o map

        Gson gson = new Gson();

        try {
            String js;           

            BufferedReader br = new BufferedReader(new FileReader("clientes.json"));
            while ((js = br.readLine()) != null) {
                Cliente cliente = gson.fromJson(js, Cliente.class);
                Map<String,String> tabelaDeClientes = new HashMap<>();
               tabelaDeClientes.put(cliente.getCpf(), cliente.getNome());
            }
            br.close();
            //convert the json string back to object  

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return tabelaDeClientes();
    }
}
