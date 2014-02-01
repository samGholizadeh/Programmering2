/* Jag tror att jag gl�mde kommentera uppgift 5
 * d�r man ska skapa de olympiska ringarna. Men det
 * har i princip samma struktur.
 * 
 * Importerar alla bibliotek/Klasser vi ska anv�nda.
 */
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Prog2Uppgift6Applet extends JPanel{
	private static final long serialVersionUID = 1L;
	
	//Instantierar v�ra GUI komponenter som ska l�ggas i JFrame containern.
	Random random = new Random(); //Instantierar ett random objekt f�r att genererar slumpm�ssiga heltal.
	int x, y, width, height; // Deklarerar fyra variablar.
	//Initialiserar en array som inneh�ller Color objekt.
	Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.BLACK, Color.GREEN, Color.CYAN, Color.GRAY, Color.ORANGE};
	
	//Init metoden k�rs n�r Appleten laddas p� browsern. S�tter ny size och bakgrundsf�rg.
	public void init(){
		setPreferredSize(new Dimension(300, 300));
		setBackground(Color.GRAY);
	}
	
	/* H�r overridar jag paintComponent metoden
	 * och skapar en for loop d�r jag genererar
	 * nya v�rder f�r de instance variabler jag deklarerade
	 * Sedan skapar jag en if selektion med en modulus operator
	 * och om resterande v�rdet av operationen �r lika med 0 s�
	 * skapas en Oval annars skapas en Rectangel och fylls med f�rg.
	 * 
	 * */
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		for(int i = 0; i < 100; i++){
			x = random.nextInt(200);
			y = random.nextInt(200);
			width = random.nextInt(60);
			height = random.nextInt(60);
			g.setColor(colors[random.nextInt(7)]);
			if(i % 2 == 0){
				g.drawOval(x, y, height, width);
				g.fillOval(x, y, height, width);
			}else {
				g.drawRect(x, y, height, width);
				g.fillRect(x, y, height, width);
			}	
		}
	}
}
