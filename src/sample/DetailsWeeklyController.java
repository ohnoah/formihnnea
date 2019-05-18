package sample;

import classes.Location;
import classes.currentweather.CurrentWeather;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.OWM;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;

import static sample.Main.*;


public class DetailsWeeklyController {


    //set up IDs for all variables in the system
    @FXML
    private Label chanceOfRain;

    @FXML
    private Label time1;

    @FXML
    private Label time2;

    @FXML
    private Label time3;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label time4;

    @FXML
    private Label time5;

    @FXML
    private Label time6;

    @FXML
    private Label time7;

    @FXML
    private Label time8;

    @FXML
    private Label vis7;

    @FXML
    private Label vis6;

    @FXML
    private ImageView btnBack;

    @FXML
    private ToggleButton btnWeekly;

    @FXML
    private Label vis5;

    @FXML
    private Label vis4;

    @FXML
    private Label vis3;

    @FXML
    private Label visibility;

    @FXML
    private Label vis2;

    @FXML
    private Label vis1;

    @FXML
    private Label cloudCover;

    @FXML
    private Label vis8;

    @FXML
    private Label sunPosition;

    @FXML
    private ToggleButton btnHourly;

    @FXML
    private Label sundown8;

    @FXML
    private Label sundown6;

    @FXML
    private Label sunrise;

    @FXML
    private Label sundown7;

    @FXML
    private Label locate;

    @FXML
    private Label sundown1;

    @FXML
    private Label sunup2;

    @FXML
    private Label sunup1;

    @FXML
    private Label temp2;

    @FXML
    private Label sunup4;

    @FXML
    private Label sundown4;

    @FXML
    private Label temp3;

    @FXML
    private Label sunup3;

    @FXML
    private Label sundown5;

    @FXML
    private Label sundown2;

    @FXML
    private Label sunup6;

    @FXML
    private Label temp1;

    @FXML
    private Label sunup5;

    @FXML
    private Label sundown3;

    @FXML
    private ImageView sun2;

    @FXML
    private Label rain8;

    @FXML
    private Label sunup8;

    @FXML
    private ImageView sun3;

    @FXML
    private Label sunup7;

    @FXML
    private Label cld7;

    @FXML
    private ImageView sun1;

    @FXML
    private Label cld8;

    @FXML
    private Label rain4;

    @FXML
    private Label cld5;

    @FXML
    private Label rain5;

    @FXML
    private Label cld6;

    @FXML
    private Label rain6;

    @FXML
    private Label cld3;

    @FXML
    private Label rain7;

    @FXML
    private Label cld4;

    @FXML
    private Label cld1;

    @FXML
    private Label temperature;

    @FXML
    private Label cld2;

    @FXML
    private ImageView sun8;

    @FXML
    private ImageView sun6;

    @FXML
    private ImageView sun7;

    @FXML
    private ImageView sun4;

    @FXML
    private GridPane hourlyGrid;

    @FXML
    private ImageView sun5;

    @FXML
    private Label rain1;

    @FXML
    private Label rain2;

    @FXML
    private Label rain3;

    @FXML
    private ToggleGroup timeGroup;

    @FXML
    private ImageView sunType;

    @FXML
    private Label temp6;

    @FXML
    private Label temp7;

    @FXML
    private ScrollPane horizScrollPane;

    @FXML
    private Label temp4;

    @FXML
    private Label temp5;

    @FXML
    private Label temp8;

    @FXML
    private Label sunset;


    //this is the only parent
    private Parent root;


    //called when the back button is pressed
    public void back() throws IOException {
        root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Main.stage.setTitle("Back from Weekly");
        Main.stage.setScene(new Scene(root, 479, 673));
        stage.show();
    }

    //When the button is toggled we switch to weekly
    public void weeklySwitch(ActionEvent event) throws IOException {

        Parent weeklyParent = new FXMLLoader().load(getClass().getResource("detailpageweekly.fxml"));
        Scene weeklyScene = new Scene(weeklyParent);

        //Get the stage information from the clicked button
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(weeklyScene);
        window.show();

    }

    //When the button is toggled we switch to hourly
    public void hourlySwitch(ActionEvent event) throws IOException {

        Parent hourlyParent = new FXMLLoader().load(getClass().getResource("detailpage.fxml"));
        Scene hourlyScene = new Scene(hourlyParent);

        //Get the stage information from the clicked
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(hourlyScene);
        window.show();


    }
    //Mihnea's method which initializes all fields in the top part of the screen
    public void initialize(){
        btnWeekly.setSelected(true);
        CurrentWeather cw = OWM.getCurrentWeather(new Location(getCity()+","+getCountry()));
        locate.setText(getCity() + ", " + getCountry() );
        BigDecimal bd = new BigDecimal(cw.mainParameters.temperature - 273.15);
        bd = bd.round(new MathContext(3));
        temperature.setText(String.valueOf(bd) + "°");
        visibility.setText(cw.visibility);
        sunrise.setText(cw.systemParameters.sunrise.toString().split(" ")[3].substring(0,5));
        sunset.setText(cw.systemParameters.sunset.toString().split(" ")[3].substring(0,5));
        cloudCover.setText(new Double(cw.clouds.cloudiness).intValue() +"%");
        String rainOutput = cw.rain != null ? (cw.rain.rainAmt + "%") : "N/A";
        chanceOfRain.setText(rainOutput);

    }

}
