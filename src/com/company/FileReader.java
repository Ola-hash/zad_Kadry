package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<Pracownik> read(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            List<Pracownik> pracownicy = (List<Pracownik>) objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return pracownicy;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public static List<Pracownik> importPracownicy(String fileName) { //import danhych z pliku tekstowego
        List<Pracownik> pracownicy = new ArrayList<>();
        try {
            InputStream inputStream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tab = line.split(" ");
                Pracownik pracownik = new Pracownik(tab[0],tab[1],Integer.parseInt(tab[2]),tab[3].charAt(0),Integer.parseInt(tab[4]));
                pracownicy.add(pracownik);
            }
        } catch (Exception ex) {

        }
        return pracownicy;
    }
}
