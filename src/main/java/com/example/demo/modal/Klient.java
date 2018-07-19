package com.example.demo.modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Klient")
public class Klient  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdKlient;
    private String Imie;
    private String Nazwisko;
    private int Numer_tel;

    public Klient(){}
    public Klient(String imie, String nazwisko, int numer_tel) {
        Imie = imie;
        Nazwisko = nazwisko;
        Numer_tel = numer_tel;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "IdKlient=" + IdKlient +
                ", Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", Numer_tel='" + Numer_tel + '\'' +
                '}';
    }

    public void setIdKlient(int idKlient) {
        this.IdKlient = idKlient;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public void setNumer_tel(int numer_tel) {
        Numer_tel = numer_tel;
    }

    public int getIdKlient() {
        return IdKlient;
    }

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public int getNumer_tel() {
        return Numer_tel;
    }
}
