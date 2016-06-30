package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author romulo
 */
public class Login {
 
    public static boolean autentica(String username, String password) {
        // hardcoded username and password
        if (username.equals("a") && password.equals("a")) {
            return true;
        }
        return false;
    }
}
