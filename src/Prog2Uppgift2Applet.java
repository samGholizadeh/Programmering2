//Importerar alla bibliotek/Klasser vi ska anv�nda.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
		
		public class Prog2Uppgift2Applet extends JApplet {
			private static final long serialVersionUID = 1L; // Vet inte vad detta �r, men eclipse rekommenderade att jag initialiserar det.
			
			//Instantierar v�ra GUI komponenter som ska l�ggas i JApplet containern.
			//S�tter ett v�lkomstmeddelande som f�rklarar vad programmet g�r ut p�.
			protected JButton performCalculation = new JButton("Ber�kna");
			protected JTextField textField = new JTextField(15);
			protected JTextArea textArea = new JTextArea(5, 15);
			Container c;
			
			int kostnad = 0; // Initialiserar en variabel vars v�rde kommer att �ndra beroende p� brevets vikt.
			int gram;
			String message;
			
			/*
			 * init metoden �r anropas efter att Appleten �r skapad. I den har vi kod som skapar
			 * komponeneter f�r att sedan l�gga till de till containern JApplet.
			*/
			public void init(){
				c = getContentPane(); //Returnerar panelen vi ska l�gga GUI komponenter i.
				c.setBackground(Color.green); //Byter bakgrundsf�rg
				c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
				Operator priceButton = new Operator(); //Instantierar listener objekt som hanterar events. Allts� n�r anv�ndaren trycker p� Ber�kna knappen.
				performCalculation.addActionListener(priceButton); //Attachar lyssnar objektet till r�tt GUI komponent.
				JPanel panel1 = new JPanel(new FlowLayout()); //Skapar en ny panel
				textArea.setColumns(40); //fixerar TextArea f�r design purposes.
				textArea.setLineWrap(true);
				panel1.add(textField); //L�gger till alla komponenter som vi skapat.
				panel1.add(performCalculation);
				panel1.add(textArea);
				c.add(panel1); //L�gger till panelen till JApplet containern
				//V�lkomst meddelande som skrivs ut i JTextArea.
				textArea.setText("Ber�kna porta. Skriv in antal gram i f�ltet och tryck sedan p� Ber�kna");
			}
			
			//Skapade en inner class som implementerar ActionListener.
			private class Operator implements ActionListener{
				public void actionPerformed(ActionEvent e){
					gram = Integer.parseInt(textField.getText());
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
					textArea.setText(message);
					textField.setText("");
				}
			}
		}