/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.dao;

import br.com.pokedex.jdbc.ConnectionFactory;
import br.com.pokedex.model.Ginasio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GinasioDAO {
    private Connection connection;

    public GinasioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrar_ginasio(Ginasio ginasio){
        try{
            String sql = "insert into ginasio(endereco,nome,tipo) " +
                    "values(?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, ginasio.getEndereco());
            statement.setString(2, ginasio.getNome());
            statement.setString(3, ginasio.getTipo());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro -> "+e);
        }
    }
    
    public void alterar_ginasio(Ginasio ginasio) {
        try {
            String sql = "update ginasio set tipo=? where endereco=? and nome=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, ginasio.getTipo());
            
            statement.setString(2, ginasio.getEndereco());
            statement.setString(3, ginasio.getNome());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    public void excluir_ginasio(Ginasio ginasio) {
        try {
            String sql = "delete from ginasio where endereco=? and nome=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, ginasio.getEndereco());
            statement.setString(2, ginasio.getNome());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }
    
    public List<Ginasio> listar_ginasios() {
        try {
            List<Ginasio> ginasioList = new ArrayList<>();

            String sql = "select * from ginasio";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Ginasio ginasio = new Ginasio();

                ginasio.setEndereco(rs.getString("endereco"));
                ginasio.setNome(rs.getString("nome"));
                ginasio.setTipo(rs.getString("tipo"));
                
                ginasioList.add(ginasio);
            }
            return ginasioList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
    
    public List<Ginasio> buscar_ginasio_Nome(String nome) {
        try {
            List<Ginasio> ginasioList = new ArrayList<>();

            String sql = "select * from ginasio where nome like ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Ginasio ginasio = new Ginasio();

                ginasio.setEndereco(rs.getString("endereco"));
                ginasio.setNome(rs.getString("nome"));
                ginasio.setTipo(rs.getString("tipo"));
                
                ginasioList.add(ginasio);
            }
            return ginasioList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
}
