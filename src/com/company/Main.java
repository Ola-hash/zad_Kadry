package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Pracownik pracownik1 = new Pracownik("Ola", "loza", 25, 'k', 3);
        Pracownik pracownik2 = new Pracownik("igor", "loza", 25, 'k', 3);
        Kadry kadry = new Kadry();
        kadry.dodajPracownika(pracownik1);
        kadry.dodajPracownika(pracownik2);
        kadry.sredniZarobek();
        System.out.println(kadry.sredniZarobek());
        // System.out.println(kadry.dajDzialySet());
        Set<Integer> dzialy = kadry.dajDzialySet(); // zwracam metode i przypisuje do zmiennnej
        for (Integer d : dzialy) {
            System.out.println(d);
        }
        List<Pracownik> pracownicy = List.of(pracownik1, pracownik2); // w nowych wersjach javy tak mozna tworzyc liste
        FileWriter.write("text.txt", pracownicy);

        List<Pracownik> read = FileReader.read("text.txt"); //przypisanie do zmiennnej
        System.out.println(read);

        /*kadry.dodajPracownikaInteraktywnie();
        List<Pracownik> pracownicy = FileReader.importPracownicy("pracownicy.txt");
        System.out.println(pracownicy);*/
    }
}