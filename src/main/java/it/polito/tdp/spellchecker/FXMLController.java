package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import java.util.*;

public class FXMLController {
	
	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLingua;

    @FXML
    private TextArea txtErrori;

    @FXML
    private Label txtNErrori;

    @FXML
    private TextArea txtSpelling;

    @FXML
    private Label txtTempo;

    @FXML
    void doSpellCheck(ActionEvent event) { 
    	List<String> frase=new LinkedList<>();
    	String inserito= txtSpelling.getText().toLowerCase();
    	String ins=inserito.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	System.out.print(ins);
    	String array[]=ins.split(" ");
    	for(String ss:array) {
    		frase.add(ss);    		
    	}
    	List<RichWord> pRW= new LinkedList<>();
    	pRW=model.spellCheckText(frase);
    	
    	for(RichWord rr: pRW) {
    		txtErrori.appendText(rr.toString()+"\n");
    	}
    	
    	
    	//StringTokenizer st=new StringTokenizer(txtSpelling.getText()," ");
    	
    	
    	

    }

    @FXML
    void doTextClear(ActionEvent event) {

    }
    
    @FXML
    void handleCmbLanguage(ActionEvent event) {
    	String lingua=cmbLingua.getValue();
    	model.loadDictionary(lingua);

    }
    
    void setModel(Dictionary model) {
    	this.model=model;    	
    }

    @FXML
    void initialize() {
        assert cmbLingua != null : "fx:id=\"cmbLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"txtErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNErrori != null : "fx:id=\"txtNErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSpelling != null : "fx:id=\"txtSpelling\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        cmbLingua.getItems().clear();
        cmbLingua.getItems().addAll("English","Italian");

    }

}

