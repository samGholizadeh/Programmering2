import java.awt.*;
import javax.swing.*;

public class Prog2Uppgift5 extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public Prog2Uppgift5(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(300, 300));
	}
	
	//paintComponent är en metod som används för att rita grafik på en panel
	//och anropas automatiskt vid programstart eller resize av fönster.
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		//Vi skapar tre circlar genom att anropa setColor och drawOval och ange coordinater och storlek som argument.
		g.setColor(Color.BLUE);
		g.drawOval(65, 90, 50, 50);
		g.setColor(Color.YELLOW);
		g.drawOval(95, 110, 50, 50);
		g.setColor(Color.BLACK);
		g.drawOval(125, 90, 50, 50);
		g.setColor(Color.GREEN);
		g.drawOval(155, 110, 50, 50);
		g.setColor(Color.red);
		g.drawOval(180, 90, 50, 50);
		g.drawString("Olympic Rings", 120, 185);
	}
}
