/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import com.teamdev.jxbrowser.chromium.Browser;
//import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.BrowserContextParams;
import com.teamdev.jxbrowser.chromium.BrowserPreferences;
import com.teamdev.jxbrowser.chromium.BrowserType;
import com.teamdev.jxbrowser.chromium.CloseStatus;
import com.teamdev.jxbrowser.chromium.FileChooserMode;
import com.teamdev.jxbrowser.chromium.FileChooserParams;
import com.teamdev.jxbrowser.chromium.StorageType;
//import static com.teamdev.jxbrowser.chromium.MediaType.File;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.teamdev.jxbrowser.chromium.swing.DefaultDialogHandler;
//import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.CookieStorage;
import net.sf.jasperreports.view.JasperDesignViewer;
//import net.sf.jasperreports.engine.JRExpression;

/**
 *
 * @author SyR Laptop
 */
public class utama extends javax.swing.JFrame {
        
        BrowserContextParams param = new BrowserContextParams("user-data-dir");
        BrowserContext bc = new BrowserContext(param);
        Browser admin = new Browser();
        CookieStorage cookieStorage = admin.getCookieStorage();
        Browser shop = new Browser();
        Browser phpmyadmin = new Browser();
        JasperPrint JasPri;
        JasperDesign JasDes;
        JasperReport jasrep;
        
        
        /**
     * Creates new form utama
     */
    public utama() {
        
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
                       
        initComponents();
        param.setStorageType(StorageType.MEMORY); 
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1366, 768);
        setLocationRelativeTo(null);
        Browser browser = new Browser(BrowserType.HEAVYWEIGHT);
        BrowserPreferences.setChromiumSwitches(
                "--enable-gpu",
                "--enable-gpu-compositing",
                "--enable-begin-frame-scheduling",
                "--software-rendering-fps=60"
        );
        //setSize(Toolkit.getDefaultToolkit().getScreenSize());
        
        
        
        final BrowserView view = new BrowserView(browser);
        
        jtab.addTab("Admin ", new BrowserView(admin));
        //jtab.addTab("Admin ", new BrowserView(admin));
        jtab.addTab("Shop", new BrowserView(shop));
        jtab.addTab("Database", new BrowserView(phpmyadmin));
        
        browser.setDialogHandler(new DefaultDialogHandler(view) {
            @Override
            public CloseStatus onFileChooser(final FileChooserParams params) {
                final AtomicReference<CloseStatus> result = new AtomicReference<>(
                        CloseStatus.CANCEL);

                try {
                    SwingUtilities.invokeAndWait(() -> {
                        if (params.getMode() == FileChooserMode.Open) {
                            JFileChooser fileChooser = new JFileChooser();
                            if (fileChooser.showOpenDialog(view)
                                    == JFileChooser.APPROVE_OPTION) {
                                File selectedFile = fileChooser.getSelectedFile();
                                params.setSelectedFiles(selectedFile.getAbsolutePath());
                                result.set(CloseStatus.OK);
                            }
                        }
                    });
                } catch (InterruptedException | InvocationTargetException e) {
                }

                return result.get();
            }
        });
        
