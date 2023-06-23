package hust.soict.dsai.aims.screen.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.concurrent.Callable;

public class CartScreenController {
    private Cart cart;

    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    @FXML
    private Label totalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));
        tblMedia.setItems(this.cart.getFilteredCart());
        totalCost.textProperty().bind(Bindings.createObjectBinding(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return String.format("%.3f", cart.totalCost());
            }
        }, this.cart.getFilteredCart()));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    void showFilteredMedia(String key) {
        if (key == null || key.equals("")) {
            this.cart.getFilteredCart().setPredicate(item -> true);
        }
        if (this.radioBtnFilterId.isSelected()) {
            this.cart.getFilteredCart().setPredicate(item -> (item.getId() == Integer.parseInt(key)));
        }
        else {
            this.cart.getFilteredCart().setPredicate(item -> (item.getTitle().contains(key)));
        }
    }

    private FilteredList<Media> filter(FilteredList<Media> source, String key, boolean byTitle) {
        return source;
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible((media instanceof Playable));

    }

    @FXML
    void PlayButtonPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        media.play();
    }

    @FXML
    void RemoveButtonPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void placeOrderPressed(ActionEvent event) {

    }
}
