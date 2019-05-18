package sample;

import classes.Location;
import javafx.scene.control.ListCell;
import javafx.util.Pair;

public class ListViewCell extends ListCell<WeatherTileData>
{
    @Override
    public void updateItem(WeatherTileData data, boolean empty)
    {
        super.updateItem(data, empty);
        if(data != null)
        {
            ListItem listItem = new ListItem();
            listItem.setInfo(data.getLocation(), data.isCurrentLocation());
            setGraphic(listItem.getContainer());
        } else {
            AddListItem addListItem = new AddListItem();
            setGraphic(addListItem.getContainer());
        }
    }
}