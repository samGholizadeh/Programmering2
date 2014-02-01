import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Prog2Uppgift6 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Random random = new Random();
	int x, y, width, height;
	Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.BLACK, Color.GREEN, Color.CYAN, Color.GRAY, Color.ORANGE};
	boolean oval = true;
	
	public Prog2Uppgift6(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(300, 300));
	}
	
	//paintComponent är en metod som används för att rita grafik på en panel
	//och anropas automatiskt vid programstart eller resize av fönster.
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
			}
			else {
				g.drawRect(x, y, height, width);
				g.fillRect(x, y, height, width);
			}	
		}
		//Vi skapar tre circlar genom att anropa setColor och drawOval och ange coordinater och storlek som argument.
	}
}
