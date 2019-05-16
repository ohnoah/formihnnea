package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;


public class Mainpage implements Initializable {

    @FXML
    private AnchorPane container;

    @FXML
    private MenuButton menu;

    @FXML
    private ListView listView;


    private Set<String> stringSet = new HashSet<>();
    ObservableList observableList = FXCollections.observableArrayList();

    @FXML
    private void navigateToSettings(ActionEvent event) throws IOException {
        System.out.println("Setting button clicked");

        Stage appStage=(Stage)menu.getScene().getWindow();
        Parent settingsParent = FXMLLoader.load(getClass().getResource("settingspage.fxml"));

        appStage.setScene(new Scene(settingsParent));
        appStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        TODO:
         - load list of locations -> populate weather data list
         - load background image for current location's weather data
         */

        // Set background image
        BackgroundImage myBI= new BackgroundImage(new Image("https://www.maxpixel.net/Rain-Gray-Wet-Drops-Water-Droplets-Window-354617", true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        container.setBackground(new Background(myBI));


        // Populate list
        stringSet.add("String 1");
        stringSet.add("String 2");
        stringSet.add("String 3");
        stringSet.add("String 4");
        observableList.setAll(stringSet);
        listView.setItems(observableList);
        listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>()
        {
            @Override
            public ListCell<String> call(ListView<String> listView)
            {
                return new ListViewCell();
            }
        });
    }



}
