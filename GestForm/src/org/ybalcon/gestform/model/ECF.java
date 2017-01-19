package org.ybalcon.gestform.model;

public class ECF {
	int ecf_id;
	String intitule;

	public ECF(int id, String intitule) {
		this.intitule = intitule;
		this.ecf_id = id;
	}

	public int getId() {
		return ecf_id;
	}

	public void setId(int id) {
		this.ecf_id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

}
