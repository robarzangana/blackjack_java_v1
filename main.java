import javax.swing.*;
public class main {
	public static void main(String[] arg) {
		kort k1 = new kort(); //Skapa nytt objekt "k1" av klassen "kort"
		int s; //Initierar variablen s av typen int(integer)
		
		while(true) { //Skapar en while-loop som p�g�r s� l�nge spelet p�g�r. Allt inom samma instans
			s = JOptionPane.showConfirmDialog(null, "Do you want a card?", "Confirm", JOptionPane.YES_NO_OPTION); //Fr�gar anv�ndare om nytt kort beviljas
			if (s==0) //Ifall anv�ndaren klickar "Ja/Yes"...
				JOptionPane.showMessageDialog(null, k1.toString() + "\nTotal sum: " + k1.metodSummaEtt()); //...Anropas metoderna toString och metodSummaEtt
			else { //Ifall anv�ndaren klickar nej, och inte vill ha nytt kort kommer "datorn" att spela
				JOptionPane.showMessageDialog(null, k1.metodSummaTv�());//H�r anropas metodSummaTv� som genererar tre tal och summan l�ggs ihop "datan spelar"
				JOptionPane.showMessageDialog(null, k1.metodResultat());//Efter att "datorns" resultat �r inne s� j�mf�rs resultaten f�r spelare ett och...
				System.exit(0); //... datorn. Som som fick n�rmars 21 eller 21 vinner. Sedan st�ngs programmet av.
			} //D� allt anrop �r inom samma loop, s� sparas alla v�rden och kan anv�ndas under andra anrop i samma instans. 
		}
	}
}