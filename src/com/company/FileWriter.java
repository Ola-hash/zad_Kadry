package com.company;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWriter {

    public static void write(String fileName, List<Pracownik> pracownicy) {  // medota zapisyawania pracownikow do pliku w postaci binarnej
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(pracownicy);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
