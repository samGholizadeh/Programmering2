import javax.swing.*;
import java.awt.*;

public class Prog2Uppgift1 extends JApplet {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * init metoden �r anropas efter att Appleten �r skapad. I den har vi kod som skapar
	 * komponeneter f�r att sedan l�gga till de till containern JApplet.
	*/
	public void init(){
		/* Color �r en klass man anv�nder f�r att skapa en f�rg. Vi anv�nder den
		 * f�r att instantiera en Color objekt som ska anv�ndas som argument n�r vi
		 * ska skapa komponenten som ska visas i broswern. Vi anger tre olika argument
		 * som �r en siffra mellan 0 och 255 RBG tal d�r RGB st�r f�r Red, Green och Blue.
		 */
		Color backGround = new Color(34, 139, 34);
		Color foreGround = new Color(240, 230, 140);
		
		//JLabel �r ett swing komponent som ritas upp i browsern och i den kommer vi visa en str�ng
		//text som vi d� anger som argument n�r vi skapar JLabel objektet. Vi anv�nder �ven en konstant som
		//Finns initialiserad i JLabel klassen som d� centrerar texten f�r oss autmatiskt.
		JLabel nameLabel = new JLabel("Mitt namn �r Sam Gholizadeh.", JLabel.CENTER);

		nameLabel.setBackground(backGround); // Metod som vi anv�nder f�r att s�tta bakgrundsf�rg.
		nameLabel.setForeground(foreGround); // Metod f�r att s�tta f�rgrunden. Dessa tv� metoder f�r s� att texten f�r en f�rg.
		nameLabel.setFont(new Font("Calibri", Font.BOLD, 30)); //Denna metod byter typsnitt, Tjocklek och storlek p� texten.
		
		/* 
		 * Slutligen anropas add metoden och anger v�r JLabel objekt som argument. Add metoden har �rvts av
		 * java.awt.Container klassen.
		 */
		add(nameLabel);
	}
}

