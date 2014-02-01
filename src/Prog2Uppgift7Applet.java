import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Prog2Uppgift7Applet extends JApplet {
	private static final long serialVersionUID = 1L;
	
	protected JTextField timlönInput = new JTextField(10);
	protected JLabel meter = new JLabel("Timlön ");
	protected JTextField arbetstidInput = new JTextField(10);
	protected JLabel meter2 = new JLabel("Arbetstid");
	protected JTextArea resultArea = new JTextArea(2, 20);
	protected JButton PerformCalculation = new JButton("Beräkna");
	
	protected double timlön = 0;
	protected double arbetstid = 0;
	protected double veckolön = 0;
	
	Container c;
	
	public void init(){
		c = getContentPane();
		c.setBackground(Color.green); //Byter bakgrundsfärg
		c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
		resultArea.setColumns(40); //fixerar TextArea för design purposes.
		resultArea.setLineWrap(true);
		resultArea.setText("Mata in antal timmar personen jobbat under veckan och timlön för att kalkylera veckolönen.");
		
		JPanel panel1 = new JPanel();
		panel1.add(timlönInput);
		panel1.add(meter);
		panel1.add(arbetstidInput);
		panel1.add(meter2);
		panel1.add(resultArea);
		panel1.add(PerformCalculation);
		
		c.add(panel1);
		
		PerformCalculation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((timlönInput.getText().equals("")) || (arbetstidInput.getText().equals(""))){ //om någon av fälten är tomma så får användaren ett felmeddlande.
					resultArea.setText("Du har glömt att ange värde i både eller någon av fälten.");
				} else { //Om allt står rätt till samlas värden in och resultatet räknas ut.
					timlön = Double.parseDouble(timlönInput.getText());
					arbetstid = Double.parseDouble(arbetstidInput.getText());
					if(arbetstid > 40){
						double övertid = arbetstid - 40;
						veckolön += övertid * (timlön + timlön / 2);
						veckolön += 40 * timlön;
					} else {
						veckolön += arbetstid * timlön;
					}
					timlönInput.setText("");
					arbetstidInput.setText("");
					DecimalFormat f = new DecimalFormat("##.00");
					resultArea.setText("Veckolönen är " + f.format(veckolön) + " kronor.");
				}
			}
		});
	}

}
