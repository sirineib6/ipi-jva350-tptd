package com.ipi.jva350.model;

public class Salarie {

    // Attributs
    private String nom;  // Nom du salarié
    private int joursTravaillesAnneeNMoins1; // Jours travaillés l'année précédente

    // Constructeurs
    public Salarie() {
        // Constructeur par défaut
    }

    public Salarie(String nom, int joursTravaillesAnneeNMoins1) {
        this.nom = nom;
        this.joursTravaillesAnneeNMoins1 = joursTravaillesAnneeNMoins1;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getJoursTravaillesAnneeNMoins1() {
        return joursTravaillesAnneeNMoins1;
    }

    public void setJoursTravaillesAnneeNMoins1(int joursTravaillesAnneeNMoins1) {
        this.joursTravaillesAnneeNMoins1 = joursTravaillesAnneeNMoins1;
    }

    // Méthode pour vérifier si le salarié a droit à des congés payés
    public boolean aLegalementDroitADesCongesPayes() {
        // Si le salarié a travaillé 10 jours ou plus l'année précédente, il a droit à des congés payés
        return this.joursTravaillesAnneeNMoins1 >= 10;
    }
}
