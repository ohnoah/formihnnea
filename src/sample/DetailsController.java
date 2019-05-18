package sample;

import classes.Location;
import classes.currentweather.CurrentWeather;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import java.io.IOException;
import utils.OWM;

import static sample.Main.*;



public class DetailsController {

    public Label temperature;
    public ToggleButton btnHourly;
    public ToggleButton btnWeekly;
    private Parent root;
    public Label locate;
    public Label visibility;
    public Label chanceOfRain;
    public Label sunPosition;
    public Label cloudCover;
    public Label sunrise;
    public Label sunset;

    public void displayHourly(){
        System.out.println("display hourly");
        System.out.println("country"+ Main.getCountry());
        System.out.println("city" + Main.getCity());
    }

    public void back() throws IOException {
        root = FXMLLoader.load(getClass().getResource("detailpage.fxml"));
        Main.stage.setTitle("Hello World");
        Main.stage.setScene(new Scene(root, 479, 673));
        stage.show();
    }

    public void initialize(){
        CurrentWeather cw = OWM.getCurrentWeather(new Location(getCity()+","+getCountry()));
        locate.setText(getCity() + ", " + getCountry() );
        temperature.setText(String.valueOf(cw.mainParameters.temperature - 273.15));
        visibility.setText(cw.visibility);
        sunrise.setText(cw.systemParameters.sunrise.toString().split(" ")[3].substring(0,5));
        sunset.setText(cw.systemParameters.sunset.toString().split(" ")[3].substring(0,5));
        cloudCover.setText(new Double(cw.clouds.cloudiness).intValue() +"%");
        String rainOutput = cw.rain != null ? (cw.rain.rainAmt + "%") : "N/A";
        chanceOfRain.setText(rainOutput);

    }

}
