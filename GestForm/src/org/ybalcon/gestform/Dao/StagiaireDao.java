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

    Formation formation;

    public static void delete(Stagiaire s) throws Exception {
        Connection cn = ConnectDb.getConnection();
        PreparedStatement st;
        try {
            st = (PreparedStatement) cn.prepareStatement("DELETE FROM Personne WHERE id = ?");
            st.setInt(1, s.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("error during the creation process" + e.getMessage());
        }

    }

    public static void create(Stagiaire s) throws Exception {
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
            s.setId(rs.getInt(1));

            stAddStagiaire = (PreparedStatement) cn.prepareStatement("INSERT INTO Stagiaire (matricule, id_personne, id_formation) VALUES (?, ?, ?)");
            stAddStagiaire.setInt(1, s.getMatricule());
            stAddStagiaire.setInt(2, s.getId());
            stAddStagiaire.setInt(3, s.getFormation().getId());
            stAddStagiaire.execute();

            rs = (ResultSet) stAddStagiaire.getGeneratedKeys();
            if (!rs.next()) {
                throw new Exception("Cannot generate \"personne_id\"");
            }
            s.setMatricule(rs.getInt(1));
            cn.commit();
            stAddPersonne.close();
            stAddStagiaire.close();

        } catch (SQLException e) {
            cn.rollback();
            throw new Exception("error during the creation process" + e.getMessage());
        }
    }

    public static List<Stagiaire> findAll() {
        Connection cn = ConnectDb.getConnection();
        List<Stagiaire> stagiaires = new ArrayList<>();
        PreparedStatement st;

        try {
            st = (PreparedStatement) cn
                    .prepareStatement("SELECT * FROM Stagiaire  s INNER JOIN Personne  p ON s.id_personne = p.id INNER JOIN  Formation f ON s.id_formation = f.id");

            ResultSet rs = (ResultSet) st.executeQuery();

            while (rs.next()) {
                int matricule = rs.getInt("s.matricule");
                String nom = rs.getString("p.nom");
                String prenom = rs.getString("p.prenom");
                int id = rs.getInt("id_personne");
                Formation formation = new Formation(rs.getInt("f.id"), rs.getString("f.nom"));

                Stagiaire s = new Stagiaire(id, nom, prenom, matricule, formation);

                stagiaires.add(s);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return stagiaires;

    }

    public static void update(Stagiaire s) throws Exception {
        Connection cn = ConnectDb.getConnection();
        PreparedStatement st;
        PreparedStatement stm;
        try {
            st = (PreparedStatement) cn.prepareStatement("UPDATE Personne SET nom = ?, prenom = ?  WHERE id = ?");
            st.setString(1, s.getNom());
            st.setString(2, s.getPrenom());
            st.setInt(3, s.getId());
            st.executeUpdate();

            stm = (PreparedStatement) cn.prepareStatement("UPDATE Stagiaire SET id_formation = ? WHERE id = ?");
            stm.setInt(1, s.getFormation().getId());
            stm.setInt(2, s.getId());
            stm.executeUpdate();
            
        } catch (SQLException e) {
            throw new Exception("error during the creation process" + e.getMessage());
        }
    }
}
