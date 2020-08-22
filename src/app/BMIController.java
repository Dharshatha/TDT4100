package app;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BMIController {
	private BMIUtregning BMICalculator;
	private IbsToKg converter;
	private Person person;
	private FileManagementClass filhåndtering;
	
	@FXML
	public void initialize() {
		this.BMICalculator = new BMIUtregning();
		this.converter = new IbsToKg();
		this.person = new Person();
		this.filhåndtering = new FileManagementClass();
	}
	

    @FXML
    private TextField høyde;

    @FXML
    private TextField vekt;

    @FXML
    private Button BMIknapp;

    @FXML
    private TextField pounds;

    @FXML
    private Button konverterknapp;

    @FXML
    private TextArea bmien;

    @FXML
    private TextArea Kilo;

    @FXML
    private TextField navnet;

    @FXML
    private Button Enter;

    @FXML
    private Button Lagre;

    @FXML
    private Button Laste;

    @FXML
    void Convert(ActionEvent event) {
    	try {
    		String value = ((Button) event.getSource()).getText();
    		if(value.equals("Konverter")) {
    			double poundsen = Double.parseDouble(pounds.getText());
    			double kgs = this.converter.IbstilKg(poundsen);
    			String kgsomstreng = String.format("%,.2f", kgs);
    			Kilo.setText(poundsen + "pounds i kg blir: " + kgsomstreng + " kg!");
    		}
    		
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    		Kilo.setText("Noe er galt med dataen, sjekk at du har brukt tall!");
    	}
    }

    @FXML
    void Navn(ActionEvent event) {
    	try {
    		String value = ((Button) event.getSource()).getText();
    		if(value.equals("Enter")) {
    			String navn = navnet.getText();
    			this.person.setNavn(navn);
    		}
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    		bmien.setText("Noe gikk galt, desverre.");
    	}
    }

    @FXML
    void Regnutbmi(ActionEvent event) {
    	try {
    		String value = ((Button) event.getSource()).getText();
    		if(value.equals("BMI")) {
    			double hoyden = Double.parseDouble(høyde.getText());
    			int vekten = Integer.parseInt(vekt.getText());
    			double bmi = this.BMICalculator.utregning(hoyden, vekten);
    			String result = this.BMICalculator.resultat(bmi);
    			String selve_bmisomstreng = String.format("%,.2f", bmi);
    			bmien.setText("Du har en bmi på " + selve_bmisomstreng + " og du " + result);
    		}
    	}
    	catch(Exception e) {
    		System.out.println(e.getCause());
    		bmien.setText("Pass på at du har satt inn kun tall i feltene.");
    		
    	}

    }

    @FXML
    void load(ActionEvent event) {
  	  try {
		  	String lagre = ((Button) event.getSource()).getText();
		  	if (lagre.equals("Laste")){
		  		Kilo.setText(this.filhåndtering.load("test.txt"));
		  	}}
		  	catch (IOException e) {
		  		System.out.println(e.getMessage());
				Kilo.setText("Noe gikk galt med loadingen.");
				}  	
		  } 


    @FXML
    void save(ActionEvent event) {
    	try {
    	  	String lagre = ((Button) event.getSource()).getText();
    	  	if (lagre.equals("Lagre")){
    	  		this.filhåndtering.save("test.txt", this.BMICalculator, this.person);
    	  	}}
    	  	catch (IOException e) {
    	  		System.out.println(e.getMessage());
    			Kilo.setText("Noe med å skrive inn.");
    			}  	
    	  }
}

