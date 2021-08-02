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
import java.sql.SQLException;

public class PokemonDAO {

    private Connection connection;

    public PokemonDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrar_pokemon(Pokemon pokemon){
        try{
            String sql = "insert into tb_pokemons(nome,tipo,status_disponivel,data_captura,qtd_estoque) " +
                    "values(?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pokemon.getNome());
            statement.setString(2, pokemon.getTipo());
            statement.setInt(3, 1);
            statement.setString(4, pokemon.getDataCaptura());
            //statement.setInt(4, pokemon.);

            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro -> "+e);
        }
    }
}