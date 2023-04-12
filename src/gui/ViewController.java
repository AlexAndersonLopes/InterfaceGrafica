package gui;

import gui.util.Alerts;
import gui.util.Constraints;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewController implements Initializable {

    public static final DecimalFormat df = new DecimalFormat("#.##");

    @FXML
    private MenuItem menuCotacao;
    @FXML
    private MenuItem menuErro;
    @FXML
    private MenuItem menuImposto;
    @FXML
    private Button imposto;
    @FXML
    private Button erroTeste;
    @FXML
    private Button calcular;
    @FXML
    private Button cotacaoDolar;
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
        desmarcarOutrosCheckboxes(adicao);
        resultado.clear();
        return adicao.isSelected();
    }

    @FXML
    public boolean onSubtracao() {
        desmarcarOutrosCheckboxes(subtracao);
        resultado.clear();
        return subtracao.isSelected();
    }

    @FXML
    public boolean onMultiplicacao() {
        desmarcarOutrosCheckboxes(multiplicacao);
        resultado.clear();
        return multiplicacao.isSelected();
    }

    @FXML
    public boolean onDivisao() {
        desmarcarOutrosCheckboxes(divisao);
        resultado.clear();
        return divisao.isSelected();
    }

    //MARCAR APENAS 1 CHECKBOX AO MESMO TEMPO
    public void desmarcarOutrosCheckboxes(CheckBox checkboxClicado) {
        if (checkboxClicado.isSelected()) {
            adicao.setSelected(checkboxClicado.equals(adicao));
            subtracao.setSelected(checkboxClicado.equals(subtracao));
            multiplicacao.setSelected(checkboxClicado.equals(multiplicacao));
            divisao.setSelected(checkboxClicado.equals(divisao));
        }
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

    @FXML
    public void onErroTesteAction(ActionEvent evento) {
        Alerts.showAlert("ERRO", null, "Você é muito teimoso, "
                + "eu falei para não apertar esse botão!!!", Alert.AlertType.ERROR);
    }

    @FXML
    public void teste(ActionEvent event) throws IOException {
        abrirJanela("/gui/Cotacao.fxml", event);
    }

    @FXML
    public void onCotacaoDolarAction(ActionEvent event) throws IOException {
        abrirJanela("/gui/Cotacao.fxml", event);
    }

    @FXML
    public void onImpostoAction(ActionEvent event) throws IOException {
        abrirJanela("/gui/Imposto.fxml", event);
    }

    //METODO PARA ABRIR UMA NOVA JANELA RECEBENDO O ENDEREÇO E O EVENTO
    public void abrirJanela(String fxmlFile, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
