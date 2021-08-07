/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.dao;

import br.com.pokedex.jdbc.ConnectionFactory;
import br.com.pokedex.model.Treinador;
import br.com.pokedex.view.LoginForm;
import br.com.pokedex.view.MenuForm;
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
            String sql = "insert into tb_treinadores(nome,cpf,email,senha,nivel_acesso,celular,cep,endereco,numero,"
                    + "complemento,bairro,cidade,uf,data_ingresso,pokemons_capturados,batalhas_perdidas,batalhas_vencidas,"
                    + "status_batalha) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, treinador.getNome());
            statement.setString(2, treinador.getCpf());
            statement.setString(3, treinador.getEmail());
            statement.setString(4, treinador.getSenha());
            statement.setString(5, treinador.getNivelAcesso());
            statement.setString(6, treinador.getCelular());
            statement.setString(7, treinador.getCEP());
            statement.setString(8, treinador.getEndereco());
            statement.setInt(9, treinador.getNumero());
            statement.setString(10, treinador.getComplemento());
            statement.setString(11, treinador.getBairro());
            statement.setString(12, treinador.getCidade());
            statement.setString(13, treinador.getUf());
            statement.setString(14, treinador.getDataIngresso());
            statement.setInt(15, 0);
            statement.setInt(16, 0);
            statement.setInt(17, 0);
            statement.setBoolean(18, false);

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    public void alterar_treinador(Treinador treinador) {
        try {
            String sql = "update tb_treinadores set nome=?,email=?,senha=?,nivel_acesso=?,celular=?,cep=?,endereco=?,numero=?,"
                    + "complemento=?,bairro=?,cidade=?,uf=?,data_ingresso=?,pokemons_capturados=?,batalhas_perdidas=?,batalhas_vencidas=?,"
                    + "status_batalha=? where cpf=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, treinador.getNome());
            statement.setString(2, treinador.getEmail());
            statement.setString(3, treinador.getSenha());
            statement.setString(4, treinador.getNivelAcesso());
            statement.setString(5, treinador.getCelular());
            statement.setString(6, treinador.getCEP());
            statement.setString(7, treinador.getEndereco());
            statement.setInt(8, treinador.getNumero());
            statement.setString(9, treinador.getComplemento());
            statement.setString(10, treinador.getBairro());
            statement.setString(11, treinador.getCidade());
            statement.setString(12, treinador.getUf());
            statement.setString(13, treinador.getDataIngresso());
            statement.setInt(14, treinador.getPokemonsCapturados());
            statement.setInt(15, treinador.getBatalhasPerdidas());
            statement.setInt(16, treinador.getBatalhasVencidas());
            statement.setBoolean(17, treinador.isStatusBatalha());
            statement.setString(18, treinador.getCpf());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    public void excluir_treinador(Treinador treinador) {
        try {
            String sql = "delete from tb_treinadores where cpf = ?";

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

            String sql = "select * from tb_treinadores";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Treinador treinador = new Treinador();

                treinador.setNome(rs.getString("nome"));
                treinador.setCpf(rs.getString("cpf"));
                treinador.setEmail(rs.getString("email"));
                treinador.setSenha(rs.getString("senha"));
                treinador.setNivelAcesso(rs.getString("nivel_acesso"));
                treinador.setCelular(rs.getString("celular"));
                treinador.setCEP(rs.getString("cep"));
                treinador.setEndereco(rs.getString("endereco"));
                treinador.setNumero(rs.getInt("numero"));
                treinador.setComplemento(rs.getString("complemento"));
                treinador.setBairro(rs.getString("bairro"));
                treinador.setCidade(rs.getString("cidade"));
                treinador.setUf(rs.getString("uf"));
                treinador.setDataIngresso(rs.getString("data_ingresso"));
                treinador.setBatalhasPerdidas(rs.getInt("batalhas_perdidas"));
                treinador.setBatalhasVencidas(rs.getInt("batalhas_vencidas"));
                treinador.setPokemonsCapturados(rs.getInt("pokemons_capturados"));
                treinador.setStatusBatalha(rs.getBoolean("status_batalha"));

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

            String sql = "select * from tb_treinadores where nome like ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Treinador treinador = new Treinador();

                treinador.setNome(rs.getString("nome"));
                treinador.setCpf(rs.getString("cpf"));
                treinador.setEmail(rs.getString("email"));
                treinador.setSenha(rs.getString("senha"));
                treinador.setNivelAcesso(rs.getString("nivel_acesso"));
                treinador.setCelular(rs.getString("celular"));
                treinador.setCEP(rs.getString("cep"));
                treinador.setEndereco(rs.getString("endereco"));
                treinador.setNumero(rs.getInt("numero"));
                treinador.setComplemento(rs.getString("complemento"));
                treinador.setBairro(rs.getString("bairro"));
                treinador.setCidade(rs.getString("cidade"));
                treinador.setUf(rs.getString("uf"));
                treinador.setDataIngresso(rs.getString("data_ingresso"));
                treinador.setBatalhasPerdidas(rs.getInt("batalhas_perdidas"));
                treinador.setBatalhasVencidas(rs.getInt("batalhas_vencidas"));
                treinador.setPokemonsCapturados(rs.getInt("pokemons_capturados"));
                treinador.setStatusBatalha(rs.getBoolean("status_batalha"));

                treinadorList.add(treinador);
            }
            return treinadorList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }

    public void efetuar_login(String email, String senha) {
        try {
            String sql = "select * from tb_treinadores where email=? and senha=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, senha);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                //Caso Lider
                if (rs.getString("nivel_acesso").equals("Líder")) {
                    JOptionPane.showMessageDialog(null, "Login efetuado!");
                    MenuForm menu = new MenuForm();
                    menu.setVisible(true);
                }
                //Caso Integrante
                else if(rs.getString("nivel_acesso").equals("Integrante")){
                    JOptionPane.showMessageDialog(null, "Login efetuado!");
                    MenuForm menu = new MenuForm();
                    menu.MenuTreinadores.setVisible(false);
                    menu.setVisible(true);
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

}
