//Jag valde att använda ArrayList istället för vector.
//Importerar de bibliotek vi måste använda.
import java.util.*;

public class Prog2Uppgift8 {
	
	//Deklarerae variabler som vi kommer avnända i programmet.
	protected ArrayList<String> Kortlek; //ArrayList som kommer innehålla våra kort.
	protected String[] Färger = {"S", "H", "K", "R"}; //ArrayLista med Olika typer av kort.
	
	/*Konstruktor som initialiserar ArrayLista
	 * Skapar två loopar. En yttre och en inre
	 * där varje yttreloop lägger till 13 kort för
	 * varje färg.
	 */
	public Prog2Uppgift8(){
		Kortlek = new ArrayList<String>();
		for(int i = 0; i < 4; i++){
			for(int k = 1; k < 14; k++){
				Kortlek.add(Färger[i] + k);
			}
		}
	}
	//Metod som blandar element positioneringen i Kortleken
	public void blandaKortlek(){
		Collections.shuffle(Kortlek);
	}
	
	/*Huvudtråden som instantierar Kortlek objekt och blandar ArrayListan.
	 * Sedan så väljer den det första elementet och bryter
	 * ut Första karaktären och valören.
	 * Beroende på Karakätrn så bestäms färgen.
	 * Färg och valör skrivs ut.
	*/
	public static void main(String[] args){
		Prog2Uppgift8 test = new Prog2Uppgift8();
		test.blandaKortlek();
		String kort = test.Kortlek.get(0);
		int valör = Integer.parseInt(kort.substring(1));
		String Färg;
		if(kort.charAt(0) == 'S'){
			Färg = "Spader";
		} else if(kort.charAt(0) == 'H'){
			Färg = "Hjärter";
		} else if(kort.charAt(0) == 'R'){
			Färg = "Ruter";
		} else {
			Färg = "Klöver";
		}
		System.out.println("Färg: " + Färg + ". Valör: " + valör);
	}
}
