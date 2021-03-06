package org.ybalcon.gestform.model;

public class Personne {

    int personne_id;
    String nom;
    String prenom;

    public Personne(int id, String nom, String prenom) {
        super();
        this.personne_id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return personne_id;
    }

    public void setId(int personne_id) {
        this.personne_id = personne_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }

}
