package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ViewController implements Initializable{

    public static final DecimalFormat df = new DecimalFormat("#.##"); 
    
    @FXML
    private Button erroTeste;
    @FXML
    private Button calcular;
    @FXML
    private TextField numero1;
    @FXML
    private TextField numero2;
    @FXML
    private TextField resultado;
    @FXML
    private CheckBox adicao;
    @FXML
    private CheckBox subtracao;
    @FXML
    private CheckBox multiplicacao;
    @FXML
    private CheckBox divisao;

    @FXML
    public void onButtonAction(ActionEvent evento) {        
        int num1 = Integer.parseInt(numero1.getText());
        int num2 = Integer.parseInt(numero2.getText());
        double res = 0;
        if (onAdicao()) {
            res = (double) num1 + num2;
        }
        if (onSubtracao()) {
            res = (double) num1 - num2;
        }
        if (onMultiplicacao()) {
            res = (double) num1 * num2;
        }
        if (onDivisao()) {
            res = (double) num1 / num2;
        }
        mostrarResultado(res);
        limparTela();
        }    
 

    @FXML
    public void onErroTesteAction(ActionEvent evento){
        Alerts.showAlert("ERRO", null, "Você é muito teimoso, eu falei para não apertar esse botão!!!", Alert.AlertType.ERROR);
    }
    
    @FXML
    public boolean onAdicao() {
        return adicao.isSelected();
    }

    @FXML
    public boolean onSubtracao() {
        return subtracao.isSelected();
    }

    @FXML
    public boolean onMultiplicacao() {
        return multiplicacao.isSelected();
    }

    @FXML
    public boolean onDivisao() {
        return divisao.isSelected();
    }

    public void limparTela() {
        numero1.clear();
        numero2.clear();
        adicao.setSelected(false);
        subtracao.setSelected(false);
        multiplicacao.setSelected(false);
        divisao.setSelected(false);
    }

    //MOSTRAR O RESULTADO INT ou DOUBLE
    public void mostrarResultado(double res) {
        if (res % 1 == 0) {
            resultado.setText(String.valueOf((int) res));
        } else {           
            String dfRes = df.format(res); 
            resultado.setText(dfRes);
        }
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //LIMITAR PARA ACEITAR APENAS NUMEROS INTEIROS
        Constraints.setTextFieldInteger(numero1);
        Constraints.setTextFieldInteger(numero2);
        //LIMITAR PARA ACEITAR ATÉ 12 CARACTERES
        Constraints.setTextFieldMaxLength(numero1, 12);
        Constraints.setTextFieldMaxLength(numero2, 12);
    }

}
