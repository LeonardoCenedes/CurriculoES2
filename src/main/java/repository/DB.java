/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.io.Serializable;
import model.Usuario;

/**
 *
 * @author Usuario
 */
public class DB implements Serializable{
    private Usuario[] usuarios;
    private int index;


    public DB() {
        this.usuarios = new Usuario[100];
        this.index = 0;
    }
    
     public Usuario[] buscarUsuarios() {
        return usuarios;
    }

    public void setUsuario(Usuario usuario) {
        if (this.index <100) {
            usuarios[this.index] = usuario;
        }
        this.index++;
    }

    public int contarUsuarios() {
        int contador = 0;

        // Percorre o array de usuários
        for (Usuario usuario : this.usuarios) {
            if (usuario != null) { // Verifica se a posição não está vazia
                contador++;
            }
        }

        return contador;
    }
    

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
}
