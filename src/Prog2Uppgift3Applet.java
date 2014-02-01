//Importerar alla bibliotek/Klasser vi ska använda.
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Prog2Uppgift3Applet extends JApplet {
	private static final long serialVersionUID = 1L;
	
	//Instantierar våra GUI komponenter som ska läggas i JApplet containern.
	protected ArrayList<Integer> tal = new ArrayList<Integer>();
	protected JTextField inputField = new JTextField(20);
	protected JTextArea resultArea = new JTextArea(2, 20);
	protected JButton okButton = new JButton("Lägg till tal");
	protected JButton PerformCalculation = new JButton("Medel");
	Container c;
	
	protected double medel;
	protected double total;
	
	/*
	 * init metoden är anropas efter att Appleten är skapad. I den har vi kod som skapar
	 * komponeneter för att sedan lägga till de till containern JApplet.
	*/
	
	public void init(){
		c = getContentPane(); //Returnerar panelen vi ska lägga GUI komponenter i.
		c.setBackground(Color.green); //Byter bakgrundsfärg
		c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
		JPanel panel1 = new JPanel();
		panel1.add(inputField);
		panel1.add(resultArea);
		panel1.add(PerformCalculation);
		panel1.add(okButton);
		c.add(panel1);
		resultArea.setColumns(40); //fixerar TextArea för design purposes.
		resultArea.setLineWrap(true);
		resultArea.setText("Skriv in värden i fältet ovan och tryck på 'Lägg till tal' knappen för att ha med talet i beräkning för medelvärde");
		
		/*
		 * Anropar addActionListener metoden och anger en anonym klass som argument som hanterar
		 * event som fires när man trycker på JButton knappen PerformCalculation
		 * */
		PerformCalculation.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				if(!inputField.getText().equals("")){ //Denna selektion kollar att fältet inte är tom eller inte
					tal.add(new Integer(inputField.getText())); //Om fältet inte är tom så adderas talet till tal listan.
					inputField.setText("");//Tar bort talet från fältet.
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
