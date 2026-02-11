/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ironm
 */
public class FileManager {

    private String filePath = "LogAccessi.csv";
    private List<String[]> righe = new ArrayList<>();

    public void leggiFile() {
        try (BufferedReader rd = new BufferedReader(new FileReader(filePath))) {
            String riga;
            while ((riga = rd.readLine()) != null) {
                String[] valori = riga.split(",");
                righe.add(valori);
            }
        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
        }

        for (String[] riga : righe) {
            if (riga.length >= 3) {
                System.out.println("Nome: " + riga[0] + " | Citta': " + riga[2]);
            }
        }
    }

    public void conta() {

        for (int i = 0; i < righe.size(); i++) {
            String utente = righe.get(i)[1];
            String esito = righe.get(i)[3];

            if (esito.equals("FAIL")) {

                int apparizioniPassate = 0;
                for (int j = 0; j < i; j++) {
                    if (righe.get(j)[1].equals(utente) && righe.get(j)[3].equals("FAIL")) {
                        apparizioniPassate++;
                    }
                }

                if (apparizioniPassate == 0) {
                    int totale = 0;
                    for (int k = 0; k < righe.size(); k++) {
                        if (righe.get(k)[1].equals(utente) && righe.get(k)[3].equals("FAIL")) {
                            totale++;
                        }
                    }
                    System.out.println("Utente: " + utente + " - Fallimenti: " + totale);
                }
            }
        }
    }

    public void segnalatore() {
        int diSeguito = 0;

        for (int i = 0; i < righe.size(); i++) {
            String esito = righe.get(i)[3];
            String ipAttuale = righe.get(i)[2];

            if (esito.equals("FAIL")) {
                diSeguito++;

                if (diSeguito == 3) {
                    System.out.println("ALLERTA: L'IP " + ipAttuale + " ha fallito 3 volte di seguito!");
                }
            } else {

                diSeguito = 0;
            }

        }
    }

    public void accessiMultipli() {
        for (int i = 0; i < righe.size(); i++) {
            for (int j = i + 1; j < righe.size(); j++) {
                String[] r1 = righe.get(i);
                String[] r2 = righe.get(j);

                if (r1[1].equals(r2[1]) && r1[0].equals(r2[0]) && !r1[2].equals(r2[2])) {
                    System.out.println(r1[1] + " - " + r1[0] + " - IP1: " + r1[2] + " IP2: " + r2[2]);
                }
            }
        }
    }
    
    public void ordina(){
        for(int i = 0; i < righe.size(); i++){
            String t1 = righe.get(i)[0];
            System.out.println(t1);
        }
    }
}