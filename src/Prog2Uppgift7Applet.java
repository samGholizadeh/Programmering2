import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Prog2Uppgift7Applet extends JApplet {
	private static final long serialVersionUID = 1L;
	
	protected JTextField timl�nInput = new JTextField(10);
	protected JLabel meter = new JLabel("Timl�n ");
	protected JTextField arbetstidInput = new JTextField(10);
	protected JLabel meter2 = new JLabel("Arbetstid");
	protected JTextArea resultArea = new JTextArea(2, 20);
	protected JButton PerformCalculation = new JButton("Ber�kna");
	
	protected double timl�n = 0;
	protected double arbetstid = 0;
	protected double veckol�n = 0;
	
	Container c;
	
	public void init(){
		c = getContentPane();
		c.setBackground(Color.green); //Byter bakgrundsf�rg
		c.setFont(new Font("Verdana", Font.BOLD, 20)); //Byter typsnitt och storlek.
		resultArea.setColumns(40); //fixerar TextArea f�r design purposes.
		resultArea.setLineWrap(true);
		resultArea.setText("Mata in antal timmar personen jobbat under veckan och timl�n f�r att kalkylera veckol�nen.");
		
		JPanel panel1 = new JPanel();
		panel1.add(timl�nInput);
		panel1.add(meter);
		panel1.add(arbetstidInput);
		panel1.add(meter2);
		panel1.add(resultArea);
		panel1.add(PerformCalculation);
		
		c.add(panel1);
		
		PerformCalculation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((timl�nInput.getText().equals("")) || (arbetstidInput.getText().equals(""))){ //om n�gon av f�lten �r tomma s� f�r anv�ndaren ett felmeddlande.
					resultArea.setText("Du har gl�mt att ange v�rde i b�de eller n�gon av f�lten.");
				} else { //Om allt st�r r�tt till samlas v�rden in och resultatet r�knas ut.
					timl�n = Double.parseDouble(timl�nInput.getText());
					arbetstid = Double.parseDouble(arbetstidInput.getText());
					if(arbetstid > 40){
						double �vertid = arbetstid - 40;
						veckol�n += �vertid * (timl�n + timl�n / 2);
						veckol�n += 40 * timl�n;
					} else {
						veckol�n += arbetstid * timl�n;
					}
					timl�nInput.setText("");
					arbetstidInput.setText("");
					DecimalFormat f = new DecimalFormat("##.00");
					resultArea.setText("Veckol�nen �r " + f.format(veckol�n) + " kronor.");
				}
			}
		});
	}

}
