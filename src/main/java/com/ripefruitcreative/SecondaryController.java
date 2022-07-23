package com.ripefruitcreative;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void startWIAGame() throws InterruptedException{
        PrimaryController.whatIAm = "";
        PrimaryController.myCrapArrayList.clear();
        App callback = new App();
        Stage blankStage = new Stage();
        String [] firstPaths = new String[2];
        String baseQuestion = "Which mood are you in more often?";
        firstPaths[0] = "videos/pexels-mikhail-nilov-7710516.mp4";
        firstPaths[1] = "videos/pexels-zlatin-georgiev-5607740.mp4";
        callback.showTwoVideos(blankStage, firstPaths, "Protective and focused", "Carefree with different interests", 1, baseQuestion);
    }
    // String pickThisVid(String baseString, String vidName) throws IOException {
    //     String directory = "../videos/";
    //     baseString = directory+baseString;
    //     return baseString;
    // }
    public void vidSelect(ActionEvent event) throws IOException{
        Node node = (Node) event.getSource();
        String filePath = (String) node.getUserData();
        String fileName= (String) node.getId();
        PrimaryController pc = new PrimaryController(filePath, fileName);
        // App.setRoot("primary");
    }
}