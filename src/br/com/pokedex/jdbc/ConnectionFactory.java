/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/* Classe responsavel por criar a conexao com o BD */
public class ConnectionFactory {

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedexTest", "tpBD", "123");
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

