package com.ripefruitcreative;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable {
    public static int hearCounter = 0;
    public static int seeCounter = 0;

    public String fp;
    public String fn;
    public static String whatIAm = "";
    public static ArrayList<String> myCrapArrayList = new ArrayList<String>();

    // Image theImage = new Image(new
    // File("images/troll-face.jpg").toURI().toString());

    @FXML
    private ImageView myImage;

    @FXML
    private MediaView mediaView;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public static void addToWhatIAm(String ButtonWord, int whereWeGo) throws IOException, InterruptedException {// ActionEvent event) throws
                                                                                          // IOException {
        App callback = new App();
        String baseQuestion = "";
        String whatToAdd = "";
        Stage blankStage = new Stage();
        String[] paths = new String[2];
        // Node node = (Node) event.getSource();
        // Button textGrabber = (Button) node;
        // String ButtonWord = textGrabber.getText();
        // String whereWeGo = node.getUserData().toString();
        System.out.println("what to add");
        System.out.println(ButtonWord);
        System.out.println("where to go after");
        System.out.println(whereWeGo);

        switch (ButtonWord) {
            case "Protective and focused":
                whatToAdd = "Stron";
                myCrapArrayList.add("videos/pexels-mikhail-nilov-7710516.mp4");
                break;

            case "Carefree with different interests":
                whatToAdd = "Fre'";
                myCrapArrayList.add("videos/pexels-zlatin-georgiev-5607740.mp4");
                break;

            case "Calm and slow":
                whatToAdd = "carie";
                myCrapArrayList.add("videos/calmcat.mp4");
                break;

            case "Fast and frantic":
                whatToAdd = "quii";
                myCrapArrayList.add("videos/Squirrel - 406.mp4");
                break;

            case "You're going to hear about it":
                whatToAdd = "laoudie";
                myCrapArrayList.add("videos/Lightning Bolt At Night.mp4");
                break;

            case "You won't see it coming":
                whatToAdd = "snee";
                myCrapArrayList.add("videos/pexels-rostislav-uzunov-7513671.mp4");
                break;

            case "To be surrounded by friends and go with the flow":
                whatToAdd = "flow";
                myCrapArrayList.add("videos/Pexels Videos 1151329.mp4");
                break;

            case "To be with yourself and set your own pace":
                whatToAdd = "indie";
                myCrapArrayList.add("videos/Black Bear - 3343.mp4");
                break;

            case "Peaceful and Repetitive":
                whatToAdd = "slee";
                myCrapArrayList.add("videos/Pexels Videos 1526909.mp4");
                break;

            case "There's always something going on":
                whatToAdd = "bizee";
                myCrapArrayList.add("videos/Pexels Videos 1860079.mp4");
                break;
        }
        whatIAm = whatIAm + whatToAdd;
        System.out.println(whatIAm);
        switch (whereWeGo) {
            case 1:
                baseQuestion = "Which best reflects your mood right now?";
                paths[0] = "videos/calmcat.mp4";
                paths[1] = "videos/Squirrel - 406.mp4";
                callback.showTwoVideos(blankStage, paths, "Calm and slow", "Fast and frantic", 2, baseQuestion);
                break;

            case 2:
                baseQuestion = "Which best reflects your mood when you're upset?";
                paths[0] = "videos/Lightning Bolt At Night.mp4";
                paths[1] = "videos/pexels-rostislav-uzunov-7513671.mp4";
                callback.showTwoVideos(blankStage, paths, "You're going to hear about it", "You won't see it coming", 3,
                        baseQuestion);
                break;

            case 3:
                baseQuestion = "Which best reflects what you prefer?";
                paths[0] = "videos/Pexels Videos 1151329.mp4";
                paths[1] = "videos/Black Bear - 3343.mp4";
                callback.showTwoVideos(blankStage, paths, "To be surrounded by friends and go with the flow",
                        "To be with yourself and set your own pace",
                        4, baseQuestion);
                break;

            case 4:
                baseQuestion = "Which place would you rather spend more time?";
                paths[0] = "videos/countryroad.mp4";
                paths[1] = "videos/Pexels Videos 1860079.mp4";
                callback.showTwoVideos(blankStage, paths, "Peaceful and Repetitive",
                        "There's always something going on", 5, baseQuestion);
                break;

            case 5:
                callback.playABunchOfVideos(blankStage, myCrapArrayList, whatIAm);
        }
        // App.showTwoVideos(whereWeGo);

    }

    private void setWhatIAmToNull() {
        whatIAm = "";
        myCrapArrayList = new ArrayList<String>();
    }

    public PrimaryController() {
    };

    public PrimaryController(String filePath, String fileName) {
        // final String theFilePath = filePath;
        setFilepath(filePath);
        setFilename(fileName);
        System.out.println("case and switch");
        switch (fn) {
            case "InSync":
                new video(5, 5);
                break;
            case "dummy1":
                new video(5, 5);
                break;
            case "dummy2":
                new video(5, 5);
                break;
        }
        System.out.println("in the initialize");
        System.out.println(fn);
        playVideo(fp);
    }

    private void setFilepath(String FilePath) {
        fp = FilePath;
        System.out.println("line 41");
        System.out.println(fp);
    }

    private void setFilename(String FileName) {
        fn = FileName;
        System.out.println("line 46");
        System.out.println(fn);
    }

    public int increaseHearCounter() throws IOException {
        hearCounter = hearCounter + 1;
        System.out.println(hearCounter);
        return hearCounter;
    }

    public int increaseSeeCounter() throws IOException {
        seeCounter = seeCounter + 1;
        System.out.println(seeCounter);
        return seeCounter;
    }

    public void playVideo(String filePath) {
        App callback = new App();
        Stage blankStage = new Stage();
        try {
            callback.startVideo(blankStage, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }
}
