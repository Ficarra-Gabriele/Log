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
                System.out.println("Nome: " + riga[0] + " | Città: " + riga[2]);
            }
        }
    }
}