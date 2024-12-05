/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Clock;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.CampoCurriculo;
import model.Curriculo;
import model.DadosPessoais;
import model.Usuario;
import repository.DB;
import view.GerarTelaFactory;
import view.Tela;

/**
 *
 * @author Diego Reis
 */
public class Controlador {
    
    private static Usuario usuarioLogado;
    private static DB db;
    
    // Bloco estático para inicializar o controlador
    static {
        db = new DB();
    }

    
    public static Tela login(String email, String senha){
        setUsuarioLogado(verificarUsuario(email, senha));
        
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela tela = null;
        if(getUsuarioLogado()==null)
            tela = gerar.gerarTela("erro");
        else
            tela = gerar.gerarTela("principal");
        
        return tela;
    }
    
    public static Tela logon(){/////////////////////////////////////////////////////////////////////////
        JOptionPane.showMessageDialog(null, "chamar tela logon!");
        Tela tela = null; 
        return tela;
    }
    
    public static void iniciarSistema() throws IOException, ClassNotFoundException{
        carregarDB();
        for(int i = 0; i<db.getIndex();i++){
            System.out.print(db.getUsuarios()[i].getEmail()+" - "+db.getUsuarios()[i].getSenha());
        }
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela tela = gerar.gerarTela("login");
        tela.setVisible(true);
        
    }
    
    
    private static Usuario[] buscarUsuarios(){
        Usuario[] usuarios = db.buscarUsuarios();
        return usuarios;
    }
    
    private static Usuario verificarUsuario(String email, String senha){
        Usuario[] usuarios = buscarUsuarios();
        Usuario login = null;
        for(int i=0; i<db.getIndex();i++){
            if(usuarios[i].getEmail().trim().equals(email.trim()) && usuarios[i].getSenha().trim().equals(senha.trim())){
                login = usuarios[i];
                break;
            }
        }
        return login;
    }
    
    public static void gerarHtml(){///////////////////////////////////////////////////////////////////////
        JOptionPane.showMessageDialog(null, "gerar html!");
    }
    
