package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connection.*;

public class Service {
    int id;
    String nom;

    //constructeur
    public Service() {

    }

    //CRUD
    public static void insert(String nom) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String insert = "INSERT INTO Service(nom) VALUES(?)";
            st  = con.prepareStatement(insert);
            st.setString(1, nom);
            st.execute();
            
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        finally{
            st.close();
            con.close();
        }
        
    }
    public static void delete(String id) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String delete = "DELETE FROM Service Where id = ?";
            st = con.prepareStatement(delete);
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        finally{
            st.close();
            con.close();
        }
    }
    public static void update(String id,String nom) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String update = "Update Service set nom = ? Where id = ?";
            st = con.prepareStatement(update);
            st.setString(1, nom);
            st.setInt(2, Integer.parseInt(id));
            st.executeUpdate();    
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        finally{
            st.close();
            con.close();
        }
    }
    public static Vector getAll() throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from Service";
            st = con.prepareStatement(sql);
            ResultSet result = st.executeQuery();
            Vector liste = new Vector();
            while (result.next()) {
                Service service = new Service();
                service.setId(result.getInt("id"));
                service.setNom(result.getString("nom"));
                liste.add(service);
            }
            return liste;    
        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        finally{
            st.close();
            con.close();
        }
        
    }
    public static Service getById(String id) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from Service Where id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            ResultSet result = st.executeQuery();
            Service ser = new Service();
            if (result.next()) {
                
                ser.setId(result.getInt("id"));
                ser.setNom(result.getString("nom"));
            }
            
            return ser;

        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        finally{
            st.close();
            con.close();
        }
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    
}
