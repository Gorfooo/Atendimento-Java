package br.com.gorfo.mvnfxmlpadrao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class ControllerTelaPrincipal implements Initializable{
    
    @FXML
    private MenuItem menuItemCadastrarAtendente;
    
    @FXML
    private MenuItem menuItemCadastrarEmpresa;
    
    @FXML
    private MenuItem menuItemCadastrarAtendimento;
        
    @FXML
    private MenuItem menuItemRelatorioAtendente;
    
    @FXML
    private MenuItem menuItemCadastrarCliente;
    
    @FXML
    private AnchorPane anchorPaneFundo;
    
    @Override
    public void initialize(URL location, ResourceBundle Resources){
        
    }
    
    @FXML
    private void handlerCadastrarAtendente(javafx.event.ActionEvent event){
        try{
        AnchorPane a = FXMLLoader.load(getClass().getResource("/br.com.gorfo.mvnfxmlpadrao/TelaCadastroAtendente.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
        }catch (IOException e){
            System.out.println("Erro ao abrir tela de cadastro de atendentes: "+e);
        }   
    }
    
    @FXML
    private void handlerCadastrarEmpresa(javafx.event.ActionEvent event){
        try{
            AnchorPane a = FXMLLoader.load(getClass().getResource("/br.com.gorfo.mvnfxmlpadrao/TelaCadastroEmpresa.fxml"));
            anchorPaneFundo.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao abrir tela de cadastro de empresas: "+e);
        }
    }
    
    @FXML
    private void handlerCadastrarAtendimento(javafx.event.ActionEvent event){
        try{
            AnchorPane a = FXMLLoader.load(getClass().getResource("/br.com.gorfo.mvnfxmlpadrao/TelaCadastroAtendimento.fxml"));
            anchorPaneFundo.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao abrir tela de cadastro de atendimento: "+e);
        }
    }
    
    @FXML
    private void handlerCadastrarCliente(javafx.event.ActionEvent event){
        try{
            AnchorPane a = FXMLLoader.load(getClass().getResource("/br.com.gorfo.mvnfxmlpadrao/TelaCadastroCliente.fxml"));
        }catch (IOException e){
            System.out.println("Erro ao abrir tela de cadastro de clientes: "+e);
        }
    }
}