    public static Tela cadastrarDados(){//////////////////////////////////////////////////////////////////////
        Tela tela = null;
        return tela;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    public static Tela Cadastrar(String email, String senha, String nomeCompleto, String dataNasc, String nacionalidade, String paisResidencia, String estado, String cidade, String rua, int numero, String complemento, String telefone){
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela tela = null;
        Usuario user = new Usuario(email, senha);
        user.enviarDados(nomeCompleto, dataNasc, nacionalidade, paisResidencia, estado, cidade, rua, numero, complemento, telefone);
        if(user.getDadosPessoais().validarDados()){
            Controlador.getDb().setUsuario(user);
            
            tela = gerar.gerarTela("login");
        }else{
            tela = gerar.gerarTela("erro");
        }
        return tela;
    }
    
    public static Tela criarCampo(String titulo, String descricao, File arquivo){
        getUsuarioLogado().criarCampo(titulo, descricao, arquivo);
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela telaVisualizarCurriculo = gerar.gerarTela("visualizarcurriculo");
        return telaVisualizarCurriculo;
    }
    
    public static Tela criarCurriculo(){
        Usuario usuario = getUsuarioLogado();
        DadosPessoais dados = usuario.getDadosPessoais();
        Curriculo curriculo = new Curriculo(dados);
        usuario.setCurriculo(curriculo);
        
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela telaVisualizarCurriculo = gerar.gerarTela("visualizarcurriculo");
        return telaVisualizarCurriculo;
    }

    public static Tela editarCampoCurriculo(int campo){
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela tela = gerar.gerarTela("edicaocampo");
        return tela;
    }
    
    public static Tela editarCampo(String titulo, String descricao, File arquivo, CampoCurriculo campoSelecionado){
        if(campoSelecionado!=null){
            campoSelecionado.setTitulo(titulo);
            campoSelecionado.setDescricao(descricao);
            campoSelecionado.getPdf().setArquivo(arquivo);
            GerarTelaFactory gerar = new GerarTelaFactory();
            Tela tela = gerar.gerarTela("edicaocampo");
            return tela;
        }else{
            GerarTelaFactory gerar = new GerarTelaFactory();
            Tela tela = gerar.gerarTela("erro");
            return tela;
        }
    }
    
    public static Tela excluirCamposCurriculo(){
        getUsuarioLogado().getCurriculo().getCampoCurriculo().clear();
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela tela = gerar.gerarTela("visualizarcurriculo");
        return tela;
    }
    
    public static Tela excluirCampo(CampoCurriculo campo){
        getUsuarioLogado().getCurriculo().getCampoCurriculo().remove(campo);
        GerarTelaFactory gerar = new GerarTelaFactory();
        Tela tela = gerar.gerarTela("edicaocampo");
        return tela;
    }
    
    public static void exportarCurriculo() {
        Usuario user = getUsuarioLogado();
        // Começa o HTML básico
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>Currículo</title></head><body>");

        // Adiciona dados pessoais
        html.append("<h1>Dados Pessoais</h1>");
        html.append("<p><strong>Nome: </strong>").append(user.getDadosPessoais().getNomeCompleto()).append("</p>");
        html.append("<p><strong>Email: </strong>").append(user.getEmail()).append("</p>");
        html.append("<p><strong>Data Nascimento: </strong>").append(user.getDadosPessoais().getDataNasc()).append("</p>");
        html.append("<p><strong>Nacionalidade: </strong>").append(user.getDadosPessoais().getNacionalidade()).append("</p>");
        html.append("<p><strong>Pais de residencia: </strong>").append(user.getDadosPessoais().getPaisResidencia()).append("</p>");
        html.append("<p><strong>Estado: </strong>").append(user.getDadosPessoais().getEstado()).append("</p>");
        html.append("<p><strong>Cidade: </strong>").append(user.getDadosPessoais().getCidade()).append("</p>");
        html.append("<p><strong>Rua: </strong>").append(user.getDadosPessoais().getRua()).append("</p>");
        html.append("<p><strong>Numero: </strong>").append(user.getDadosPessoais().getNumero()).append("</p>");
        html.append("<p><strong>Complemento: </strong>").append(user.getDadosPessoais().getComplemento()).append("</p>");
        html.append("<p><strong>Telefone: </strong>").append(user.getDadosPessoais().getTelefone()).append("</p>");
        // Adicione outros campos pessoais conforme necessário

        // Adiciona os campos do currículo
        html.append("<h2>Campos do Currículo</h2>");

        for (CampoCurriculo campo : user.getCurriculo().getCampoCurriculo()) {
            html.append(campo.getHtml().getHtml());
        }

        // Finaliza o HTML
        html.append("</body></html>");

        // Usando JFileChooser para escolher o local de salvamento
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha onde salvar o curriculo");
        fileChooser.setSelectedFile(new File("curriculo.html")); // Sugere o nome do arquivo
        fileChooser.setAcceptAllFileFilterUsed(false); // Não aceitar qualquer tipo de arquivo

        // Filtra apenas arquivos .html
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos HTML", "html"));

        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Se o usuário não colocar a extensão, adiciona ".html"
            if (!file.getName().endsWith(".html")) {
                file = new File(file.getAbsolutePath() + ".html");
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(html.toString());
                System.out.println("Currículo exportado para: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("A operação foi cancelada.");
        }
    }
    
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario user) {
        usuarioLogado = user;
    }

    public static DB getDb() {
        return db;
    }

    public static void setDb(DB db) {
        Controlador.db = db;
    }
    
    public static void salvarDB() {
        // Obtém o diretório do usuário
        String userHome = System.getProperty("user.home");
        // Define o caminho completo para o arquivo
        File diretorio = new File(userHome, "projetoDados");
        if (!diretorio.exists()) {
            diretorio.mkdirs(); // Cria o diretório se não existir
        }
        File arquivo = new File(diretorio, "arquivo.dat");
            
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(db); // Salva a instância atual de DB
            System.out.println("Dados salvos com sucesso no arquivo: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar DB: " + e.getMessage());
        }
    }

    public static void carregarDB() {
        // Obtém o diretório do usuário
            String userHome = System.getProperty("user.home");
            File arquivo = new File(userHome, "projetoDados/arquivo.dat");

        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            db = (DB) ois.readObject(); // Carrega a instância de DB do arquivo
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar DB: " + e.getMessage());
        }
    }

    
}
