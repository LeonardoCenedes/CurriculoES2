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
public class PDF implements Serializable{
    //private String caminho;
    //private String conteudo;
    private File arquivo;

    public PDF(File arquivo) {
        this.arquivo = arquivo;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }
    
    
}
