package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Cliente;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerTelaCadastroCliente implements Initializable{
    
    @FXML
    private TextField textFieldId;
    
    @FXML
    private TextField textFieldNome;
    
    @FXML
    private TextField textFieldCpf;
    
    @FXML
    private TextField textFieldRg;
    
    @FXML
    private TextField textFieldFone;
    
    @FXML
    private TextField textFieldEmail;
    
    @FXML
    private TextField textFieldObservacao;
    
    @FXML
    private TextField textFieldRevenda;
    
    @FXML
    private TextField textFieldEndereco;
    
    @FXML
    private DatePicker datePickerDataDeNascimento;
    
    @FXML
    private TableView<Cliente> tableViewCliente;
    
    @FXML
    private TableColumn<Cliente, Integer> tableColumnId;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnNome;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnCpf;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnRg;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnEndereco;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnFone;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnEmail;
    
    @FXML
    private TableColumn<Cliente, Date> tableColumnNascimento;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnObservacao;
    
    @FXML
    private TableColumn<Cliente, String> tableColumnRevenda;
    
    @FXML
    private Button buttonConsultarCliente;
    
    @FXML
    private Button buttonInserirCliente;
    
    @FXML
    private Button buttonAtualizarCliente;
    
    @FXML
    private Button buttonExcluirCliente;
    
    @FXML
    private Button buttonNovoCliente;
    
    private ObservableList<Cliente> olCliente;
    
    private Integer idClienteSelecionado;
    
    private Cliente clienteSelecionado;
    
    @Override
    public void initialize (URL location, ResourceBundle resources){
        
    }
    
    public void popularCliente(){
        
    }
    
    public void selecionarCliente(Cliente cliente){
        
    }
    
    @FXML
    private void handlerConsultarCliente(ActionEvent event){
        
    }
    
    @FXML
    private void handlerInserirCliente(ActionEvent event){
        
    }
    
    @FXML
    private void handlerAtualizarCliente(ActionEvent event){
        
    }
    
    @FXML
    private void handlerExcluirCliente(ActionEvent event){
        
    }
    
    @FXML
    private void handlerNovoCliente(ActionEvent event){
        textFieldId.setText(null);
        textFieldNome.setText(null);
        textFieldCpf.setText(null);
        textFieldRg.setText(null);
        textFieldFone.setText(null);
        textFieldEmail.setText(null);
        textFieldObservacao.setText(null);
        textFieldRevenda.setText(null);
        textFieldEndereco.setText(null);
        datePickerDataDeNascimento.setValue(null);
    }
}
