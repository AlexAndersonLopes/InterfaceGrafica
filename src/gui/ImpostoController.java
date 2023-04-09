package gui;

import gui.util.Constraints;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ImpostoController implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private CheckBox pgReal;
    @FXML
    private CheckBox pgDolar;
    @FXML
    private TextField valorCompra;
    @FXML
    private Label total;
    @FXML
    private Button calcular;

    @FXML
    public void onCalcularAction() {
        double valor = Double.parseDouble(valorCompra.getText());
        double tot = 0.0, totImp = 0.0;
        if (onPgReal()) {
            tot = valor / 100 * 60;
            totImp = tot + valor;
        }
        if (onPgDolar()) {
            tot = valor * 5.25 / 100 * 60;
            totImp = valor * 5.25 + tot;
        }
        total.setText("O valor do imposto será de R$ " + String.valueOf((double) tot)
                + "\nValor total será de R$ " + totImp);
        limparTela();
    }

    @FXML
    public boolean onPgReal() {
        total.setText("");
        //pgDolar.setSelected(false);
        return pgReal.isSelected();
    }

    @FXML
    public boolean onPgDolar() {
        //pgReal.setSelected(false);
        total.setText("");
        return pgDolar.isSelected();
    }

    public void limparTela() {
        valorCompra.clear();
        pgDolar.setSelected(false);
        pgReal.setSelected(false);
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
        Constraints.setTextFieldDouble(valorCompra);
    }
    
    

}//FIM DA CLASSE



/*
    @FXML
    public void onJanelaPrincipal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/View.fxml.fxml"));
        Parent parent = loader.load();
        ImpostoController impostoController = loader.getController();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
    
        
    @FXML
    public void onCotacaoDolarAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Cotacao.fxml"));
        Parent parent = loader.load();
        CotacaoController cotacaoController = loader.getController();
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
     */
