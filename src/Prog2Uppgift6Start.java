//Importerar swing biblioteket då det behövs för att skapa användargränssnitt.
import java.awt.*;
import javax.swing.*;

public class Prog2Uppgift6Start extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Prog2Uppgift6 ProgUppgift5; //Deklarerar en variable som ska användas att referera till ett objekt vi ska instantiera senare.
	
	public Prog2Uppgift6Start(){
		Container c = getContentPane(); //returnerar containtpane för denna Frame.
		ProgUppgift5 = new Prog2Uppgift6(); //Instantierar en ny circle
		c.setBackground(Color.GRAY); // Sätter bakgrundsfärgen till grå
		setSize(300, 300);
		c.add(ProgUppgift5);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		Prog2Uppgift6Start c1 = new Prog2Uppgift6Start();
	}
}
