/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.model;

public class Treinador {

    private String nome;
    private String cpf;
    private String endereco;
    private String complemento;
    private String bairro;
    private String CEP;
    private int numero;
    private String uf;
    private String cidade;
    private String celular;
    private String email;
    private String senha;
    private String nivelAcesso;
    private String dataIngresso;
    private boolean statusBatalha;
    private int pokemonsCapturados;
    private int batalhasPerdidas;
    private int batalhasVencidas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(String dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public boolean isStatusBatalha() {
        return statusBatalha;
    }

    public void setStatusBatalha(boolean statusBatalha) {
        this.statusBatalha = statusBatalha;
    }

    public int getPokemonsCapturados() {
        return pokemonsCapturados;
    }

    public void setPokemonsCapturados(int pokemonsCapturados) {
        this.pokemonsCapturados = pokemonsCapturados;
    }

    public int getBatalhasPerdidas() {
        return batalhasPerdidas;
    }

    public void setBatalhasPerdidas(int batalhasPerdidas) {
        this.batalhasPerdidas = batalhasPerdidas;
    }

    public int getBatalhasVencidas() {
        return batalhasVencidas;
    }

    public void setBatalhasVencidas(int batalhasVencidas) {
        this.batalhasVencidas = batalhasVencidas;
    }
}
