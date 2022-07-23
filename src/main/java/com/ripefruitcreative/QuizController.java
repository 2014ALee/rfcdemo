package com.ripefruitcreative;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class QuizController implements Initializable{
    // private StringProperty audioStim = new SimpleStringProperty(this, "audioStim", "");
    // private StringProperty visualStim = new SimpleStringProperty(this, "visualStim", "");
    private String audioStim;
    private String visualStim;
    private int hearCounter;
    private int seeCounter;
    public QuizController(){};
    // public QuizController(int hCount, int sCount){
    //     hCount = hearCounter;
    //     sCount = seeCounter;
    //     System.out.println("What we just got:");
    //     System.out.println(hearCounter);
    //     System.out.println(seeCounter);
    //     // initialize(arg0, arg1);
    // }

    // PrimaryController pc = new PrimaryController();

    @FXML
    private Label gameLabelOne;

    @FXML
    private Label gameLabelTwo;

    public String getAudioStim(){
        return audioStim;
    }
    public String getVisualStim(){
        return visualStim;
    }
    public void setAudioStim(String audioStim){
        this.audioStim = audioStim;
    }
    public void setVisualStim(String visualStim){
        this.visualStim = visualStim;
    }
    @FXML
    private void switchToVidSelect() throws IOException {
        // Stage blankStage = new Stage();
        App.returnToMainMenu(App.stage2);
    }

    private void checkTheScore(String theScore, int whatsToBeChecked, Label theLabel ){
        System.out.println("The Score:");
        System.out.println(theScore);
        System.out.println("what we're checking");
        System.out.println(whatsToBeChecked);
        System.out.println("The label");
        System.out.println(theLabel);
        if(Integer.parseInt(theScore) >= whatsToBeChecked){
            theLabel.setStyle("-fx-text-fill: blue");
            System.out.println(theLabel.getText());
        }
    }



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        // System.out.println(PrimaryController.hearCounter);

        audioStim = String.valueOf(PrimaryController.hearCounter);
        visualStim = String.valueOf(PrimaryController.seeCounter);
        checkTheScore(audioStim, video.hearingPrompts, gameLabelOne);
        checkTheScore(visualStim, video.seeingPrompts, gameLabelTwo);

        // System.out.println(gameLabel);
        
    }
}
