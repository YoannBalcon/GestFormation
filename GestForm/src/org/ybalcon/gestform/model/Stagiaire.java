package org.ybalcon.gestform.model;

public class Stagiaire extends Personne {

    int matricule;
    Formation formation;

    public Stagiaire(int personne_id, String nom, String prenom, int matricule) {
        super(personne_id, nom, prenom);
        this.matricule = matricule;
    }

    public Stagiaire(int personne_id, String nom, String prenom, int matricule, Formation formation) {
        super(personne_id, nom, prenom);
        this.matricule = matricule;
        this.formation = formation;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

}
