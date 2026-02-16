/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ironm
 */
public class Gestore {

    public void accessiFalliti(List<String[]> dati) {

        ArrayList controllati = new ArrayList<>();

        for (int i = 0; i < dati.size(); i++) {
            String x = dati.get(i)[1];
            if (!controllati.contains(x)) {
                int count = 0;
                for (int j = 0; j < dati.size(); j++) {
                    if (dati.get(j)[1].equals(x) && dati.get(j)[3].equals("FAIL")) {
                        count++;
                    }
                }
                System.out.println(x + ": " + count);
                controllati.add(x);
            }
        }
    }
    
    public void ipSpospetti(List<String[]> dati){
        
        int limite = 2;
        ArrayList controllati = new ArrayList<>();
        
        for (int i = 0; i < dati.size(); i++) {
            String x = dati.get(i)[2];
            if (!controllati.contains(x)) {
                int count = 0;
                for (int j = 0; j < dati.size(); j++) {
                    if (dati.get(j)[2].equals(x) && dati.get(j)[3].equals("FAIL")) {
                        count++;
                    }
                    if (count >= limite){
                        System.out.println( x + " e' sospetto");
                    }
                }
                controllati.add(x);
            }
        } 
    }
    
    public void intervallo (List<String[]> dati, String oraInizio, String oraFine){
        
        for (int i = 0; i < dati.size(); i++){
            String t  = dati.get(i)[0];
            String o = t.substring(11);
            if (o.compareTo(oraInizio) >= 0 && o.compareTo(oraFine) <= 0){
                String utente = dati.get(i)[1];
                String ip = dati.get(i)[2];
                String risultato = dati.get(i)[3];
                System.out.println(o + " " + utente + " " + ip + " " + risultato);
            }
        }
    }
}