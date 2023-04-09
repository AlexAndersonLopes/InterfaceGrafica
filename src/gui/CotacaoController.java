package gui;

import gui.util.Constraints;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CotacaoController implements Initializable{

    @FXML
    private Button voltar;
    @FXML
    private TextField qtdDolar;
    @FXML
    private TextField cotacaoDolarReal;
    @FXML
    private Label total;
    @FXML
    private Button calcular;

    //private String cotacao;

    @FXML
    public void onCalcularAction() throws Exception {
        double cot = Double.valueOf(cotacaoDolarReal.getText());
        double qtd = Double.parseDouble(qtdDolar.getText());
        
        double valorTotal = cot * qtd;
        total.setText(String.valueOf((double) valorTotal));
       
    }
    
    @FXML
    private void onVoltarAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) voltar.getScene().getWindow();
    stage.close();
    
    // Abre a janela anterior
    FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Minha aplicação");
    stage.show();
    }
       
       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Constraints.setTextFieldDouble(qtdDolar);
    }
    
    

}//FIM DA CLASSE
