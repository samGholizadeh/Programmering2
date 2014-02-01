/*
 * Jag börjar med att importera alla de bibliotek som behövs.
 * De tre viktigaste är java.util.*, javax.swing.*, java.awt.**/
import java.util.*;
import javax.swing.*; //Innehåller grafiska komponenter.
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent; //Behövs för att hantera event som skickas när man trycker på en knapp.
import java.awt.event.ActionListener; //Lyssnar klass som behövs för att kunna lägga till lyssnar funktion till t.ex. knappar.

public class Prog2Uppgift8Swing extends JFrame {
	private static final long serialVersionUID = 1L;
	protected int playerScore = 0; //Håller reda på spelare 1 poäng.
	protected int computerScore = 0; //Håller reda på spelare 2 poäng
	protected int cardValue; //Deklarerar variabel som ska användas vid kortdragning
	protected boolean red;
	protected boolean winner = false; //Initialiserar boolean variabel som ska hålla reda på om någon har vunnit.
	
	protected boolean playerPass = false; //Initialiserar boolean variabel som håller koll på om spelare 1 har tryckt på pass.
	protected boolean computerPass = false; //Initialiserar boolean variabel som håller koll på om spelare 2 har tryckt på pass.
	
	protected Prog2Uppgift8 kortlek = new Prog2Uppgift8(); // Instantiera kortleks objekt.
	
	//Initialiserar Grafiska komponenter och anger en String som argument som då kommer vara texten i knappen.
	protected JButton NyttSpelButton = new JButton("Nytt spel");
	protected JButton StartaOmButton = new JButton("Starta om");
	protected JButton PlayerKortButton = new JButton("Kort");
	protected JButton PlayerPassButton = new JButton("Pass");
	protected JButton ComputerKortButton = new JButton("Kort");
	protected JButton ComputerPassButton = new JButton("Pass");
	
	protected JPanel frame;
	protected JTextField PlayerText = new JTextField();
	protected JPanel PlayerPanel;
	protected JPanel PlayerCardsPanel;
	protected JPanel PlayerButtons;
	
	protected JTextField ComputerText = new JTextField();
	protected JPanel ComputerPanel;
	protected JPanel ComputerCardsPanel;
	protected JPanel ComputerButtons;
	
