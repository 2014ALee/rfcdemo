package com.ripefruitcreative;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage stage2;
    private Boolean isPaused = false;
    // private final long createdMillis = System.currentTimeMillis();

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Main Menu");
        scene = new Scene(loadFXML("secondary"), 640, 480);
        stage2 = stage;
        stage.setScene(scene);
        stage.show();

    }

    public static void returnToMainMenu(Stage stage) throws IOException {
        stage2 = stage;
        stage.setTitle("Main Menu");
        scene = new Scene(loadFXML("secondary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public void showTwoVideos(Stage stage, String[] paths, String option1, String option2, int whereWeGoNext, String theQuestion) throws InterruptedException {
        Media[] medias = new Media[2];
        MediaPlayer[] mediaPlayers = new MediaPlayer[2];
        MediaView[] mediaViews = new MediaView[2];
        for (int i = 0; i < 2; i++) {
            System.out.println("Going through number "+i);
            medias[i] = new Media(new File(paths[i]).toURI().toString());
            mediaPlayers[i] = new MediaPlayer(medias[i]);
            mediaViews[i] = new MediaView();
            mediaViews[i].setMediaPlayer(mediaPlayers[i]);
            System.out.println(medias[i].getSource());

            System.out.println(mediaPlayers[i]);
            // DoubleProperty width = mediaViews[i].fitWidthProperty();
            // DoubleProperty height = mediaViews[i].fitHeightProperty();
            // width.bind(Bindings.selectDouble(mediaViews[i].sceneProperty(), "width"));
            // height.bind(Bindings.selectDouble(mediaViews[i].sceneProperty(), "height"));
            mediaViews[i].setFitWidth(450);
            mediaViews[i].setFitHeight(450);
            System.out.println(mediaViews[i].isVisible());
            mediaPlayers[i].setCycleCount(MediaPlayer.INDEFINITE);
            // mediaPlayers[i].setAutoPlay(true);
            mediaPlayers[i].setMute(true);
            mediaPlayers[i].getOnReady();

        }
        mediaPlayers[0].setOnReady(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("I'm on the left and I'M READY!");
                try{
                    mediaPlayers[0].setAutoPlay(true);
                }catch (MediaException e){
                    // mediaPlayers[0].dispose();
                    mediaViews[0].getMediaPlayer().dispose();
                    mediaViews[0].setMediaPlayer(new MediaPlayer(medias[0]));
                    mediaPlayers[0].setAutoPlay(true);

            }
            }
        });
        mediaPlayers[1].setOnReady(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("I'm on the right and I'M READY!");
                try{
                    mediaPlayers[1].setAutoPlay(true);
                }catch (MediaException e){
                    mediaViews[1].getMediaPlayer().dispose();
                    mediaViews[1].setMediaPlayer(new MediaPlayer(medias[1]));
                    mediaPlayers[1].setAutoPlay(true);
                }

            }
        });
        mediaPlayers[0].setOnPlaying(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("I'm on the left side and I'm playing, I swear");
                
            }

        });
        mediaPlayers[1].setOnPlaying(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("I'm on the right side and I'm playing, I swear");
                
            }

        });
        mediaPlayers[0].setOnError(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("I'm on the left side and I fucked up.");
                mediaViews[0].getMediaPlayer().dispose();
                mediaViews[0].setMediaPlayer(new MediaPlayer(medias[0]));
                mediaPlayers[0].setAutoPlay(true);
                System.out.println(mediaPlayers[0].getError());
                
            }

        });
        mediaPlayers[1].setOnError(new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("I'm on the right side and I fucked up.");
                System.out.println(mediaPlayers[1].getError());
                mediaViews[1].getMediaPlayer().dispose();
                mediaViews[1].setMediaPlayer(new MediaPlayer(medias[1]));
                mediaPlayers[1].setAutoPlay(true);
                
            }

        });
        mediaViews[1].setX(410);
        // mediaPlayers[1].setAutoPlay(true);
        // mediaPlayers[0].setAutoPlay(true);
        System.out.println("The Coords of each are:");
        System.out.println("Left One:");
        System.out.println(mediaViews[0].getX());
        System.out.println("Right One:");
        System.out.println(mediaViews[1].getX());

        Label currentQuestion = new Label(theQuestion);
        currentQuestion.setTranslateX(450);
        currentQuestion.setTranslateY(450);
        Button selectOption1 = new Button(option1);
        selectOption1.setLayoutY(500);
        selectOption1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayers[1].dispose();
                mediaPlayers[0].dispose();
                // System.out.println("left disposal check");
                // System.out.println(mediaPlayers);
                try {
                    PrimaryController.addToWhatIAm(option1, whereWeGoNext);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        Button selectOption2 = new Button(option2);
        selectOption2.setLayoutY(500);
        selectOption2.setLayoutX(500);
        selectOption2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mediaPlayers[1].dispose();
                mediaPlayers[0].dispose();
                // System.out.println("right disposal check");
                // System.out.println(mediaPlayers);
                // Call the function in PrimaryController, maybe?
                try {
                    PrimaryController.addToWhatIAm(option2, whereWeGoNext);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        stage = stage2;
        Group root = new Group();
        // Pane root = new Pane(loadFXML("secondary"));
        // root.getChildren().add(loadFXML("secondary"));
        root.getChildren().add(mediaViews[0]);
        root.getChildren().add(mediaViews[1]);
        root.getChildren().addAll(selectOption1, selectOption2, currentQuestion);
        Scene scene = new Scene(root, 1200, 1200);
        System.out.println(root.getChildren().get(1));
        System.out.println(root.getChildren().get(0));
        Thread.sleep(1000);
        stage.setScene(scene);
        stage.setTitle(currentQuestion.getText());
        stage.show();
        System.out.println("left one");
        System.out.println("Status:");
        System.out.println(mediaViews[1].getMediaPlayer().getStatus());
        System.out.println("is visible:");
        System.out.println(mediaViews[0].isVisible());
        System.out.println("is disabled:");
        System.out.println(mediaViews[0].isDisabled());
        System.out.println("right one");
        System.out.println("Status:");
        System.out.println(mediaViews[1].getMediaPlayer().getStatus());
        System.out.println("is visible:");
        System.out.println(mediaViews[1].isVisible());
        System.out.println("is disabled:");
        System.out.println(mediaViews[1].isDisabled());

    }

    public void playABunchOfVideos(Stage stage, ArrayList<String> allPaths, String iAmA) {
        // double xPusher = 0;
        // Media[] medias = new Media[allPaths.size()];
        // MediaPlayer[] mediaPlayers = new MediaPlayer[allPaths.size()];
        // MediaView[] mediaViews = new MediaView[allPaths.size()];
        // for (int i = 0; i < allPaths.size(); i++) {
        //     medias[i] = new Media(new File(allPaths.get(i)).toURI().toString());
        //     mediaPlayers[i] = new MediaPlayer(medias[i]);
        //     mediaViews[i] = new MediaView(mediaPlayers[i]);
        //     mediaViews[i].setFitWidth(450);
        //     mediaViews[i].setFitHeight(450);
        //     mediaPlayers[i].setAutoPlay(true);
        //     mediaPlayers[i].setCycleCount(MediaPlayer.INDEFINITE);
        //     mediaViews[i].setX(xPusher);
        //     xPusher += 200;
        // }
        stage = stage2;
        Label youAreA = new Label("You are a...");
        youAreA.setLayoutX(500);
        youAreA.setLayoutY(400);
        Label whatAreYou = new Label(iAmA);
        whatAreYou.setLayoutX(500);
        whatAreYou.setLayoutY(500);
        Button goBack = new Button("Return to Main Menu");
        goBack.setLayoutY(600);
        goBack.setLayoutX(500);
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                try {
                    // for (int i = 0; i < mediaViews.length; i++) {
                    //     mediaPlayers[i].stop();
                    //     mediaPlayers[i].dispose();
                    // }
                    returnToMainMenu(stage2);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        Group root = new Group();
        root.getChildren().addAll(whatAreYou, youAreA, goBack);
        // for (int i = 0; i < mediaViews.length; i++) {
        //     root.getChildren().add(mediaViews[i]);
        // }
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.setTitle("You are a " + iAmA);
        stage.show();
    }

    public void startVideo(Stage stage, String path) throws IOException {
        Image seeButtonImage = new Image(new File("buttons/iSawSomething.PNG").toURI().toString());
        Image hearButtonImage = new Image(new File("buttons/iHeardSomething.PNG").toURI().toString());
        Image pauseButtonImage = new Image(new File("buttons/pauseButton.PNG").toURI().toString());
        Image playButtonImage = new Image(new File("buttons/playButton.PNG").toURI().toString());
        ImageView playImageView = new ImageView(playButtonImage);
        ImageView pauseImageView = new ImageView(pauseButtonImage);
        ImageView sImageView = new ImageView(seeButtonImage);
        ImageView hImageView = new ImageView(hearButtonImage);
        hImageView.setFitHeight(150);
        hImageView.setFitWidth(250);
        sImageView.setFitHeight(150);
        sImageView.setFitWidth(250);
        playImageView.setFitHeight(150);
        playImageView.setFitWidth(250);
        pauseImageView.setFitHeight(150);
        pauseImageView.setFitWidth(250);
        // Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        // Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Instantiating MediaView class
        MediaView mediaView = new MediaView(mediaPlayer);
        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

        // by setting this property to true, the Video will be played

        mediaPlayer.setOnReady(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                PrimaryController.seeCounter = 0;
                PrimaryController.hearCounter = 0;
                System.out.println("in the run function");
                mediaPlayer.setAutoPlay(true);

            }
        });
        PrimaryController pc = new PrimaryController();
        stage = stage2;
        Button seeCounter = new Button("", sImageView);
        // seeCounter.setLayoutY(-100);
        // seeCounter.setScaleX(0.3);
        // seeCounter.setScaleY(0.3);
        seeCounter.setLayoutX(125);
        seeCounter.setTranslateX(200);
        seeCounter.setLayoutY(250);
        seeCounter.setTranslateY(100);
        seeCounter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                try {
                    pc.increaseSeeCounter();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        Button hearCounter = new Button("", hImageView);
        // hearCounter.setGraphic(hImageView);
        hearCounter.setTranslateX(10);
        hearCounter.setLayoutY(250);
        hearCounter.setTranslateY(100);
        hearCounter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                try {
                    pc.increaseHearCounter();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });
        Button goBack = new Button("go back");
        goBack.setLayoutY(350);
        goBack.setTranslateY(200);
        goBack.setLayoutX(325);
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                try {
                    mediaPlayer.stop();
                    mediaPlayer.dispose();
                    returnToMainMenu(stage2);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        });

        Button pauseVid = new Button("Pause");
        pauseVid.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!isPaused) {
                    isPaused = true;
                    mediaPlayer.pause();
                    // System.out.println(mediaPlayer.getStatus());
                } else {
                    isPaused = false;
                    mediaPlayer.play();
                    // System.out.println(mediaPlayer.getStatus());
                }
            }
        });
        pauseVid.setLayoutY(350);
        pauseVid.setTranslateY(200);
        pauseVid.setLayoutX(230);
        mediaPlayer.setOnEndOfMedia(() -> {
            try {
                Thread.sleep(1000);
                mediaPlayer.dispose();
                stage2.setTitle("Quiz Results");
                // QuizController quiz = new QuizController(pc.hearCounter, pc.seeCounter);
                scene = new Scene(loadFXML("Quiz"), 640, 480);
                stage2.setScene(scene);
                stage2.show();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        // setting group and scene
        Group root = new Group();
        // Pane root = new Pane(loadFXML("secondary"));
        // root.getChildren().add(loadFXML("secondary"));
        root.getChildren().add(mediaView);
        root.getChildren().addAll(seeCounter, hearCounter, goBack, pauseVid);
        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Playing video");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static MediaView globalMediaViewer;

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}