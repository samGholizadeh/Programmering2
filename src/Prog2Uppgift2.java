import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Prog2Uppgift2 {
	public static void main(String[] args){
		JFrame frame = new JFrame(); // JFrame anv�nds som en container (h�llare) s� att man kan l�gga swing komponenter i.
		int kostnad = 0; // Initialiserar en variabel vars v�rde kommer att �ndra beroende p� brevets vikt.
		String message;
		
		//O�ndlig loop
		while(true){
			// Try-block som inneh�ller programmets logik och hanterar en NumberFormatException
			try{
				//Fr�ga anv�ndaren om hur mycket brevet v�ger. V�rdet returneras som String och m�ste d�rf�r
				// konverteras till int och det g�rs genom att anropas parseInt metoden,
				int gram = Integer.parseInt(JOptionPane.showInputDialog("Hur mycket v�ger " + 
						"ditt brev i gram?"));
				//If selektion som kollar v�rdet som anv�ndaren angav och ger variabel kostnad r�tt v�rde.
				//om antal gram �verskrider 2000 s� anger man en str�ng som informerar anv�ndaren om att
				//brevet r�knas som paket. D�refter s� skapar men en dialogruta som skriver ut priset.
				if(gram < 2001){
					if(gram < 21){
						kostnad = 6;
					} else if(gram > 20 && gram < 101){
						kostnad = 12;
					} else if(gram > 100 && gram < 251){
						kostnad = 24;
					} else if(gram > 250 && gram < 501){
						kostnad = 36;
					} else if(gram > 500 && gram < 1001){
						kostnad = 48;
					} else if(gram > 1000 && gram < 2001){
						kostnad = 72;
					}
					message = "Pris: " + kostnad;
				} else {
					message = "Brev �ver 2000g r�knas som paket.";
				}
				JOptionPane.showMessageDialog(frame, message);
			}
			//N�r jag testk�rde programmet s� kastades denna exception n�r man st�ngde av programmet och jag l�ste
			//det genom att ange keyword break s� att error inte uppst�r.
			catch(NumberFormatException e){
				break;
			}
		}
	}
}
