//Importerar swing biblioteket d� det beh�vs f�r att skapa anv�ndargr�nssnitt.
import java.awt.*;
import javax.swing.*;

public class Prog2Uppgift5Start extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Prog2Uppgift5 circle; //Deklarerar en variable som ska anv�ndas att referera till ett objekt vi ska instantiera senare.
	
	public Prog2Uppgift5Start(){
		Container c = getContentPane(); //returnerar containtpane f�r denna Frame.
		circle = new Prog2Uppgift5(); //Instantierar en ny circle
		c.setBackground(Color.GRAY); // S�tter bakgrundsf�rgen till gr�
		setSize(300, 300);
		c.add(circle);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		Prog2Uppgift5Start c1 = new Prog2Uppgift5Start();
	}
}