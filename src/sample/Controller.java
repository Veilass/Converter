package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> Box;

    @FXML
    private TextField textfield_label;

    @FXML
    private Label label_tone;

    @FXML
    private Label label_kg;

    @FXML
    private Label label_gramm;

    @FXML
    void initialize() {
        Box.getItems().add("Тонны");
        Box.getItems().add("Килограммы");
        Box.getItems().add("Граммы");

        Box.getSelectionModel().selectFirst();

        Box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (textfield_label.getCharacters().length() > 0)
                    setValues();
            }
        });
    }


    @FXML
    void onkeyReleasedText() {
        if (textfield_label.getCharacters().length() > 0)
            setValues();
    }

    void setValues() {

        String numberUser = textfield_label.getCharacters().toString();

        int selectedIndex = Box.getSelectionModel().getSelectedIndex();
        if (selectedIndex == 0) {

            label_tone.setText(numberUser);


        label_kg.setText(String.valueOf(Integer.parseInt(numberUser) * 1000));
        label_gramm.setText(String.valueOf(Integer.parseInt(numberUser) * 1000 * 1000));

    } else if(selectedIndex == 1) {

        label_tone.setText(String.valueOf(Float.parseFloat(numberUser) / 1000));

        label_kg.setText(numberUser);

        label_gramm.setText(String.valueOf(Integer.parseInt(numberUser) * 1000 ));

    }else if(selectedIndex == 2) {

        label_tone.setText(String.valueOf(Float.parseFloat(numberUser) / 1000 / 1000));

        label_kg.setText(String.valueOf(Integer.parseInt(numberUser) / 1000));

        label_gramm.setText(numberUser);
    }
  }
}