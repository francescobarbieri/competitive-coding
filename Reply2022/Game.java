/* 
# Classe Game:
# - Metodo per inizializzarla (costruttore), leggendo da file e settando tutti i parametri
# - Metodo per l'avanzamento della stamina
# - Metodo per ogni singolo round
# - Metodo per il calcolo dei punti
# - 

16 4 18 13 

num1 -> numero di stamina necessario per battere il mostro
num2 -> numero di round dopo il quale recuperi num3 stamina points
num3 -> stamina points recuperati dopo num2 round
num4 -> numero di round per cui ottieni fragments (tutti i numeri successivi)

Problema: come modellare la struttura dati del nemico per renderla facilmente accessibile? -> Creare una classe nemico?!
{
    {0, },
    {1, },
}

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Game {
    // Hashamp con le impostazioni del gioco
    HashMap <String, Integer> gameSettings = new HashMap<String, Integer>();

    // "Struttura dati" per i nemici


    public Game() {
        try {
            File myobj = new File ("input.txt");
            Scanner myReader = new Scanner (myobj);
            
            // Lettura dati prima riga
            String[] temp = myReader.nextLine().split(" ");
            
            // Push dati in gameSettings (il parseInt fa un po' cagare)
            gameSettings.put("startingStamina", Integer.parseInt(temp[0]));
            gameSettings.put("maxStamina", Integer.parseInt(temp[1]));
            gameSettings.put("rounds", Integer.parseInt(temp[2]));
            gameSettings.put("enemies", Integer.parseInt(temp[3]));

            // Lettura dati altre righe
            
            while( myReader.hasNextLine() ) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to locate input file.");
        }
    }

    public void printSettings() {
        System.out.println(this.gameSettings);
    }


    public static void main(String[] args) {
        Game test = new Game();
        test.printSettings();

    }
}