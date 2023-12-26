module com.example.requestdesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.postgresql.jdbc;
    requires java.sql;


    opens com.example.requestdesktop to javafx.fxml;
    exports com.example.requestdesktop;

    opens com.example.requestdesktop.db to javafx.fxml;
    exports com.example.requestdesktop.db;

    opens com.example.requestdesktop.models to javafx.fxml;
    exports com.example.requestdesktop.models;
}