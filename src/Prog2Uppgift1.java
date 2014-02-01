import javax.swing.*;
import java.awt.*;

public class Prog2Uppgift1 extends JApplet {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * init metoden är anropas efter att Appleten är skapad. I den har vi kod som skapar
	 * komponeneter för att sedan lägga till de till containern JApplet.
	*/
	public void init(){
		/* Color är en klass man använder för att skapa en färg. Vi använder den
		 * för att instantiera en Color objekt som ska användas som argument när vi
		 * ska skapa komponenten som ska visas i broswern. Vi anger tre olika argument
		 * som är en siffra mellan 0 och 255 RBG tal där RGB står för Red, Green och Blue.
		 */
		Color backGround = new Color(34, 139, 34);
		Color foreGround = new Color(240, 230, 140);
		
		//JLabel är ett swing komponent som ritas upp i browsern och i den kommer vi visa en sträng
		//text som vi då anger som argument när vi skapar JLabel objektet. Vi använder även en konstant som
		//Finns initialiserad i JLabel klassen som då centrerar texten för oss autmatiskt.
		JLabel nameLabel = new JLabel("Mitt namn är Sam Gholizadeh.", JLabel.CENTER);

		nameLabel.setBackground(backGround); // Metod som vi använder för att sätta bakgrundsfärg.
		nameLabel.setForeground(foreGround); // Metod för att sätta förgrunden. Dessa två metoder för så att texten får en färg.
		nameLabel.setFont(new Font("Calibri", Font.BOLD, 30)); //Denna metod byter typsnitt, Tjocklek och storlek på texten.
		
		/* 
		 * Slutligen anropas add metoden och anger vår JLabel objekt som argument. Add metoden har ärvts av
		 * java.awt.Container klassen.
		 */
		add(nameLabel);
	}
}

