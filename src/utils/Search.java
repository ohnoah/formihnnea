package utils;

import classes.Location;
import classes.coords.Coordinate;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static utils.QueryParser.callQuery;

public class Search {

    private static final String api_id_google = "AIzaSyAhxpVJs2OH7oYj_LM8DR5Yyzdyl8eMGu0";

    public static Coordinate getCoords(String googleId){
        return null;
    }


    public static List<Location> autoCompleteInput(String stringLocation){
        String query = "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + stringLocation + "&key=" + api_id_google;
        JSONObject jobj = callQuery(query);

        System.out.println(jobj);

        Gson g = new Gson();

        JsonObject jsonObject = g.fromJson(jobj.toJSONString(), JsonObject.class);

        List<Location> autoCompResults = new ArrayList<>();

        //for (JsonElement job: jsonObject.get("predictions").getAsJsonArray()){
        //    String id = job.getAsJsonObject().get("place_id").getAsString();
        //    autoCompResults.add(new Location(
        //            job.getAsJsonObject().get("description").getAsString(),
        //            id,
        //            getCoords(id)
        //    ));
        //}

        return autoCompResults;
    }

    //Cannot get actual 'current' location - have to ask on startup



    public static void main(String[] args) {
        System.out.println(Search.autoCompleteInput("uni").get(0).name);
    }
}
