import java.text.DecimalFormat;

import javax.swing.*;


public class Prog2Uppgift7 {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		while(true){
			try{
				double timl�n = 0;
				double arbetstid = 0;
				double veckol�n = 0;
				arbetstid = Double.parseDouble(JOptionPane.showInputDialog("Ange antalet arbetstimmar"));
				timl�n = Double.parseDouble(JOptionPane.showInputDialog("Ange timl�n."));
				if(arbetstid > 40){
					double �vertid = arbetstid - 40;
					veckol�n += �vertid * (timl�n + timl�n / 2);
					veckol�n += 40 * timl�n;
				} else {
					veckol�n += arbetstid * timl�n;
				}
				DecimalFormat f = new DecimalFormat("##.00");
				JOptionPane.showMessageDialog(frame, "Veckol�nen �r " + f.format(veckol�n) + " kronor.");
			} catch(NumberFormatException e){
				break;
			} catch(NullPointerException e){
				break;
			}
		}
	}
}