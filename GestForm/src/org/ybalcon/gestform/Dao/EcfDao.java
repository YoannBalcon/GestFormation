package org.ybalcon.gestform.Dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import static org.ybalcon.gestform.Dao.FormationDao.rs;
import static org.ybalcon.gestform.Dao.FormationDao.st;
import org.ybalcon.gestform.model.ECF;
import org.ybalcon.gestform.model.Formation;

/**
 *
 * @author ybalcon
 */
public class EcfDao {

    public static Statement stm = null;
    public static ResultSet rs = null;
    Formation formation;

    public static void create(ECF e) throws Exception {
        Connection cn = ConnectDb.getConnection();

        PreparedStatement st;

        try {
            cn.setAutoCommit(false);

            st = (PreparedStatement) cn.prepareStatement("INSERT INTO Ecf (id, nom, id_formation) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, e.getId());
            st.setString(2, e.getNom());
            st.setInt(3, e.getFormation().getId());
            st.execute();
        } catch (SQLException ex) {
            throw new RuntimeException();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
