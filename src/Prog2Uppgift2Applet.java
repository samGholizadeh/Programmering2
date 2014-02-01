//Importerar alla bibliotek/Klasser vi ska använda.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
		
		public class Prog2Uppgift2Applet extends JApplet {
			private static final long serialVersionUID = 1L; // Vet inte vad detta är, men eclipse rekommenderade att jag initialiserar det.
			
			//Instantierar våra GUI komponenter som ska läggas i JApplet containern.
			//Sätter ett välkomstmeddelande som förklarar vad programmet går ut på.
			protected JButton performCalculation = new JButton("Beräkna");
			protected JTextField textField = new JTextField(15);
			protected JTextArea textArea = new JTextArea(5, 15);
			Container c;
			
			int kostnad = 0; // Initialiserar en variabel vars värde kommer att ändra beroende på brevets vikt.
			int gram;
			String message;
			
			/*
			 * init metoden är anropas efter att Appleten är skapad. I den har vi kod som skapar
			 * komponeneter för att sedan lägga till de till containern JApplet.
			*/
			public void init(){
				c = getContentPane(); //Returnerar panelen vi ska lägga GUI komponenter i.
				c.setBackground(Color.green); //Byter bakgrundsfärg
				c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
				Operator priceButton = new Operator(); //Instantierar listener objekt som hanterar events. Alltså när användaren trycker på Beräkna knappen.
				performCalculation.addActionListener(priceButton); //Attachar lyssnar objektet till rätt GUI komponent.
				JPanel panel1 = new JPanel(new FlowLayout()); //Skapar en ny panel
				textArea.setColumns(40); //fixerar TextArea för design purposes.
				textArea.setLineWrap(true);
				panel1.add(textField); //Lägger till alla komponenter som vi skapat.
				panel1.add(performCalculation);
				panel1.add(textArea);
				c.add(panel1); //Lägger till panelen till JApplet containern
				//Välkomst meddelande som skrivs ut i JTextArea.
				textArea.setText("Beräkna porta. Skriv in antal gram i fältet och tryck sedan på Beräkna");
			}
			
			//Skapade en inner class som implementerar ActionListener.
			private class Operator implements ActionListener{
				public void actionPerformed(ActionEvent e){
					gram = Integer.parseInt(textField.getText());
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
					textArea.setText(message);
					textField.setText("");
				}
			}
		}