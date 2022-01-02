/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.model;

public class Login {
    private String email;
    private String senha;
    private String cpfTreinador;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpfTreinador() {
        return cpfTreinador;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpfTreinador(String cpfTreinador) {
        this.cpfTreinador = cpfTreinador;
    }
    
    
}
