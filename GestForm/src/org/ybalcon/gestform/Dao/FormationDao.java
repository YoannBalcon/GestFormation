package org.ybalcon.gestform.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ybalcon.gestform.model.Formation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class FormationDao {

    public static Statement st = null;
    public static ResultSet rs = null;

    public static void create(Formation f) {
        Connection cn = ConnectDb.getConnection();
        {
            try {
                PreparedStatement st = cn.prepareStatement(
                        "INSERT INTO `Formation` (`nom`) VALUES (?);",
                        Statement.RETURN_GENERATED_KEYS);
                st.setString(1, f.getNom());
                st.executeUpdate();

                ResultSet rs = (ResultSet) st.getGeneratedKeys();
                if (!rs.next()) {
                    return;
                }
                f.setId(rs.getInt(1));
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

    public static List<Formation> findAll() {

        Connection cn = ConnectDb.getConnection();

        List<Formation> formations = new ArrayList<>();
        Statement st;
        try {
            st = (Statement) cn.createStatement();

            String sql = "select * from Formation";
            ResultSet rs = (ResultSet) st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");

                Formation f = new Formation(id, nom);

                formations.add(f);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return formations;

    }

    public Formation findBy(int id) {
        Formation f = null;
        Connection cn = ConnectDb.getConnection();
        PreparedStatement st;
        try {
            st = cn.prepareStatement("select * from formation WHERE id= ?");
            st.setInt(1, id);
            ResultSet rs = (ResultSet) st.executeQuery();
            if (rs.next()) {
                f = new Formation(rs.getInt("id"), rs.getString("nom"));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return f;
    }

    public static void delete(Formation f) throws Exception {
        Connection cn = ConnectDb.getConnection();
        PreparedStatement st;
        try {
            st = (PreparedStatement) cn.prepareStatement("DELETE FROM Formation WHERE id = ?");
            st.setInt(1, f.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("error during the creation process" + e.getMessage());
        }

    }

    public static void update(Formation f) throws Exception {
        Connection cn = ConnectDb.getConnection();
        PreparedStatement st;
        try {
            st = (PreparedStatement) cn.prepareStatement("UPDATE Formation SET nom = ? WHERE id = ?");
            st.setString(1, f.getNom());
            st.setInt(2, f.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("error during the creation process" + e.getMessage());
        }
    }
}
