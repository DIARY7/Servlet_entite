package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connection.*;

public class Region {
    int id;
    String nom;

    //constructeur
    public Region() {

    }

    //CRUD
    public static void insert(String nom) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String insert = "INSERT INTO Region(nom) VALUES(?)"; 
            st = con.prepareStatement(insert);
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
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String delete = "DELETE FROM Region Where id = ?";
            st = con.prepareStatement(delete);
            st.setInt(1, Integer.parseInt(id));
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
    public static void update(String id,String nom) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String update = "Update Region set nom = ? Where id = ?";
            st = con.prepareStatement(update);
            st.setString(1, nom);
            st.setInt(2,Integer.parseInt(id));
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
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from Region";
            st = con.prepareStatement(sql);
            ResultSet result = st.executeQuery();
            Vector liste = new Vector();
            while (result.next()) {
                Region region = new Region();
                region.setId(result.getInt("id"));
                region.setNom(result.getString("nom"));
                liste.add(region);
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
    public static Region getById(String id) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from Region Where id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            ResultSet result = st.executeQuery();
            Region reg = new Region();
            if (result.next()) {
                
                reg.setId(result.getInt("id"));
                reg.setNom(result.getString("nom"));
            }
            
            return reg;

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
