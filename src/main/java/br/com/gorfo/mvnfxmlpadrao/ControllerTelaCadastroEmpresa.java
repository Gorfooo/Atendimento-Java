package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Empresa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerTelaCadastroEmpresa implements Initializable{
    
    @FXML
    private TextField textFieldId;
    
    @FXML
    private TextField textFieldInscricaoEstadual;
    
    @FXML
    private TextField textFieldCnpj;
    
    @FXML
    private TextField textFieldRazaoSocial;
    
    @FXML
    private TextField textFieldEndereco;
    
    @FXML
    private TextField textFieldFone;
    
    @FXML
    private TextField textFieldTipoDeSistema;
    
    @FXML
    private TextField textFieldSerial;
    
    @FXML
    private TableView<Empresa> tableViewEmpresa;
    
    @FXML
    private TableColumn<Empresa, Integer> tableColumnId;
    
    @FXML
    private TableColumn<Empresa, String> tableColumnSerial;
    
    @FXML
    private TableColumn<Empresa, String> tableColumnCnpj;
    
    @FXML
    private TableColumn<Empresa, String> tableColumnRazaoSocial;
    
    @FXML
    private TableColumn<Empresa, String> tableColumnFone;
    
    @FXML
    private TableColumn<Empresa, String> tableColumnEndereco;
    
    @FXML
    private TableColumn<Empresa, String> tableColumnInscricaoEstadual;
    
    @FXML
    private TableColumn<Empresa, Integer> tableColumnTipoDeSistema;
    
    @FXML
    private Button buttonConsultarEmpresa;
    
    @FXML
    private Button buttonInserirEmpresa;
    
    @FXML
    private Button buttonAtualizarEmpresa;
    
    @FXML
    private Button buttonExcluirEmpresa;
    
    @FXML
    private Button buttonCadastrarClientes;
    
    private ObservableList<Empresa> olCliente;
    
    private Integer idEmpresaSelecionada;
    
    private Empresa empresaSelecionada;
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        
    }
    
    public void popularEmpresa(){
        
    }
    
    public void selecionarEmpresa(Empresa empresa){
        
    }
    
    @FXML
    private void handlerConsultarEmpresa(ActionEvent event){
        
    }
    
    @FXML
    private void handlerInserirEmpresa(ActionEvent event){
        
    }
    
    @FXML
    private void handlerAtualizarEmpresa(ActionEvent event){
        
    }
    
    @FXML
    private void handlerExcluirEmpresa(ActionEvent event){
        
    }
    
    @FXML
    private void handlerCadastrarClientes(ActionEvent event){
        
    }
    
}