        admin.loadURL("http://localhost/tvftfHFhbhgfHFhbfGhfGHbfFyFKFJFfjjhvJVBhjjHGJg");
        shop.loadURL("http://localhost");
        phpmyadmin.loadURL("http://localhost/phpMyAdmin");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtab = new javax.swing.JTabbedPane();
        MenuBar = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        logoutAdm = new javax.swing.JMenuItem();
        logoutApp = new javax.swing.JMenuItem();
        itemClose = new javax.swing.JMenuItem();
        menuReload = new javax.swing.JMenu();
        RAdmin = new javax.swing.JMenuItem();
        RShop = new javax.swing.JMenuItem();
        RDb = new javax.swing.JMenuItem();
        RAll = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        pPenjualan = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        itemProgram = new javax.swing.JMenuItem();
        itemDeveloper = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jtab);

        Menu.setText("Menu");

        logoutAdm.setText("logout admin");
        logoutAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutAdmActionPerformed(evt);
            }
        });
        Menu.add(logoutAdm);

        logoutApp.setText("Logout APP");
        logoutApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutAppActionPerformed(evt);
            }
        });
        Menu.add(logoutApp);

        itemClose.setText("Close");
        itemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCloseActionPerformed(evt);
            }
        });
        Menu.add(itemClose);

        MenuBar.add(Menu);

        menuReload.setText("Reload");

        RAdmin.setText("Admin");
        RAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAdminActionPerformed(evt);
            }
        });
        menuReload.add(RAdmin);

        RShop.setText("Shop");
        RShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RShopActionPerformed(evt);
            }
        });
        menuReload.add(RShop);

        RDb.setText("Database");
        RDb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RDbActionPerformed(evt);
            }
        });
        menuReload.add(RDb);

        RAll.setText("All");
        RAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAllActionPerformed(evt);
            }
        });
        menuReload.add(RAll);

        MenuBar.add(menuReload);

        menuReport.setText("Report");

        pPenjualan.setText("Penjualan");
        pPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pPenjualanActionPerformed(evt);
            }
        });
        menuReport.add(pPenjualan);

        MenuBar.add(menuReport);

        menuAbout.setText("About");

        itemProgram.setText("Program");
        itemProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProgramActionPerformed(evt);
            }
        });
        menuAbout.add(itemProgram);

        itemDeveloper.setText("Developer");
        itemDeveloper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeveloperActionPerformed(evt);
            }
        });
        menuAbout.add(itemDeveloper);

        MenuBar.add(menuAbout);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAdmActionPerformed
        int numberOfDeletedCookies = cookieStorage.deleteAll();
        cookieStorage.save();
        admin.reload();
        //this.dispose();
        //new Login().setVisible(true);
    }//GEN-LAST:event_logoutAdmActionPerformed

    private void itemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemCloseActionPerformed

    private void RDbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RDbActionPerformed
        phpmyadmin.reloadIgnoringCache();
    }//GEN-LAST:event_RDbActionPerformed

    private void RAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAdminActionPerformed
        admin.reloadIgnoringCache();
    }//GEN-LAST:event_RAdminActionPerformed

    private void RShopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RShopActionPerformed
        shop.reloadIgnoringCache();
    }//GEN-LAST:event_RShopActionPerformed

    private void RAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAllActionPerformed
        admin.reloadIgnoringCache();
        shop.reloadIgnoringCache();
        phpmyadmin.reloadIgnoringCache();
    }//GEN-LAST:event_RAllActionPerformed

    private void itemProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProgramActionPerformed
        Program p = new Program();
        p.setVisible(true);
    }//GEN-LAST:event_itemProgramActionPerformed

    private void itemDeveloperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeveloperActionPerformed
        new Developer().setVisible(true);
    }//GEN-LAST:event_itemDeveloperActionPerformed

    private void pPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pPenjualanActionPerformed
            Map parame = new HashMap();
            java.sql.Connection con;
            Statement stm;
            
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/newgadget", "root", "root");
            stm = con.createStatement();
           File report = new File("src/penjualan1.jrxml");
           
           JasDes = JRXmlLoader.load(report);
           jasrep = JasperCompileManager.compileReport(JasDes);
           JasPri = JasperFillManager.fillReport(jasrep, parame, con);
           // JasperViewer.viewReport(JasPri);
           JasperViewer.viewReport(JasPri,false);
                       
        }catch(ClassNotFoundException | SQLException | JRException e){
            JOptionPane.showMessageDialog(null, e);
        }
            
    }//GEN-LAST:event_pPenjualanActionPerformed

    private void logoutAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutAppActionPerformed
        int numberOfDeletedCookies = cookieStorage.deleteAll();
        cookieStorage.save();
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutAppActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem RAdmin;
    private javax.swing.JMenuItem RAll;
    private javax.swing.JMenuItem RDb;
    private javax.swing.JMenuItem RShop;
    private javax.swing.JMenuItem itemClose;
    private javax.swing.JMenuItem itemDeveloper;
    private javax.swing.JMenuItem itemProgram;
    private javax.swing.JTabbedPane jtab;
    private javax.swing.JMenuItem logoutAdm;
    private javax.swing.JMenuItem logoutApp;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenu menuReload;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenuItem pPenjualan;
    // End of variables declaration//GEN-END:variables
}
