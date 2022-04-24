package inter;






import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import static java.time.Instant.now;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Compte_1 {
    //pas la peine de gérer l'auto_increment au niveau de la classe
    //l'autoincrement sera géré dans la base de données pour éviter les conflits 
    //(plusieurs applicaitons utilisant la meme base de données)
    int idCmpt;
    String nom, prenom, telephone, mail, CIN, login, password, role;
    String etatCmp;
    Date dateCreation;
    String siteAffect;
     LocalDate todaysDate = LocalDate.now();

    ZoneId defaultZoneId = ZoneId.systemDefault();
     Date date = Date.from(todaysDate.atStartOfDay(defaultZoneId).toInstant());

//System.out.println(format.format(date));
    public static LinkedList <Compte_1> listCmpts = new LinkedList <Compte_1> ();
    // nom de la table compte dans la base de données, 
    //elle sera utilisée appelée plusieurs fois ci dessous
    private static String dbTableName = "Compte";
    
    // constructeur avec id: utilisé pour manipuler les comptes déjà enregistrés dans la bdd
    public Compte_1(int idCmpt, String nom, String prenom, String telephone, String mail, String CIN, String login, String password, String role, String etatCmp, Date dateCreation,String siteAffect) {
        
        this.idCmpt = idCmpt;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.CIN = CIN;
        //suppostion: login unique ajouter comme contrainte dans la BD pour ne pas creer deux comptes avec le meme login
        this.login = login;
        this.password = password;
        this.role = role;
        this.etatCmp = "active";
        this.dateCreation=date;
        this.siteAffect=siteAffect;
                
    }
    
    // constructeur sans id: utilisé pour la creation d'un nouveau compte (dont on ne connait pas l'id)
    public Compte_1(String nom, String prenom, String telephone, String mail, String CIN, String login, String password, String role, String etatCmp, Date dateCreation,String siteAffect) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.mail = mail;
        this.CIN = CIN;
        this.login = login;
        this.password = password;
        this.role = role;
        this.etatCmp = "active";
        this.dateCreation=date;
        this.siteAffect=siteAffect;
    }

   
