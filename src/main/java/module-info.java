module com.ripefruitcreative {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;

    opens com.ripefruitcreative to javafx.fxml;
    exports com.ripefruitcreative;
}
