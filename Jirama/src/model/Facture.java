package model;

import connection.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;

public class Facture {
    int id;
    int idClient;
    double montant;
    int idService; 
    LocalDate dateFacture;
    
    public Facture(){

    }

    //CRUD
    public static void insert(String idClient,String montant,String idService,String dateFacture) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String insert = "INSERT INTO Facture(idClient,montant,idService,dateFacture) VALUES(?,?,?,?)"; 
            st = con.prepareStatement(insert);
            st.setInt(1, Integer.parseInt(idClient));
            st.setDouble(2, Double.parseDouble(montant));
            st.setInt(3,Integer.parseInt(idService));
            st.setDate(4, Date.valueOf(dateFacture));

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
            String delete = "DELETE FROM Facture Where id = ?";
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
    public static void update(String id,String idClient,String montant,String idService,String dateFacture) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {

            String update = "Update Facture set idClient = ?,montant = ?,idService = ? , dateFacture = ? Where id = ?";
            st = con.prepareStatement(update);
            st.setInt(1, Integer.parseInt(idClient));
            st.setDouble(2, Double.parseDouble(montant));
            st.setInt(3,Integer.parseInt(idService));
            st.setDate(4, Date.valueOf(dateFacture));
            st.setInt(5, Integer.parseInt(id));
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
            String sql = "SELECT * from Facture";
            st = con.prepareStatement(sql);
            ResultSet result = st.executeQuery();
            Vector liste = new Vector();
            while (result.next()) {
                Facture facture = new Facture();
                facture.setId(result.getInt("id"));
                facture.setIdClient(result.getInt("idClient"));
                facture.setMontant(result.getDouble("montant"));
                facture.setDateFacture(result.getDate("datefacture"));
                liste.add(facture);
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

    public static Facture getById(String id) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres","root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from facture Where id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            ResultSet result = st.executeQuery();
            Facture fact = new Facture();
            
            if (result.next()) {
                fact.setId(result.getInt("id"));
                fact.setIdClient(result.getInt("idClient"));
                fact.setIdService(result.getInt("idService"));
                fact.setMontant(result.getDouble("montant"));
                fact.setDateFacture(result.getDate("dateFacture"));    
            }
            
            return fact;

        } catch (Exception e) {
            // TODO: handle exception
            throw e;
        }
        finally{
            st.close();
            con.close();
        }
    }
    public static Vector getByDate(String dateMin,String dateMax) throws Exception {
        ConnectionPost conPost = new ConnectionPost("postgres", "root");
        Connection con = conPost.getConnection();
        PreparedStatement st = null;
        try {
            String sql = "SELECT * from Facture WHere dateFacture <=? and dateFacture >=? ";
            st = con.prepareStatement(sql);
            st.setDate(1, Date.valueOf(dateMax));
            st.setDate(2, Date.valueOf(dateMin));
            ResultSet result = st.executeQuery();
            Vector liste = new Vector();
            while (result.next()) {
                Facture facture = new Facture();
                facture.setId(result.getInt("id"));
                facture.setIdClient(result.getInt("idClient"));
                facture.setMontant(result.getDouble("montant"));
                facture.setDateFacture(result.getDate("datefacture"));
                liste.add(facture);
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
    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture.toLocalDate();
    }

    //getters
    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public double getMontant() {
        return montant;
    }

    public int getIdService() {
        return idService;
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }
}
