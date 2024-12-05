/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Diego Reis
 */
public class TelaFactory {
    
    public Tela gerarTela(String tipo){
        Tela tela;
       if(tipo.equalsIgnoreCase("principal"))
           tela = new TelaPrincipal();
       else if(tipo.equalsIgnoreCase("visualizardados")) 
           tela = new TelaVisualizarDados();
       else if(tipo.equalsIgnoreCase("cadastro")) 
           tela = new TelaCadastro();
       else if(tipo.equalsIgnoreCase("login")) 
           tela = new TelaLogin();
       else if(tipo.equalsIgnoreCase("sucesso")) 
           tela = new ModalSucesso();
       else if(tipo.equalsIgnoreCase("erro")) 
           tela = new ModalErro();
       else if(tipo.equalsIgnoreCase("visualizarcurriculo")) 
           tela = new TelaVisualizarCurriculo();
       else if(tipo.equalsIgnoreCase("confirmacao")) 
           tela = new ModalConfirmacao();
       else if(tipo.equalsIgnoreCase("criacaocampo")) 
           tela = new ModalCriacaoCampo();
       else if(tipo.equalsIgnoreCase("cadastrocurriculo")) 
           tela = new TelaCadastroCurriculo();
       else 
           tela = null;
           
       return tela;
    }
}
