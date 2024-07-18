module chessuno {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens chessuno to javafx.fxml;
    exports chessuno;
}
