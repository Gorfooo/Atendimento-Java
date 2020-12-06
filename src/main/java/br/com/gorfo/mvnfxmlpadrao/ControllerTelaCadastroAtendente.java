package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Atendente;
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

public class ControllerTelaCadastroAtendente implements Initializable{
    
    @FXML
    private TextField textFieldId;
    
    @FXML
    private TextField textFieldNome;
    
    @FXML
    private TextField textFieldEmail;
    
    @FXML
    private TextField textFieldCpf;
    
    @FXML
    private TextField textFieldRg;
    
    @FXML
    private TextField textFieldPasep;
    
    @FXML
    private TextField textFieldPis;
    
    @FXML
    private TextField textFieldEndereco;
    
    @FXML
    private TextField textFieldFone;
    
    @FXML
    private TextField textFieldObservacao;
    
    @FXML
    private TextField textFieldSetor;
    
    @FXML
    private TextField textFieldRamal;
    
    @FXML
    private DatePicker datePickerDataDeNascimento;
    
    @FXML
    private TableView<Atendente> tableViewAtendente;
    
    @FXML
    private TableColumn<Atendente, Integer> tableColumnId;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnNome;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnCpf;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnRg;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnEndereco;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnFone;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnEmail;
    
    @FXML
    private TableColumn<Atendente, Date> tableColumnNascimento;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnObs;
    
    @FXML
    private TableColumn<Atendente, Integer> tableColumnRamal;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnPis;
    
    @FXML
    private TableColumn<Atendente, String> tableColumnPasep;
    
    @FXML
    private TableColumn<Atendente, Integer> tableColumnSetor;
    
    @FXML
    private Button buttonInserirAtendente;
    
    @FXML
    private Button buttonAtualizarAtendente;
    
    @FXML
    private Button buttonExcluirAtendente;
    
    @FXML
    private Button buttonConsultarAtendente;
    
    private ObservableList<Atendente> olAtendente;
    
    private Integer idAtendenteSelecionado;
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        tableViewAtendente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarAtendente(newValue));
    }
    
    public void popularAtendente(){
        
    }
    
    public void selecionarAtendente(Atendente atendente){
        
    }
    
    @FXML
    private void handlerConsultarAtendente(ActionEvent event){
        
    }
    
    @FXML
    private void handlerExcluirAtendente(ActionEvent event){
        
    }
    
    @FXML
    private void handlerAtualizarAtendente(ActionEvent event){
        
    }
    
    @FXML
    private void handlerInserirAtendente(ActionEvent event){
        
    }
}
