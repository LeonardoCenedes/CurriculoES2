/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Diego Reis
 */
public class CampoCurriculo implements Serializable{
    private String titulo;
    private String descricao;
    private PDF pdf;
    private ComponenteHtml html;
    
    public CampoCurriculo(String titulo, String descricao, File pdf){
        this.titulo = titulo;
        this.descricao = descricao;
        this.pdf = new PDF(pdf);
        this.html = new ComponenteHtml(titulo, descricao, this.pdf);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PDF getPdf() {
        return pdf;
    }

    public void setPdf(PDF pdf) {
        this.pdf = pdf;
    }

    public ComponenteHtml getHtml() {
        return html;
    }

    public void setHtml(ComponenteHtml html) {
        this.html = html;
    }
    
    
}
