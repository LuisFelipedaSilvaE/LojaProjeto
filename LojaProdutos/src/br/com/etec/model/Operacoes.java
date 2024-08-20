package br.com.etec.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Operacoes {
	
	@FXML
	private TextField txfUsuario;
	
	@FXML
	private PasswordField psfUsuario;
	
	@FXML
	private Button btnAcessar;
	
	@FXML
	private void accessAccount(ActionEvent event) {
	
		String userName;
		userName = txfUsuario.getText();

		String userPassword;
		userPassword = psfUsuario.getText();

		if(userName.isEmpty() || userPassword.isEmpty()) {
			
			if(userName.isEmpty()) {
				showMessage(Alert.AlertType.WARNING, "Missing Data", "No User or Password");
			}
			else {
				showMessage(Alert.AlertType.WARNING, "Missing Data", "Type the Password");
			}
			
		}
	}
	
	private void showMessage(Alert.AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
