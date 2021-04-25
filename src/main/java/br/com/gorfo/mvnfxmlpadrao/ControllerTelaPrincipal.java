package br.com.gorfo.mvnfxmlpadrao;

import br.com.gorfo.mvnfxmlpadrao.database.Conexao;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import static org.jfree.util.ObjectUtilities.getClassLoader;

public class ControllerTelaPrincipal implements Initializable{
    
//    @FXML
//    private MenuItem menuItemCadastrarAtendente;
//    
//    @FXML
//    private MenuItem menuItemCadastrarEmpresa;
//    
//    @FXML
//    private MenuItem menuItemCadastrarAtendimento;
//        
//    @FXML
//    private MenuItem menuItemRelatorioAtendente;
//    
//    @FXML
//    private MenuItem menuItemCadastrarCliente;
    
    @FXML
    private AnchorPane anchorPaneFundo;
    
    @Override
    public void initialize(URL location, ResourceBundle Resources){
        
    }
    
    @FXML
    private void handlerCadastrarAtendente(javafx.event.ActionEvent event){
        try{
        AnchorPane a = FXMLLoader.load(getClass().getResource("TelaCadastroAtendente.fxml"));
        anchorPaneFundo.getChildren().setAll(a);
        }catch (IOException e){
            System.out.println("Erro ao abrir tela de cadastro de atendentes: "+ e);
        }   
    }
    
    @FXML
    private void handlerCadastrarEmpresa(javafx.event.ActionEvent event){
        try{
            AnchorPane a = FXMLLoader.load(getClass().getResource("TelaCadastroEmpresa.fxml"));
            anchorPaneFundo.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao abrir tela de cadastro de empresas: "+ e);
        }
    }
    
    @FXML
    private void handlerCadastrarAtendimento(javafx.event.ActionEvent event){
        try{
            AnchorPane a = FXMLLoader.load(getClass().getResource("TelaCadastroAtendimento.fxml"));
            anchorPaneFundo.getChildren().setAll(a);
        }catch(IOException e){
            System.out.println("Erro ao abrir tela de cadastro de atendimento: "+ e);
        }
    }
    
    @FXML
    private void handlerCadastrarCliente(javafx.event.ActionEvent event){
        try{
            AnchorPane a = FXMLLoader.load(getClass().getResource("TelaCadastroCliente.fxml"));
            anchorPaneFundo.getChildren().setAll(a);
        }catch (IOException e){
            System.out.println("Erro ao abrir tela de cadastro de clientes: "+ e);
        }
    }
    
    @FXML
    private void handlerRelatorioAtendente(ActionEvent event) throws JRException{
        
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("relatorio/Atendente.jasper");
        
//        JasperReport report = JasperCompileManager.compileReport(in);

//            ByteArrayInputStream is = (ByteArrayInputStream) getClassLoader().getResourceAsStream("relatorio/Atendente.jrxml");
            
//            JasperDesign jasperDesign = JRXmlLoader.load(is);
            
//            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        
//        URL url = getClass().getResource("relatorio/Atendente.jasper");
        
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(url);
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, Conexao.getConnection());
        
        JasperViewer jasperViewer = new JasperViewer (jasperPrint, false);
        
        jasperViewer.setVisible(true);
    }
}
