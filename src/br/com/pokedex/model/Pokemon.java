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
    private Boolean statusBatalha;
    private int pontosCombate;
    private Boolean possuiEvolucao;
    private Boolean podeEvoluir;
    private int batalhasPerdidas;
    private int batalhasVencidas;
    private int id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataCaptura() {
        return dataCaptura;
    }

    public void setDataCaptura(String dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public Boolean getStatusBatalha() {
        return statusBatalha;
    }

    public void setStatusBatalha(Boolean statusBatalha) {
        this.statusBatalha = statusBatalha;
    }

    public int getPontosCombate() {
        return pontosCombate;
    }

    public void setPontosCombate(int pontosCombate) {
        this.pontosCombate = pontosCombate;
    }

    public Boolean getPossuiEvolucao() {
        return possuiEvolucao;
    }

    public void setPossuiEvolucao(Boolean possuiEvolucao) {
        this.possuiEvolucao = possuiEvolucao;
    }

    public Boolean getPodeEvoluir() {
        return podeEvoluir;
    }

    public void setPodeEvoluir(Boolean podeEvoluir) {
        this.podeEvoluir = podeEvoluir;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
