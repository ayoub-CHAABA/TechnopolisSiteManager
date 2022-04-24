package inter;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;



public class Demande_1 {
    int idDem;
    //MODIFIER HEUREVISITE PAR DATEFINVISITE
    int idUtl;
    String nom, prenom, CNE,  heureDebutVisite,heureFinVisite, prsV, mail,etatDem;
    Date dateVisite;
   int nbrPersonnes;
    public static LinkedList <Demande_1> listDem = new LinkedList <Demande_1> ();
    private static String dbTableName = "Demande";
    public  Demande_1(){
    
}
    public Demande_1(int idDem,int idUtl, String nom, String prenom, String CNE, Date dateVisite, String heureDebutVisite,String heureFinVisite, int nbrPersonnes, String prsV,String mail, String etatDem) {
        this.idDem = idDem;
        this.idUtl=idUtl;
        this.nom = nom;
        this.prenom = prenom;
        this.CNE = CNE;
        this.dateVisite = dateVisite;
        this.heureDebutVisite = heureDebutVisite;
        this.heureFinVisite = heureFinVisite;
        this.nbrPersonnes=nbrPersonnes;
        this.prsV = prsV;
        this.mail = mail;
        this.etatDem="en cours de traitement";
    }

    public Demande_1( String nom, String prenom, String CNE, Date dateVisite, String heureDebutVisite,String heureFinVisite, int nbrPersonnes, String prsV,String mail, String etatDem) {
        this.nom = nom;
        this.idUtl=idUtl;
        this.prenom = prenom;
        this.CNE = CNE;
        this.dateVisite = dateVisite;
        this.heureDebutVisite = heureDebutVisite;
        this.heureFinVisite = heureFinVisite;
        this.nbrPersonnes=nbrPersonnes;
        this.prsV = prsV;
        this.mail = mail;
        this.etatDem="en cours de traitement";
    }

    public int getIdDem() {
        return idDem;
    }

