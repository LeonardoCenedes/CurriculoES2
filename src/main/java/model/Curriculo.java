/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Reis
 */
public class Curriculo implements Serializable {
    
    private List<CampoCurriculo> campoCurriculo;
    
    public Curriculo(DadosPessoais dadosPessoais){
        this.campoCurriculo = new ArrayList<>();
    }
    
    public void criarCampo(String titulo, String descricao, File arquivo){
        CampoCurriculo campo = new CampoCurriculo(titulo, descricao, arquivo);
        campoCurriculo.add(campo);
    }
    
    public void editarCampo(String titulo, String descricao, String caminho){///////////////////////////////////
        JOptionPane.showMessageDialog(null, "editar campo!");
    }
    
    public void excluirCampo(int campo){///////////////////////////////////////////////
        JOptionPane.showMessageDialog(null, "excluir campo!");
    }

    public List<CampoCurriculo> getCampoCurriculo() {
        return campoCurriculo;
    }

    public void setCampoCurriculo(List<CampoCurriculo> campoCurriculo) {
        this.campoCurriculo = campoCurriculo;
    }

    public String exportarCurriculo() {
        StringBuilder html = new StringBuilder();
        html.append("<div class=\"Curriculo\">\n");

        // Adiciona os campos, incluindo o HTML para o botão
        for (CampoCurriculo campo : campoCurriculo) {
            html.append(campo.getHtml().getHtml()); // Adiciona o HTML de cada campo
        }

        html.append("</div>\n");
        return html.toString();
    }
}
