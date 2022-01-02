/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.dao;

import br.com.pokedex.jdbc.ConnectionFactory;
import br.com.pokedex.model.Pokemon;
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
            String sql = "insert into pokemon(nome,tipo,pontos_combate,local_captura,data_captura,evolucao,Treinador_cpf) " +
                    "values(?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pokemon.getNome());
            statement.setString(2, pokemon.getTipo());
            statement.setInt(3, pokemon.getPontosCombate());
            statement.setString(4, pokemon.getLocalCaptura());
            statement.setString(5, pokemon.getDataCaptura());
            statement.setString(6, pokemon.getEvolucao());
            statement.setString(7, pokemon.getCpfTreinador());

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
            String sql = "update pokemon set nome=?,tipo=?,pontos_combate=?,local_captura=?,data_captura=?,"
                    + "evolucao=?,Treinador_cpf=? where idPokemon=?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pokemon.getNome());
            statement.setString(2, pokemon.getTipo());
            statement.setInt(3, pokemon.getPontosCombate());
            statement.setString(4, pokemon.getLocalCaptura());
            statement.setString(5, pokemon.getDataCaptura());
            statement.setString(6, pokemon.getEvolucao());
            statement.setString(7, pokemon.getCpfTreinador());
            statement.setInt(8, pokemon.getId());

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
        }
    }

    public void excluir_pokemon(Pokemon pokemon) {
        try {
            String sql = "delete from pokemon where idPokemon = ?";

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

            String sql = "select * from pokemon";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();

                pokemon.setId(rs.getInt("idPokemon"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setTipo(rs.getString("tipo"));
                pokemon.setPontosCombate(rs.getInt("pontos_combate"));
                pokemon.setLocalCaptura(rs.getString("local_captura"));
                pokemon.setDataCaptura(rs.getString("data_captura"));
                pokemon.setEvolucao(rs.getString("evolucao"));
                pokemon.setCpfTreinador(rs.getString("Treinador_cpf"));
                
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

            String sql = "select * from pokemon where nome like ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();

                pokemon.setId(rs.getInt("idPokemon"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setTipo(rs.getString("tipo"));
                pokemon.setPontosCombate(rs.getInt("pontos_combate"));
                pokemon.setLocalCaptura(rs.getString("local_captura"));
                pokemon.setDataCaptura(rs.getString("data_captura"));
                pokemon.setEvolucao(rs.getString("evolucao"));
                pokemon.setCpfTreinador(rs.getString("Treinador_cpf"));
                
                pokemonList.add(pokemon);
            }
            return pokemonList;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro -> " + e);
            return null;
        }
    }
}