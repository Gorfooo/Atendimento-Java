module br.com.gorfo.mvnfxmlpadrao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;

    opens br.com.gorfo.mvnfxmlpadrao to javafx.fxml;
    opens br.com.gorfo.mvnfxmlpadrao.beans to javafx.base;
    exports br.com.gorfo.mvnfxmlpadrao;
}
