package org.ybalcon.gestform.model;

import java.util.ArrayList;

public class Resultat {
	int id;
	int note;
	int matricule;

	ArrayList<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	ArrayList<ECF> ecfs = new ArrayList<ECF>();

	public Resultat(int id, int note, int matricule) {
		super();
		this.id = id;
		this.note = note;
		this.matricule = matricule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getmatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

}
