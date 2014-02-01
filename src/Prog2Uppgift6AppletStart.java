/* Jag tror att jag glömde kommentera uppgift 5
 * där man ska skapa de olympiska ringarna. Men det
 * har i princip samma struktur.
 * 
 * Importerar alla bibliotek/Klasser vi ska använda.
 */
import javax.swing.*;
import java.awt.*;

public class Prog2Uppgift6AppletStart extends JApplet {
	private static final long serialVersionUID = 1L;
	
	//Deklarerar en variabel som ska hålla CirclesRandomApplet objekt.
	private Prog2Uppgift6Applet ProgUppgift5Applet;
	
	/*Konstruktor som anropar getContentPane som returnerar
	 * en content pane som vi senare ska använda som container
	 * för att lägga till vår JPanel som innehåller våra cirklar
	 * Vi anropar även metoder för att ställa in vår container.
	 * Så som att ändra bakgrundsfärgen.
	 * */
	public Prog2Uppgift6AppletStart(){
		Container c = getContentPane();
		ProgUppgift5Applet = new Prog2Uppgift6Applet();
		c.setBackground(Color.GRAY); // Sätter bakgrundsfärgen till grå
		c.setSize(300, 300);
		c.add(ProgUppgift5Applet);
		c.setVisible(true);
	}
	
	//Main metod som instantierar hela programmet.
	public static void main(String[] args){
		Prog2Uppgift6AppletStart start = new Prog2Uppgift6AppletStart();
	}
}
