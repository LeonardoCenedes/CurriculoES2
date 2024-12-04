/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Reis
 */
public class ComponenteHtml implements Serializable{
    private String html;
    
    public ComponenteHtml(String titulo, String descricao, PDF arquivo) {
        // Verifica se o PDF está presente
        String pdfUrl = arquivo.getArquivo() != null ? arquivo.getArquivo().getAbsolutePath() : "#";  // Caminho absoluto do arquivo
        // Gera o código HTML para o campo com o link para o PDF
        this.html = "<div class=\"campo\">\n"
                + "<h3>" + titulo + "</h3>\n"
                + "<p>" + descricao + "</p>\n"
                + (arquivo.getArquivo() != null ? "<a href=\"file:///" + pdfUrl.replace("\\", "/") + "\" target=\"_blank\">Ver PDF</a>\n" : "")
                + "</div>\n";
    }


    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
    
    
}
