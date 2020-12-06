package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Atendimento;
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

public class ControllerTelaCadastroAtendimento implements Initializable{
    
    @FXML
    private TextField textFieldId;
    
    @FXML
    private TextField textFieldAbandonada;
    
    @FXML
    private TextField textFieldAtendente;
    
    @FXML
    private TextField textFieldCliente;
    
    @FXML
    private TextField textFieldObservacao;
    
    @FXML
    private TextField textFiedAtendenteTransferido;
    
    @FXML
    private DatePicker datePickerData;
    
    @FXML
    private TableView<Atendimento> tableViewAtendimento;
    
    @FXML
    private TableColumn <Atendimento, Integer> tableColumnId;
    
    @FXML
    private TableColumn <Atendimento, String> tableColumnAbandonada;
    
    @FXML
    private TableColumn <Atendimento, Date> tableColumnData;
    
    @FXML
    private TableColumn <Atendimento, Integer> tableColumnAtendenteTransferido;
    
    @FXML
    private TableColumn <Atendimento, String> tableColumnObservacao;
    
    @FXML
    private TableColumn <Atendimento, Integer> tableColumnCliente;
    
    @FXML
    private TableColumn <Atendimento, Integer> tableColumnAtendente;
    
    @FXML
    private Button buttonConsultarAtendimento;
    
    @FXML
    private Button buttonInserirAtendimento;
    
    @FXML
    private Button buttonAtualizarAtendimento;
    
    @FXML
    private Button buttonExcluirAtendimento;
    
    private ObservableList<Atendimento> olAtendimento;
    
    private Integer idAtendimentoSelecionado;
    
    private Atendimento atendimentoSelecionado;
    
    @Override
    public void initialize (URL location, ResourceBundle resources){
        
    }
    
    public void popularAtendimento(){
        
    }
    
    public void selecionarAtendimento(Atendimento atendimento){
        
    }
    
    @FXML
    private void handlerConsultarAtendimento(ActionEvent event){
        
    }
    
    @FXML
    private void handlerInserirAtendimento(ActionEvent event){
        
    }
    
    @FXML
    private void handlerAtualizarAtendimento(ActionEvent event){
        
    }
    
    @FXML
    private void handlerExcluirAtendimento(ActionEvent event){
        
    }
}
