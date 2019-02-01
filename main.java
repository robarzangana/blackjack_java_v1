import javax.swing.*;
public class main {
	public static void main(String[] arg) {
		kort k1 = new kort(); //Skapa nytt objekt "k1" av klassen "kort"
		int s; //Initierar variablen s av typen int(integer)
		
		while(true) { //Skapar en while-loop som pågår så länge spelet pågår. Allt inom samma instans
			s = JOptionPane.showConfirmDialog(null, "Do you want a card?", "Confirm", JOptionPane.YES_NO_OPTION); //Frågar användare om nytt kort beviljas
			if (s==0) //Ifall användaren klickar "Ja/Yes"...
				JOptionPane.showMessageDialog(null, k1.toString() + "\nTotal sum: " + k1.metodSummaEtt()); //...Anropas metoderna toString och metodSummaEtt
			else { //Ifall användaren klickar nej, och inte vill ha nytt kort kommer "datorn" att spela
				JOptionPane.showMessageDialog(null, k1.metodSummaTvå());//Här anropas metodSummaTvå som genererar tre tal och summan läggs ihop "datan spelar"
				JOptionPane.showMessageDialog(null, k1.metodResultat());//Efter att "datorns" resultat är inne så jämförs resultaten för spelare ett och...
				System.exit(0); //... datorn. Som som fick närmars 21 eller 21 vinner. Sedan stängs programmet av.
			} //Då allt anrop är inom samma loop, så sparas alla värden och kan användas under andra anrop i samma instans. 
		}
	}
}