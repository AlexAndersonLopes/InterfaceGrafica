package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ViewController {

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

    public void mostrarResultado(double res) {
        if (res % 1 == 0) {
            resultado.setText(String.valueOf((int) res));
        } else {
            resultado.setText(String.valueOf(res));
        }
    }

    
    
}
