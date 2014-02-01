//Importerar alla bibliotek/Klasser vi ska anv�nda.
import java.util.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prog2Uppgift3 extends JFrame {
	/**
	 * 
	 */
	
	//Instantierar v�ra GUI komponenter som ska l�ggas i JFrame containern.
	private static final long serialVersionUID = 1L;
	protected ArrayList<Integer> tal = new ArrayList<Integer>(); //ArrayList som kommer att inneh�lla alla tal som ska vara med i ber�kningen
	protected JTextField inputField = new JTextField(20);
	protected JTextArea resultArea = new JTextArea(2, 20);
	protected JButton okButton = new JButton("L�gg till tal");
	protected JButton PerformCalculation = new JButton("Medel");
	
	//deklarerar variabler som beh�vs i programmet.
	protected double medel;
	protected double total;
	
	//Konstruktor som Initialiserar JPanel och l�gger till alla GUI komponeneter.
	public Prog2Uppgift3(){
		JPanel panel1 = new JPanel();
		resultArea.setText("Skriv in v�rden i f�ltet ovan och tryck p� 'L�gg till tal' knappen f�r att ha med talet i ber�kning f�r medelv�rde");
		panel1.add(inputField);
		panel1.add(resultArea);
		panel1.add(PerformCalculation);
		panel1.add(okButton);
		
		add(panel1); //L�gger till Panel komponenten till JFrame containern.
		
		/*
		 * Anropar addActionListener metoden och anger en anonym klass som argument som hanterar
		 * event som fires n�r man trycker p� JButton knappen PerformCalculation
		 * */
		PerformCalculation.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				if(!inputField.getText().equals("")){//Denna selektion kollar att f�ltet inte �r tom eller inte
					tal.add(new Integer(inputField.getText())); //Om f�ltet inte �r tom s� adderas talet till tal listan.
					inputField.setText("");//Tar bort talet fr�n f�ltet.
				}
				for(int i = 0; i < tal.size(); i++){ //Loop som itererar genom tal listan och summerar talet till total varibeln.
					total += tal.get(i).doubleValue();
				}
				medel = Math.round(total / tal.size());//Avrundar medeltalet
				resultArea.setText("Medel: " + medel);//Skriver ut medel i textrutan
				tal.clear();
				total = 0;
				medel = 0;
			}
		});
		
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!inputField.getText().equals("")){
					tal.add(new Integer(inputField.getText()));
					inputField.setText("");
				}
			}
		});
		
	}
	
	
	public static void main(String[] args){
		Prog2Uppgift3 medel = new Prog2Uppgift3(); //Anropar Medel klassens konstruktor som skapar GUIn och ger knapparna funktionalitet.
		medel.setTitle("Medel"); //St�ller in medel containern.
		medel.setSize(300, 130);
		medel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		medel.setLocationRelativeTo(null);
		medel.setVisible(true);
		medel.setResizable(false);
	}
}
