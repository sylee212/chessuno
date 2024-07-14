module chessuno {
    requires javafx.controls;
    requires javafx.fxml;

    opens chessuno to javafx.fxml;
    exports chessuno;
}
