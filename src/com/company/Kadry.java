package com.company;

import java.util.*;

public class Kadry {
    private Pracownik[] pracownicy;
    private int zatrudnienie;
    private int maxZatrudnienie;

    public Kadry() {
        this.maxZatrudnienie = 100;
        this.zatrudnienie = 0;
        this.pracownicy = new Pracownik[maxZatrudnienie];
    }

    public void dodajPracownika(Pracownik pracownik) {
        if (zatrudnienie <= maxZatrudnienie) {
            pracownicy[zatrudnienie] = pracownik;
            zatrudnienie++;
        }
    }

    public void dodajPracownikaInteraktywnie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie pracownika.");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko pracownika.");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj wynagrodzenie pracownika. ");
        double placa = scanner.nextDouble();
        System.out.println("Podaj plec pracownika");
        char plec = scanner.next().charAt(0);
        System.out.println("Podaj dzial w ktorym pracuje pracownik.");
        int dzial = scanner.nextInt();
        Pracownik pracownik = new Pracownik(imie, nazwisko, placa, plec, dzial);
        dodajPracownika(pracownik);

    }

    public double sredniZarobek() {
        double suma = 0;
        for (int i = 0; i < zatrudnienie; i++) {
            suma += pracownicy[i].getPlaca();
        }
        return suma / zatrudnienie;
    }

    public double sredniZarobekWDziale(int dzial) {
        double suma = 0;
        int ilosc = 0;
        for (int i = 0; i < zatrudnienie; i++) {
            if (dzial == pracownicy[i].getdzial()) {
                suma += pracownicy[i].getPlaca();
                ilosc++;
            }
        }
        return suma / ilosc;
    }

    public ArrayList<Integer> dajDzialy() {
        ArrayList<Integer> dzialy = new ArrayList<>();
        for (int i = 0; i < zatrudnienie; i++) {
            if (!dzialy.contains(pracownicy[i].getdzial())) {
                dzialy.add(pracownicy[i].getdzial());
            }
        }
        return dzialy;
    }

    public Set<Integer> dajDzialySet() {
        Set<Integer> dzialy = new HashSet<>();
        for (int i = 0; i < zatrudnienie; i++) {  // w Set nie musze porownywac, poniewaz bierze tylko unikalne obiekty
            dzialy.add(pracownicy[i].getdzial());
        }
        return dzialy;
    }

    @Override
    public String toString() {
        return "Kadry{" +
                "pracownicy=" + Arrays.toString(pracownicy) +
                ", zatrudnienie=" + zatrudnienie +
                ", maxZatrudnienie=" + maxZatrudnienie +
                '}';
    }
}
