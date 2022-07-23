package com.ripefruitcreative;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.image.BufferedImage;

public class WhatIAmFinalController implements Initializable{
    private String whatYouAre;
    private File[] imageUrl = new File[7];//{"@images/troll-face.jpg", "@images/troll-face.jpg", "@images/troll-face.jpg", "@images/troll-face.jpg", "@images/troll-face.jpg", "@images/troll-face.jpg","@images/troll-face.jpg"};
    
    @FXML
    private ImageView imageView1 = new ImageView();
    // @FXML
    // Image id2;
    // @FXML
    // Image id3;
    // @FXML
    // Image id4;
    // @FXML
    // Image id5;
    // @FXML
    // Image id6;
    // @FXML
    // Image id7;
    
    public String getWhatYouAre(){
        return whatYouAre;
    }
    public void setWhatYouAre(String whatYouAre){
        this.whatYouAre = whatYouAre;
    }

    // void setImageUrls(){
    //     System.out.println(imageView1);
    //     System.out.println("in the urls function");
    //     for(int i=0; i <7; i++){
    //         System.out.println("at number: "+i);
    //         BufferedImage bufferedImage;
    //         this.imageUrl[i] = PrimaryController.myCrapArrayList.get(i);
    //         // bufferedImage = ImageIO.read(this.imageUrl[i]);
    //         // Image thisImage = SwingFXUtils.toFXImage(bufferedImage, null);
    //         // this.imageView1.setImage(thisImage);
    //         // System.out.println(thisImage);
    //     }
    //     System.out.println(imageView1);
    // }



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    // String pickThisVid(String baseString, String vidName) throws IOException {
    //     String directory = "../videos/";
    //     baseString = directory+baseString;
    //     return baseString;
    // }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        System.out.println("Initializing Final Quiz Controller");
        // Image pleaseWork = new Image(new File("src/main/resources/com/ripefruitcreative/images/troll-face.jpg").toURI().toString());
        // imageView1.setImage(pleaseWork);
        // setImageUrls();

        whatYouAre = String.valueOf(PrimaryController.whatIAm);

        // System.out.println(gameLabel);
        
    }
}