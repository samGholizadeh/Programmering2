/*
 * Jag b�rjar med att importera alla de bibliotek som beh�vs.
 * De tre viktigaste �r java.util.*, javax.swing.*, java.awt.**/
import java.util.*;
import javax.swing.*; //Inneh�ller grafiska komponenter.
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent; //Beh�vs f�r att hantera event som skickas n�r man trycker p� en knapp.
import java.awt.event.ActionListener; //Lyssnar klass som beh�vs f�r att kunna l�gga till lyssnar funktion till t.ex. knappar.

public class Prog2Uppgift8Swing extends JFrame {
	private static final long serialVersionUID = 1L;
	protected int playerScore = 0; //H�ller reda p� spelare 1 po�ng.
	protected int computerScore = 0; //H�ller reda p� spelare 2 po�ng
	protected int cardValue; //Deklarerar variabel som ska anv�ndas vid kortdragning
	protected boolean red;
	protected boolean winner = false; //Initialiserar boolean variabel som ska h�lla reda p� om n�gon har vunnit.
	
	protected boolean playerPass = false; //Initialiserar boolean variabel som h�ller koll p� om spelare 1 har tryckt p� pass.
	protected boolean computerPass = false; //Initialiserar boolean variabel som h�ller koll p� om spelare 2 har tryckt p� pass.
	
	protected Prog2Uppgift8 kortlek = new Prog2Uppgift8(); // Instantiera kortleks objekt.
	
	//Initialiserar Grafiska komponenter och anger en String som argument som d� kommer vara texten i knappen.
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
		/*Konstruktor som bland annat skapar programmet GUI och l�gger
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
		
		String playerKortTv�Text = drawCard(kortlek.Kortlek, playerPass);
		addNewCard(playerKortTv�Text, PlayerCardsPanel);
		PlayerText.setText("Spelare 1.     Score: " + playerScore);
		playerPass = true;
		
		String computerKortEttText = drawCard(kortlek.Kortlek, playerPass);
		addNewCard(computerKortEttText, ComputerCardsPanel);
		
		String computerKortTv�Text = drawCard(kortlek.Kortlek, playerPass);
		addNewCard(computerKortTv�Text, ComputerCardsPanel);
		ComputerText.setText("Spelare 2.     Score: " + computerScore);
		playerPass = false;
		int win = isWinner(playerScore, computerScore, playerPass, computerPass);
		declareWinner(win);
		
		NyttSpelButton.addActionListener(new NyttSpel());
		
		frame.add(PlayerPanel);
		frame.add(ComputerPanel);
		
		add(frame);
		
		/*Anropar addActionListener som anv�nds f�r att
		 * l�gga till en lyssnar instans p� PlayerKortButton objektet.
		 * Som argument instantierar vi en anonym klass ActionListener.
		 * N�r man g�r det m�ste man overrida actionPerfomed metoder som finns
		 * i ActionListener klassen/interfacet. I denna specifika actionPerformed
		 * metod s� kollar vi om ett villkor och om det g�ller s� tar vi ett
		 * kort fr�n kortleken och l�gger tilldet p� spelaren kort plan.
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
		
		//Alla resterande addActionListeners �r ungef�r samma som ovan.
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
	 * Den tar det f�rsta kortet och sedan tar den bort den fr�n kortleken
	 * Sedan s� bygger den en str�ng som ska returneras. Den kollar �ven
	 * v�rdet p� kortet och parsar Stringen till ett int och adderar
	 * det till spelarens po�ng variabel.*/
	public String drawCard(ArrayList<String> Kortlek, boolean player){
		String kort = Kortlek.get(0);
		String returnString;
		Kortlek.remove(0); //Ta bort kortet man drog.
		if(kort.charAt(0) == 'S'){
			returnString = "Spader";
			red = false;
		} else if(kort.charAt(0) == 'H'){
			returnString = "Hj�rter";
			red = true;
		} else if(kort.charAt(0) == 'R'){
			returnString = "Ruter";
			red = true;
		} else {
			returnString = "Kl�ver";
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
	
	/*Metod som tar tv� variabler. En String och en Jpanel.
	 * Den skapar en JLabel som d� ska representera ett kort
	 * och l�gger till det p� JPanel*/
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
	
	//Denna metod best�mmer om n�gn har vunnit.
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
			
			String playerKortTv�Text = drawCard(kortlek.Kortlek, playerPass);
			addNewCard(playerKortTv�Text, PlayerCardsPanel);
			PlayerText.setText("Spelare 1.     Score: " + playerScore);
			playerPass = true;
			
			String computerKortEttText = drawCard(kortlek.Kortlek, playerPass);
			addNewCard(computerKortEttText, ComputerCardsPanel);
			
			String computerKortTv�Text = drawCard(kortlek.Kortlek, playerPass);
			addNewCard(computerKortTv�Text, ComputerCardsPanel);
			ComputerText.setText("Spelare 2.     Score: " + computerScore);
			playerPass = false;
			
			Color color = UIManager.getColor ( "Panel.background" );
			PlayerText.setBackground(color);
			ComputerText.setBackground(color);
			
			int win = isWinner(playerScore, computerScore, playerPass, computerPass);
			declareWinner(win);
		}
	}
	//Main metod som instantierar ett objekt fr�n kortlek klassen och startar spelet.
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