package sample;

import classes.Location;
import classes.currentweather.CurrentWeather;
import classes.forecast.daily.Temperature;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import sample.Main;

import java.io.IOException;

import utils.LocationFinder;
import utils.OWM;




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

    //public void displayHourly(){
    //   System.out.println("display hourly");
    //   System.out.println("country"+getCountry());
    //   System.out.println("city" + getCity());
    //}

    //public void back() throws IOException {
    //   root = FXMLLoader.load(getClass().getResource("/fxml/mainpage.fxml"));
    //   Main.stage.setTitle("Hello World");
    //   stage.setScene(new Scene(root, 479, 673));
    //   stage.show();
    //

    //public void initialize(){
    //   OWM owmObj = new OWM();
    //   LocationFinder locationFinder = new LocationFinder();
    //   Location location = locationFinder.getCurrentLocation();
    //   locate.setText(locationFinder.getCity() + ", " + getCountry() );
    //   CurrentWeather cw = owmObj.getCurrentWeather(new Location(getCity()+","+getCountry()), "metric");
    //   temperature.setText(new Double(cw.mainParameters.temperature).intValue() +"\u2103");
    //   visibility.setText(cw.visibility);
    //   sunrise.setText(cw.systemParameters.sunrise.toString().split(" ")[3].substring(0,5));
    //   sunset.setText(cw.systemParameters.sunset.toString().split(" ")[3].substring(0,5));

    //}

}
