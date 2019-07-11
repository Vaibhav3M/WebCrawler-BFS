package view;

import Model.BFSCrawler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Welcome extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {


        TextArea welcomeText = new TextArea();
        welcomeText.setText("Enter a valid URL");

        TextField url = new TextField();


        Button go = new Button("GO");
        go.setOnMouseClicked(event -> {
            BFSCrawler crawler = new BFSCrawler();
            crawler.callCrawler(url.getText());
        });

        VBox vbox = new VBox();

        vbox.getChildren().addAll(welcomeText,url,go);

        Scene scene  = new Scene(vbox,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();

    }





}