// etat:compte active ou non
    public void setEtatCmp(String etatCmp) {
        this.etatCmp = etatCmp;
    }

    public String getEtatCmp() {
        return etatCmp;
    }

    public int getIdCmpt() {
        return idCmpt;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMail() {
        return mail;
    }

    public String getCIN() {
        return CIN;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }
     public Date getDateCreation() {
        return dateCreation;
    }
     public String getSiteAffect() {
        return siteAffect;
    }

    public void setIdCmpt(int idCmpt) {
        this.idCmpt = idCmpt;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
       public void setSiteAffect(String siteAffect) {
        this.siteAffect = siteAffect;
    }
    
    // les methodes:
    //pour séléctionner un compte 
   /*public static String authen (String login, String pwd){
        String res="guerite";
         String SQL = "SELECT * FROM Compte WHERE login=?" +"AND password=?"; 
        try{
            
            Connection conn = SingletonConnection.getConnection();
            // valeur null pour l'id, le champ idCmpt est en auto_increment dans la base. il sera généré automatiquement dans la bdd
            
            PreparedStatement pstmt =  conn.prepareStatement(SQL);
            pstmt.setString(1, login);
            pstmt.setString(2, pwd);
            ResultSet rs =pstmt.executeQuery();
            while(rs.next()){
               
                res=rs.getString(9);
                rs.close();
                pstmt.close();
            }
            
        } catch(SQLException e){
            e.printStackTrace();
                
            }
       
        return res;
    }
    */
    

    // méthode pour créer/insérer l'objet compte dans la base de données
    //methode CRUD NON STATIQUE CAR PROPRE A CHAQUE COMPTE 
    public boolean insert(){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            java.sql.Connection conn = SingletonConnection.getConnection();
            // valeur null pour l'id, le champ idCmpt est en auto_increment dans la base. il sera généré automatiquement dans la bdd
            String SQL = "INSERT INTO " + this.dbTableName + " VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
             // Date class of Util package contains both date and
        // time information
        
  
        // Print and display the utility package date in
        // java
        
  
        // Date class of sql package contains only date
        // information without time
        
  
            pstmt.setString(1, this.nom);
            pstmt.setString(2, this.prenom);
            pstmt.setString(3, this.telephone);
            pstmt.setString(4, this.mail);
            pstmt.setString(5, this.CIN);
            pstmt.setString(6, this.login);
            pstmt.setString(7, this.password);
            pstmt.setString(8, this.role);
            pstmt.setString(9, this.etatCmp);
            pstmt.setDate(10, (java.sql.Date) this.dateCreation);
            pstmt.setString(11, this.siteAffect);
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.println("Probleme d'ajout à la table " + this.dbTableName);
            System.out.println(e.getMessage());
        }
        
        return res;
    }
    
    // méthode pour sauvegarder les modifs sur l'objet Compte après changement
    public boolean updateEtatCmp(String f){
        
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE Compte"+" SET  etatCmp=? WHERE idCmpt=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            
            
            pstmt.setString(1, f);
            pstmt.setInt(2, this.idCmpt);
            
            
            
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table");
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    
    public boolean updateSite(String y){
        
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE " + this.dbTableName + " SET  siteAffect=? WHERE idCmpt=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            
            
            pstmt.setString(1, y);
            pstmt.setInt(2,this.idCmpt);
            
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table " + this.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    
    public boolean updateRole(String y){
        
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "UPDATE " + this.dbTableName + " SET  Role=? WHERE idCmpt=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);
            
            
            pstmt.setString(1, y);
            pstmt.setInt(2, this.idCmpt);
            
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de mise à jour de la table " + this.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    
    
    
    // méthode pour supprimer un compte de la bdd
    public boolean delete(int y){
        boolean res = false;
        
        int r = 0;
        
        try{
            
            Connection conn = SingletonConnection.getConnection();
            String SQL = "DELETE FROM " + this.dbTableName + " WHERE idCmpt=?";
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(SQL);

            pstmt.setInt(1, y);
            
            r = pstmt.executeUpdate();
            if(r == 1)
                res = true;
        } catch(SQLException e){
            System.out.print("Probleme de suppression de données de la table " + this.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public boolean activerCompte(){
        
     //com.mysql.jdbc.Connection conn=(com.mysql.jdbc.Connection) SingletonConnection.getConnection();
      
    
        this.etatCmp = "active";
        return this.updateEtatCmp(this.etatCmp);
    }
    
    public boolean desactiverCompte(){
        boolean res=false;
        
        if(LocalDate.now().getYear() - this.dateCreation.getYear() >= 1){
             this.updateEtatCmp("desactive");
             res=true;
        }
        return res;
    }
    //methode static car liée à plusieurs compteS NON PAS A UN COMPTE SPECIFIQUE
    // methode pour loader tous les comptes de la bdd , retourne linkedlist des comptes
    public static LinkedList<Compte_1> getAll(){
    
        LinkedList<Compte_1> res = new LinkedList<Compte_1>();
        
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM " + Compte_1.dbTableName;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            Compte_1 c = null;
            while(rs.next()){
                c = new Compte_1(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getDate(11),rs.getString(12));
                res.add(c);              
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Compte_1.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    // methode de recherche par filtrage
    public static Compte_1 filter(String column, String searchedValue){
    
        //Compte_1 res = null;
        Compte_1 c = null;
        try{
        
            Connection conn = SingletonConnection.getConnection();
            String req = "SELECT * FROM " + Compte_1.dbTableName + " WHERE " + column + " like '%" + searchedValue + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            
            while(rs.next()){
                c = new Compte_1(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getDate(11),rs.getString(12));
                              
            }
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Compte_1.dbTableName);
            //System.out.print(e.getMessage());
        }
        
        return c;
    }
    
    public static LinkedList <Compte_1> filterA(String column, String searchedValue){
    
        //Compte_1 res = null;
        LinkedList <Compte_1> o = new LinkedList <Compte_1> ();
        Compte_1 c = null;
        try{
        
            Connection conn = SingletonConnection.getConnection();
             String req = "SELECT * FROM " + Compte_1.dbTableName + " WHERE " + column + " like '%" + searchedValue + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(req);
            
            
            while(rs.next()){
                c = new Compte_1(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getDate(11),rs.getString(12));
                o.add(c);
                              
            }
           
            rs.close();
            stmt.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Compte_1.dbTableName);
            System.out.print(e.getMessage());
        }
        
        return o;
    }
    // à inserer dans l'interface graphique voir partie oumaima
    public static boolean isAuthentificated(String login, String password){
        Compte_1 c = Compte_1.filter("login", login);
        boolean res=false;
            if(c.password.equals(password) && c.etatCmp.equals("active")){
                guerite g=new guerite();
                Admin ad=new Admin();
       
                SuperAdmin sa=new SuperAdmin();
                UtilisateurEntreprise ue=new UtilisateurEntreprise();
      
       
       ReponsableSite resp = new ReponsableSite();
       
       
       
       
       
       
        if(c.role.equals("guerite")) {
           res=true;
            g.setVisible(true);
           
        }else if(c.role.equals("Admin")){
            res=true;

            ad.setVisible(true);
            

        }else if(c.role.equals("SuperAdmin")){
             res=true;

            sa.setVisible(true);
            
        }
        else if(c.role.equals("UtilisateurEntreprise")){
            res=true;
            ue.setVisible(true);
            
        }else if(c.role.equals("RespoSite")){
             
                 res=true;
            resp.setVisible(true);
           
            
        }}else{
            
           res=false;
            }
                
                
                
                
             return res;   
        
               
    }
    
    
    //methode de recherche par login
   public static Compte_1 getByLogin(String login){
        // supposition que le login est unique, dans le filtre va retourner un seul element
        // filter methode static, appelé de la classe
        Compte_1 cpt = Compte_1.filter("login", login);
        if(cpt!=null){
            return cpt;}
        return null;
    }
    
   
   
   
   public static Compte_1 getId(int id){
       
       Compte_1 c=null;
       try{
        
            Connection conn = SingletonConnection.getConnection();
             String req = "SELECT * FROM compte WHERE  idCmpt=?";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(req);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery(req);
            
            
            if(rs.next()){
                c = new Compte_1(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),rs.getDate(11),rs.getString(12));
                
                              
            }
           
            rs.close();
            ps.close();
        } catch(SQLException e){
            System.out.println("Probleme durant la recupération des données de la table " + Compte_1.dbTableName);
            System.out.print(e.getMessage());
        }
       
       return c;
   }
    
    
 
    
    
    
    }
