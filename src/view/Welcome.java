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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Welcome extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {


        TextArea welcomeText = new TextArea();
        welcomeText.setText("Enter a valid URL");
        welcomeText.setEditable(false);

        TextField url = new TextField();


        Button go = new Button("GO");
        go.setOnMouseClicked(event -> {
            BFSCrawler crawler = new BFSCrawler();
            String urlString = formatURL(url.getText());

            System.out.println(urlString);
            crawler.callCrawler(urlString);
        });

        VBox vbox = new VBox();

        vbox.getChildren().addAll(welcomeText,url,go);

        Scene scene  = new Scene(vbox,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private String formatURL(String url){

        String regexp1 = "www.";
        Pattern pattern1 = Pattern.compile(regexp1);
        Matcher matcher1 = pattern1.matcher(url);

        if (!matcher1.find()){
            url = "www." + url;
        }

        String regexp2 = "https://";
        Pattern pattern2 = Pattern.compile(regexp2);
        Matcher matcher2 = pattern2.matcher(url);


        if (!matcher2.find()){
            url = "https://" + url;
        }

        return url;

    }





}
