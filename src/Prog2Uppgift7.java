import java.text.DecimalFormat;

import javax.swing.*;


public class Prog2Uppgift7 {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		while(true){
			try{
				double timlön = 0;
				double arbetstid = 0;
				double veckolön = 0;
				arbetstid = Double.parseDouble(JOptionPane.showInputDialog("Ange antalet arbetstimmar"));
				timlön = Double.parseDouble(JOptionPane.showInputDialog("Ange timlön."));
				if(arbetstid > 40){
					double övertid = arbetstid - 40;
					veckolön += övertid * (timlön + timlön / 2);
					veckolön += 40 * timlön;
				} else {
					veckolön += arbetstid * timlön;
				}
				DecimalFormat f = new DecimalFormat("##.00");
				JOptionPane.showMessageDialog(frame, "Veckolönen är " + f.format(veckolön) + " kronor.");
			} catch(NumberFormatException e){
				break;
			} catch(NullPointerException e){
				break;
			}
		}
	}
}