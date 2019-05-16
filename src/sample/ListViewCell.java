package sample;

import javafx.scene.control.ListCell;

public class ListViewCell extends ListCell<String>
{
    @Override
    public void updateItem(String string, boolean empty)
    {
        super.updateItem(string,empty);
        if(string != null)
        {
            ListItem data = new ListItem();
            data.setInfo(string);
            setGraphic(data.getContainer());
        }
    }
}