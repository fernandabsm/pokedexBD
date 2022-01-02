/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.dao;

import br.com.pokedex.jdbc.ConnectionFactory;
import br.com.pokedex.view.LoginForm;
import br.com.pokedex.view.MenuForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author nanda
 */
public class LoginDAO {
    
    private Connection connection;

    public LoginDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void efetuar_login(String email, String senha) {
        try {
            String sql = "select * from login where email=? and senha=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, senha);

            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                //Caso Lider
                sql = "select * from treinador where cpf=?";
                statement = connection.prepareStatement(sql);
                statement.setString(1, rs.getString("Treinador_cpf"));
                
                rs = statement.executeQuery();
                if (rs.next()) {
                    if (rs.getString("ranking").equals("Líder")) {
                        JOptionPane.showMessageDialog(null, "Login efetuado!");
                        MenuForm menu = new MenuForm();
                        menu.setVisible(true);
                    }
                    //Caso Integrante
                    else if(rs.getString("ranking").equals("Integrante")){
                        JOptionPane.showMessageDialog(null, "Login efetuado!");
                        MenuForm menu = new MenuForm();
                        menu.MenuTreinadores.setVisible(false);
                        menu.setVisible(true);
                    }
                }
                else {
                      JOptionPane.showMessageDialog(null, "O login falhou! Dados incorretos.");
                      new LoginForm().setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "O login falhou! Dados incorretos.");
                new LoginForm().setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            new LoginForm().setVisible(true);
        }
    }
    
    public void efetuar_cadastro (String email, String senha, String cpf) {
        try {
            String sql = "insert into login(email,senha,Treinador_cpf) values(?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, senha);
            statement.setString(3, cpf);

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastrado efetuado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

}
