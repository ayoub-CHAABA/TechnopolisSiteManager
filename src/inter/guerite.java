package inter;


import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.lang.Object;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ragragui
 */
public class guerite extends javax.swing.JFrame {

    /**
     * Creates new form Utilisateur
     */
    public guerite() {
        initComponents();
    }
    
    public static Compte_1 g=Compte_1.getByLogin(authentification.jtfLogin.getText());
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtf = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);

        jPanel4.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(24, 24, 24));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/parking_86279_1.png"))); // NOI18N
        jLabel3.setMaximumSize(new java.awt.Dimension(51, 51));
        jLabel3.setMinimumSize(new java.awt.Dimension(51, 51));
        jPanel4.add(jLabel3);
        jLabel3.setBounds(10, 40, 210, 210);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/policeofficer_man_person_polici_2846.png"))); // NOI18N
        jLabel2.setText("Guérite");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(30, 20, 190, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fond-aquarelle-peint-main-forme-ciel-nuages_24972-1092.jpg"))); // NOI18N
        jPanel4.add(jLabel1);
        jLabel1.setBounds(0, 0, 240, 310);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 240, 310);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Source Code Pro Black", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Gestion des demandes");

        jtf.setBackground(new java.awt.Color(255, 204, 204));
        jtf.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jtf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Source Code Pro Black", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/emblemok_103757 (1).png"))); // NOI18N
        jButton1.setText("Autoriser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Source Code Pro Black", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/no_23025 (1).png"))); // NOI18N
        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 153, 153));
        jButton3.setFont(new java.awt.Font("Source Code Pro Black", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/filter_list_21446.png"))); // NOI18N
        jButton3.setText("Filtrer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idDem", "idCmpt", "uti_idCmpt", "Nom", "Prénom", "CNIE", "Date de visite", "HeureDebutVisite", "HeureFinVisite", "nbrPersonnes", "prsV", "mail", "etatDem"
            }
        ));
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/powerbutton_120788.png"))); // NOI18N
        jLabel5.setText("Log Out");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Source Code Pro Black", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 153, 153));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/korganizer_task_tasks_list_9500 (1).png"))); // NOI18N
        jButton5.setText("Lister");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtf, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(240, 0, 950, 310);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel b= (DefaultTableModel)jt.getModel();
        int y=g.idCmpt;
        Demande_1 d=new Demande_1();
        int ligne=jt.getSelectedRow();
        
        int id=Integer.parseInt(b.getValueAt(ligne,0).toString());
        int User=Integer.parseInt(b.getValueAt(ligne, 2).toString());
       
        
        b.setValueAt(y, ligne, 1);
        b.setValueAt("valide",ligne , 12);
         LinkedList <Demande_1> cc=Demande_1.getAll();
         LinkedList <Compte_1> bb=Compte_1.getAll();
        for(int i=0;i<cc.size();i++){
            if(cc.get(i).idDem==id){
                cc.get(i).etatDem="valide";
                 d=cc.get(i);
            }
        }
        String m=null;
        for(int i=0;i<bb.size();i++){
            if(bb.get(i).idCmpt==User){
                m=bb.get(i).mail;
            }
        }
           String em=b.getValueAt(ligne, 11).toString();
           System.out.println(cc.get(1).idDem);
          // jf.setVisible(true);
          System.out.println(m);
           notif.sendMailAccept(em, "uservisit123@gmail.com", "rihabouma123");
           notif.sendMailAccept(m,"uservisit123","rihabouma123" );
           
           d.updateEtatDemValide(id);
           d.updateIdCmp(y, id);
            
            
            
       
       
       
            
            
            
            
            
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       Compte_1 g=Compte_1.getByLogin(authentification.jtfLogin.getText());
        DefaultTableModel b= (DefaultTableModel)jt.getModel();
        int y=g.idCmpt;
        Demande_1 d=new Demande_1();
        int ligne=jt.getSelectedRow();
        
        int id=Integer.parseInt(b.getValueAt(ligne,0).toString());
        int User=Integer.parseInt(b.getValueAt(ligne, 2).toString());
       
        
        b.setValueAt(y, ligne, 1);
        b.setValueAt("non valide",ligne , 12);
         LinkedList <Demande_1> cc=Demande_1.getAll();
         LinkedList <Compte_1> bb=Compte_1.getAll();
        for(int i=0;i<cc.size();i++){
            if(cc.get(i).idDem==id){
                cc.get(i).etatDem="non valide";
                 d=cc.get(i);
            }
        }
        String m=null;
        for(int i=0;i<bb.size();i++){
            if(bb.get(i).idCmpt==User){
                m=bb.get(i).mail;
            }
        }
           String em=b.getValueAt(ligne, 11).toString();
           System.out.println(cc.get(1).idDem);
          // jf.setVisible(true);
          System.out.println(m);
           notif.sendMailFail(em, "uservisit123@gmail.com", "rihabouma123");
           notif.sendMailFail(m,"uservisit123","rihabouma123" );
           d.updateEtatDemNonValide(id);
           d.updateIdCmp(y, id);
           
        
            
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        authentification a=new authentification();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseClicked
        // TODO add your handling code here:
        
       /* com.mysql.jdbc.Connection conn=(com.mysql.jdbc.Connection) SingletonConnection.getConnection();
         try {
    com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) conn.createStatement();
    String q="select * from demande ;";
    st.executeQuery(q);
    ResultSet rs = st.executeQuery(q);
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       }
  catch (Exception ex) {
  JOptionPane.showMessageDialog(null, ex);
  }*/
    }//GEN-LAST:event_jtMouseClicked

    private void jtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfKeyTyped
        // TODO add your handling code here:
        LinkedList<Demande_1> lc=new LinkedList<Demande_1>();
Vector <String> Vcols=new Vector <String>();
Vcols.add("idDem");
Vcols.add("nom");
Vcols.add("prenom");
Vcols.add("CNE");
Vcols.add("DateVisite");
Vcols.add("heureDebutVisite");
Vcols.add("heureFinVisite");
Vcols.add("nbrPersonnes");
Vcols.add("prsV");
Vcols.add("mail");
Vcols.add("etatDemande");
Vector <Object> Vligne=new Vector <Object>();
Vector <Vector<Object>> Vdata=new Vector <Vector<Object>>();
for(Demande_1 c:lc){
Vligne.add(c.idDem);
Vligne.add(c.nom);
Vligne.add(c.prenom);
Vligne.add(c.CNE);
Vligne.add(c.dateVisite);
Vligne.add(c.heureDebutVisite);
Vligne.add(c.heureFinVisite);
Vligne.add(c.nbrPersonnes);
Vligne.add(c.prsV);
Vligne.add(c.mail);
Vligne.add(c.etatDem);
Vdata.add(Vligne);
}

DefaultTableModel model=new DefaultTableModel (Vdata,Vcols);
jt.setModel(model);
        
        
        
        
    }//GEN-LAST:event_jtfKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        com.mysql.jdbc.Connection conn=(com.mysql.jdbc.Connection) SingletonConnection.getConnection();
         try {
    com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) conn.createStatement();
    String q="select * from demande  ;";
    st.executeQuery(q);
    ResultSet rs = st.executeQuery(q);
    jt.setModel(DbUtils.resultSetToTableModel(rs));
       }
  catch (Exception ex) {
  JOptionPane.showMessageDialog(null, ex);
  }
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                guerite g=new guerite();
                g.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    private javax.swing.JTextField jtf;
    // End of variables declaration//GEN-END:variables
}