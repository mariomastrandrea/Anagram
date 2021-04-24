package it.polito.tdp.anagram;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import it.polito.tdp.anagram.model.MyAnagramModel;
import it.polito.tdp.anagram.model.MyAnagramModel.Mode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static it.polito.tdp.anagram.model.TestAnagramma.*;

public class FXMLController 
{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField parolaTextField;

    @FXML
    private Button calcolaButton;
    
    @FXML
    private TextArea resultTextArea;
    
    private MyAnagramModel model;

    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) 
    {
    	String inputWord = this.parolaTextField.getText();
    	
    	if(inputWord.length() > 8)
    	{
    		this.resultTextArea.setText("Word too long! Choose a shorter word");
    		return;
    	}
    	inputWord = inputWord.trim();
    	if(inputWord.split("\\s").length > 1)
    	{
    		this.resultTextArea.setText("You can write only one word!");
    		return;
    	}
    	
    	Collection<String> anagrams = this.model.computeAnagramsOf(inputWord, Mode.NoRepetitions);
    	String result = printCollection(anagrams);
    	
    	this.resultTextArea.setText(result);
    }

    @FXML
    void handleInputTyping(KeyEvent event) 
    {
    	if(this.parolaTextField.getText().isBlank())
    		this.calcolaButton.setDisable(true);
    	else
    		this.calcolaButton.setDisable(false);
    }

    @FXML
    void initialize() 
    {
        assert parolaTextField != null : "fx:id=\"parolaTextField\" was not injected: check your FXML file 'Scene_anagram.fxml'.";
        assert calcolaButton != null : "fx:id=\"calcolaButton\" was not injected: check your FXML file 'Scene_anagram.fxml'.";
        assert resultTextArea != null : "fx:id=\"resultTextArea\" was not injected: check your FXML file 'Scene_anagram.fxml'.";
    }
    
    void setModel(MyAnagramModel newModel)
    {
    	this.model = newModel;
    }
}
