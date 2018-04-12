/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txt"
    private TextField txt; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    private TextArea fieldAnagrammiCorretti;

    @FXML
    private TextArea fieldAnagrammiErrati;
   
   private Model modello= new Model();
    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {
    	modello.cancellaSoluzioniPrecedenti();
    	this.fieldAnagrammiCorretti.clear();
    	this.fieldAnagrammiErrati.clear();
    	
    	modello.setParola(this.txt.getText());
    	
    	 modello.recursive(modello.getStep(), modello.getParziale(), modello.getParola());
    	 
    	 for(int i=0; i<modello.getSoluzioni().size();i++) {
    		if( modello.getAnagrammi().isCorrect(modello.getSoluzioni().get(i))) {
    			 this.fieldAnagrammiCorretti.appendText(modello.getSoluzioni().get(i).toString()+"\n");
    		} else {
    			this.fieldAnagrammiErrati.appendText(modello.getSoluzioni().get(i).toString()+"\n");
    		}
    	 }
    	 
    	
    	
    	 
    	 
    	
    	

    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.txt.clear();
    	this.fieldAnagrammiCorretti.clear();
    	this.fieldAnagrammiErrati.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txt != null : "fx:id=\"txt\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert fieldAnagrammiCorretti != null : "fx:id=\"fieldAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert fieldAnagrammiErrati != null : "fx:id=\"fieldAnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
