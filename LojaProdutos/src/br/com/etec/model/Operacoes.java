package br.com.etec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Operacoes {
	
	@FXML
	private TextField txfUsuario;
	
	@FXML
	private PasswordField psfUsuario;
	
	@FXML
	private Button btnAcessar;
	
	@FXML
	private Button btnFechar;
	
	@FXML
	private Stage acpPalco;
	
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
	
	@FXML
	private void closeLoginScreen(ActionEvent event) {
		acpPalco = (Stage) btnFechar.getScene().getWindow();
		acpPalco.close();
	}
	
	private void showMessage(Alert.AlertType type, String title, String message) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
		
	//----------------------------------------------------------------
	@FXML
	private void fecharTelaLogin(ActionEvent event) {
		acpPalco = (Stage) btnFechar.getScene().getWindow();
		acpPalco.close();	
	}
	
	//----------------------------------------------------------------

	 private boolean verificarUsuarioSenha(String usuario, String senha) throws SQLException {
	        Connection conexao = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        boolean usuarioValido = false;

	        try {
	            conexao = ClasseConexao.conectar();
	            String sql = "SELECT * FROM tabelasenha WHERE usuario = ? AND senha = ?";
	            stmt = conexao.prepareStatement(sql);
	            stmt.setString(1, usuario);
	            stmt.setString(2, senha);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                usuarioValido = true;
	            }
	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            ClasseConexao.fechar(conexao);
	        }

	        return usuarioValido;
	    }
	
}
