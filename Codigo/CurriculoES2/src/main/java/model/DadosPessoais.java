/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 *
 * @author Diego Reis
 */
public class DadosPessoais implements Serializable {
    protected String nomeCompleto;
    protected String dataNasc;
    protected String nacionalidade;
    protected String paisResidencia;
    protected String estado;
    protected String cidade;
    protected String rua;
    protected int numero;
    protected String complemento;
    protected String telefone;

    public DadosPessoais(String nomeCompleto, String dataNasc, String nacionalidade, String paisResidencia, String estado, String cidade, String rua, int numero, String complemento, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNasc = dataNasc;
        this.nacionalidade = nacionalidade;
        this.paisResidencia = paisResidencia;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
    }

    public boolean validarDados() {

        if (nomeCompleto == null || nomeCompleto.isEmpty()) {
            return false;
        }

        if (!validarData(dataNasc)) {
            return false;
        }

        if (nacionalidade == null || nacionalidade.isEmpty()) {
            return false;
        }

        if (paisResidencia == null || paisResidencia.isEmpty()) {
            return false;
        }

        if (estado == null || estado.isEmpty()) {
            return false;
        }

        if (cidade == null || cidade.isEmpty()) {
            return false;
        }

        if (rua == null || rua.isEmpty()) {
            return false;
        }

        if (numero <= 0) {
            return false;
        }

        if(telefone == null || telefone.isEmpty()) {
            return false;
        }

        // Se não houver erros, os dados são válidos
        return true;
    }

    // Método auxiliar para validar data
    private boolean validarData(String data) {
        if (data == null || data.isEmpty()) {
            return false;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(data); // Tenta fazer o parse da data
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
