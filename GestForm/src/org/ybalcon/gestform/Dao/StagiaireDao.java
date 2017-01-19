package org.ybalcon.gestform.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ybalcon.gestform.model.Formation;
import org.ybalcon.gestform.model.Stagiaire;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class StagiaireDao {
	
	public void createStagiaire(Stagiaire s) throws Exception {
		Connection cn = ConnectDb.getConnection();

		PreparedStatement stAddPersonne;
		PreparedStatement stAddStagiaire;

		try {
			cn.setAutoCommit(false);

			stAddPersonne = (PreparedStatement) cn.prepareStatement(
					"INSERT INTO Personne (nom, prenom) VALUES (?, ?);",
					Statement.RETURN_GENERATED_KEYS);
			stAddPersonne.setString(1, s.getNom());
			stAddPersonne.setString(2, s.getPrenom());

			stAddPersonne.execute();

			ResultSet rs = (ResultSet) stAddPersonne.getGeneratedKeys();
			if (!rs.next()) {
				throw new Exception("Cannot generate \"personne_id\"");
			}
			s.setMatricule(rs.getInt(1));

			stAddStagiaire = (PreparedStatement) cn
					.prepareStatement("INSERT INTO Stagiaire (matricule, id_personne, id_formation), VALUES (?, ?, ?)");
			stAddStagiaire.setInt(1, s.getId());
			stAddStagiaire.setInt(1, s.getMatricule());
			stAddStagiaire.setInt(1, s.getFormation().getId());
			stAddStagiaire.execute();

			cn.commit();
			stAddPersonne.close();
			stAddStagiaire.close();
		} catch (SQLException e) {
			cn.rollback();
			throw new Exception("error during the creation process"
					+ e.getMessage());
		}
	}

	public List<Stagiaire> findAll(Formation formation) {
		Connection cn = ConnectDb.getConnection();
		List<Stagiaire> stagiaires = new ArrayList<>();
		PreparedStatement st;

		try {
			st = (PreparedStatement) cn
					.prepareStatement("SELECT * FROM Stagiaire INNER JOIN Personne ON stagiaire.id_personne = Personne.id WHERE id_formation = ?");
			st.setInt(1, formation.getId());

			ResultSet rs = (ResultSet) st.executeQuery();

			while (rs.next()) {
				int matricule = rs.getInt("matricule");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int id = rs.getInt("id");

				Stagiaire s = new Stagiaire(id, nom, prenom, matricule,
						formation);

				stagiaires.add(s);
			}
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return stagiaires;

	}
}
