/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Reis
 */
public class Usuario implements Serializable {
    private String email;
    private String senha;
    private DadosPessoais dadosPessoais;
    private Curriculo curriculo;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.dadosPessoais = null;
        this.curriculo = null;
    }

    public boolean enviarDados(String nomeCompleto, String dataNasc, String nacionalidade, String paisResidencia, String estado, String cidade, String rua, int numero, String complemento, String telefone){
        this.dadosPessoais = new DadosPessoais(nomeCompleto, dataNasc, nacionalidade, paisResidencia, estado, cidade, rua, numero, complemento, telefone);
        if(this.dadosPessoais.equals(null)) return false;
        else return true;
    }
    
    public void criarCampo(String titulo, String descricao, File arquivo){///////////////////////////////
        this.curriculo.criarCampo(titulo, descricao, arquivo);
    }
    
    public void editarCampo(String titulo, String descricao, String caminho){///////////////////
        JOptionPane.showMessageDialog(null, "editar campo!");
    }
    
    public void excluirCampo(int campo){/////////////////////////////////////////////////////////
        JOptionPane.showMessageDialog(null, "excluir campo!");
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

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
    
}
