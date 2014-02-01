//Importerar alla bibliotek/Klasser vi ska anv�nda.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Prog2Uppgift4 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Instantierar v�ra GUI komponenter som ska l�ggas i JFrame containern.
	protected JTextField radiusInput = new JTextField(8);
	protected JLabel meter = new JLabel("meter(s) ");
	protected JTextField heightInput = new JTextField(8);
	protected JLabel meter2 = new JLabel("meter(s)");
	protected JTextArea resultArea = new JTextArea(10, 20);
	protected JButton PerformCalculation = new JButton("Ber�kna");
	
	//deklarerar variabler som beh�vs i programmet.
	protected double radius;
	protected double height;
	protected double result;
	
	//Konstruktor som Initialiserar JPanel och l�gger till alla GUI komponeneter.
	public Prog2Uppgift4(){
		JPanel panel = new JPanel();
		resultArea.setText("Skriv in Radius i v�nstra f�ltet och h�jd i h�gre f�ltet");
		panel.add(radiusInput);
		panel.add(meter);
		panel.add(heightInput);
		panel.add(meter2);
		panel.add(resultArea);
		panel.add(PerformCalculation);
		
		//L�gger till Panel komponenten till JFrame containern.
		add(panel);
		
		//Denna metod l�gger en eventHandler vilket ser till s� att n�got h�nder n�r
		//man trycker p� Ber�kna knappen.
		PerformCalculation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(radiusInput.getText().equals("") || radiusInput.getText().equals("")){
					resultArea.setText("Du har gl�mt att ange v�rde i b�de eller n�gon av f�lten.");
				} else {
					radius = Double.parseDouble(radiusInput.getText());
					height = Double.parseDouble(heightInput.getText());
					result = Math.round(Math.PI * Math.pow(radius, 2) * height);
					resultArea.setText("The radius of the circle is: " + result);
					radiusInput.setText("");
					heightInput.setText("");
				}
			}
		});
	}
	
	//Anropar Cylinder klassens konstruktor som skapar GUIn och ger knapparna funktionalitet.
	public static void main(String[] args){
		Prog2Uppgift4 c = new Prog2Uppgift4();
		c.setTitle("Cylinder volume calculator"); //St�ller in c containern.
		c.setSize(300, 300); //St�ller in Cylinder containern.
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLocationRelativeTo(null);
		c.setVisible(true);
		c.setResizable(false);
	}
	
}
