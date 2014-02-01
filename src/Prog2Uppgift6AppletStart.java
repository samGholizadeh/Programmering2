/* Jag tror att jag gl�mde kommentera uppgift 5
 * d�r man ska skapa de olympiska ringarna. Men det
 * har i princip samma struktur.
 * 
 * Importerar alla bibliotek/Klasser vi ska anv�nda.
 */
import javax.swing.*;
import java.awt.*;

public class Prog2Uppgift6AppletStart extends JApplet {
	private static final long serialVersionUID = 1L;
	
	//Deklarerar en variabel som ska h�lla CirclesRandomApplet objekt.
	private Prog2Uppgift6Applet ProgUppgift5Applet;
	
	/*Konstruktor som anropar getContentPane som returnerar
	 * en content pane som vi senare ska anv�nda som container
	 * f�r att l�gga till v�r JPanel som inneh�ller v�ra cirklar
	 * Vi anropar �ven metoder f�r att st�lla in v�r container.
	 * S� som att �ndra bakgrundsf�rgen.
	 * */
	public Prog2Uppgift6AppletStart(){
		Container c = getContentPane();
		ProgUppgift5Applet = new Prog2Uppgift6Applet();
		c.setBackground(Color.GRAY); // S�tter bakgrundsf�rgen till gr�
		c.setSize(300, 300);
		c.add(ProgUppgift5Applet);
		c.setVisible(true);
	}
	
	//Main metod som instantierar hela programmet.
	public static void main(String[] args){
		Prog2Uppgift6AppletStart start = new Prog2Uppgift6AppletStart();
	}
}
