import javax.swing.*;
import java.util.*;
public class kort {
	private int färg; //Deklararar int variabeln "färg" och lagrar den som private, så ingen kan ändra innehållet
    private int valör; //Samma som raden ovan
    private int summaEtt; // -||-
    private int summaTvå; // -||-

	String[] f = {"Klöver", "Ruter", "Hjärter", "Spader"}; /*Vi har skapat ett fält "f" med fyra komponenter som innehåller 
                                                           färgerna. OBS! indexering från 0-3, där 0 är första komponent*/
	int[] v = {1, 2, 3, 4, 5, 6, 7,
                             8, 9, 10, 11, 12, 13}; /*Vi har skapat ett fält "v" med 13 komponenter som 
                                                                      innehåller alla valörer ess-kung*/

    
    public kort() { //Konstruktor som initierar instansvariablerna summaEtt och summaTvå
        summaEtt = 0;
        summaTvå = 0;
    }

    public void metodRandomF() { //Metod
        färg = (int) (Math.random() * 4); //färg får ett slumpmässigt tal mellan 0-3, där 0 är första komponent av fält "f"
    }

    public void metodRandomV() {
        valör = (int) (Math.random() * 13); //valör får ett slumpmässigt tal mellan 0-12, där 0 är första komponent av fält "v"
    }

    public int metodSummaEtt() { //Denna metod behandlar allt spelaren (inte datorn) gör under sessionen
        if(valör==0 && summaEtt+valör+14<=21) //ifall valör blir 0, alltså ess. Och summaEtt+valör(0)+14 är mindre eller lika med 21...
            summaEtt += 14; //... Då lägger vi till 14 till totala summan. Eftersom Ess = 1 eller 14
        else if(valör==0 && summaEtt+valör+14>=21) //ifall valör blir 0, alltså ess. Och summaEtt+valör(0)+14 är mer än 21...
            summaEtt += 1; // ... Då skall 1 läggas till i totala summan. Då vi har två val, tar vi den som är smartast.
        else // Ifall annan valör än 0, alltså ess blir vårt kort...
            summaEtt += valör + 1; //... då lägger vi till valör poäng, +1. +1 för att valör 1 i fältet är 0 och 2=1. Så vi lägger till +1
        if(summaEtt>21) { //Ifall spelaren får mer än 21 i totala summan, då får spelaren meddelandet "You lost" och programmer slutar
            JOptionPane.showMessageDialog(null, "You lost!\n\n" + f[färg] + " " + v[valör] + "\nTotal sum: "+ summaEtt);
            System.exit(0); //Program slutar ifall summaEtt>21
        }
        return summaEtt;
    }
    public String metodSummaTvå() { //Vi använder exakt samma satser för att beräkna "datorns" poäng. Men det finns vissa skillnad här...
        for(int i=0; i<10; i++) { //... Dator får 11 drag på sig 0, 1 och 2 (i) osv för att få rätt poäng. Detta gör vi genom en for-loop
            if(valör==0 && summaTvå+valör+14<=21) //Denna if sats är identiska med satsen i metoden MetodSummaEtt
                summaTvå += 14;
            else if(valör==0 && summaTvå+valör+14>=21) // -||-
                summaTvå += 1;
            else if(valör+summaTvå<=21) // Ifall valör+summaTvå blir mindre eller lika med 21 så skall datorn tag kortet, lite fusk men blir bättre motstånd
                summaTvå += valör + 1;
            else if(valör+summaTvå>21) // Ifall valör+summaTvå blir mer än 21 så skall datorn inte tag kortet, och då stannar datorn med break-satsen
                break; //De två else if satserna ovan gör datorn lite "smartare" då "den kan göra fler beslut" beroende på situationen, bästa resultat väljs
            else
                summaTvå += valör + 1; //Annars är det bara fortsätta tag kort, om inga villkor ovan gäller
            if(summaTvå>21) {
                JOptionPane.showMessageDialog(null, "Computer lost! Total sum: " + summaTvå);
                System.exit(0); //Ifall "datorn" får mer än 21, då stängs programet och användare får meddelandet som finns i raden ovan
            }
        }
        return "Computer total sum: " + summaTvå; // Ifall "datorn" inte får mer än 21, då kommer användaren få reda på hur mycket...
                                                  //... datorn fick i totalsumman. Vi använder en return sats för det.
    }

    public String metodResultat() { //Denna metod räknar bara ut vem som blev vinnaren. Datorn eller användaren. Och visar meddelande...
        if(summaTvå>=summaEtt)      //... beroende på vem som vann. Då ingen kan få mer än 21, eftersom programmet stängs av i så fall...
           return "The computer is the winner!\n " + summaTvå + " >= " + summaEtt; //... behöver jag inte vara oroad för om någon av...
        if(summaTvå<summaEtt)                                                   //... spelarna får mer än 21. Denna metod används bara
           return "You are the winner!\n " + summaTvå + " < " + summaEtt;         //... ifall båda användarna fått 21 eller mindre. Annars...
       return "";                                                               //... kommer denna metod inte användas.
    }


	public String toString() { //Denna toString metod visat användaren vilka kort han/hon får och ändrar kortet varje gång (shuffle).
        metodRandomF(); //Genererar nytt "kortfärg" genom att anropa på metoden "metodRandomF"
        metodRandomV(); //Genererar ny "kortvalör" genom att anropa på metoden "metodRandomV"
        return f[färg] + " " + v[valör]; //Efter att ha genererat ny färg och valör så visas kortet upp för användaren i en dialogruta
    }
}