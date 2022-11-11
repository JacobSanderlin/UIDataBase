module com.jacob.uidatabase {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.fx.countries;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.j;

    opens com.jacob.uidatabase.registration to javafx.fxml;
    exports com.jacob.uidatabase.registration;
    exports com.jacob.uidatabase;
    opens com.jacob.uidatabase to javafx.fxml;
}