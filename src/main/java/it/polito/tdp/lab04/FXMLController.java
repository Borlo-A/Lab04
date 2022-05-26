/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class FXMLController {
	
	private Model model;
	private List<Corso> corsi;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscritti"
    private Button btnCercaIscritti; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="cmbBox"
    private ComboBox<Corso> cmbBox; // Value injected by FXMLLoader

    @FXML // fx:id="doCheckBox"
    private Button btnCercaNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCercaNome(ActionEvent event)
    {
    	txtResult.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	cmbBox.setValue(null);
    	if (txtMatricola.getText().compareTo("")==0)
    	{
    		txtMatricola.setStyle("-fx-border-color: red;");
    		btnCercaNome.setStyle("-fx-background-color: red;");
    		btnCercaNome.setText("X");
    		return;
    	}
    	Studente s = this.model.getStudente(Integer.parseInt(txtMatricola.getText()));
    	if (s==null)
    	{
    		txtMatricola.setStyle("-fx-text-inner-color: red;");
    		btnCercaNome.setStyle("-fx-background-color: red;");
    		
    		btnCercaNome.setText("X");
    		return;
    	}
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());   
    	txtMatricola.setStyle("-fx-text-inner-color: green;");
    	btnCercaNome.setStyle("-fx-background-color: green;");
    	btnCercaNome.setText("V");
    }
    
    @FXML
    void doCercaCorsi(ActionEvent event) 
    {
    	txtResult.clear();
    	cmbBox.setValue(null);
    	if(txtMatricola.getText().compareTo("")==0)
    	{
    		txtMatricola.setStyle("-fx-border-color: red;");
    		txtNome.clear();
    		txtCognome.clear();
    		btnCercaNome.setText(null);
    		btnCercaNome.setStyle("-fx-background-color:;");
    		return;
    	}
    	Studente s = this.model.getStudente(Integer.parseInt(txtMatricola.getText())); 
    	if(s==null)
    	{
    		//txtMatricola.setStyle("-fx-text-inner-color: red;");
    		txtMatricola.setStyle("-fx-border-color: red;");
    		//txtResult.setText("Studente non presente.");
    		return;
    	}
		txtMatricola.setStyle("-fx-text-inner-color:;");
    	List<Corso> corsiStudente = this.model.getCorsiByStudente(this.model.getStudente(Integer.parseInt(txtMatricola.getText())));
    	for (Corso c : corsiStudente)
    	{
    		txtResult.appendText(c.toString());
    	}
    }

    @FXML
    void doCercaIscritti(ActionEvent event) 
    {
    	txtResult.clear();
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	btnCercaNome.setText(null);
    	btnCercaNome.setStyle("-fx-background-color: ;");
    	txtMatricola.setStyle("-fx-text-inner-color:;");
    	if (cmbBox.getValue()==null)
    	{
    		cmbBox.setStyle("-fx-border-color: red;");
    		return;
    	}
    	cmbBox.setStyle("-fx-border-color:;");
    	List<Studente> studentiCorso = this.model.getStudentiByCorso(cmbBox.getValue());
    	for (Studente s : studentiCorso)
    	{
    		txtResult.appendText(s.toString());
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) 
    {
    	txtResult.clear();
    	List<Corso> corsiStudente = this.model.getCorsiByStudente(this.model.getStudente(Integer.parseInt(txtMatricola.getText())));
    	//List<Studente> studentiCorso = this.model.getStudentiByCorso(cmbBox.getValue());

    	for (Corso c: corsiStudente)
    	{
    		if(c.equals(cmbBox.getValue()))
    		{
    			txtResult.setText("Studente già iscritto al corso.");
    			return;
    		}
    	}
    }

    @FXML
    void doReset(ActionEvent event) {

    }

    private void setComboItems() {
    	//ottieni tutti i corsi del model
    	corsi = model.getTuttiICorsi();
    	//Aggiungi tutti i corsi alla ComboBox. 
    	Collections.sort(corsi); // per avere maggiore ordine li sorto alfabeticamente
    	cmbBox.getItems().add(null);
    	cmbBox.getItems().addAll(corsi); // richiama il toString dell'oggetto Corso
    }
    
    public void setModel(Model model)
    {
    	this.model = model;
    	cmbBox.getItems().clear();
    	setComboItems();
    }
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbBox != null : "fx:id=\"cmbBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'Scene.fxml'.";        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

        
    }

}
