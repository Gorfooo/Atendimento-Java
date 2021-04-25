package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Atendimento;
import br.com.gorfo.mvnfxmlpadrao.dao.AtendimentoDao;
import br.com.gorfo.mvnfxmlpadrao.database.Conexao;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private TextField textFieldAtendenteTransferido;
    
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
    
//    @FXML
//    private Button buttonConsultarAtendimento;
//    
//    @FXML
//    private Button buttonInserirAtendimento;
//    
//    @FXML
//    private Button buttonAtualizarAtendimento;
//    
//    @FXML
//    private Button buttonExcluirAtendimento;
//    
//    @FXML
//    private Button buttonNovoAtendimento;
//    
//    @FXML
//    private AnchorPane setaVoltarCadastroAtendente;
    
    @FXML
    private AnchorPane anchorPaneFundoAtendimento;
    
    private ObservableList<Atendimento> olAtendimento;
    
    @Override
    public void initialize (URL location, ResourceBundle resources){
        popularAtendimento();
        tableViewAtendimento.getSelectionModel().selectedItemProperty().addListener((parametro, parametroo, parametrooo) -> selecionarAtendimento(parametrooo));
    }
    
    public void popularAtendimento(){
        Connection con = Conexao.getConnection();
        AtendimentoDao adao = new AtendimentoDao();
        adao.setConnection(con);
        List<Atendimento> listaAtendimento = adao.listar();
        tableColumnId.setCellValueFactory(new PropertyValueFactory("id"));
        tableColumnAbandonada.setCellValueFactory(new PropertyValueFactory("abandonada"));
        tableColumnAtendente.setCellValueFactory(new PropertyValueFactory("atendente"));
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory("cliente"));
        tableColumnObservacao.setCellValueFactory(new PropertyValueFactory("observacao"));
        tableColumnAtendenteTransferido.setCellValueFactory(new PropertyValueFactory("atendente_transferido"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory("data"));
        
        olAtendimento = FXCollections.observableArrayList(listaAtendimento);
        tableViewAtendimento.setItems(olAtendimento);
    }
    
    public void selecionarAtendimento(Atendimento atendimento){
        try{
        textFieldId.setText(String.valueOf(atendimento.getId()));
        textFieldAbandonada.setText(atendimento.getAbandonada());
        textFieldAtendente.setText(atendimento.getAtendente());
        textFieldCliente.setText(atendimento.getCliente());
        textFieldObservacao.setText(atendimento.getObservacao());
        textFieldAtendenteTransferido.setText(atendimento.getAtendente_transferido());
        datePickerData.setValue(atendimento.getData());
        }catch(NullPointerException e){
            System.out.print("");
        }
    }
    
    @FXML
    private void handlerConsultarAtendimento(ActionEvent event){
        try{
        Connection con = Conexao.getConnection();
        AtendimentoDao adao = new AtendimentoDao();
        adao.setConnection(con);
        Atendimento atendimento = adao.buscar(Integer.parseInt(textFieldId.getText()));
        textFieldAbandonada.setText(atendimento.getAbandonada());
        textFieldAtendente.setText(atendimento.getAtendente());
        textFieldCliente.setText(atendimento.getCliente());
        textFieldObservacao.setText(atendimento.getObservacao());
        textFieldAtendenteTransferido.setText(atendimento.getAtendente_transferido());
        datePickerData.setValue(atendimento.getData());
        }catch(SQLException e){
            System.out.println("Atendimento não localizado:\n"+ e);
            textFieldId.setText(null);
            textFieldAbandonada.setText(null);
            textFieldAtendente.setText(null);
            textFieldCliente.setText(null);
            textFieldObservacao.setText(null);
            textFieldAtendenteTransferido.setText(null);
            datePickerData.setValue(null);
        }
    }
    
    @FXML
    private void handlerInserirAtendimento(ActionEvent event){
        try{
        Integer id = Integer.parseInt (textFieldId.getText());
        String abandonada = textFieldAbandonada.getText();
        LocalDate data = datePickerData.getValue();
        String atendente_transferido = textFieldAtendenteTransferido.getText();
        String observacao = textFieldObservacao.getText();
        String cliente = textFieldCliente.getText();
        String atendente = textFieldAtendente.getText();
        Atendimento atendimento = new Atendimento(id, abandonada, data, atendente_transferido, observacao, cliente, atendente);
        
        Connection con = Conexao.getConnection();
        AtendimentoDao adao = new AtendimentoDao();
        adao.setConnection(con);
        adao.inserir(atendimento);
        popularAtendimento();
        } catch (NumberFormatException e) {
            System.out.println("Caracter informado é inválido:\n" + e);
        }
    }
    
    @FXML
    private void handlerAtualizarAtendimento(ActionEvent event){
//        try{
        Integer id = Integer.parseInt(textFieldId.getText()); 
        String abandonada = textFieldAbandonada.getText();
        String atendente = textFieldAtendente.getText();
        String cliente = textFieldCliente.getText();
        String observacao = textFieldObservacao.getText();
        String atendenteTransferido = textFieldAtendenteTransferido.getText();
        LocalDate data = datePickerData.getValue();
        Atendimento atendimento = new Atendimento(id, abandonada, data, atendenteTransferido, observacao, cliente, atendente);
        
        Connection con = Conexao.getConnection();
        AtendimentoDao adao = new AtendimentoDao();
        adao.setConnection(con);
        adao.atualizar(atendimento);
        popularAtendimento();
//        }catch(NumberFormatException e){
//            System.out.println("Caracter informado é inválido:\n" + e +"\n");
//        }
    }
    
    @FXML
    private void handlerExcluirAtendimento(ActionEvent event){
        Connection con = Conexao.getConnection();
        AtendimentoDao adao = new AtendimentoDao();
        adao.setConnection(con);
        adao.remover(Integer.parseInt(textFieldId.getText()));
        popularAtendimento();
    }
    
    @FXML
    private void handlerVoltarCadastroAtendimento(MouseEvent event){
        try{
        AnchorPane a = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        anchorPaneFundoAtendimento.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao voltar para tela principal:\n"+ e);
        }
    }
    
    @FXML
    private void handlerNovoAtendimento(ActionEvent event){
        textFieldId.setText(null);
        textFieldAbandonada.setText(null);
        textFieldAtendente.setText(null);
        textFieldCliente.setText(null);
        textFieldObservacao.setText(null);
        textFieldAtendenteTransferido.setText(null);
        datePickerData.setValue(null);
    }
}
