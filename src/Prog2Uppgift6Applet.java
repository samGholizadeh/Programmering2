/* Jag tror att jag glömde kommentera uppgift 5
 * där man ska skapa de olympiska ringarna. Men det
 * har i princip samma struktur.
 * 
 * Importerar alla bibliotek/Klasser vi ska använda.
 */
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Prog2Uppgift6Applet extends JPanel{
	private static final long serialVersionUID = 1L;
	
	//Instantierar våra GUI komponenter som ska läggas i JFrame containern.
	Random random = new Random(); //Instantierar ett random objekt för att genererar slumpmässiga heltal.
	int x, y, width, height; // Deklarerar fyra variablar.
	//Initialiserar en array som innehåller Color objekt.
	Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.BLACK, Color.GREEN, Color.CYAN, Color.GRAY, Color.ORANGE};
	
	//Init metoden körs när Appleten laddas på browsern. Sätter ny size och bakgrundsfärg.
	public void init(){
		setPreferredSize(new Dimension(300, 300));
		setBackground(Color.GRAY);
	}
	
	/* Här overridar jag paintComponent metoden
	 * och skapar en for loop där jag genererar
	 * nya värder för de instance variabler jag deklarerade
	 * Sedan skapar jag en if selektion med en modulus operator
	 * och om resterande värdet av operationen är lika med 0 så
	 * skapas en Oval annars skapas en Rectangel och fylls med färg.
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
