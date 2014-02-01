//Importerar alla bibliotek/Klasser vi ska anv�nda.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Instantierar v�ra GUI komponenter som ska l�ggas i JApplet containern.
public class Prog2Uppgift4Applet extends JApplet {
	private static final long serialVersionUID = 1L;
	
	protected JTextField radiusInput = new JTextField(10);
	protected JLabel meter = new JLabel("meter(s) ");
	protected JTextField heightInput = new JTextField(10);
	protected JLabel meter2 = new JLabel("meter(s)");
	protected JTextArea resultArea = new JTextArea(2, 20);
	protected JButton PerformCalculation = new JButton("Ber�kna");
	
	protected double radius;
	protected double height;
	protected double result;
	
	Container c;
	
	/*
	 * init metoden �r anropas efter att Appleten �r skapad. I den har vi kod som skapar
	 * komponeneter f�r att sedan l�gga till de till containern JApplet.
	*/
	
	public void init(){
		c = getContentPane(); //Returnerar panelen vi ska l�gga GUI komponenter i.
		c.setBackground(Color.green); //Byter bakgrundsf�rg
		c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
		resultArea.setColumns(40); //fixerar TextArea f�r design purposes.
		resultArea.setLineWrap(true);
		resultArea.setText("Skriv in Radius i v�nstra f�ltet och h�jd i h�gre f�ltet");
		
		JPanel panel1 = new JPanel();
		panel1.add(radiusInput);
		panel1.add(meter);
		panel1.add(heightInput);
		panel1.add(meter2);
		panel1.add(resultArea);
		panel1.add(PerformCalculation);
		
		c.add(panel1);
		
		/*
		 * Anropar addActionListener metoden och anger en anonym klass som argument som hanterar
		 * event som fires n�r man trycker p� JButton knappen PerformCalculation
		 * */
		PerformCalculation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((radiusInput.getText().equals("")) || (heightInput.getText().equals(""))){ //om n�gon av f�lten �r tomma s� f�r anv�ndaren ett felmeddlande.
					resultArea.setText("Du har gl�mt att ange v�rde i b�de eller n�gon av f�lten.");
				} else { //Om allt st�r r�tt till samlas v�rden in och resultatet r�knas ut.
					radius = Double.parseDouble(radiusInput.getText());
					height = Double.parseDouble(heightInput.getText());
					result = Math.round(Math.PI * Math.pow(radius, 2) * height);
					resultArea.setText("The colume of the circle is: " + result + "m^3");
					radiusInput.setText("");
					heightInput.setText("");
				}
			}
		});
	}
}
