/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.jdbc;

import javax.swing.*;

public class ConnectionFactoryTest {

    public static void main(String[] args){

        try{
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ->"+ e);
        }
    }
}