	public Prog2Uppgift8Swing(){
		/*Konstruktor som bland annat skapar programmet GUI och lägger
		 * till funktioner till vissa av komponenterna som t.ex. knappar.*/
		
		//Startar kortspelet
		kortlek.blandaKortlek();
		
		frame = new JPanel();
		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		
		PlayerPanel = new JPanel();
		PlayerCardsPanel = new JPanel();
		PlayerButtons = new JPanel();
		
		ComputerPanel = new JPanel();
		ComputerCardsPanel = new JPanel();
		ComputerButtons = new JPanel();
		
		PlayerPanel.setLayout(new BorderLayout());
		
		ComputerPanel.setLayout(new BorderLayout());
		
		PlayerPanel.setSize(475, 120);
		PlayerCardsPanel.setSize(460, 120);
		PlayerCardsPanel.setBorder(new EmptyBorder(30, 10, 0, 10));
		PlayerButtons.setSize(460, 140);
		
		ComputerPanel.setSize(475, 120);
		ComputerCardsPanel.setSize(460, 120);
		ComputerCardsPanel.setBorder(new EmptyBorder(30, 10, 0, 10));
		ComputerButtons.setSize(460, 140);
		
		PlayerButtons.add(PlayerKortButton);
		PlayerButtons.add(PlayerPassButton);
		
		ComputerButtons.add(ComputerKortButton);
		ComputerButtons.add(ComputerPassButton);
		ComputerButtons.add(NyttSpelButton);
		
		PlayerText.setOpaque(true);
		PlayerPanel.add(PlayerText, BorderLayout.NORTH);
		PlayerPanel.add(PlayerCardsPanel, BorderLayout.CENTER);
		PlayerPanel.add(PlayerButtons, BorderLayout.SOUTH);
		
		ComputerText.setOpaque(true);
		ComputerPanel.add(ComputerText, BorderLayout.NORTH);
		ComputerPanel.add(ComputerCardsPanel, BorderLayout.CENTER);
		ComputerPanel.add(ComputerButtons, BorderLayout.SOUTH);
		
		ComputerPanel.setSize(475, 190);
		ComputerCardsPanel.setSize(460, 120);
		ComputerButtons.setSize(460, 100);
		
		String playerKortEttText = drawCard(kortlek.Kortlek, playerPass);
		addNewCard(playerKortEttText, PlayerCardsPanel);
		
		String playerKortTvåText = drawCard(kortlek.Kortlek, playerPass);
		addNewCard(playerKortTvåText, PlayerCardsPanel);
		PlayerText.setText("Spelare 1.     Score: " + playerScore);
		playerPass = true;
		
		String computerKortEttText = drawCard(kortlek.Kortlek, playerPass);
		addNewCard(computerKortEttText, ComputerCardsPanel);
		
		String computerKortTvåText = drawCard(kortlek.Kortlek, playerPass);
		addNewCard(computerKortTvåText, ComputerCardsPanel);
		ComputerText.setText("Spelare 2.     Score: " + computerScore);
		playerPass = false;
		int win = isWinner(playerScore, computerScore, playerPass, computerPass);
		declareWinner(win);
		
		NyttSpelButton.addActionListener(new NyttSpel());
		
		frame.add(PlayerPanel);
		frame.add(ComputerPanel);
		
		add(frame);
		
		/*Anropar addActionListener som används för att
		 * lägga till en lyssnar instans på PlayerKortButton objektet.
		 * Som argument instantierar vi en anonym klass ActionListener.
		 * När man gör det måste man overrida actionPerfomed metoder som finns
		 * i ActionListener klassen/interfacet. I denna specifika actionPerformed
		 * metod så kollar vi om ett villkor och om det gäller så tar vi ett
		 * kort från kortleken och lägger tilldet på spelaren kort plan.
		 */
		PlayerKortButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				if(!playerPass && !winner){
					String playerKortText = drawCard(kortlek.Kortlek, false);
					addNewCard(playerKortText, PlayerCardsPanel);
					int winner = isWinner(playerScore, computerScore, playerPass, computerPass);
					PlayerText.setText("Spelare 1.     Score: " + playerScore);
					declareWinner(winner);
				}
			}
		});
		
		//Alla resterande addActionListeners är ungefär samma som ovan.
		ComputerKortButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				if(playerPass && !winner){
					String computerKortText = drawCard(kortlek.Kortlek, true);
					addNewCard(computerKortText, ComputerCardsPanel);
					int winner = isWinner(playerScore, computerScore, playerPass, computerPass); 
					ComputerText.setText("Spelare 2.     Score: " + computerScore);
					declareWinner(winner);
				}
			}
		});
		
		PlayerPassButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!playerPass && !winner){
					playerPass = true;
					int winner = isWinner(playerScore, computerScore, playerPass, computerPass);
					declareWinner(winner);
				}
			}
		});
		
		ComputerPassButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(playerPass && !winner){
					computerPass = true;
					int winner = isWinner(playerScore, computerScore, playerPass, computerPass);
					declareWinner(winner);
				}
			}
		});
	}
	
	/*Metod som tar en ArrayList och boolean variabel som argument
	 * Den tar det första kortet och sedan tar den bort den från kortleken
	 * Sedan så bygger den en sträng som ska returneras. Den kollar även
	 * värdet på kortet och parsar Stringen till ett int och adderar
	 * det till spelarens poäng variabel.*/
	public String drawCard(ArrayList<String> Kortlek, boolean player){
		String kort = Kortlek.get(0);
		String returnString;
		Kortlek.remove(0); //Ta bort kortet man drog.
		if(kort.charAt(0) == 'S'){
			returnString = "Spader";
			red = false;
		} else if(kort.charAt(0) == 'H'){
			returnString = "Hjärter";
			red = true;
		} else if(kort.charAt(0) == 'R'){
			returnString = "Ruter";
			red = true;
		} else {
			returnString = "Klöver";
			red = false;
		}
		
		cardValue = Integer.parseInt(kort.substring(1));
		
		if(playerScore < 8 && cardValue == 1){
			if(!player)
				playerScore += 14;
			else
				computerScore += 14;
		}else if(cardValue == 11 || cardValue == 12 || cardValue == 13){
			if(!player){
				playerScore += 10;
			} else {
				computerScore += 10;
			}
		}else{
			if(!player){
				playerScore += cardValue;
			} else {
				computerScore += cardValue;
			}
		}
		
		if(cardValue == 11){
			returnString += " Knekt.";
			return returnString;
		} else if(cardValue == 12){
			returnString += " Drottning.";
			return returnString;
		} else if(cardValue == 13){
			returnString += " Kung.";
			return returnString;
		}
		
		returnString += " " + String.valueOf(cardValue);
		return returnString;
	}
	
	/*Metod som tar två variabler. En String och en Jpanel.
	 * Den skapar en JLabel som då ska representera ett kort
	 * och lägger till det på JPanel*/
	public void addNewCard(String CardText, JPanel panel){
		JLabel CardContainer = new JLabel(CardText);
		CardContainer.setBorder(new EmptyBorder(20, 5, 20, 5));
		CardContainer.setSize(80, 45);
		CardContainer.setBackground(Color.WHITE);
		if(red){
			CardContainer.setForeground(Color.RED);
		} else {
			CardContainer.setForeground(Color.BLACK);
		}
		panel.add(CardContainer);
		panel.revalidate();
	}
	
	//Denna metod bestämmer om någn har vunnit.
	public int isWinner(int playerScore, int computerScore, boolean playerPass, boolean computerPass){
		if(computerScore > 21){
			winner = true;
			return 0;
		} else if(playerScore > 21){
			winner = true;
			return 1;
		} else if(computerScore < 22 && computerScore >= playerScore && playerPass && computerPass){
			winner = true;
			return 1;
		} else if(playerScore < 22 && playerScore > computerScore && playerPass && computerPass){
			winner = true;
			return 0;
		} else if(computerScore == 21){
			winner = true;
			return 1;
		} else {
			return 2;
		}
	}
	
	//Metod som grafiskt deklarerar vem som har vunnit.
	public void declareWinner(int i){
		if(i == 0){
			PlayerText.setBackground(Color.GREEN);
			ComputerText.setBackground(Color.RED);
		} else if(i == 1){
			ComputerText.setBackground(Color.GREEN);
			PlayerText.setBackground(Color.RED);
		}
	}
	
	/* Inner-klass som implementerar ActionListener interface.
	 * den startar om spelet.*/
	class NyttSpel implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			playerScore = 0;
			computerScore = 0;
			cardValue = 0;
			playerPass = false;
			computerPass = false;
			winner = false;
			playerPass = false;
			
			PlayerCardsPanel.removeAll();
			PlayerCardsPanel.revalidate();
			ComputerCardsPanel.removeAll();
			ComputerCardsPanel.revalidate();
			
			String playerKortEttText = drawCard(kortlek.Kortlek, playerPass);
			addNewCard(playerKortEttText, PlayerCardsPanel);
			
			String playerKortTvåText = drawCard(kortlek.Kortlek, playerPass);
			addNewCard(playerKortTvåText, PlayerCardsPanel);
			PlayerText.setText("Spelare 1.     Score: " + playerScore);
			playerPass = true;
			
			String computerKortEttText = drawCard(kortlek.Kortlek, playerPass);
			addNewCard(computerKortEttText, ComputerCardsPanel);
			
			String computerKortTvåText = drawCard(kortlek.Kortlek, playerPass);
			addNewCard(computerKortTvåText, ComputerCardsPanel);
			ComputerText.setText("Spelare 2.     Score: " + computerScore);
			playerPass = false;
			
			Color color = UIManager.getColor ( "Panel.background" );
			PlayerText.setBackground(color);
			ComputerText.setBackground(color);
			
			int win = isWinner(playerScore, computerScore, playerPass, computerPass);
			declareWinner(win);
		}
	}
	//Main metod som instantierar ett objekt från kortlek klassen och startar spelet.
	public static void main(String[] args){
		Prog2Uppgift8Swing test = new Prog2Uppgift8Swing();
		test.setTitle("Black jack");
		test.setSize(600, 400);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.setVisible(true);
		test.setResizable(false);
	}
}