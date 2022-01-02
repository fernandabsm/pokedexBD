/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pokedex.model;

public class Batalha {
    private String cpfTreinador;
    private String enderecoGinasio;
    private String adversario;
    private String vencedor;
    private String status;

    public String getCpfTreinador() {
        return cpfTreinador;
    }

    public String getEnderecoGinasio() {
        return enderecoGinasio;
    }

    public String getAdversario() {
        return adversario;
    }

    public String getVencedor() {
        return vencedor;
    }

    public String getStatus() {
        return status;
    }

    public void setCpfTreinador(String cpfTreinador) {
        this.cpfTreinador = cpfTreinador;
    }

    public void setEnderecoGinasio(String enderecoGinasio) {
        this.enderecoGinasio = enderecoGinasio;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    } 

    public void setStatus(String status) {
        this.status = status;
    } 
}
