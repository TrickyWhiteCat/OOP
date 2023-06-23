package hust.soict.dsai.aims.screen.addMedia;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class AddMediaToStoreScreen extends JFrame {
    private Store store;
    public AddMediaToStoreScreen(String type, Store store) {
        super();

        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Media");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("hust/soict/dsai/aims/screen/addMedia/addMedia.fxml"));
                    AddMediaToStoreScreenController controller = new AddMediaToStoreScreenController(store, type);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
