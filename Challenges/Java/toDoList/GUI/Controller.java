package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller {

	private ObservableList<String> items = FXCollections.observableArrayList();
	private FileChooser choose = new FileChooser();
	private File fileToSave;
	private List<ArrayList<String>> history = new LinkedList<ArrayList<String>>();

	@FXML
	private Button addButton;
	@FXML
	private Button delButton;
	@FXML
	private TextField textField;
	@FXML
	private TextField indexField;
	@FXML
	private Label warningAddLabel;
	@FXML
	private Label warningDelLabel;

	@FXML
	private ListView<String> list = new ListView<String>();
	@FXML
	private MenuItem clearButton;
	@FXML
	private MenuItem sortButton;
	@FXML
	private MenuItem shuffleButton;
	@FXML
	private MenuItem saveButton;
	@FXML
	private MenuItem saveAsButton;
	@FXML
	private MenuItem openButton;
	@FXML
	private MenuItem closeButton;
	@FXML
	private MenuItem undoButton;

	@FXML
	public void addButtonClick(ActionEvent event) {

		if (textField.getText().length() != 0 && !textField.getText().equals(" ")) {

			addToQue(items);

			warningAddLabel.setText("");
			items.add("- " + textField.getText());
			list.setItems(items);
			textField.setText("");
		} else {
			warningAddLabel.setText("Please Insert a Task");
		}
	}

	@FXML
	public void textFieldFill(ActionEvent event) {

		if (textField.getText().length() != 0 && !textField.getText().equals(" ")) {

			addToQue(items);

			warningAddLabel.setText("");
			items.add("- " + textField.getText());
			list.setItems(items);
			textField.setText("");
		} else {
			warningAddLabel.setText("Please Insert a Task");
		}
	}

	@FXML
	public void delButtonClick(ActionEvent event) {

		if (!list.getSelectionModel().isEmpty() && indexField.getText().equals("")) {

			addToQue(items);

			try {
				int currSel = list.getSelectionModel().getSelectedIndex();

				items.remove(currSel);
				list.setItems(items);
				list.getSelectionModel().select(currSel - 1);
			} catch (IndexOutOfBoundsException e) {
			}
		} else {

			try {

				addToQue(items);

				warningDelLabel.setText("");
				items.remove(Integer.parseInt(indexField.getText()) - 1);
				indexField.setText("");
			} catch (IndexOutOfBoundsException e) {
				if (!items.isEmpty()) {
					items.remove(items.size() - 1);
					indexField.setText("");
				} else {
					warningDelLabel.setText("Please Add Tasks first");
					indexField.setText("");
				}
			} catch (NumberFormatException e) {
				warningDelLabel.setText("Please Insert a valid Number");
				indexField.setText("");
			}
		}
	}

	@FXML
	public void indexFieldFill(ActionEvent event) {
		try {

			addToQue(items);

			warningDelLabel.setText("");
			items.remove(Integer.parseInt(indexField.getText()) - 1);
			indexField.setText("");
		} catch (IndexOutOfBoundsException e) {
			if (!items.isEmpty()) {
				items.remove(items.size() - 1);
				indexField.setText("");
			} else {
				warningDelLabel.setText("Please Add Tasks first");
				indexField.setText("");
			}
		} catch (NumberFormatException e) {
			warningDelLabel.setText("Please Insert a valid Number");
			indexField.setText("");
		}
	}

	@FXML
	public void clearButtonClick(ActionEvent event) {

		addToQue(items);

		items.clear();
		list.setItems(items);
	}

	@FXML
	public void sortButtonClick(ActionEvent event) {

		addToQue(items);

		Collections.sort(items);
		list.setItems(items);
	}

	@FXML
	public void shuffleButtonClick(ActionEvent event) {

		addToQue(items);

		Collections.shuffle(items);
		list.setItems(items);
	}

	@FXML
	public void saveButtonClick(ActionEvent event) {
		choose.setTitle("Save File: ");
		choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
		choose.setSelectedExtensionFilter(new ExtensionFilter("Binary Files (*.bin)", "*.bin"));
		choose.getExtensionFilters().add(new ExtensionFilter("Binary Files (*.bin)", "*.bin"));
		try {
			if (fileToSave == null) {
				fileToSave = choose.showSaveDialog(Main.primaryStage);
			}

			try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileToSave))) {

				ArrayList<String> temp = new ArrayList<String>(items);

				os.writeObject(temp);

			}

		} catch (NullPointerException e) {

		} catch (FileNotFoundException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Save Error");
			alert.setHeaderText("Failed to save File");
			alert.setContentText("Please try again!");

			alert.showAndWait();

		} catch (IOException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Save Error");
			alert.setHeaderText("Failed to save File");
			alert.setContentText("Please try again!");

			alert.showAndWait();

		}
	}

	@FXML
	public void saveAsButtonClick(ActionEvent event) {
		choose.setTitle("Save File: ");
		choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
		choose.setSelectedExtensionFilter(new ExtensionFilter("Binary Files (*.bin)", "*.bin"));
		choose.getExtensionFilters().add(new ExtensionFilter("Binary Files (*.bin)", "*.bin"));
		try {
			fileToSave = choose.showSaveDialog(Main.primaryStage);

			try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileToSave))) {

				ArrayList<String> temp = new ArrayList<String>(items);

				os.writeObject(temp);

			}

		} catch (NullPointerException e) {

		} catch (FileNotFoundException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Save Error");
			alert.setHeaderText("Failed to save File");
			alert.setContentText("Please try again!");

			alert.showAndWait();

		} catch (IOException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Save Error");
			alert.setHeaderText("Failed to save File");
			alert.setContentText("Please try again!");

			alert.showAndWait();

		}
	}

	@FXML
	public void openButtonClick(ActionEvent event) {

		addToQue(items);

		choose.setTitle("Open File: ");
		choose.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
		choose.setSelectedExtensionFilter(new ExtensionFilter("Binary Files (*.bin)", "*.bin"));
		try {
			File fileToOpen = choose.showOpenDialog(Main.primaryStage);

			try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileToOpen))) {

				@SuppressWarnings("unchecked")
				ArrayList<String> temp = (ArrayList<String>) is.readObject();
				items.clear();
				for (String s : temp) {
					items.add(s);
				}
				list.setItems(items);

			}

		} catch (NullPointerException e) {

		} catch (FileNotFoundException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Save Error");
			alert.setHeaderText("Failed to save File");
			alert.setContentText("Please try again!");

			alert.showAndWait();

		} catch (IOException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Save Error");
			alert.setHeaderText("Failed to save File");
			alert.setContentText("Please try again!");

			alert.showAndWait();

		} catch (ClassNotFoundException e) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("File Save Error");
			alert.setHeaderText("Failed to save File");
			alert.setContentText("Please try again!");

			alert.showAndWait();

		}
	}

	@FXML
	public void closeButtonClick(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}

	@FXML
	public void undoButtonClick(ActionEvent event) {
		if (history.size() > 0) {

			items.clear();
			ArrayList<String> temp2 = history.get(history.size() - 1);

			for (String s : temp2) {
				items.add(s);
			}
			list.setItems(items);
			history.remove(history.size() - 1);
		}

	}

	private void addToQue(ObservableList<String> lastItems) {
		ArrayList<String> temp = new ArrayList<String>(lastItems);
		history.add(temp);
	}
}
