package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import connection.*;

public class Client {
    int id;
    String nom;
    int idRegion;

    //constructeur
    public Client() {
    
    }
    //CRUD
    public static void insert(String nom,String idRegion) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String insert = "INSERT INTO Client(nom,idRegion) VALUES(?,?)"; 
            st = con.prepareStatement(insert);
            st.setString(1, nom);
            st.setInt(2, Integer.parseInt(idRegion));
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
            String delete = "DELETE FROM Client Where id = ?";
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
    public static void update(String id,String nom,String idRegion) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String update = "Update Client set nom = ? , idRegion = ? Where id = ?";
            st = con.prepareStatement(update);
            st.setString(1, nom);
            st.setInt(2, Integer.parseInt(idRegion));
            st.setInt(3, Integer.parseInt(id));
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
        System.out.println(con);
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from Client";
            st = con.prepareStatement(sql);
            ResultSet result = st.executeQuery();
            Vector liste = new Vector();
            while (result.next()) {
                Client client = new Client();
                client.setId(result.getInt("id"));
                client.setNom(result.getString("nom"));
                client.setIdRegion(result.getInt("idRegion"));
                liste.add(client);
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
    public static Client getById(String id) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from client Where id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            ResultSet result = st.executeQuery();
            Client cl = new Client();
            if (result.next()) {
                cl.setId(result.getInt("id"));
                cl.setIdRegion(result.getInt("idRegion"));
                cl.setNom(result.getString("nom"));
            }
            
            return cl;

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
    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }
    //getters
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public int getIdRegion() {
        return idRegion;
    }
    
}
