//Importerar alla bibliotek/Klasser vi ska använda.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Instantierar våra GUI komponenter som ska läggas i JApplet containern.
public class Prog2Uppgift4Applet extends JApplet {
	private static final long serialVersionUID = 1L;
	
	protected JTextField radiusInput = new JTextField(10);
	protected JLabel meter = new JLabel("meter(s) ");
	protected JTextField heightInput = new JTextField(10);
	protected JLabel meter2 = new JLabel("meter(s)");
	protected JTextArea resultArea = new JTextArea(2, 20);
	protected JButton PerformCalculation = new JButton("Beräkna");
	
	protected double radius;
	protected double height;
	protected double result;
	
	Container c;
	
	/*
	 * init metoden är anropas efter att Appleten är skapad. I den har vi kod som skapar
	 * komponeneter för att sedan lägga till de till containern JApplet.
	*/
	
	public void init(){
		c = getContentPane(); //Returnerar panelen vi ska lägga GUI komponenter i.
		c.setBackground(Color.green); //Byter bakgrundsfärg
		c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
		resultArea.setColumns(40); //fixerar TextArea för design purposes.
		resultArea.setLineWrap(true);
		resultArea.setText("Skriv in Radius i vänstra fältet och höjd i högre fältet");
		
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
		 * event som fires när man trycker på JButton knappen PerformCalculation
		 * */
		PerformCalculation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((radiusInput.getText().equals("")) || (heightInput.getText().equals(""))){ //om någon av fälten är tomma så får användaren ett felmeddlande.
					resultArea.setText("Du har glömt att ange värde i både eller någon av fälten.");
				} else { //Om allt står rätt till samlas värden in och resultatet räknas ut.
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
