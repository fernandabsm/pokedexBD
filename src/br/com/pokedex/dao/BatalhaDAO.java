/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.dao;

import br.com.pokedex.jdbc.ConnectionFactory;
import br.com.pokedex.model.Batalha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BatalhaDAO {
    private Connection connection;

    public BatalhaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrar_batalha(Batalha batalha){
        try{
            String sql = "insert into treinador_batalha_ginasio(Treinador_cpf,Ginasio_endereco,adversario,vencedor,status)" +
                    "values(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, batalha.getCpfTreinador());
            statement.setString(2, batalha.getEnderecoGinasio());
            statement.setString(3, batalha.getAdversario());
            statement.setString(4, batalha.getVencedor());
            statement.setString(5, batalha.getStatus());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro -> "+e);
        }
    }
    
    public void alterar_batalha(Batalha batalha) {
        try {
            String sql = "update treinador_batalha_ginasio set adversario=?,vencedor=?,status=? where Treinador_cpf=? and Ginasio_endereco=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, batalha.getAdversario());
            statement.setString(2, batalha.getVencedor());
            statement.setString(3, batalha.getStatus());
            
            statement.setString(4, batalha.getCpfTreinador());
            statement.setString(5, batalha.getEnderecoGinasio());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }
    
    public List<Batalha> listar_batalhas() {
        try {
            List<Batalha> batalhaList = new ArrayList<>();

            String sql = "select * from treinador_batalha_ginasio";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Batalha batalha = new Batalha();

                batalha.setCpfTreinador(rs.getString("Treinador_cpf"));
                batalha.setEnderecoGinasio(rs.getString("Ginasio_endereco"));
                batalha.setAdversario(rs.getString("adversario"));
                batalha.setVencedor(rs.getString("vencedor"));
                batalha.setStatus(rs.getString("status"));
                
                batalhaList.add(batalha);
            }
            return batalhaList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
    
    public List<Batalha> buscar_batalha_Treinador(String cpf) {
        try {
            List<Batalha> batalhaList = new ArrayList<>();

            String sql = "select * from treinador_batalha_ginasio where Treinador_cpf like ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               Batalha batalha = new Batalha();

                batalha.setCpfTreinador(rs.getString("Treinador_cpf"));
                batalha.setEnderecoGinasio(rs.getString("Ginasio_endereco"));
                batalha.setAdversario(rs.getString("adversario"));
                batalha.setVencedor(rs.getString("vencedor"));
                batalha.setStatus(rs.getString("status"));
                
                batalhaList.add(batalha);
            }
            return batalhaList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
}
