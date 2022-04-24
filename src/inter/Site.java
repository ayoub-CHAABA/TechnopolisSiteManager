package inter;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Site {
    // idCmpt on doit le recuperer avec une requete BD sans le declarer comme attribut dans la classe site
    int idSite;
    public static int cpt=1;
    String nomSite, ville;
    public static LinkedList <Site> listSites = new LinkedList <Site> ();
    private static String dbTableName = "Site";

    public Site(int idSite, String nomSite, String ville) {
        this.idSite = idSite;
        
        this.nomSite = nomSite;
        this.ville = ville;
    }
    //CONSTRUCTEUR SANS idCmpt
    public Site( String nomSite, String ville) {
        
        this.nomSite = nomSite;
        this.ville = ville;
    }

    public int getIdSite() {
        return idSite;
    }

    
    public String getNomSite() {
        return nomSite;
    }

    public String getVille() {
        return ville;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    public boolean insert(){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "INSERT INTO site VALUES (null,null, ?, ?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            
            
            pstmt.setString(1, this.nomSite);
            pstmt.setString(2, this.ville);
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.println("Probleme d'ajout à la table " + this.dbTableName);
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public boolean updateNom(String o){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE " + this.dbTableName + " SET  nomSite=? WHERE idSite=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            
            //pstmt.setInt(, this.idCmpt);
            pstmt.setString(1, o);
            //pstmt.setString(2, this.ville);
            pstmt.setInt(2, this.idSite);
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table " + this.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public boolean updateVille(String g){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE " + this.dbTableName + " SET  ville=? WHERE idSite=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            
            //pstmt.setInt(, this.idCmpt);
            //pstmt.setString(1, this.nomSite);
            pstmt.setString(1, g);
            pstmt.setInt(2, this.idSite);
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table " + this.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public boolean delete(int f){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "DELETE FROM " + this.dbTableName + " WHERE idSite=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);

            pstmt.setInt(1, f);
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de suppression de données de la table " + this.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public static LinkedList<Site> getAll(){
    
        LinkedList<Site> res = new LinkedList<Site>();
        
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM " + Site.dbTableName;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            Site o = null;
            while(rs.next()){
                o = new Site(rs.getInt(1), rs.getString(3), rs.getString(4));
                res.add(o);                
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Site.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public static LinkedList<Site> filter(String column, String searchedValue){
    
        LinkedList<Site> res = new LinkedList<Site>();
        
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM " + Site.dbTableName + " WHERE " + column + " like '%" + searchedValue + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            Site o = null;
            while(rs.next()){
                
                o = new Site( rs.getInt(0x1), rs.getString(3), rs.getString(4));
                res.add(o);                
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Site.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    
    public static Site filterA(String column, String searchedValue){
    
        //LinkedList<Site> res = new LinkedList<Site>();
        Site o = null;
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM " + Site.dbTableName + " WHERE " + column + " like '%" + searchedValue + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            
            while(rs.next()){
                
                o = new Site( rs.getInt(0x1), rs.getString(3), rs.getString(4));
               // res.add(o);                
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Site.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return o;
    }
}
