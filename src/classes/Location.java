package classes;

import classes.coords.Coordinate;

public class Location {

    public String name;
    public String googleId;
    public String owmId;
    public Coordinate position;

    public static Location fromName(String name){ return new Location(name);}

    public Location(String name, String googleId){
        this.name = name;
        this.googleId = googleId;
    }

    public Location(String name){
        this.name = name;
    }

    public Location(){};
}
