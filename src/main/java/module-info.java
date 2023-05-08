module t1.task1 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;

    opens t1.task1 to javafx.fxml;
    exports t1.task1;
}