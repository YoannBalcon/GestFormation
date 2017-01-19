package org.ybalcon.gestform.model;

import java.util.ArrayList;

public class Formation {
	int formation_id;
	String nom;
	ArrayList<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	ArrayList<ECF> ecfs = new ArrayList<ECF>();

	public Formation(String nom) {
		this.nom = nom;
	}

	public Formation(int formation_id, String nom) {
		super();
		this.formation_id = formation_id;
		this.nom = nom;
	}

	public int getId() {
		return formation_id;
	}

	public void setId(int formation_id) {
		this.formation_id = formation_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void addStagiaire(Stagiaire s) {
		this.stagiaires.add(s);
	}

	public ArrayList<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(ArrayList<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public ArrayList<ECF> getEcfs() {
		return ecfs;
	}

	public void setEcfs(ArrayList<ECF> ecfs) {
		this.ecfs = ecfs;
	}

	@Override
	public String toString() {
		return nom +"\n";
	}

}
