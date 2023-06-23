package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private Color chosenColor;
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, chosenColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void PenChosen(ActionEvent event) {
        chosenColor = Color.BLACK;
    }

    @FXML
    void EraserChosen(ActionEvent event) {
        chosenColor = (Color) drawingAreaPane.getBackground().getFills().get(0).getFill();
    }


}
