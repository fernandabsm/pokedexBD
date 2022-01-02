/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.model;

public class Pokemon {

    private String nome;
    private String tipo;
    private String dataCaptura;
    private String localCaptura;
    private int pontosCombate;
    private String evolucao;
    private int id;
    private String cpfTreinador;

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDataCaptura() {
        return dataCaptura;
    }

    public String getLocalCaptura() {
        return localCaptura;
    }

    public int getPontosCombate() {
        return pontosCombate;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public int getId() {
        return id;
    }

    public String getCpfTreinador() {
        return cpfTreinador;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataCaptura(String dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public void setLocalCaptura(String localCaptura) {
        this.localCaptura = localCaptura;
    }

    public void setPontosCombate(int pontosCombate) {
        this.pontosCombate = pontosCombate;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCpfTreinador(String cpfTreinador) {
        this.cpfTreinador = cpfTreinador;
    }

}
