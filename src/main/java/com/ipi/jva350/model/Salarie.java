package com.ipi.jva350.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class Salarie {

    private String nom;
    private LocalDate moisDebutContrat;
    private LocalDate moisEnCours;
    private double joursTravaillesAnneeN;
    private double congesPayesAcquisAnneeN;
    private LinkedHashSet<LocalDate> congesPayesPris;
    private double joursTravaillesAnneeNMoins1;
    private double congesPayesAcquisAnneeNMoins1;
    private double congesPayesPrisAnneeNMoins1;

    // Constructeur sans paramètre
    public Salarie() {
        this.congesPayesPris = new LinkedHashSet<>();
    }

    // Constructeur avec paramètres
    public Salarie(String nom, LocalDate moisDebutContrat, LocalDate moisEnCours,
                   double joursTravaillesAnneeN, double congesPayesAcquisAnneeN,
                   double joursTravaillesAnneeNMoins1, double congesPayesAcquisAnneeNMoins1,
                   double congesPayesPrisAnneeNMoins1) {
        this.nom = nom;
        this.moisDebutContrat = moisDebutContrat;
        this.moisEnCours = moisEnCours;
        this.joursTravaillesAnneeN = joursTravaillesAnneeN;
        this.congesPayesAcquisAnneeN = congesPayesAcquisAnneeN;
        this.joursTravaillesAnneeNMoins1 = joursTravaillesAnneeNMoins1;
        this.congesPayesAcquisAnneeNMoins1 = congesPayesAcquisAnneeNMoins1;
        this.congesPayesPrisAnneeNMoins1 = congesPayesPrisAnneeNMoins1;
        this.congesPayesPris = new LinkedHashSet<>();
    }

    // Méthode pour savoir si le salarié a droit aux congés payés
    public boolean aLegalementDroitADesCongesPayes() {
        return this.joursTravaillesAnneeNMoins1 >= 10;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getMoisDebutContrat() {
        return moisDebutContrat;
    }

    public void setMoisDebutContrat(LocalDate moisDebutContrat) {
        this.moisDebutContrat = moisDebutContrat;
    }

    public LocalDate getMoisEnCours() {
        return moisEnCours;
    }

    public void setMoisEnCours(LocalDate moisEnCours) {
        this.moisEnCours = moisEnCours;
    }

    public double getJoursTravaillesAnneeN() {
        return joursTravaillesAnneeN;
    }

    public void setJoursTravaillesAnneeN(double joursTravaillesAnneeN) {
        this.joursTravaillesAnneeN = joursTravaillesAnneeN;
    }

    public double getCongesPayesAcquisAnneeN() {
        return congesPayesAcquisAnneeN;
    }

    public void setCongesPayesAcquisAnneeN(double congesPayesAcquisAnneeN) {
        this.congesPayesAcquisAnneeN = congesPayesAcquisAnneeN;
    }

    public LinkedHashSet<LocalDate> getCongesPayesPris() {
        return congesPayesPris;
    }

    public void setCongesPayesPris(LinkedHashSet<LocalDate> congesPayesPris) {
        this.congesPayesPris = congesPayesPris;
    }

    public double getJoursTravaillesAnneeNMoins1() {
        return joursTravaillesAnneeNMoins1;
    }

    public void setJoursTravaillesAnneeNMoins1(double joursTravaillesAnneeNMoins1) {
        this.joursTravaillesAnneeNMoins1 = joursTravaillesAnneeNMoins1;
    }

    public double getCongesPayesAcquisAnneeNMoins1() {
        return congesPayesAcquisAnneeNMoins1;
    }

    public void setCongesPayesAcquisAnneeNMoins1(double congesPayesAcquisAnneeNMoins1) {
        this.congesPayesAcquisAnneeNMoins1 = congesPayesAcquisAnneeNMoins1;
    }

    public double getCongesPayesPrisAnneeNMoins1() {
        return congesPayesPrisAnneeNMoins1;
    }

    public void setCongesPayesPrisAnneeNMoins1(double congesPayesPrisAnneeNMoins1) {
        this.congesPayesPrisAnneeNMoins1 = congesPayesPrisAnneeNMoins1;
    }
}
