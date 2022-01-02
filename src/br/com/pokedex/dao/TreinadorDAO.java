/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.dao;

import br.com.pokedex.jdbc.ConnectionFactory;
import br.com.pokedex.model.Treinador;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreinadorDAO {

    private Connection connection;

    public TreinadorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    //Metodo para cadastrar novos treinadores
    public void cadastrar_treinador(Treinador treinador) {
        try {
            String sql = "insert into treinador(cpf,nome,endereco,ranking) values(?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, treinador.getCpf());
            statement.setString(2, treinador.getNome());
            statement.setString(3, treinador.getEndereco());
            statement.setString(4, treinador.getRanking());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    public void alterar_treinador(Treinador treinador) {
        try {
            String sql = "update treinador set nome=?,endereco=?,ranking=? where cpf=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, treinador.getNome());
            statement.setString(2, treinador.getEndereco());
            statement.setString(3, treinador.getRanking());
            statement.setString(4, treinador.getCpf());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    public void excluir_treinador(Treinador treinador) {
        try {
            String sql = "delete from treinador where cpf = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, treinador.getCpf());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    //Metodo para listar treinadores
    public List<Treinador> listar_treinadores() {
        try {
            List<Treinador> treinadorList = new ArrayList<>();

            String sql = "select * from treinador";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Treinador treinador = new Treinador();

                treinador.setNome(rs.getString("nome"));
                treinador.setCpf(rs.getString("cpf"));
                treinador.setEndereco(rs.getString("endereco"));
                treinador.setRanking(rs.getString("ranking"));

                treinadorList.add(treinador);
            }
            return treinadorList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }

    //Metodo para buscar treinadores por nome
    public List<Treinador> buscar_treinador_Nome(String nome) {
        try {
            List<Treinador> treinadorList = new ArrayList<>();

            String sql = "select * from treinador where nome like ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Treinador treinador = new Treinador();
                
                treinador.setCpf(rs.getString("cpf"));
                treinador.setNome(rs.getString("nome"));
                treinador.setEndereco(rs.getString("endereco"));
                treinador.setRanking(rs.getString("ranking"));

                treinadorList.add(treinador);
            }
            return treinadorList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
}
