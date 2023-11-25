module com.spotify {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.spotify to javafx.fxml;
    exports com.spotify;
}
