package org.ybalcon.gestform.model;

public class ECF {

    int id;
    String nom;
    int id_formation;
    Formation formation;

    public ECF(int id, String nom) {
        this.nom = nom;
        this.id = id;
    }

    public ECF(int id, String nom, Formation formation) {
        this.nom = nom;
        this.id = id;
        this.formation = formation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