    public void setIdDem(int idDem) {
        this.idDem = idDem;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public String getHeureDebutVisite() {
        return heureDebutVisite;
    }

    public void setHeureDebutVisite(String heureDebutVisite) {
        this.heureDebutVisite = heureDebutVisite;
    }

    public String getHeureFinVisite() {
        return heureFinVisite;
    }

    public void setHeureFinVisite(String heureFinVisite) {
        this.heureFinVisite = heureFinVisite;
    }

    public String getPrsV() {
        return prsV;
    }

    public void setPrsV(String prsV) {
        this.prsV = prsV;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEtatDem() {
        return etatDem;
    }

    public void setEtatDem(String etatDem) {
        this.etatDem = etatDem;
    }

    public Date getDateVisite() {
        return dateVisite;
    }

    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }

    public int getNbrPersonnes() {
        return nbrPersonnes;
    }

    public void setNbrPersonnes(int nbrPersonnes) {
        this.nbrPersonnes = nbrPersonnes;
    }

    public static LinkedList<Demande_1> getListDem() {
        return listDem;
    }

    public static void setListDem(LinkedList<Demande_1> listDem) {
        Demande_1.listDem = listDem;
    }

    
    public boolean insert(){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "INSERT INTO Demande VALUES (null, null, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            Compte_1 k =null;
            //k=Compte_1.getByLogin(jtfLogin.getText());
            //pstmt.setInt(1, k.idCmpt);
            pstmt.setString(1, this.nom);
            pstmt.setString(2, this.prenom);
            pstmt.setString(3, this.CNE);
            pstmt.setDate(4, (java.sql.Date) this.dateVisite);
            pstmt.setString(5, this.heureDebutVisite);
            pstmt.setString(6, this.heureFinVisite);
            pstmt.setInt(7, this.nbrPersonnes);
            pstmt.setString(8, this.prsV);
            pstmt.setString(9, this.mail);
            pstmt.setString(10, this.etatDem);
        
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.println("Probleme d'ajout à la table " + this.dbTableName);
            //System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    public boolean updateEtatDemValide(int id) {
        boolean res = false;
        
     
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE demande SET  etatDemande='valide' WHERE idDem=? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
                pstmt.setInt(1, id);
                
             
               //pstmt.setInt(3, iddem);
                int  r = pstmt.executeUpdate();
                
                if (r == 1) {
                    res = true;
                    System.out.println("hiii");
                }
                //conn.close();
                pstmt.close();
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table " + this.dbTableName);
            //System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    
    
    
     public boolean updateEtatDemNonValide(int id) {
        boolean res = false;
        
     
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE demande SET etatDemande=? WHERE idDem=? ";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
                pstmt.setString(1, "non valide");
                pstmt.setInt(2, id);
             
               //pstmt.setInt(3, iddem);
                int  r = pstmt.executeUpdate();
                
                if (r == 1) {
                    res = true;
                    System.out.println("hiii");
                }
                //conn.close();
                pstmt.close();
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table " + this.dbTableName);
            //System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    
    
    
    
    
    public boolean updateIdCmp(int u,int y) {
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE " + this.dbTableName + " SET  idCmpt=? WHERE idDem=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            
            
     
            pstmt.setInt(1, u);
            pstmt.setInt(2, y);
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table " + this.dbTableName);
            //System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public boolean delete(){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "DELETE FROM " + this.dbTableName + " WHERE idDem=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);

            pstmt.setInt(1, this.idDem);
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de suppression de données de la table " + this.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public static LinkedList<Demande_1> getAll(){
    
        LinkedList<Demande_1> res = new LinkedList<Demande_1>();
        
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM " + Demande_1.dbTableName;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            Demande_1 d = null;
            while(rs.next()){
                d = new Demande_1(rs.getInt(1), rs.getInt(3),rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11),rs.getString(12),rs.getString(13));
                res.add(d);                
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Demande_1.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public static Demande_1 filter(String column, String searchedValue){
    
        //LinkedList<Demande_1> res = new LinkedList<Demande_1>();
        Demande_1 d = null;
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM " + Demande_1.dbTableName + " WHERE " + column + " like '%" + searchedValue + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            
            while(rs.next()){
                d = new Demande_1(rs.getInt(1), rs.getInt(3),rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11),rs.getString(12),rs.getString(13));
                              
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Demande_1.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return d;
    }
    
    
 /*  public int recupId(){
       Demande_1 d;
       int id;
       Connection conx=SingletonConnection.getConnection();
       String req="select * from Compte  ";
       
       try{
       PreparedStatement st = (PreparedStatement) conx.prepareStatement(req);
       st.setString(1, this.CNE);
       ResultSet rs=st.executeQuery();
       
       if(rs.next()){
           id=rs.getInt(3);
       }
 
           
           
       
       }catch(SQLException e ){
           
       }
       
       
       
     
   }
    */
    
    
    
    public static LinkedList<Demande_1> getAllValide(){
    
        LinkedList<Demande_1> res = new LinkedList<Demande_1>();
        
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM demande where etatDemande='valide'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            Demande_1 d = null;
            while(rs.next()){
                d = new Demande_1(rs.getInt(1), rs.getInt(3),rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getString(11),rs.getString(12),rs.getString(13));
                res.add(d);                
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Demande_1.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    public static int nbre_total_de_visites(){
		int res = 0;
		LinkedList<Demande_1> demandes = Demande_1.getAllValide();
                System.out.println(demandes.size());
                res=demandes.size();
		
		return res;
	}
		
	public static int nbre_total_de_demandes(){
		return Demande_1.getAll().size();
	}
 

    public static float moyenne_visites_journaliere(){
        HashMap<Date, Integer> date_visite_map = new HashMap<Date, Integer>();
        LinkedList<Demande_1> demandes = Demande_1.getAllValide();
        Demande_1 demande =new Demande_1();
        for(int i=0; i<demandes.size(); i++){
            
            
                if(!date_visite_map.containsKey(demande.dateVisite))
                    date_visite_map.put(demande.dateVisite, 0);
                date_visite_map.put(demande.dateVisite, date_visite_map.get(demande.dateVisite) + 1);
            
        }
        return Demande_1.avg(new ArrayList<Integer>(date_visite_map.values()));
    }

 
    public static float duree_moyenne_visites(){
        LinkedList<Integer> durees = new LinkedList<Integer>();
        LinkedList<Demande_1> demandes = Demande_1.getAllValide();
        for(int i=0; i<demandes.size(); i++){
            Demande_1 demande = demandes.get(i);
           
               int start = Integer. parseInt(demande.heureDebutVisite);
               int end = Integer. parseInt(demande.heureFinVisite);
               int duree = end - start;
               durees.add(Math.abs(duree));
            
        }
        return Demande_1.avg(durees);
    }


    public static float avg(AbstractList<Integer>  col){
        Integer sum = 0;
        float size = col.size();
        for(int i=0; i<col.size(); i++){
            sum += col.get(i);
        }
        return sum / size;
    }

}
