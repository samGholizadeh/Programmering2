//Jag valde att anv�nda ArrayList ist�llet f�r vector.
//Importerar de bibliotek vi m�ste anv�nda.
import java.util.*;

public class Prog2Uppgift8 {
	
	//Deklarerae variabler som vi kommer avn�nda i programmet.
	protected ArrayList<String> Kortlek; //ArrayList som kommer inneh�lla v�ra kort.
	protected String[] F�rger = {"S", "H", "K", "R"}; //ArrayLista med Olika typer av kort.
	
	/*Konstruktor som initialiserar ArrayLista
	 * Skapar tv� loopar. En yttre och en inre
	 * d�r varje yttreloop l�gger till 13 kort f�r
	 * varje f�rg.
	 */
	public Prog2Uppgift8(){
		Kortlek = new ArrayList<String>();
		for(int i = 0; i < 4; i++){
			for(int k = 1; k < 14; k++){
				Kortlek.add(F�rger[i] + k);
			}
		}
	}
	//Metod som blandar element positioneringen i Kortleken
	public void blandaKortlek(){
		Collections.shuffle(Kortlek);
	}
	
	/*Huvudtr�den som instantierar Kortlek objekt och blandar ArrayListan.
	 * Sedan s� v�ljer den det f�rsta elementet och bryter
	 * ut F�rsta karakt�ren och val�ren.
	 * Beroende p� Karak�trn s� best�ms f�rgen.
	 * F�rg och val�r skrivs ut.
	*/
	public static void main(String[] args){
		Prog2Uppgift8 test = new Prog2Uppgift8();
		test.blandaKortlek();
		String kort = test.Kortlek.get(0);
		int val�r = Integer.parseInt(kort.substring(1));
		String F�rg;
		if(kort.charAt(0) == 'S'){
			F�rg = "Spader";
		} else if(kort.charAt(0) == 'H'){
			F�rg = "Hj�rter";
		} else if(kort.charAt(0) == 'R'){
			F�rg = "Ruter";
		} else {
			F�rg = "Kl�ver";
		}
		System.out.println("F�rg: " + F�rg + ". Val�r: " + val�r);
	}
}
