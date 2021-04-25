package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Cliente;
import br.com.gorfo.mvnfxmlpadrao.dao.ClienteDao;
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
    
//    @FXML
//    private Button buttonConsultarCliente;
//    
//    @FXML
//    private Button buttonInserirCliente;
//    
//    @FXML
//    private Button buttonAtualizarCliente;
//    
//    @FXML
//    private Button buttonExcluirCliente;
//    
//    @FXML
//    private Button buttonNovoCliente;
//    
//    @FXML
//    private AnchorPane setaVoltarCadastroCliente;
    
    @FXML
    private AnchorPane anchorPaneFundoCliente;
    
    private ObservableList<Cliente> olCliente;
    
    @Override
    public void initialize (URL location, ResourceBundle resources){
        popularCliente();
        tableViewCliente.getSelectionModel().selectedItemProperty().addListener((parametro, parametroo, parametrooo)-> selecionarCliente(parametrooo));
    }
    
    public void popularCliente(){
            Connection con = Conexao.getConnection();
            ClienteDao cdao = new ClienteDao();
            cdao.setConnection(con);
            List<Cliente> listaCliente = cdao.listar();
            tableColumnId.setCellValueFactory(new PropertyValueFactory("id"));
            tableColumnNome.setCellValueFactory(new PropertyValueFactory("nome"));
            tableColumnCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
            tableColumnRg.setCellValueFactory(new PropertyValueFactory("rg"));
            tableColumnEndereco.setCellValueFactory(new PropertyValueFactory("endereco"));
            tableColumnFone.setCellValueFactory(new PropertyValueFactory("fone"));
            tableColumnEmail.setCellValueFactory(new PropertyValueFactory("email"));
            tableColumnNascimento.setCellValueFactory(new PropertyValueFactory("dataNascimento"));
            tableColumnObservacao.setCellValueFactory(new PropertyValueFactory("observacao"));
            tableColumnRevenda.setCellValueFactory(new PropertyValueFactory("revenda"));
            
            olCliente = FXCollections.observableArrayList(listaCliente);
            tableViewCliente.setItems(olCliente);
    }
    
    public void selecionarCliente(Cliente cliente){
        try{
        textFieldId.setText(String.valueOf(cliente.getId()));
        textFieldNome.setText(cliente.getNome());
        textFieldCpf.setText(cliente.getCpf());
        textFieldRg.setText(cliente.getRg());
        textFieldFone.setText(cliente.getFone());
        textFieldEmail.setText(cliente.getEmail());
        textFieldObservacao.setText(cliente.getObservacao());
        textFieldRevenda.setText(cliente.getRevenda());
        textFieldEndereco.setText(cliente.getEndereco());
        datePickerDataDeNascimento.setValue(cliente.getDataNascimento());
        }catch(NullPointerException e){
            System.out.print("");
        }
    }
    
    @FXML
    private void handlerConsultarCliente(ActionEvent event){
        try{
            Connection con = Conexao.getConnection();
            ClienteDao cdao = new ClienteDao();
            cdao.setConnection(con);
            Cliente cliente = cdao.buscar(Integer.parseInt(textFieldId.getText()));
            textFieldNome.setText(cliente.getNome());
            textFieldCpf.setText(cliente.getCpf());
            textFieldRg.setText(cliente.getRg());
            textFieldFone.setText(cliente.getFone());
            textFieldEmail.setText(cliente.getEmail());
            textFieldObservacao.setText(cliente.getObservacao());
            textFieldRevenda.setText(cliente.getRevenda());
            textFieldEndereco.setText(cliente.getEndereco());
            datePickerDataDeNascimento.setValue(cliente.getDataNascimento());
        }catch(SQLException e){
            System.out.println("Cliente não localizado:\n"+ e);
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
    
    @FXML
    private void handlerInserirCliente(ActionEvent event){
        try{
        Integer id = Integer.parseInt(textFieldId.getText());
        String revenda = textFieldRevenda.getText();
        String Nome = textFieldNome.getText();
        String cpf = textFieldCpf.getText();
        String rg = textFieldRg.getText();
        String endereco = textFieldEndereco.getText();
        String fone = textFieldFone.getText();
        String email = textFieldEmail.getText();
        LocalDate dataNascimento = datePickerDataDeNascimento.getValue();
        String observacao= textFieldObservacao.getText();
        Cliente cliente = new Cliente(revenda, id, Nome, cpf, rg, endereco, fone, email, dataNascimento, observacao);
        
        Connection con = Conexao.getConnection();
        ClienteDao cdao = new ClienteDao();
        cdao.setConnection(con);
        cdao.inserir(cliente);
        } catch (NumberFormatException e) {
            System.out.println("Caracter informado é inválido:\n" + e);
        }
        popularCliente();
    }
    
    @FXML
    private void handlerAtualizarCliente(ActionEvent event){
        try{
        Integer id = Integer.parseInt(textFieldId.getText());
        String nome = textFieldNome.getText();
        String cpf = textFieldCpf.getText();
        String rg = textFieldRg.getText();
        String fone = textFieldFone.getText();
        String email = textFieldEmail.getText();
        String observacao = textFieldObservacao.getText();
        String revenda = textFieldRevenda.getText();
        String endereco = textFieldEndereco.getText();
        LocalDate data = datePickerDataDeNascimento.getValue();
        Cliente cliente = new Cliente(revenda, id, nome, cpf, rg, endereco, fone, email, data, observacao);
        
        Connection con = Conexao.getConnection();
        ClienteDao cdao = new ClienteDao();
        cdao.setConnection(con);
        cdao.atualizar(cliente);
        }catch(NumberFormatException e){
            System.out.println("Caracter informado é inválido:\n" + e);
        }
        popularCliente();
    }
    
    @FXML
    private void handlerExcluirCliente(ActionEvent event){
        Connection con = Conexao.getConnection();
        ClienteDao cdao = new ClienteDao();
        cdao.setConnection(con);
        cdao.remover(Integer.parseInt(textFieldId.getText()));
        popularCliente(); 
    }
    
    @FXML
    private void handlerVoltarCadastroCliente(MouseEvent event){
        try{
        AnchorPane a = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        anchorPaneFundoCliente.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao voltar para tela principal:\n"+ e);
        }
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
