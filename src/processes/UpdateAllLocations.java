package processes;

import classes.Location;
import classes.currentweather.CurrentWeather;
import classes.forecast.ForecastInformationDay;
import classes.forecast.ForecastInformationWeek;
import utils.OWM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UpdateAllLocations {
    private Map<Location, ForecastInformationWeek> dailyForecasts = new HashMap<>();
    private Map<Location, ForecastInformationDay> hourlyForecasts = new HashMap<>();
    private Map<Location, CurrentWeather> allCurrentWeather = new HashMap<>();
    private List<Location> locations = new ArrayList<>();

    private static UpdateAllLocations uwa;
    private ScheduledExecutorService executor;


    private Runnable updateAllHourly = () -> {
        Map<Location, ForecastInformationDay> newHourlyForecasts = new HashMap<>();
        for(Location location: hourlyForecasts.keySet()){
            newHourlyForecasts.put(location, OWM.getDayForecast(location));
        }
        hourlyForecasts = newHourlyForecasts;
    };

    private Runnable updateAllDaily = () -> {
        Map<Location, ForecastInformationWeek> newDailyForecasts = new HashMap<>();
        for(Location location: dailyForecasts.keySet()){
            newDailyForecasts.put(location, OWM.getWeekForecast(location));
        }
        dailyForecasts = newDailyForecasts;
    };

    private Runnable updateAllCurrent = () -> {
        Map<Location, CurrentWeather> newCurrentWeather = new HashMap<>();
        for(Location location: allCurrentWeather.keySet()){
            newCurrentWeather.put(location, OWM.getCurrentWeather(location));
        }
        allCurrentWeather = newCurrentWeather;
    };


    private UpdateAllLocations(){
        executor = Executors.newScheduledThreadPool(3);
        executor.schedule(updateAllDaily, 10L, TimeUnit.MINUTES);
        executor.schedule(updateAllHourly, 10L, TimeUnit.MINUTES);
        executor.schedule(updateAllCurrent, 5L, TimeUnit.MINUTES);
    }


    public void addLocation(Location location){
        locations.add(location);
        dailyForecasts.put(location, OWM.getWeekForecast(location));
        hourlyForecasts.put(location, OWM.getDayForecast(location));
        allCurrentWeather.put(location, OWM.getCurrentWeather(location));
    }

    public void removeLocation(Location location){
        locations.remove(location);
        dailyForecasts.remove(location);
        hourlyForecasts.remove(location);
        allCurrentWeather.remove(location);
    }

    public ForecastInformationWeek getDaily(Location location){
        if (dailyForecasts.containsKey(location)) {
            return dailyForecasts.get(location);
        } else {
            System.out.println("No forecast exists for this yet.");
        }
        return null;
    }

    public ForecastInformationDay getHourly(Location location){
        if (hourlyForecasts.containsKey(location)) {
            return hourlyForecasts.get(location);
        } else {
            System.out.println("No forecast exists for this yet.");
        }
        return null;
    }

    public CurrentWeather getCurrent(Location location){
        if (allCurrentWeather.containsKey(location)) {
            return allCurrentWeather.get(location);
        } else {
            System.out.println("Location not found");
        }
        return null;
    }

    public void closeProcess(){
        executor.shutdown();
        uwa = null;
    }

    public static UpdateAllLocations getUwa(){
        if (uwa != null) {
            return uwa;
        } else {
            uwa = new UpdateAllLocations();
        }
        return uwa;
    }

}
