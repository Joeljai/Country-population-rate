module org.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.example.project1 to javafx.fxml;
    exports org.example.project1;
}