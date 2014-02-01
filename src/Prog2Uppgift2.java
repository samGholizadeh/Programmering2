import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Prog2Uppgift2 {
	public static void main(String[] args){
		JFrame frame = new JFrame(); // JFrame används som en container (hållare) så att man kan lägga swing komponenter i.
		int kostnad = 0; // Initialiserar en variabel vars värde kommer att ändra beroende på brevets vikt.
		String message;
		
		//Oändlig loop
		while(true){
			// Try-block som innehåller programmets logik och hanterar en NumberFormatException
			try{
				//Fråga användaren om hur mycket brevet väger. Värdet returneras som String och måste därför
				// konverteras till int och det görs genom att anropas parseInt metoden,
				int gram = Integer.parseInt(JOptionPane.showInputDialog("Hur mycket väger " + 
						"ditt brev i gram?"));
				//If selektion som kollar värdet som användaren angav och ger variabel kostnad rätt värde.
				//om antal gram överskrider 2000 så anger man en sträng som informerar användaren om att
				//brevet räknas som paket. Därefter så skapar men en dialogruta som skriver ut priset.
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
					message = "Brev över 2000g räknas som paket.";
				}
				JOptionPane.showMessageDialog(frame, message);
			}
			//När jag testkörde programmet så kastades denna exception när man stängde av programmet och jag löste
			//det genom att ange keyword break så att error inte uppstår.
			catch(NumberFormatException e){
				break;
			}
		}
	}
}
