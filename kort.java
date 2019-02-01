import javax.swing.*;
import java.util.*;
public class kort {
	private int f�rg; //Deklararar int variabeln "f�rg" och lagrar den som private, s� ingen kan �ndra inneh�llet
    private int val�r; //Samma som raden ovan
    private int summaEtt; // -||-
    private int summaTv�; // -||-

	String[] f = {"Kl�ver", "Ruter", "Hj�rter", "Spader"}; /*Vi har skapat ett f�lt "f" med fyra komponenter som inneh�ller 
                                                           f�rgerna. OBS! indexering fr�n 0-3, d�r 0 �r f�rsta komponent*/
	int[] v = {1, 2, 3, 4, 5, 6, 7,
                             8, 9, 10, 11, 12, 13}; /*Vi har skapat ett f�lt "v" med 13 komponenter som 
                                                                      inneh�ller alla val�rer ess-kung*/

    
    public kort() { //Konstruktor som initierar instansvariablerna summaEtt och summaTv�
        summaEtt = 0;
        summaTv� = 0;
    }

    public void metodRandomF() { //Metod
        f�rg = (int) (Math.random() * 4); //f�rg f�r ett slumpm�ssigt tal mellan 0-3, d�r 0 �r f�rsta komponent av f�lt "f"
    }

    public void metodRandomV() {
        val�r = (int) (Math.random() * 13); //val�r f�r ett slumpm�ssigt tal mellan 0-12, d�r 0 �r f�rsta komponent av f�lt "v"
    }

    public int metodSummaEtt() { //Denna metod behandlar allt spelaren (inte datorn) g�r under sessionen
        if(val�r==0 && summaEtt+val�r+14<=21) //ifall val�r blir 0, allts� ess. Och summaEtt+val�r(0)+14 �r mindre eller lika med 21...
            summaEtt += 14; //... D� l�gger vi till 14 till totala summan. Eftersom Ess = 1 eller 14
        else if(val�r==0 && summaEtt+val�r+14>=21) //ifall val�r blir 0, allts� ess. Och summaEtt+val�r(0)+14 �r mer �n 21...
            summaEtt += 1; // ... D� skall 1 l�ggas till i totala summan. D� vi har tv� val, tar vi den som �r smartast.
        else // Ifall annan val�r �n 0, allts� ess blir v�rt kort...
            summaEtt += val�r + 1; //... d� l�gger vi till val�r po�ng, +1. +1 f�r att val�r 1 i f�ltet �r 0 och 2=1. S� vi l�gger till +1
        if(summaEtt>21) { //Ifall spelaren f�r mer �n 21 i totala summan, d� f�r spelaren meddelandet "You lost" och programmer slutar
            JOptionPane.showMessageDialog(null, "You lost!\n\n" + f[f�rg] + " " + v[val�r] + "\nTotal sum: "+ summaEtt);
            System.exit(0); //Program slutar ifall summaEtt>21
        }
        return summaEtt;
    }
    public String metodSummaTv�() { //Vi anv�nder exakt samma satser f�r att ber�kna "datorns" po�ng. Men det finns vissa skillnad h�r...
        for(int i=0; i<10; i++) { //... Dator f�r 11 drag p� sig 0, 1 och 2 (i) osv f�r att f� r�tt po�ng. Detta g�r vi genom en for-loop
            if(val�r==0 && summaTv�+val�r+14<=21) //Denna if sats �r identiska med satsen i metoden MetodSummaEtt
                summaTv� += 14;
            else if(val�r==0 && summaTv�+val�r+14>=21) // -||-
                summaTv� += 1;
            else if(val�r+summaTv�<=21) // Ifall val�r+summaTv� blir mindre eller lika med 21 s� skall datorn tag kortet, lite fusk men blir b�ttre motst�nd
                summaTv� += val�r + 1;
            else if(val�r+summaTv�>21) // Ifall val�r+summaTv� blir mer �n 21 s� skall datorn inte tag kortet, och d� stannar datorn med break-satsen
                break; //De tv� else if satserna ovan g�r datorn lite "smartare" d� "den kan g�ra fler beslut" beroende p� situationen, b�sta resultat v�ljs
            else
                summaTv� += val�r + 1; //Annars �r det bara forts�tta tag kort, om inga villkor ovan g�ller
            if(summaTv�>21) {
                JOptionPane.showMessageDialog(null, "Computer lost! Total sum: " + summaTv�);
                System.exit(0); //Ifall "datorn" f�r mer �n 21, d� st�ngs programet och anv�ndare f�r meddelandet som finns i raden ovan
            }
        }
        return "Computer total sum: " + summaTv�; // Ifall "datorn" inte f�r mer �n 21, d� kommer anv�ndaren f� reda p� hur mycket...
                                                  //... datorn fick i totalsumman. Vi anv�nder en return sats f�r det.
    }

    public String metodResultat() { //Denna metod r�knar bara ut vem som blev vinnaren. Datorn eller anv�ndaren. Och visar meddelande...
        if(summaTv�>=summaEtt)      //... beroende p� vem som vann. D� ingen kan f� mer �n 21, eftersom programmet st�ngs av i s� fall...
           return "The computer is the winner!\n " + summaTv� + " >= " + summaEtt; //... beh�ver jag inte vara oroad f�r om n�gon av...
        if(summaTv�<summaEtt)                                                   //... spelarna f�r mer �n 21. Denna metod anv�nds bara
           return "You are the winner!\n " + summaTv� + " < " + summaEtt;         //... ifall b�da anv�ndarna f�tt 21 eller mindre. Annars...
       return "";                                                               //... kommer denna metod inte anv�ndas.
    }


	public String toString() { //Denna toString metod visat anv�ndaren vilka kort han/hon f�r och �ndrar kortet varje g�ng (shuffle).
        metodRandomF(); //Genererar nytt "kortf�rg" genom att anropa p� metoden "metodRandomF"
        metodRandomV(); //Genererar ny "kortval�r" genom att anropa p� metoden "metodRandomV"
        return f[f�rg] + " " + v[val�r]; //Efter att ha genererat ny f�rg och val�r s� visas kortet upp f�r anv�ndaren i en dialogruta
    }
}