package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
	private Label logoLabel;

	@FXML
	private Pane spinnerPane;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Label helloLabel;

	@FXML
	private Label nameLabel;

	Main main;
	Stage stage;

	public void main(Stage stage, Main main) {
		this.main = main;
		this.stage = stage;
	}

	public void showMenu() {
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("menu.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage sendStage = new Stage();
			sendStage.setTitle("Main Menu");
			Scene scene=new Scene(page);
			sendStage.setScene(scene);
//			sendStage.setMaximized(true);
			sendStage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		TranslateTransition translateTransition = new TranslateTransition(
				Duration.seconds(0.1), logoLabel);
		translateTransition.setByX(700);
		translateTransition.play();

		TranslateTransition translateTransition0 = new TranslateTransition(
				Duration.seconds(0.1), nameLabel);
		translateTransition0.setByX(-700);
		translateTransition0.play();

		TranslateTransition translateTransition00 = new TranslateTransition(
				Duration.seconds(0.5), helloLabel);
		translateTransition00.setByY(700);
		translateTransition00.play();

		translateTransition
				.setOnFinished(event -> {
					TranslateTransition translateTransition1 = new TranslateTransition(
							Duration.seconds(1), logoLabel);
					//translateTransition1.setByY(-700);
					translateTransition1.setByX(-700);
					translateTransition1.play();

					translateTransition1.setOnFinished(event1 -> {

						nameLabel.setVisible(true);

						TranslateTransition translateTransition11 = new TranslateTransition(
								Duration.seconds(1), nameLabel);
						translateTransition11.setByX(700);
						translateTransition11.play();

						translateTransition11.setOnFinished(event2 -> {

							helloLabel.setVisible(true);
							TranslateTransition translateTransition111 = new TranslateTransition(
									Duration.seconds(1), helloLabel);
							translateTransition111.setByY(-700);
							translateTransition111.play();

							translateTransition111.setOnFinished(event3 -> {
								spinnerPane.setVisible(true);

								FadeTransition fadeTransition = new FadeTransition(
										Duration.seconds(1), spinnerPane);
								fadeTransition.setFromValue(0);
								fadeTransition.setToValue(1);
								fadeTransition.play();

								fadeTransition.setOnFinished(event4 -> {

									FadeTransition fadeTransition1 = new FadeTransition(
											Duration.seconds(1), rootPane);
									fadeTransition1.setFromValue(1);
									fadeTransition1.setToValue(0.1);
									fadeTransition1.play();

									fadeTransition1.setOnFinished(event5 -> {
										main.closeStage();
										showMenu();
										System.out
												.println("------- splash screen is closed --------");
									});

								});

							});

						});
					});

				});

	}
}
