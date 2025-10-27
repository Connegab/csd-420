// Gabe Conner
// CSD 420
// 10/26/25

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardDisplay extends Application {

    private static final String CARD_PATH = "cards/"; // The directory for card images
    private static final int NUM_CARDS = 52;           // Total number of cards
    private static final int DISPLAY_COUNT = 4;        // Cards to display each time

    private HBox cardBox = new HBox(10); // Holds the four displayed cards

    @Override
    public void start(Stage primaryStage) {
        cardBox.setAlignment(Pos.CENTER);
        cardBox.setPadding(new Insets(15));

        // The initial display of four random cards
        showRandomCards();

        // A button to refresh and reshuffle cards
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> showRandomCards()); // Lambda expression

        // Layout setup
        VBox root = new VBox(15, cardBox, refreshButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Random Card Display - Gabe Conner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to display four random cards
    private void showRandomCards() {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= NUM_CARDS; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);

        cardBox.getChildren().clear();

        for (int i = 0; i < DISPLAY_COUNT; i++) {
            String imagePath = CARD_PATH + deck.get(i) + ".png";
            File file = new File(imagePath);
            if (file.exists()) {
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setPreserveRatio(true);
                cardBox.getChildren().add(imageView);
            } else {
                System.out.println("Missing image: " + imagePath);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
