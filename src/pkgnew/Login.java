/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;
import com.mysql.jdbc.Connection;
import java.awt.TextField;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author SyR Laptop
 */
public class Login extends javax.swing.JFrame {
    java.sql.Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    TextField t;
    private static Connection koneksi;
 public static Connection getKoneksi(){
  if (koneksi == null){
   try {String url = "jdbc:mysql://localhost:3306"; // nama databasenya login
          String user=""; // username mysql root
          String pass=""; //passwordnya kosong

 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
koneksi = (Connection) DriverManager.getConnection(url , user, pass);
    
 } 
   catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
}

return koneksi;
}
    public Login() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JButton();
        login = new javax.swing.JButton();
        passwd = new javax.swing.JPasswordField();
        tuser = new javax.swing.JLabel();
        tpass = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setText("Keluar");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 63, -1));
        getContentPane().add(passwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 146, -1));

        tuser.setText("Username");
        getContentPane().add(tuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        tpass.setText("Password");
        getContentPane().add(tpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        uname.setToolTipText("username");
        uname.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 146, -1));

        bg.setForeground(new java.awt.Color(255, 102, 204));
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/gambar/WhatsApp Image 2018-11-30 at 12.02.21.jpeg"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        setSize(new java.awt.Dimension(501, 345));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        try {String url = "jdbc:mysql://localhost:3306"; // nama databasenya login
            //String user=""; // username mysql root
            //String pass=""; //passwordnya kosong
            String user = ""+uname.getText();
            String pass = ""+passwd.getText();

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = (Connection) DriverManager.getConnection(url , user, pass);
            utama home = new utama();
            home.setVisible(true);
            this.dispose();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "User/Pass Salah "+e.getMessage());
        }
    }//GEN-LAST:event_loginActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton close;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passwd;
    private javax.swing.JLabel tpass;
    private javax.swing.JLabel tuser;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
