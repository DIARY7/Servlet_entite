package utilitaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.*;
public class Traitement {

    public static int checkLogin(String login,String mdp) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql ="SELECT id from utilisateur where login = ? and mdp = ?";    
            st = con.prepareStatement(sql);
            st.setString(1, login);
            st.setString(2, mdp);
            ResultSet result = st.executeQuery();
            if (!result.next()) {
                throw new Exception("Identification incorrecte");
            }
            return result.getInt("id");
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        finally{
            st.close();
            con.close();
        }
        
    }
}
