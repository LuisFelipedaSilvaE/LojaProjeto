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
				if(userPassword.isEmpty()) {
					showMessage(Alert.AlertType.WARNING, "Missing Data", "Type the Password");
				}
			}
		}
		else {
			if(userName.equals("admin") && userPassword.equals("123456")) {
				showMessage(Alert.AlertType.CONFIRMATION, "Access Allowed", "Welcome.");
			}
			else {
				showMessage(Alert.AlertType.ERROR, "Access Error", "Wrong User or Password");
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
