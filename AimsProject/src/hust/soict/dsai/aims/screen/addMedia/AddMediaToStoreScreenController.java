package hust.soict.dsai.aims.screen.addMedia;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMediaToStoreScreenController {

    private final Store store;
    private final String type;
    @FXML
    private Button addBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField titleField;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField costField;

    public AddMediaToStoreScreenController(Store store, String type) {
        this.store = store;
        this.type = type;
    }

    @FXML
    void addBtnPressed(ActionEvent event) {
        Media media;
        switch (this.type.toLowerCase()) {
            case "book":
                media = new Book(titleField.getText(), categoryField.getText(), Double.parseDouble(costField.getText()));
                break;
            case "cd":
                media = new CompactDisc(titleField.getText(), categoryField.getText(), Double.parseDouble(costField.getText()));
                break;
            case "dvd":
                media = new DigitalVideoDisc(titleField.getText(), categoryField.getText(), Double.parseDouble(costField.getText()));
                break;
            default:
                throw new IllegalArgumentException("Type " + this.type + " is not supported.");
        }
        this.store.addMedia(media);
    }

    @FXML
    void cancelBtnPressed(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }

}
