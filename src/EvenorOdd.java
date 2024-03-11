import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class EvenorOdd extends Application {

    private RadioButton leftButton, rightButton;
    private FlowPane pane;
    private TextField text;
    private Label message;

    public void start(Stage primaryStage) {

        text = new TextField();
        message = new Label("Enter a number"); // Use javafx.scene.control.Label

        leftButton = new RadioButton("Even");
        leftButton.setOnAction(this::processColorButton);

        rightButton = new RadioButton("Odd");
        rightButton.setOnAction(this::processColorButton);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(this::submitClicked); // Add event handler for submit button

        Image img1 = new Image("odd.jpg");
        Image img2 = new Image("even.jpg");

        ToggleGroup group = new ToggleGroup();
        leftButton.setToggleGroup(group);
        rightButton.setToggleGroup(group);

        leftButton.setTranslateY(50);
        rightButton.setTranslateY(50);
        text.setTranslateY(50);

        pane = new FlowPane();
        pane.getChildren().addAll(message, text, leftButton, rightButton, submitButton); // Add submit button
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(20);
        pane.setStyle("-fx-background-color: pink");

        Scene scene = new Scene(pane, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Project 2");
    }

    private void processColorButton(ActionEvent event) {
        if (event.getSource() == leftButton)
            pane.setStyle("-fx-background-color: Pink");
        else
            pane.setStyle("-fx-background-color: Yellow");

    }

    // Add logic to handle submit button click
    private void submitClicked(ActionEvent event) {
        // Add logic to handle submit button click
        String input = text.getText();
        try {
            int number = Integer.parseInt(input);
            // Add logic to handle the entered number
            if (number % 2 == 0) {
                // Number is even
                pane.setStyle("image: url('even.jpg')");
            } else {
                // Number is odd
                pane.setStyle("-fx-background-image: url('odd.jpg')");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer number.");
        }
    }
}
