//Importerar alla bibliotek/Klasser vi ska anv�nda.
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Prog2Uppgift3Applet extends JApplet {
	private static final long serialVersionUID = 1L;
	
	//Instantierar v�ra GUI komponenter som ska l�ggas i JApplet containern.
	protected ArrayList<Integer> tal = new ArrayList<Integer>();
	protected JTextField inputField = new JTextField(20);
	protected JTextArea resultArea = new JTextArea(2, 20);
	protected JButton okButton = new JButton("L�gg till tal");
	protected JButton PerformCalculation = new JButton("Medel");
	Container c;
	
	protected double medel;
	protected double total;
	
	/*
	 * init metoden �r anropas efter att Appleten �r skapad. I den har vi kod som skapar
	 * komponeneter f�r att sedan l�gga till de till containern JApplet.
	*/
	
	public void init(){
		c = getContentPane(); //Returnerar panelen vi ska l�gga GUI komponenter i.
		c.setBackground(Color.green); //Byter bakgrundsf�rg
		c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
		JPanel panel1 = new JPanel();
		panel1.add(inputField);
		panel1.add(resultArea);
		panel1.add(PerformCalculation);
		panel1.add(okButton);
		c.add(panel1);
		resultArea.setColumns(40); //fixerar TextArea f�r design purposes.
		resultArea.setLineWrap(true);
		resultArea.setText("Skriv in v�rden i f�ltet ovan och tryck p� 'L�gg till tal' knappen f�r att ha med talet i ber�kning f�r medelv�rde");
		
		/*
		 * Anropar addActionListener metoden och anger en anonym klass som argument som hanterar
		 * event som fires n�r man trycker p� JButton knappen PerformCalculation
		 * */
		PerformCalculation.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				if(!inputField.getText().equals("")){ //Denna selektion kollar att f�ltet inte �r tom eller inte
					tal.add(new Integer(inputField.getText())); //Om f�ltet inte �r tom s� adderas talet till tal listan.
					inputField.setText("");//Tar bort talet fr�n f�ltet.
				}
				for(int i = 0; i < tal.size(); i++){//Loop som itererar genom tal listan och summerar talet till total varibeln.
					total += tal.get(i).doubleValue();
				}
				medel = Math.round(total / tal.size()); //Avrundar medeltalet
				resultArea.setText("Medel: " + medel); //Skriver ut medel i textrutan
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

}
