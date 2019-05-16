package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ListItem {
    @FXML
    private Label temperature;
    @FXML
    private Label visibility;

    @FXML
    private Pane container;


    public ListItem()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listitem.fxml"));
        fxmlLoader.setController(this);
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(String string)
    {
        temperature.setText(string);
        visibility.setText(string);
    }

    public Pane getContainer()
    {
        return container;
    }
}
