package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller implements Initializable {

	FileChooser choose = new FileChooser();
	File fileToSave;

	@FXML
	private Button encipherButton;
	@FXML
	private Button decipherButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button openButton;
	@FXML
	private ChoiceBox<String> choiceBox;
	@FXML
	private TextArea textArea;
	@FXML
	private Label enSaveLabel;
	@FXML
	private Label deOpenLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceBox.setItems(FXCollections.observableArrayList("Cesar Chiper", "Simple ASCII Cipher", "Vigenere", "RC4"));
		choiceBox.setValue(choiceBox.getItems().get(0));
	}

	@FXML
	public void encipherButtonClick(ActionEvent event) {
		deOpenLabel.setText("");
		enSaveLabel.setText("");
		switch (choiceBox.getSelectionModel().getSelectedItem()) {
		case "Simple ASCII Cipher":
			textArea.setText(CipherMaker.encipherSimple(textArea.getText()));
			break;
		case "Cesar Chiper":
			textArea.setText(CipherMaker.encipherCesar(textArea.getText()));
			break;
		case "Vigenere":
			if(!textArea.getText().equals("")) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Cipher-Code");
				dialog.setHeaderText("Type in a Password to encipher your text with!");
				dialog.setContentText("Enter your password here...");
				
				Optional<String> result = dialog.showAndWait();
				if(result.isPresent()) {
					textArea.setText(CipherMaker.encipherVigenere(textArea.getText(), result.get()));
				}
			}
			break;
		case "RC4":
			if(!textArea.getText().equals("")) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Cipher-Code");
				dialog.setHeaderText("Type in a number to encipher your text with!");
				dialog.setContentText("Enter your number here...");
				
				Optional<String> result = dialog.showAndWait();
				if(result.isPresent() && result.get().matches("[0-9]+")) {
					textArea.setText(CipherMaker.encipherRC4(textArea.getText(), Integer.parseInt(result.get())));
				} else {
					enSaveLabel.setText("Encipher not possible...");
				}
			}
			
			break;
		}

	}

	@FXML
	public void decipherButtonClick(ActionEvent event) {
		deOpenLabel.setText("");
		enSaveLabel.setText("");
		switch (choiceBox.getSelectionModel().getSelectedItem()) {
		case "Simple ASCII Cipher":
			textArea.setText(CipherMaker.decipherSimple(textArea.getText()));
			break;
		case "Cesar Chiper":
			textArea.setText(CipherMaker.decipherCesar(textArea.getText()));
			break;
		case "Vigenere":
			if(!textArea.getText().equals("")) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Cipher-Code");
				dialog.setHeaderText("Type in a Password to decipher your text with!");
				dialog.setContentText("Enter your password here...");
				
				Optional<String> result = dialog.showAndWait();
				if(result.isPresent()) {
					textArea.setText(CipherMaker.decipherVigenere(textArea.getText(), result.get()));
				}
			}
			break;
		case "RC4":
			if(!textArea.getText().equals("")) {
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("Cipher-Code");
				dialog.setHeaderText("Type in the number to decipher!");
				dialog.setContentText("Enter your number here...");
				
				Optional<String> result = dialog.showAndWait();
				if(result.isPresent() && result.get().matches("[0-9]+")) {
					textArea.setText(CipherMaker.decipherRC4(textArea.getText(), Integer.parseInt(result.get())));
				} else {
					deOpenLabel.setText("Decipher not possible...");
				}
			}
			
			break;
		}
	}

	@FXML
	public void saveButtonClick(ActionEvent event) {
		switch (choiceBox.getSelectionModel().getSelectedItem()) {
		case "Simple ASCII Cipher":
			enSaveLabel.setText("Saving not possible...");
			break;
		case "Cesar Chiper":

			choose.setTitle("Save File: ");
			choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			choose.setSelectedExtensionFilter(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			choose.getExtensionFilters().add(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			fileToSave = choose.showSaveDialog(Main.primaryStage);

			try (PrintWriter pwr = new PrintWriter(new PrintStream(fileToSave))) {

				String[] temp = textArea.getText().split("\n");

				for (int i = 0; i < temp.length; i++) {
					pwr.write(temp[i] + System.getProperty("line.separator"));
				}

			} catch (FileNotFoundException e) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("File Save Error");
				alert.setHeaderText("Failed to save File");
				alert.setContentText("Please try again!");

				alert.showAndWait();

			} catch (NullPointerException e) {
				// ignore
			}
			break;
		case "Vigenere":

			choose.setTitle("Save File: ");
			choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			choose.setSelectedExtensionFilter(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			choose.getExtensionFilters().add(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			fileToSave = choose.showSaveDialog(Main.primaryStage);

			try (PrintWriter pwr = new PrintWriter(new PrintStream(fileToSave))) {

				String[] temp = textArea.getText().split("\n");

				for (int i = 0; i < temp.length; i++) {
					pwr.write(temp[i] + System.getProperty("line.separator"));
				}

			} catch (FileNotFoundException e) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("File Save Error");
				alert.setHeaderText("Failed to save File");
				alert.setContentText("Please try again!");

				alert.showAndWait();

			} catch (NullPointerException e) {
				// ignore
			}
			break;
		case "RC4":

			choose.setTitle("Save File: ");
			choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			choose.setSelectedExtensionFilter(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			choose.getExtensionFilters().add(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			fileToSave = choose.showSaveDialog(Main.primaryStage);

			try (PrintWriter pwr = new PrintWriter(new PrintStream(fileToSave))) {

				String[] temp = textArea.getText().split("\n");

				for (int i = 0; i < temp.length; i++) {
					pwr.write(temp[i] + System.getProperty("line.separator"));
				}

			} catch (FileNotFoundException e) {

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("File Save Error");
				alert.setHeaderText("Failed to save File");
				alert.setContentText("Please try again!");

				alert.showAndWait();

			} catch (NullPointerException e) {
				// ignore
			}
			break;
		}
	}

	@FXML
	public void openButtonClick(ActionEvent event) {
		switch (choiceBox.getSelectionModel().getSelectedItem()) {
		case "Simple ASCII Cipher":
			deOpenLabel.setText("Opening not possible...");
			break;
		case "Cesar Chiper":

			choose.setTitle("Open File: ");
			choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			choose.setSelectedExtensionFilter(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			choose.getExtensionFilters().add(new ExtensionFilter("Text Files (*.txt)", "*.txt"));

			try {
				File fileToOpen = choose.showOpenDialog(Main.primaryStage);
				textArea.clear();

				BufferedReader br = new BufferedReader(new FileReader(fileToOpen));

				String test;

				try {

					while ((test = br.readLine()) != null) {
						textArea.setText(textArea.getText() + test + "\n");
					}

					textArea.setText(textArea.getText().trim());

				} finally {
					br.close();
				}

			} catch (FileNotFoundException e2) {

			} catch (IOException e) {

			} catch (NullPointerException e) {

			}
			break;
		case "Vigenere":
			choose.setTitle("Open File: ");
			choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			choose.setSelectedExtensionFilter(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			choose.getExtensionFilters().add(new ExtensionFilter("Text Files (*.txt)", "*.txt"));

			try {
				File fileToOpen = choose.showOpenDialog(Main.primaryStage);
				textArea.clear();

				BufferedReader br = new BufferedReader(new FileReader(fileToOpen));

				String test;

				try {

					while ((test = br.readLine()) != null) {
						textArea.setText(textArea.getText() + test + "\n");
					}

					textArea.setText(textArea.getText().trim());

				} finally {
					br.close();
				}

			} catch (FileNotFoundException e2) {

			} catch (IOException e) {

			} catch (NullPointerException e) {

			}
			break;
		case "RC4":
			choose.setTitle("Open File: ");
			choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
			choose.setSelectedExtensionFilter(new ExtensionFilter("Text Files (*.txt)", "*.txt"));
			choose.getExtensionFilters().add(new ExtensionFilter("Text Files (*.txt)", "*.txt"));

			try {
				File fileToOpen = choose.showOpenDialog(Main.primaryStage);
				textArea.clear();

				BufferedReader br = new BufferedReader(new FileReader(fileToOpen));

				String test;

				try {

					while ((test = br.readLine()) != null) {
						textArea.setText(textArea.getText() + test + "\n");
					}

					textArea.setText(textArea.getText().trim());

				} finally {
					br.close();
				}

			} catch (FileNotFoundException e2) {

			} catch (IOException e) {

			} catch (NullPointerException e) {

			}
			break;
		}

	}
}