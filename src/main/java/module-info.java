module com.mycompany.mavenproject4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.mavenproject4 to javafx.fxml;
    opens modelo;
    exports com.mycompany.mavenproject4;
}
