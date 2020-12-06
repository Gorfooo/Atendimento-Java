package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.beans.Empresa;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.sql.Connection;
import br.com.gorfo.mvnfxmlpadrao.dao.EmpresaDao;
import br.com.gorfo.mvnfxmlpadrao.database.Conexao;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private Button buttonNovaEmpresa;
    
    @FXML
    private Button buttonInserirEmpresa;
    
    @FXML
    private Button buttonAtualizarEmpresa;
    
    @FXML
    private Button buttonExcluirEmpresa;
    
    @FXML
    private AnchorPane setaVoltarCadastroEmpresa;
    
    @FXML
    private AnchorPane anchorPaneFundoEmpresa;
    
    private ObservableList<Empresa> olEmpresa;
    
    private Integer idEmpresaSelecionada;
    
    private Empresa empresaSelecionada;
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            popularEmpresa();
        } catch (ClassNotFoundException e) {
            System.out.println("Deu pau pra achar a classe"+e);
        }
        tableViewEmpresa.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarEmpresa(newValue));
    }
    
    public void popularEmpresa() throws ClassNotFoundException {
        Connection con = Conexao.conectar();
        EmpresaDao edao = new EmpresaDao();
        edao.setConnection(con);
        List<Empresa> lst = edao.listar();
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnSerial.setCellValueFactory(new PropertyValueFactory<>("serial"));
        tableColumnCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        tableColumnRazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razao_social"));
        tableColumnFone.setCellValueFactory(new PropertyValueFactory<>("fone"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tableColumnInscricaoEstadual.setCellValueFactory(new PropertyValueFactory<>("inscricao_estadual"));
        tableColumnTipoDeSistema.setCellValueFactory(new PropertyValueFactory<>("tipo_sistema"));

        olEmpresa = FXCollections.observableArrayList(lst);
        tableViewEmpresa.setItems(olEmpresa);
    }
    
    public void selecionarEmpresa(Empresa empresa){
        idEmpresaSelecionada = empresa.getId();
        empresaSelecionada = empresa;

        textFieldId.setText(String.valueOf(empresa.getId()));
        textFieldSerial.setText(String.valueOf(empresa.getSerial()));
        textFieldCnpj.setText(String.valueOf(empresa.getCnpj()));
        textFieldRazaoSocial.setText(String.valueOf(empresa.getRazao_social()));
        textFieldFone.setText(String.valueOf(empresa.getFone()));
        textFieldEndereco.setText(String.valueOf(empresa.getEndereco()));
        textFieldInscricaoEstadual.setText(String.valueOf(empresa.getInscricao_estadual()));
        textFieldTipoDeSistema.setText(String.valueOf(empresa.getTipo_sistema()));
    }
    
    @FXML
    private void handlerConsultarEmpresa(ActionEvent event){
        
    }
    
    @FXML
    private void handlerInserirEmpresa(ActionEvent event){
        try{
        String serial = textFieldSerial.getText();
        String cnpj = textFieldCnpj.getText();
        String razaoSocial = textFieldRazaoSocial.getText();
        String fone = textFieldFone.getText();
        String endereco = textFieldEndereco.getText();
        String inscricaoEstadual = textFieldInscricaoEstadual.getText();
        Integer id_tipo_sistema = Integer.parseInt(textFieldTipoDeSistema.getText());
        Empresa empresa = new Empresa(id_tipo_sistema, serial, cnpj, razaoSocial, fone, endereco, inscricaoEstadual, fone);
        
        Connection con = Conexao.conectar();
            EmpresaDao edao = new EmpresaDao();
            edao.setConnection(con);
            edao.inserir(empresa);
        } catch (NumberFormatException | ClassNotFoundException e) {
            System.out.println("Alguma coisa errada!");
        }
    }
    
    
    @FXML
    private void handlerAtualizarEmpresa(ActionEvent event){
        
    }
    
    @FXML
    private void handlerExcluirEmpresa(ActionEvent event) throws ClassNotFoundException {
        if (idEmpresaSelecionada!=null){
            Connection con = Conexao.conectar();
            EmpresaDao edao = new EmpresaDao();
            edao.setConnection(con);
            edao.remover(empresaSelecionada);
        }
    }
    
    @FXML
    private void handlerVoltarCadastroEmpresa(MouseEvent event){
        try{
        AnchorPane a = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        anchorPaneFundoEmpresa.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao voltar para tela principal: "+ e +"\n");
        }
    }
    
    @FXML
    private void handlerNovaEmpresa(ActionEvent event){
        textFieldId.setText(null);
        textFieldInscricaoEstadual.setText(null);
        textFieldCnpj.setText(null);
        textFieldRazaoSocial.setText(null);
        textFieldEndereco.setText(null);
        textFieldFone.setText(null);
        textFieldTipoDeSistema.setText(null);
        textFieldSerial.setText(null);
    }
    
}
