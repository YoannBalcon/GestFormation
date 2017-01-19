package org.ybalcon.gestform.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ybalcon.gestform.model.Formation;
import org.ybalcon.gestform.model.Personne;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class PersonneDao {

	public static Statement st = null;
	public static ResultSet rs = null;

	public static void create(String nom, String prenom) {
		Connection cn = ConnectDb.getConnection();

		{
			try {

				st = (Statement) cn.createStatement();
				String sql = "INSERT INTO `Personne` (`id`, `nom`, `prenom`) VALUES (NULL, '"
						+ nom + "', '" + prenom + "')";
				st.executeUpdate(sql);
			} catch (SQLException e) {
				throw new RuntimeException();
			} finally {
				try {
					if (cn != null) {
						cn.close();
					}
					if (st != null) {
						st.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	
	public List<Personne> findAll() {

		Connection cn = ConnectDb.getConnection();

		List<Personne> personnes = new ArrayList<>();
		Statement st;
		try {
			st = (Statement) cn.createStatement();

			String sql = "select * from Personne";
			ResultSet rs = (ResultSet) st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");


				Personne p = new Personne (id, nom, prenom);

				personnes.add(p);
			}
			rs.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

		return personnes;

	}

}
