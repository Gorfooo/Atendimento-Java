package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Atendente;
import br.com.gorfo.mvnfxmlpadrao.dao.AtendenteDao;
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
    private TableColumn<Atendente, String> tableColumnId;
    
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
    
//    @FXML
//    private Button buttonInserirAtendente;
//    
//    @FXML
//    private Button buttonAtualizarAtendente;
//    
//    @FXML
//    private Button buttonExcluirAtendente;
//    
//    @FXML
//    private Button buttonConsultarAtendente;
//    
//    @FXML
//    private Button buttonNovoAtendente;
//    
//    @FXML
//    private AnchorPane setaVoltarCadastroAtendente;
    
    @FXML
    private AnchorPane anchorPaneFundoAtendente;
    
    private ObservableList<Atendente> olAtendente;
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        popularAtendente();
        tableViewAtendente.getSelectionModel().selectedItemProperty().addListener((parametro, parametroo, parametrooo) -> selecionarAtendente(parametrooo));

    }
    
    public void popularAtendente(){
        Connection con = Conexao.getConnection();
        AtendenteDao adao = new AtendenteDao();
        adao.setConnection(con);
        List<Atendente> listaAtendente = adao.listar();
        tableColumnId.setCellValueFactory(new PropertyValueFactory("id"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tableColumnCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        tableColumnRg.setCellValueFactory(new PropertyValueFactory("rg"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory("endereco"));
        tableColumnFone.setCellValueFactory(new PropertyValueFactory("fone"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory("email"));
        tableColumnNascimento.setCellValueFactory(new PropertyValueFactory("dataNascimento"));
        tableColumnObs.setCellValueFactory(new PropertyValueFactory("observacao"));
        tableColumnRamal.setCellValueFactory(new PropertyValueFactory("ramal"));
        tableColumnPis.setCellValueFactory(new PropertyValueFactory("pis"));
        tableColumnPasep.setCellValueFactory(new PropertyValueFactory("pasep"));
        tableColumnSetor.setCellValueFactory(new PropertyValueFactory("setor"));
        
        olAtendente = FXCollections.observableArrayList(listaAtendente);
        tableViewAtendente.setItems(olAtendente);
    }
    
    public void selecionarAtendente(Atendente atendente){
        try{
        textFieldId.setText(String.valueOf(atendente.getId()));
        textFieldNome.setText(atendente.getNome());
        textFieldEmail.setText(atendente.getEmail());
        textFieldCpf.setText(atendente.getCpf());
        textFieldRg.setText(atendente.getRg());
        textFieldPasep.setText(atendente.getPasep());
        textFieldPis.setText(atendente.getPis());
        textFieldEndereco.setText(atendente.getEndereco());
        textFieldFone.setText(atendente.getFone());
        textFieldObservacao.setText(atendente.getObservacao());
        textFieldSetor.setText(atendente.getSetor());
        textFieldRamal.setText(String.valueOf(atendente.getRamal()));
        datePickerDataDeNascimento.setValue(atendente.getDataNascimento());
        }catch(NullPointerException e){
            System.out.print("");
        }
    }
    
    @FXML
    private void handlerConsultarAtendente(ActionEvent event){
        try{
        Connection con = Conexao.getConnection();
        AtendenteDao adao = new AtendenteDao();
        adao.setConnection(con);
        Atendente atendente = adao.buscar(Integer.parseInt(textFieldId.getText()));
        textFieldNome.setText(atendente.getNome());
        textFieldEmail.setText(atendente.getEmail());
        textFieldCpf.setText(atendente.getCpf());
        textFieldRg.setText(atendente.getRg());
        textFieldPasep.setText(atendente.getPasep());
        textFieldPis.setText(atendente.getPis());
        textFieldEndereco.setText(atendente.getEndereco());
        textFieldFone.setText(atendente.getFone());
        textFieldObservacao.setText(atendente.getObservacao());
        textFieldSetor.setText(atendente.getSetor());
        textFieldRamal.setText(String.valueOf(atendente.getRamal()));
        datePickerDataDeNascimento.setValue(atendente.getDataNascimento());
        }catch(SQLException e){
            System.out.println("Atendente não localizado:\n"+ e);
            textFieldId.setText(null);
            textFieldNome.setText(null);
            textFieldEmail.setText(null);
            textFieldCpf.setText(null);
            textFieldRg.setText(null);
            textFieldPasep.setText(null);
            textFieldPis.setText(null);
            textFieldEndereco.setText(null);
            textFieldFone.setText(null);
            textFieldObservacao.setText(null);
            textFieldSetor.setText(null);
            textFieldRamal.setText(null);
            datePickerDataDeNascimento.setValue(null);
        }
    }
    
    @FXML
    private void handlerExcluirAtendente(ActionEvent event){
        Connection con = Conexao.getConnection();
        AtendenteDao adao = new AtendenteDao();
        adao.setConnection(con);
        adao.remover(Integer.parseInt(textFieldId.getText()));
        popularAtendente();
    }
    
    @FXML
    private void handlerAtualizarAtendente(ActionEvent event){
        try{
        Integer id = Integer.parseInt(textFieldId.getText());
        String nome = textFieldNome.getText();
        String email = textFieldEmail.getText();
        String cpf = textFieldCpf.getText();
        String rg = textFieldRg.getText();
        String pasep = textFieldPasep.getText();
        String pis = textFieldPis.getText();
        String endereco = textFieldEndereco.getText();
        String fone = textFieldFone.getText();
        String observacao = textFieldObservacao.getText();
        String setor = textFieldSetor.getText();
        Integer ramal = Integer.parseInt(textFieldRamal.getText());
        LocalDate dataNascimento = datePickerDataDeNascimento.getValue();
        Atendente atendente = new Atendente(ramal, pis, pasep, setor, id, nome, cpf, rg, endereco, fone, email, dataNascimento, observacao);
        
        Connection con = Conexao.getConnection();
        AtendenteDao adao = new AtendenteDao();
        adao.setConnection(con);
        adao.atualizar(atendente);
        }catch(NumberFormatException e){
            System.out.println("Caracter informado é inválido:\n" + e);
        }
        popularAtendente();
    }
    
    @FXML
    private void handlerInserirAtendente(ActionEvent event){
        try{
        Integer id = Integer.parseInt(textFieldId.getText());
        String nome = textFieldNome.getText();
        String email = textFieldEmail.getText();
        String cpf = textFieldCpf.getText();
        String rg = textFieldRg.getText();
        String pasep = textFieldPasep.getText();
        String pis = textFieldPis.getText();
        String endereco = textFieldEndereco.getText();
        String fone = textFieldFone.getText();
        String observacao = textFieldObservacao.getText();
        String setor = textFieldObservacao.getText();
        Integer ramal = Integer.parseInt(textFieldRamal.getText());
        LocalDate dataNascimento = datePickerDataDeNascimento.getValue();
        Atendente atendente = new Atendente(ramal, pis, pasep, setor, id, nome, cpf, rg, endereco, fone, email, dataNascimento, observacao);
        
        Connection con = Conexao.getConnection();
        AtendenteDao adao = new AtendenteDao();
        adao.setConnection(con);
        adao.inserir(atendente);
        }catch(NumberFormatException e){
            System.out.println("Caracter informado é inválido:\n" + e);
        }
        popularAtendente();
    }
    
    @FXML
    private void handlerVoltarCadastroAtendente(MouseEvent event){
        try{
        AnchorPane a = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        anchorPaneFundoAtendente.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao voltar para tela principal: "+ e);
        }
    }
    
    @FXML
    private void handlerNovoAtendente(ActionEvent event){
        textFieldId.setText(null);
        textFieldNome.setText(null);
        textFieldEmail.setText(null);
        textFieldCpf.setText(null);
        textFieldRg.setText(null);
        textFieldPasep.setText(null);
        textFieldPis.setText(null);
        textFieldEndereco.setText(null);
        textFieldFone.setText(null);
        textFieldObservacao.setText(null);
        textFieldSetor.setText(null);
        textFieldRamal.setText(null);
        datePickerDataDeNascimento.setValue(null);
    }
}
