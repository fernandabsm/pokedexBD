/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.dao;

import br.com.pokedex.jdbc.ConnectionFactory;
import br.com.pokedex.model.Pokemon;
import br.com.pokedex.model.Treinador;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

    private Connection connection;

    public PokemonDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrar_pokemon(Pokemon pokemon){
        try{
            String sql = "insert into tb_pokemons(nome,tipo,status_batalha,data_captura,pontos_combate,pode_evoluir,possui_evolucao,batalhas_vencidas,batalhas_perdidas) " +
                    "values(?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pokemon.getNome());
            statement.setString(2, pokemon.getTipo());
            statement.setBoolean(3, pokemon.getStatusBatalha());
            statement.setString(4, pokemon.getDataCaptura());
            statement.setInt(5, pokemon.getPontosCombate());
            statement.setBoolean(6, pokemon.getPodeEvoluir());
            statement.setBoolean(7, pokemon.getPossuiEvolucao());
            statement.setInt(8, pokemon.getBatalhasVencidas());
            statement.setInt(9, pokemon.getBatalhasPerdidas());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro -> "+e);
        }
    }
    
    public void alterar_pokemon(Pokemon pokemon) {
        try {
            String sql = "update tb_pokemons set nome=?,tipo=?,status_batalha=?,data_captura=?,"
                    + "pontos_combate=?,pode_evoluir=?,possui_evolucao=?,batalhas_vencidas=?,"
                    + "batalhas_perdidas=? where id=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pokemon.getNome());
            statement.setString(2, pokemon.getTipo());
            statement.setBoolean(3, pokemon.getStatusBatalha());
            statement.setString(4, pokemon.getDataCaptura());
            statement.setInt(5, pokemon.getPontosCombate());
            statement.setBoolean(6, pokemon.getPodeEvoluir());
            statement.setBoolean(7, pokemon.getPossuiEvolucao());
            statement.setInt(8, pokemon.getBatalhasVencidas());
            statement.setInt(9, pokemon.getBatalhasPerdidas());
            statement.setInt(10, pokemon.getId());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    public void excluir_pokemon(Pokemon pokemon) {
        try {
            String sql = "delete from tb_pokemons where id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, pokemon.getId());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }
    
    public List<Pokemon> listar_pokemons() {
        try {
            List<Pokemon> pokemonList = new ArrayList<>();

            String sql = "select * from tb_pokemons";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();

                pokemon.setId(rs.getInt("id"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setTipo(rs.getString("tipo"));
                pokemon.setPontosCombate(rs.getInt("pontos_combate"));
                pokemon.setDataCaptura(rs.getString("data_captura"));
                pokemon.setPossuiEvolucao(rs.getBoolean("possui_evolucao"));
                pokemon.setPodeEvoluir(rs.getBoolean("pode_evoluir"));
                pokemon.setBatalhasVencidas(rs.getInt("batalhas_vencidas"));
                pokemon.setBatalhasPerdidas(rs.getInt("batalhas_perdidas"));
                pokemon.setStatusBatalha(rs.getBoolean("status_batalha"));
                
                pokemonList.add(pokemon);
            }
            return pokemonList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
    
    public List<Pokemon> buscar_pokemon_Nome(String nome) {
        try {
            List<Pokemon> pokemonList = new ArrayList<>();

            String sql = "select * from tb_pokemons where nome like ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();

                pokemon.setId(rs.getInt("id"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setTipo(rs.getString("tipo"));
                pokemon.setPontosCombate(rs.getInt("pontos_combate"));
                pokemon.setDataCaptura(rs.getString("data_captura"));
                pokemon.setPossuiEvolucao(rs.getBoolean("possui_evolucao"));
                pokemon.setPodeEvoluir(rs.getBoolean("pode_evoluir"));
                pokemon.setBatalhasVencidas(rs.getInt("batalhas_vencidas"));
                pokemon.setBatalhasPerdidas(rs.getInt("batalhas_perdidas"));
                pokemon.setStatusBatalha(rs.getBoolean("status_batalha"));
                
                pokemonList.add(pokemon);
            }
            return pokemonList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
}